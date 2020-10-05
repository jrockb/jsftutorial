package co.com.jcd.jsftutorial.controllers;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class TaskController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mensaje;

	public TaskController() {
		this.mensaje = "Hola mundo";
	}

	public String getMensaje() {
		this.mensaje += String.format(", desde %s", this.getClass().getName());
		return mensaje;
	}
	

}
