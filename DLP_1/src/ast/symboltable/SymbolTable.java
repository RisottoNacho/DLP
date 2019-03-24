package ast.symboltable;

import java.util.*;

import ast.definitions.*;

public class SymbolTable {

    private int scope = 0;
    private List<Map<String, Definition>> table;

    public SymbolTable() {
        table = new ArrayList<>();
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
            getLastMap().put(definition.getName(),definition);
            return true;
        }
        return false;
    }

    public Definition find(String id) {
        for (Map<String, Definition> m : table
        ) {
            if (m.containsKey(id))
                return getLastMap().get(id);
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
