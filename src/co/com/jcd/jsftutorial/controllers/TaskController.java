package co.com.jcd.jsftutorial.controllers;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.jcd.jsftutorial.entities.Task;
import co.com.jcd.jsftutorial.entities.Usuario;
import co.com.jcd.jsftutorial.services.TaskService;
import co.com.jcd.jsftutorial.services.UsuarioService;

@Named
@RequestScoped
public class TaskController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger LOG = Logger.getLogger(TaskController.class);
	
	@Inject
	private TaskService tService = new TaskService();
	@Inject
	private UsuarioService uService = new UsuarioService();
	private Task tarea = new Task();
	private String usuario;
	
	public void guardarTarea() {
		LOG.info(String.format("Titulo de la tarea: %s", this.tarea.getTitle()));
		LOG.info(String.format("Descripcion de la tarea: %s", this.tarea.getDescription()));
		Usuario usuario = uService.getByNombre(this.usuario.trim()).get(0);
		tService.save(this.tarea, usuario);
		this.usuario = "";
		this.tarea = new Task();
	}

	public Task getTarea() {
		return tarea;
	}

	public void setTarea(Task tarea) {
		this.tarea = tarea;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public TaskService gettService() {
		return tService;
	}

	public void settService(TaskService tService) {
		this.tService = tService;
	}

	public UsuarioService getuService() {
		return uService;
	}

	public void setuService(UsuarioService uService) {
		this.uService = uService;
	}	
	
	
	

}
