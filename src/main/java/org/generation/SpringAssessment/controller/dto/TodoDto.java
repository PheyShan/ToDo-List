package org.generation.SpringAssessment.controller.dto;


import java.sql.Date;

public class TodoDto {

    private String title;
    private String description;
    private Date targetDate;

    //Constructor
    public TodoDto(String title, String description, Date targetDate) {
        this.title = title;
        this.description = description;
        this.targetDate = targetDate;
    }

    //Getter & setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

}
