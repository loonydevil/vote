package food.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vote database table.
 * 
 */
@Entity
@NamedQuery(name="Vote.findAll", query="SELECT v FROM Vote v")
public class Vote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//uni-directional many-to-one association to Restorant
	@ManyToOne
	private Restorant restorant;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Vote() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Restorant getRestorant() {
		return this.restorant;
	}

	public void setRestorant(Restorant restorant) {
		this.restorant = restorant;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}