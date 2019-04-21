package visitor;

public class AdressCodeGeneratorVisitor extends AbstractCGVisitor{

    private CodeGenerator codeGenerator;
    public AdressCodeGeneratorVisitor(CodeGenerator codeGenerator){
        this.codeGenerator = codeGenerator;
    }
}
