package io.github.cow53612.newlasersystem.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Type {

    private Map<String, String> type;

    public Type() {
        type = new HashMap<>();

        type.put("1", "簡単");
        type.put("2", "普通");
        type.put("3", "難しい");
    }

    public Map<String, String> getType() {
        return type;
    }

    public void setType(Map<String, String> type) {
        this.type = type;
    }

}
