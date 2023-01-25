package com.ag.grid.demo.model;

public class CompanyResponse {
    private long id;
    private String companyName;

    private String employeeName;

    private String description;

    private int leave;

    public CompanyResponse(){}

    public CompanyResponse(long id, String companyName, String employeeName, String description, int leave) {
        this.id = id;
        this.companyName = companyName;
        this.employeeName = employeeName;
        this.description = description;
        this.leave = leave;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLeave() {
        return leave;
    }

    public void setLeave(int leave) {
        this.leave = leave;
    }
}
