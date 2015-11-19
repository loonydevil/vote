package food.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String dish;

	private BigDecimal price;

	//bi-directional many-to-one association to Restorant
	@ManyToOne
	private Restorant restorant;

	public Menu() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDish() {
		return this.dish;
	}

	public void setDish(String dish) {
		this.dish = dish;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Restorant getRestorant() {
		return this.restorant;
	}

	public void setRestorant(Restorant restorant) {
		this.restorant = restorant;
	}

}