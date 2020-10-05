package co.com.jcd.jsftutorial.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tasks database table.
 *
 */
@Entity
@Table(name="tasks")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_task")
	private Integer idTask;

	private String completed;

	@Temporal(TemporalType.DATE)
	@Column(name="dead_line")
	private Date deadLine;

	private String description;

	private String title;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuarioBean;

	public Task() {
	}

	public Integer getIdTask() {
		return this.idTask;
	}

	public void setIdTask(Integer idTask) {
		this.idTask = idTask;
	}

	public String getCompleted() {
		return this.completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	public Date getDeadLine() {
		return this.deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}
