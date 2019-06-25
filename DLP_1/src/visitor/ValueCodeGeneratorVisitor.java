package visitor;

import ast.expressions.*;
import ast.types.Int;

public class ValueCodeGeneratorVisitor extends AbstractCGVisitor {

    private CodeGenerator codeGenerator;
    private AdressCodeGeneratorVisitor adressCodeGeneratorVisitor;

    public ValueCodeGeneratorVisitor(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

    @Override
    public Object visit(Variable variable, Object params) {
        variable.accept(this.adressCodeGeneratorVisitor, params);
        codeGenerator.load(variable.getType());
        return null;
    }

    @Override
    public Object visit(UnaryNot unaryNot, Object params) {
        unaryNot.expression.accept(this, params);
        codeGenerator.unaryNot();
        return null;
    }

    @Override
    public Object visit(StructAccess structAccess, Object params) {
        structAccess.accept(this.adressCodeGeneratorVisitor, params);
        codeGenerator.load(structAccess.getType());
        return null;
    }

    @Override
    public Object visit(FunctionProcedure functionProcedure, Object params) {
        for (Expression param : functionProcedure.params)
            param.accept(this, params);
        codeGenerator.call(functionProcedure.name.value);
        return null;
    }

    @Override
    public Object visit(ArrayAccess arrayAccess, Object params) {
        arrayAccess.accept(this.adressCodeGeneratorVisitor, params);
        codeGenerator.load(arrayAccess.getType());
        return null;
    }

    @Override
    public Object visit(Logic logic, Object params) {
        logic.left.accept(this, null);
        logic.right.accept(this, null);
        codeGenerator.logic(logic.operator);
        return null;
    }

    @Override
    public Object visit(Comparison comparison, Object params) {
        comparison.left.accept(this, params);
        comparison.right.accept(this, params);
        codeGenerator.comparison(comparison.operator, comparison.type);
        return null;
    }

    @Override
    public Object visit(IntLiteral intLiteral, Object params) {
        codeGenerator.push(intLiteral);
        return null;
    }

    @Override
    public Object visit(CharLiteral charLiteral, Object params) {
        codeGenerator.push(charLiteral);
        return null;
    }

    @Override
    public Object visit(RealLiteral realLiteral, Object params) {
        codeGenerator.push(realLiteral);
        return null;
    }

    @Override
    public Object visit(Arithmetic arithmetic, Object params) {

        arithmetic.left.accept(this, params);
        codeGenerator.convertTo(arithmetic.left.getType(), arithmetic.type);
        arithmetic.right.accept(this, params);
        codeGenerator.convertTo(arithmetic.right.getType(), arithmetic.type);

        codeGenerator.arithmetic(arithmetic.operator, arithmetic.type);
        return null;
    }

    @Override
    public Object visit(Cast cast, Object params) {
        cast.expression.accept(this, params);
        codeGenerator.convertTo(cast.expression.getType(), cast.type);
        return null;
    }

    public void setAdressCodeGeneratorVisitor(AdressCodeGeneratorVisitor adressCodeGeneratorVisitor) {
        this.adressCodeGeneratorVisitor = adressCodeGeneratorVisitor;
    }
}
