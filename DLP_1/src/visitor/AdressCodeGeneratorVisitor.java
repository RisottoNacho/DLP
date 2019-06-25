package visitor;

import ast.expressions.ArrayAccess;
import ast.expressions.StructAccess;
import ast.expressions.Variable;
import ast.types.Int;

public class AdressCodeGeneratorVisitor extends AbstractCGVisitor {

    private CodeGenerator codeGenerator;
    private ValueCodeGeneratorVisitor valueCodeGeneratorVisitor;

    public AdressCodeGeneratorVisitor(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

    @Override
    public Object visit(Variable variable, Object params) {
        if (variable.definition.getScope() == 0) {
            codeGenerator.pushGlobal(variable.definition.getOffSet());
        } else {
            codeGenerator.pushLocal(variable.definition.getOffSet());
        }
        return null;
    }

    @Override
    public Object visit(StructAccess structAccess, Object params) {
        structAccess.left.accept(this, params);
        codeGenerator.pushStruct(structAccess.left.getType().getField(structAccess.right).getOffSet());
        return null;
    }

    @Override
    public Object visit(ArrayAccess arrayAccess, Object params) {
        Int aux = new Int(0, 0);
        arrayAccess.expArray.accept(this, params);
        arrayAccess.expAccess.accept(this.valueCodeGeneratorVisitor, params);
        codeGenerator.push(aux, arrayAccess.getType().getSize());
        codeGenerator.arithmetic("*", aux);
        codeGenerator.arithmetic("+", aux);
        return null;
    }

    public void setValueCodeGenerator(ValueCodeGeneratorVisitor v) {
        this.valueCodeGeneratorVisitor = v;
    }

}
