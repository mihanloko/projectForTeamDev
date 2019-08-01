package com.simpleApp.model;

public class ApplicationsForm {
    private Long id;
    private String nameApplication;
    private String previousApplication;
    private String nextApplication;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameApplication() {
        return nameApplication;
    }

    public void setNameApplication(String nameApplication) {
        this.nameApplication = nameApplication;
    }

    public String getPreviousApplication() {
        return previousApplication;
    }

    public void setPreviousApplication(String previousApplication) {
        this.previousApplication = previousApplication;
    }

    public String getNextApplication() {
        return nextApplication;
    }

    public void setNextApplication(String nextApplication) {
        this.nextApplication = nextApplication;
    }
}
