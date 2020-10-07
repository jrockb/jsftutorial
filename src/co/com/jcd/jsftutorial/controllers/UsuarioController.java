package co.com.jcd.jsftutorial.controllers;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.jcd.jsftutorial.entities.Usuario;
import co.com.jcd.jsftutorial.services.UsuarioService;

@Named
@RequestScoped
public class UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger LOG = Logger.getLogger(Usuario.class);
	
	private Usuario usuario = new Usuario();
	@Inject
	private UsuarioService uService = new UsuarioService();

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void guardarUsuario() {
		LOG.info(String.format("Nombre: %s", this.usuario.getFirstName()));
		LOG.info(String.format("Apellido: %s", this.usuario.getLastName()));
		LOG.info(String.format("Estado civil: %s", this.usuario.getCivilStatus()));
		LOG.info(String.format("Nombre de usuario: %s", this.usuario.getUserName()));
		uService.save(this.usuario);
		LOG.info("Usuario guardado exitosamente");
		this.usuario = new Usuario();
	}

	/**
	 * @return the uService
	 */
	public UsuarioService getuService() {
		return uService;
	}

	/**
	 * @param uService the uService to set
	 */
	public void setuService(UsuarioService uService) {
		this.uService = uService;
	}

	

}
