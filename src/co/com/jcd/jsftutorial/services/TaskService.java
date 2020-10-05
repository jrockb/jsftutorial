package co.com.jcd.jsftutorial.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import co.com.jcd.jsftutorial.entities.Task;
import co.com.jcd.jsftutorial.entities.Usuario;
import co.com.jcd.jsftutorial.repositories.TaskRepository;

public class TaskService implements ITaskService {
	
	private final TaskRepository repo = new TaskRepository();
	private final UsuarioService uService = UsuarioService.getInstance();
	private static final TaskService INSTANCE = new TaskService();
	
	private TaskService() {
		// el constructor es privado para evitar que los Tasks
	    // creen nuevas instancias
	}
	
	public static TaskService getInstance() {
		return INSTANCE;
	}
	
	public void save(Task t, Usuario u ) {
		if (t != null && u != null) {
			t.setUsuarioBean(u);
			List<Task> listaTareas = new ArrayList<Task>();
			listaTareas = u.getTasks();
			if(listaTareas != null)
				u.getTasks().add(t);
			uService.update(u);
		}
		t.setCompleted("No");
		t.setDeadLine(new Date());
		repo.save(t);
	}
	
	public void update(Task obj) {
		repo.update(obj);
	}
	
	public void delete(Task obj) {
		repo.delete(obj);
	}
	
	public Optional<Task> getById(Integer id) {
		return repo.getById(id);
	}
	
	public List<Task> getAll() {
		return new LinkedList<>(repo.getAll());
	}


}
