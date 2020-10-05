package co.com.jcd.jsftutorial.main;

import java.util.ArrayList;
import java.util.List;

import co.com.jcd.jsftutorial.entities.Task;
import co.com.jcd.jsftutorial.entities.Usuario;
import co.com.jcd.jsftutorial.services.TaskService;
import co.com.jcd.jsftutorial.services.UsuarioService;

public class App {

	public static void main(String[] args) {
		UsuarioService uService = UsuarioService.getInstance();
		TaskService tService = TaskService.getInstance();
		
		Usuario u = new Usuario();
		List<Usuario> u2;
		u.setFirstName("Jonny");
		u.setLastName("Bernal");
		u.setUserName("jrockb");
		u.setCivilStatus("Soltero");
		u2 = uService.getByNombre(u.getUserName());
		if(u2.isEmpty()) {
			uService.save(u);
		} else {
			u = u2.get(0);
		}		
		
		Task t = new Task();
		t.setTitle("Construir aplicacion JSF");
		t.setDescription("prueba");
		tService.save(t, u);

	}

}
