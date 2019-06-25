package visitor;

import ast.expressions.ArrayAccess;
import ast.expressions.StructAccess;
import ast.expressions.Variable;

public class AdressCodeGeneratorVisitor extends AbstractCGVisitor {

    private CodeGenerator codeGenerator;

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
        arrayAccess.expArray.accept(this, params);
        codeGenerator.pushStruct(arrayAccess.getType().getTypeArray().getSize());
        return null;
    }

}
