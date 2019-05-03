package com.fsd.backend;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/fsdBackend")
public class FsdController {

	@Autowired
	private FsdService fsdService;
		
		
	@RequestMapping("/addTask")
	public String addTask(@RequestBody FsdJsonModel reqBody)
	{
		System.out.println("requestBody:" + reqBody.toString());
		Task task = convertFsdModeltoTask(reqBody);
		fsdService.saveTask(task);
		return  "Task with details:"  + reqBody.toString() + "Added Successfully" ;
	}
	
	@RequestMapping("/getAllTask")
	public List<Task> getAllTask()
	{
		List<Task> taskList = fsdService.getAllTaks();
		return  taskList;
	}
	
	
	@RequestMapping("/getTaskById/{taskId}")
	public Task getTaskById(@PathVariable(name="taskId")Long taskId )
	{
		Optional taskIfExist = fsdService.findById(taskId);
		if(taskIfExist != null) 
		return (Task) taskIfExist.get();
		else
		return null;	
	}
	
	@RequestMapping("/updateTask/{taskId}")
	public String updateTask(@RequestBody FsdJsonModel reqBody,@PathVariable(name="taskId")Long taskId)
	{
		System.out.println("requestBody:" + reqBody.toString());
		Optional taskIfExist = fsdService.findById(taskId);
		if(taskIfExist != null) {
		Task task = (Task) taskIfExist.get();
		task= updateTaskDetail(task,reqBody);		
		fsdService.saveTask(task);
		return  "Task with details:"  + reqBody.toString() + "Updated Successfully" ;
		}
		return "No Such Task Exists with TaskId:" + taskId;
		}
	
	
	private Task updateTaskDetail(Task task, FsdJsonModel reqBody) {
		
		if(task.getPriority() != reqBody.getPriority())
			task.setPriority(reqBody.getPriority());
		
		if(!task.getParentTask().equals(reqBody.getParentTask()))
			task.getParentTask().setParentTask(reqBody.getParentTask());
		
		if(!task.getTask().equals(reqBody.getTask()))
			task.setTask(reqBody.getTask());
		
		if(!task.getStartDate().equals(LocalDate.parse(reqBody.getStartDate())))
		    task.setStartDate(LocalDate.parse(reqBody.getStartDate()));
		
		if(!task.getEndDate().equals(LocalDate.parse(reqBody.getEndDate())))
		    task.setEndDate(LocalDate.parse(reqBody.getEndDate()));
		
		
		return task;
	}

	private Task convertFsdModeltoTask(FsdJsonModel reqBody) {
		Task  task = new Task();
		ParentTask parentTask = new ParentTask();
	    parentTask.setParentTask(reqBody.getParentTask());
	    task.setEndDate(LocalDate.parse(reqBody.getEndDate()));
	    task.setStartDate(LocalDate.parse(reqBody.getEndDate()));
	    task.setPriority(reqBody.getPriority());
	    task.setTask(reqBody.getTask());
	    task.setParentTask(parentTask);
		return task;
	}


}
