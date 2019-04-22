package visitor;

import ast.expressions.IntLiteral;

public class ValueCodeGeneratorVisitor extends AbstractCGVisitor {

    private CodeGenerator codeGenerator;

    public ValueCodeGeneratorVisitor(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

    @Override
    public Object visit(IntLiteral intLiteral, Object params) {
        //NEED TOSTRING IN ALL EXPRESSIONS
        return null;
    }

}
