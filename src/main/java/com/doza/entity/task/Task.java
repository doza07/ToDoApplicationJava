package com.doza.entity.task;

import java.time.LocalDate;
import java.util.Objects;


public class Task {
    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate updateDate;
    private LocalDate endDate;
    private TaskStatus taskStatus;

    public Task() {
    }

    public Task(Long id, String name, String description, LocalDate startDate, LocalDate updateDate, LocalDate endDate, TaskStatus taskStatus) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.updateDate = updateDate;
        this.endDate = endDate;
        this.taskStatus = taskStatus;
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

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(startDate, task.startDate) && Objects.equals(updateDate, task.updateDate) && Objects.equals(endDate, task.endDate) && taskStatus == task.taskStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, startDate, updateDate, endDate, taskStatus);
    }

    @Override
    public String toString() {
        return "Task{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", startDate=" + startDate +
               ", updateDate=" + updateDate +
               ", endDate=" + endDate +
               ", taskStatus=" + taskStatus +
               '}';
    }
}
