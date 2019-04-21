package visitor;

import ast.definitions.VariableDefinition;
import ast.expressions.Variable;

public class AdressCodeGeneratorVisitor extends AbstractCGVisitor {

    private CodeGenerator codeGenerator;

    public AdressCodeGeneratorVisitor(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

    @Override
    public Object visit(Variable variable, Object params) {
        if(variable.definition.getScope() == 0){
            codeGenerator.pusha(variable.definition.getOffSet());
        }
    }

}
