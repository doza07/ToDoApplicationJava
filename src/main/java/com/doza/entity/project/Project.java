package com.doza.entity.project;

import com.doza.entity.task.Task;
import com.doza.entity.person.Person;

import java.time.LocalDate;
import java.util.List;

public class Project {
    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate updateDate;
    private LocalDate endDate;
    private List<Task> taskList;
    private List<Person> userList;

    public Project() {
    }

    public Project(Long id, String name, String description, LocalDate startDate, LocalDate updateDate, LocalDate endDate, List<Task> taskList, List<Person> userList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.updateDate = updateDate;
        this.endDate = endDate;
        this.taskList = taskList;
        this.userList = userList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Person> getUserList() {
        return userList;
    }

    public void setUserList(List<Person> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Project{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", startDate=" + startDate +
               ", updateDate=" + updateDate +
               ", endDate=" + endDate +
               ", taskList=" + taskList +
               ", userList=" + userList +
               '}';
    }
}

