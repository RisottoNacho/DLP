package visitor;

import ast.expressions.Expression;
import ast.types.Type;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CodeGenerator {

    private PrintWriter out;
    private int labelCount;

    public CodeGenerator(String input, String output) {
        try {
            out = new PrintWriter(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        labelCount = 0;
    }

    public void pop(Type type) {
        out.println("\tpop"+type.subFix());
        out.flush();
    }

    public void call(String label) {
        out.println("\tcall " + label);
        out.flush();
    }

    public int getLabels(int plus) {
        int a = labelCount;
        labelCount = labelCount + plus;
        return a;
    }

    public void jmp(String label) {
        out.println("\tjmp " + label);
        out.flush();
    }

    public void jz(String label) {
        out.println("\tjz " + label);
        out.flush();
    }

    public void source(String programName) {
        out.println("#source " + "\"" + programName + "\"");
        out.flush();
    }

    public void load(Type type) {
        out.println("\tload" + type.subFix());
        out.flush();
    }

    public void unaryNot() {
        out.println("\tnot");
        out.flush();
    }

    public void logic(String op) {
        switch (op) {
            case "&&":
                out.println("\tand");
                break;
            case "||":
                out.println("\tor");
                break;
        }
        out.flush();
    }

    public void comparison(String op, Type type) {
        switch (op) {
            case ">":
                out.println("\tgt" + type.subFix());
                break;
            case "<":
                out.println("\tlt" + type.subFix());
                break;
            case ">=":
                out.println("\tge" + type.subFix());
                break;
            case "<=":
                out.println("\tle" + type.subFix());
                break;
            case "==":
                out.println("\teq" + type.subFix());
                break;
            case "!=":
                out.println("\tne" + type.subFix());
                break;
        }
        out.flush();
    }

    public void arithmetic(String op, Type type) {
        switch (op) {
            case "+":
                out.println("\tadd" + type.subFix());
                break;
            case "-":
                out.println("\tsub" + type.subFix());
                break;
            case "*":
                out.println("\tmul" + type.subFix());
                break;
            case "/":
                out.println("\tdiv" + type.subFix());
                break;
            case "%":
                out.println("\tmod" + type.subFix());
                break;
        }
        out.flush();
    }

    public void convertTo(Type type, Type targetType) {
        String data = "";
        if (targetType.toString().compareTo("Double") == 0) {
            if (type.toString().compareTo("Char") == 0) {
                data += "\tb2i";
                data += "\n\ti2f";
            } else if (type.toString().compareTo("Int") == 0)
                data += "\ti2f";
        } else if (targetType.toString().compareTo("Char") == 0) {
            if (type.toString().compareTo("Double") == 0) {
                data += "\tf2i";
                data += "\n\ti2b";
            } else if (type.toString().compareTo("Int") == 0)
                data += "\ti2b";
        } else {
            if (type.toString().compareTo("Char") == 0) {
                data += "\tb2i";
            } else if (type.toString().compareTo("Double") == 0) {
                data += "\tf2i";
            }
        }
        if (data != "") {
            out.println(data);
            out.flush();
        }
    }

    public void enter(int size) {
        out.println("\tenter " + size);
        out.flush();
    }

    public void labelFor(String name) {
        out.println(name + ":");
        labelCount++;
        out.flush();
    }

    public void ret(int left, int bytesLocals, int bytesParams) {
        out.println("\tret " + left + "," + bytesLocals + "," + bytesParams);
        out.flush();
    }

    public void push(Expression expression) {
        out.println("\tpush" + expression.getType().subFix() + " " + expression.getValue().toString());
        out.flush();
    }

    public void push(Type tipo, int offset) {
        out.println("\tpush" + tipo.subFix() + " " + offset);
        out.flush();
    }

    public void pushGlobal(int offset) {
        out.println("\tpusha " + offset);
        out.flush();
    }

    public void pushStruct(int offset) {
        out.println("\tpushi " + offset);
        out.println("\taddi");
        out.flush();
    }

    public void pushLocal(int offset) {
        out.println("\tpush bp");
        out.println("\tpushi " + offset);
        out.println("\taddi");
        out.flush();
    }

    public void row(int line) {
        out.println("#Line  " + line);
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
        out.println("\tin" + type.subFix());
        out.flush();
    }

    public void store(Type type) {
        out.println("\tstore" + type.subFix());
        out.flush();
    }
}
