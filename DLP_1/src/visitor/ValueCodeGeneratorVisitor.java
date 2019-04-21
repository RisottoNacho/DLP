package visitor;

public class ValueCodeGeneratorVisitor extends AbstractCGVisitor {

    private CodeGenerator codeGenerator;
    public ValueCodeGeneratorVisitor(CodeGenerator codeGenerator){
        this.codeGenerator = codeGenerator;
    }
}
