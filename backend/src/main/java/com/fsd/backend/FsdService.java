package com.fsd.backend;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.google.common.collect.Lists;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class FsdService {

	private final FsdRepo fsdRepo;
	
	public FsdService(FsdRepo fsdRepo) {
		this.fsdRepo = fsdRepo;
	}
	
	public Task saveTask(Task task) {
		Task i = fsdRepo.save(task);
		return i;
	}
	
	public Optional<Task> findById(Long Id) {
		Optional<Task> task = fsdRepo.findById(Id);
		return task;
	}

	public List<Task> getAllTaks()
	{
		Iterable<Task> task = fsdRepo.findAll();
		List<Task> taskList = Lists.newArrayList(task);
		return taskList;
	}

	
	
}
