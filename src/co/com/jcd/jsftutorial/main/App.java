package co.com.jcd.jsftutorial.main;

import co.com.jcd.jsftutorial.entities.Task;
import co.com.jcd.jsftutorial.entities.Usuario;
import co.com.jcd.jsftutorial.services.TaskService;
import co.com.jcd.jsftutorial.services.UsuarioService;

public class App {

	public static void main(String[] args) {
		UsuarioService uService = UsuarioService.getInstance();
		TaskService tService = TaskService.getInstance();
		
		Usuario u = new Usuario();
		u.setFirstName("Margarita");
		u.setLastName("Robles");
		u.setUserName("margarita_32");
		u.setCivilStatus("Soltera");
		uService.save(u);
		
		Task t = new Task();
		t.setTitle("Construir aplicacion JSF");
		t.setDescription("Terminal de leer el tutorial");
		tService.save(t, u);

	}

}
