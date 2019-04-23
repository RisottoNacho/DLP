package visitor;

import ast.expressions.Arithmetic;
import ast.expressions.CharLiteral;
import ast.expressions.IntLiteral;
import ast.expressions.RealLiteral;

public class ValueCodeGeneratorVisitor extends AbstractCGVisitor {

    private CodeGenerator codeGenerator;

    public ValueCodeGeneratorVisitor(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
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
        codeGenerator.convertTo(arithmetic.left.getType(),arithmetic.type);
        arithmetic.right.accept(this, params);
        codeGenerator.convertTo(arithmetic.right.getType(),arithmetic.type);
        return null;
    }
}
