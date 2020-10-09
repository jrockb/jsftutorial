package co.com.jcd.jsftutorial.repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import co.com.jcd.jsftutorial.entities.Task;

public class TaskRepository implements DaoRepository<Task> {
	
	private static Logger LOG = Logger.getLogger(TaskRepository.class);
	
	@Override
	public void save(Task obj) {
		Session session = FACTORY.openSession();
		Transaction trans = session.beginTransaction();
		try {
			session.save(obj);
			LOG.info("Tarea guardado exitosamente");
		} catch(Exception e) {
			LOG.info("Error: "+e.getMessage());
		}finally {
			trans.commit();
			session.close();
		}
		
	}

	@Override
	public void update(Task obj) {
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
	public void delete(Task obj) {
		Session session = FACTORY.openSession();
		Transaction trans = session.beginTransaction();
		try {
			Optional<Task> opt = this.getById(obj.getIdTask());
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
	public Optional<Task> getById(Integer id) {
		Session session = FACTORY.openSession();
		Transaction trans = session.beginTransaction();
		String jpql = "SELECT u FROM tasks u WHERE u.id_task = :id";
		Task task = session.createQuery(jpql, Task.class)
				.setParameter("id", id).getSingleResult();
		trans.commit();
		session.close();
		return Optional.of(task);
	}

	@Override
	public List<Task> getAll() {
		Session session = FACTORY.openSession();
		Transaction trans = session.beginTransaction();
		List<Task> tasks = new LinkedList<>();
		try {
			String jpql = "SELECT u FROM Task u";
			Query<Task> query = session.createQuery(jpql, Task.class); // Paso 1
			tasks.addAll(query.getResultList()); // Paso 2
			LOG.info("Retornando todos los registros de tareas");
		} catch (Exception e) {
			LOG.error("Error: " + e.getMessage());
		} finally {
			trans.commit();
			session.close();
		}
		return tasks; // Paso 3;
	}

}
