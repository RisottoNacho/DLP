package visitor;

import ast.types.Type;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CodeGenerator {

    private PrintWriter out;

    public CodeGenerator(String input, String output) {
        try {
            out = new PrintWriter(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void mainInvocation() {
        out.println("call main");
        out.flush();
    }

    public void halt() {
        out.println("halt");
        out.flush();
    }

    public void out(Type type) {
        out.println("out" + type.subFix());
    }
}
