package co.com.jcd.jsftutorial.services;

import java.util.List;
import java.util.Optional;

import co.com.jcd.jsftutorial.entities.Task;
import co.com.jcd.jsftutorial.entities.Usuario;

public interface ITaskService {
	
	public void save(Task t, Usuario u);
	public void update(Task u);
	public void delete(Task u);
	public Optional<Task> getById(Integer id);
	public List<Task> getAll();

}
