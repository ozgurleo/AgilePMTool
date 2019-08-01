package io.ozguraslan.ppmtool.exception;

public class ProjectIdExceptionRespond {//voor het bericht van exception

    private String projectIdentifier;

    public ProjectIdExceptionRespond() {
    }

    public ProjectIdExceptionRespond(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}
