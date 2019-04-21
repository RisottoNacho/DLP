package visitor;

import ast.expressions.Variable;

public class AdressCodeGeneratorVisitor extends AbstractCGVisitor {

    private CodeGenerator codeGenerator;

    public AdressCodeGeneratorVisitor(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

    @Override
    public Object visit(Variable variable, Object params) {
        if(variable.definition.getScope() == 0){
            codeGenerator.pushGlobal(variable.definition.getOffSet());
        }
        else{
            codeGenerator.pushLocal(variable.definition.getOffSet());
        }
        return null;
    }

}
