package com.fsd.backend;

/**
 * @author user
 *
 */
public class FsdJsonModel {
	
	private String task;
	private String startDate;
	private String endDate;
	private int priority;
	private String parentTask;
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getParentTask() {
		return parentTask;
	}
	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}
	
	@Override
	public String toString() {
		return "FsdJsonModel [task=" + task + ", startDate=" + startDate + ", endDate=" + endDate + ", priority="
				+ priority + ", parentTask=" + parentTask + "]";
	}
	
	

}
