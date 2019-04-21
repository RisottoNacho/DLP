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

    public void pushGlobal(int offset) {
        out.println("pusha " + offset);
        out.flush();
    }

    public void pushLocal(int offset) {
        out.println("pusha bp");
        out.println("pushi "+offset);
        out.println("add");
        out.flush();
    }

    public void row(int line) {
        out.println("#Line " + line);
        out.flush();
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
        out.println("\tout" + type.subFix());
        out.flush();
    }

    public void in(Type type) {
        out.println("\tout" + type.subFix());
        out.flush();
    }

    public void store(Type type) {
        out.println("\tstore" + type.subFix());
        out.flush();
    }
}
