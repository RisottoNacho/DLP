package visitor;

import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.Variable;
import ast.statements.Statement;
import ast.symboltable.SymbolTable;
import ast.types.ErrorType;

public class IdentificationVisitor extends ConcreteVisitor {

    private SymbolTable symbolTable = new SymbolTable();

    @Override
    public Object visit(FunctionDefinition functionDefinition, Object params) {
        for (Statement s : functionDefinition.lsStatement) {
            s.accept(this, params);
        }
        functionDefinition.functionType.accept(this,params);
        symbolTable.set();;
        for(VariableDefinition v : functionDefinition.lsVariables){
            v.accept(this,params);
            if(!symbolTable.insert(v))
                new ErrorType(v.getRow(),v.getColumn(),"Esta variable ya está definida");
        }
        symbolTable.reset();
        return null;
    }

    @Override
    public Object visit(VariableDefinition variableDefinition, Object params) {
        if(!symbolTable.insert(variableDefinition))
            new ErrorType(variableDefinition.getRow(),variableDefinition.getColumn(),"Esta variable ya está definida");
        return null;
    }

    @Override
    public Object visit(Variable variable, Object params) {
        if (symbolTable.find(variable.value) == null)
            new ErrorType(variable.getRow(),variable.getColumn(),"Esta variable no ha sido definida");
        return null;
    }
}
