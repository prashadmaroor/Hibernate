package com.fsd.backend;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Task implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private long taskId;
	
	@NotNull
	private String task;
	
	@NotNull
	private int priority;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd" )
	@NotNull
	private LocalDate startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd" )
	@NotNull
	private LocalDate endDate;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private ParentTask parentTask;


	public Task() {
	}


	public Task(@NotNull long taskId, @NotNull String task, @NotNull int priority, @NotNull LocalDate startDate,
			@NotNull LocalDate endDate, ParentTask parentTask) {
		super();
		this.taskId = taskId;
		this.task = task;
		this.priority = priority;
		this.startDate = startDate;
		this.endDate = endDate;
		this.parentTask = parentTask;
	}


	public long getTaskId() {
		return taskId;
	}


	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}


	public String getTask() {
		return task;
	}


	public void setTask(String task) {
		this.task = task;
	}


	public int getPriority() {
		return priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public ParentTask getParentTask() {
		return parentTask;
	}


	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}


	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", task=" + task + ", priority=" + priority + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", parentTask=" + parentTask + "]";
	}
	
	
	
}
