package ast.symboltable;

import java.util.*;

import ast.definitions.*;

public class SymbolTable {

    private int scope = -1;
    private List<Map<String, Definition>> table;

    public SymbolTable() {
        table = new ArrayList<>();
        set();
    }

    public void set() {
        Map<String, Definition> mp = new HashMap<>();
        scope++;
        table.add(mp);
    }

    public void reset() {
        scope--;
        table.remove(getLastMap());
    }

    public boolean insert(Definition definition) {
        if (findInCurrentScope(definition.getName()) == null) {
            definition.setScope(scope);
            getLastMap().put(definition.getName(), definition);
            return true;
        }
        return false;
    }

    public Definition find(String id) {
        for (int i = table.size() - 1; i >= 0; i--) {
            if (table.get(i).containsKey(id))
                return table.get(i).get(id);
        }
        return null;
    }

    public Definition findInCurrentScope(String id) {
        if (getLastMap().containsKey(id))
            return getLastMap().get(id);
        return null;
    }

    private Map<String, Definition> getLastMap() {
        return table.get(table.size() - 1);
    }
}
