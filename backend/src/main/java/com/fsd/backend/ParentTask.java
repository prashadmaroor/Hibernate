package com.fsd.backend;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class ParentTask  implements Serializable {

@Id
@GeneratedValue
@NotNull
private long parentTaskId;

@NotNull
private String parentTask;

@OneToOne
private Task task;


public ParentTask() {
}


public ParentTask(@NotNull long parentTaskId, @NotNull String parentTask) {
	super();
	this.parentTaskId = parentTaskId;
	this.parentTask = parentTask;
}


public long getParentTaskId() {
	return parentTaskId;
}


public void setParentTaskId(long parentTaskId) {
	this.parentTaskId = parentTaskId;
}


public String getParentTask() {
	return parentTask;
}


public void setParentTask(String parentTask) {
	this.parentTask = parentTask;
}


@Override
public String toString() {
	return "ParentTask [parentTaskId=" + parentTaskId + ", parentTask=" + parentTask +"]";
}



	
}
