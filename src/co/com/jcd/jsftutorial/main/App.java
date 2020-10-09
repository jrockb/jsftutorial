package co.com.jcd.jsftutorial.main;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import co.com.jcd.jsftutorial.entities.Task;
import co.com.jcd.jsftutorial.entities.Usuario;
import co.com.jcd.jsftutorial.services.TaskService;
import co.com.jcd.jsftutorial.services.UsuarioService;

public class App {
	
	public static void enviarCorreo(List<String> conceptos, String nitPagaduria) 
	{
		try {
			Properties props = new Properties();

			// Nombre del host de correo, es smtp.gmail.com
			props.setProperty("mail.smtp.host", "smtp.gmail.com");

			// TLS si está disponible
			props.setProperty("mail.smtp.starttls.enable", "true");

			// Puerto de gmail para envio de correos
			props.setProperty("mail.smtp.port","587");

			// Nombre del usuario
			props.setProperty("mail.smtp.user", "filtrosber@gmail.com");

			// Si requiere o no usuario y password para conectarse.
			props.setProperty("mail.smtp.auth", "true");
			
			Session session = Session.getDefaultInstance(props);
			
			session.setDebug(true);
			
			MimeMessage message = new MimeMessage(session);
			
			// Quien envia el correo
			message.setFrom(new InternetAddress("filtrosber@gmail.com"));
			
			String[] direcciones= {"thals1981@cuvox.de"};
			
			for(String direccion : direcciones) {
				message.addRecipient(Message.RecipientType.TO, 
						new InternetAddress(direccion));
			}			
			
			
			message.setSubject("Conceptos por parametrizar: "+new Date());
			message.setContent(construirMensaje(conceptos, nitPagaduria),"text/html;charset=utf-8");
			
			Transport t = session.getTransport("smtp");
			
			t.connect("filtrosber@gmail.com","fb5721235");
			
			t.sendMessage(message,message.getAllRecipients());
			
			t.close();
			
		} catch(Exception ex) {
			System.out.println("Error enviando correo "+ ex.getMessage());
		}
      
	}
	
	private static String construirMensaje(List<String> conceptos, String nitPagaduria) {
		
		StringBuilder mensaje = new StringBuilder();
		
		for(String concepto : conceptos) {
			mensaje.append("<tr><td>"+concepto+"</td></tr>"); 
		}
		
		
		String plantillaPagaduria = "<h4>Nit de pagaduria: %s</h4>"
				+"<table style='width: 602px;' border='1'>"

				+"<tr style='height: 81px;'>"

				+"<th>CONCEPTO</th>"
				
				+"%s</table>";
				
		
				
		return String.format(plantillaPagaduria, nitPagaduria, mensaje);
		
	}

	public static void main(String[] args) {
		TaskService tService = new TaskService();
		UsuarioService uService = new UsuarioService();
		List<Task> tareas = new ArrayList<>();
		tareas = tService.getAll();
		for(Task tarea : tareas) {
			System.out.println(tarea.getTitle());
		}
		
//		Usuario u = new Usuario();
//		List<Usuario> u2;
//		u.setFirstName("preuab");
//		u.setLastName("Perez");
//		u.setUserName("ppersdez123");
//		u.setCivilStatus("Soltero");
//		u2 = uService.getByNombre(u.getUserName());
//		if(u2.isEmpty()) {
//			uService.save(u);
//		} else {
//			u = u2.get(0);
//		}		
//		
//		Task t = new Task();
//		t.setTitle("Construir aplicacion JSF");
//		t.setDescription("prueba");
//		tService.save(t, u);
//		List<String> conceptos= Arrays.asList("concepto1", "concepto2","concepto3","concepto4");
//		String nitPagaduria= "45646548476546";
//		enviarCorreo(conceptos, nitPagaduria);
		

	      
	}

}
