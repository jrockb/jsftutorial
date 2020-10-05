package co.com.jcd.jsftutorial.repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;


import co.com.jcd.jsftutorial.entities.Usuario;

public class UsuarioRepository implements DaoRepository<Usuario> {
	
	private static Logger LOG = Logger.getLogger(UsuarioRepository.class);

	@Override
	public void save(Usuario obj) {		
		Session session = FACTORY.openSession();
		Transaction trans = session.beginTransaction();
		try {
			session.save(obj);
			LOG.info("Usuario guardado exitosamente");
		} catch(Exception e) {
			LOG.info("Error: "+e.getMessage());
		}finally {
			trans.commit();
			session.close();
		}
		
	}

	@Override
	public void update(Usuario obj) {
		Session session = FACTORY.openSession();
		Transaction trans = session.beginTransaction();
		try {
			session.update(obj);
			LOG.info("Usuario actualizado exitosamente");
		} catch(Exception e) {
			LOG.info("Error: "+e.getMessage());
		}finally {
			trans.commit();
			session.close();
		}		
	}

	@Override
	public void delete(Usuario obj) {
		Session session = FACTORY.openSession();
		Transaction trans = session.beginTransaction();
		try {
			Optional<Usuario> opt = this.getById(obj.getIduser());
			if(opt.isPresent()) {
				session.delete(opt.get());
				LOG.info("Usuario eliminado satisfactoriamente");
			}			
		} catch(Exception e) {
			LOG.info("Error: "+e.getMessage());
		}finally {
			trans.commit();
			session.close();
		}	
		
	}

	@Override
	public Optional<Usuario> getById(Integer id) {
		Session session = FACTORY.openSession();
		Transaction trans = session.beginTransaction();
		String jpql = "SELECT u FROM Usuario u WHERE u.iduser = :id";
		Usuario usuario = session.createQuery(jpql, Usuario.class)
				.setParameter("id", id).getSingleResult();
		trans.commit();
		session.close();
		return Optional.of(usuario);
	}

	@Override
	public List<Usuario> getAll() {
		Session session = FACTORY.openSession();
		Transaction trans = session.beginTransaction();
		List<Usuario> usuarios = new LinkedList<>();
		try {
			String jpql = "SELECT u FROM Usuario u";
			Query<Usuario> query = session.createQuery(jpql, Usuario.class); // Paso 1
			usuarios.addAll(query.getResultList()); // Paso 2
			LOG.info("Retornando todos los registros de usuarios...");
		} catch (Exception e) {
			LOG.error("Error: " + e.getMessage());
		} finally {
			trans.commit();
			session.close();
		}

		return usuarios; // Paso 3
	}
	

}
