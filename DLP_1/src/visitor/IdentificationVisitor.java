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
        symbolTable.set();;
        functionDefinition.functionType.accept(this,params);
        for(VariableDefinition v : functionDefinition.lsVariables){
            v.accept(this,params);
        }
        for (Statement s : functionDefinition.lsStatement) {
            s.accept(this, params);
        }
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
            new ErrorType(variableDefinition.getRow(),variableDefinition.getColumn(),"Esta variable ya está definida");
        return null;
    }

    @Override
    public Object visit(Variable variable, Object params) {
        Definition def = symbolTable.find(variable.value);
        if (def == null)
            new ErrorType(variable.getRow(),variable.getColumn(),"Esta variable no ha sido definida");
        variable.definition = def;
        return null;
    }
}
