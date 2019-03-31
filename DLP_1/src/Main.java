import parser.*;

import org.antlr.v4.runtime.*;

import ast.ErrorHandler;
import ast.Program;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;
import visitor.IdentificationVisitor;
import visitor.LValueVisitor;
import visitor.TypeCheckingVisitor;

public class Main {

    public static void main(String... args) throws Exception {
        if (args.length < 1) {
            System.err.println("Please, pass me the input file.");
            return;
        }

        // create a lexer that feeds off of input CharStream
        CharStream input = CharStreams.fromFileName(args[0]);
        PmmLexer lexer = new PmmLexer(input);

        // create a parser that feeds off the tokens buffer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PmmParser parser = new PmmParser(tokens);
        Program ast = parser.program().ast;

        LValueVisitor lValueVisitor = new LValueVisitor();
        lValueVisitor.visit(ast, null);
        IdentificationVisitor identificationVisitor = new IdentificationVisitor();
        identificationVisitor.visit(ast, null);
        TypeCheckingVisitor typeCheckingVisitor = new TypeCheckingVisitor();
        typeCheckingVisitor.visit(ast, null);
        // * The AST is shown
        if (ErrorHandler.getInstance().anyError()) {
            ErrorHandler.getInstance().showErrors(System.out);
        } else {
            IntrospectorModel model = new IntrospectorModel("Program", ast);
            new IntrospectorTree("Introspector", model);
        }
    }
}
