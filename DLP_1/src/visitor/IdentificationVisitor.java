package visitor;

import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.Variable;
import ast.statements.Statement;
import ast.symboltable.SymbolTable;
import ast.types.ErrorType;
import ast.types.Function;

public class IdentificationVisitor extends ConcreteVisitor {

    private SymbolTable symbolTable = new SymbolTable();

    @Override
    public Object visit(FunctionDefinition functionDefinition, Object params) {
        if(!symbolTable.insert(functionDefinition))
            functionDefinition.type = new ErrorType(functionDefinition.getRow(),functionDefinition.getColumn(),"Esta función ya está definida");
        symbolTable.set();;
        functionDefinition.type.accept(this,params);
        functionDefinition.lsVariables.forEach(v -> v.accept(this, params));
        functionDefinition.lsStatement.forEach(s -> s.accept(this, params));
        symbolTable.reset();
        return null;
    }

    @Override
    public Object visit(Function functionType, Object params) {
        for (VariableDefinition def : functionType.lsParams)
            def.accept(this, params);
        return null;
    }

    @Override
    public Object visit(VariableDefinition variableDefinition, Object params) {
        if(!symbolTable.insert(variableDefinition))
           variableDefinition.type = new ErrorType(variableDefinition.getRow(),variableDefinition.getColumn(),"Esta variable ya está definida");
        return null;
    }

    @Override
    public Object visit(Variable variable, Object params) {
        Definition def = symbolTable.find(variable.value);
        if (def == null)
            variable.type = new ErrorType(variable.getRow(),variable.getColumn(),"Esta variable no ha sido definida");
        variable.definition = def;
        return null;
    }
}
