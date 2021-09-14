package com.codingstuff.dropdown;

import java.util.List;

public class DataModel {

    private List<String> nestedList;
    private String itemText;
    private boolean isExpandable;

    public DataModel(String itemText , List<String> nestedList){
        this.itemText = itemText;
        this.nestedList = nestedList;
        isExpandable = false;
    }

    public List<String> getNestedList() {
        return nestedList;
    }

    public String getItemText() {
        return itemText;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }
}
