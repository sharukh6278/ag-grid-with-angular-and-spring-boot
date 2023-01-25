package com.ag.grid.demo.model;

public class FilterModel {
    private String filter;
    private String filterType;
    private String type;

    public FilterModel(){}
    public FilterModel(String filter, String filterType, String type) {
        this.filter = filter;
        this.filterType = filterType;
        this.type = type;
    }

    @Override
    public String toString() {
        return "FilterModel{" +
                "filter='" + filter + '\'' +
                ", filterType='" + filterType + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
