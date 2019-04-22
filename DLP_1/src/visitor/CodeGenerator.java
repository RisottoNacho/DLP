package visitor;

import ast.expressions.Expression;
import ast.types.Int;
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

    public void enter(int size){
        out.println("enter "+size);
        out.flush();
    }

    public void labelFor(String name){
        out.println(name+":");
        out.flush();
    }

    public void push(Expression expression){
        out.println("\tpush"+expression.getType().subFix()+" "+expression.);
        out.flush();
    }

    public void pushGlobal(int offset) {
        out.println("\tpusha " + offset);
        out.flush();
    }

    public void pushLocal(int offset) {
        out.println("\tpusha bp");
        out.println("\tpushi "+offset);
        out.println("\tadd");
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
