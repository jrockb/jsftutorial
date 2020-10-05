package co.com.jcd.jsftutorial.services;

import java.util.List;
import java.util.Optional;

import co.com.jcd.jsftutorial.entities.Usuario;

public interface IUsuarioService {
	
	public void save(Usuario u);
	public void update(Usuario u);
	public void delete(Usuario u);
	public Optional<Usuario> getById(Integer id);
	public List<Usuario> getByNombre(String nombre);
	public List<Usuario> getAll();
	

}
