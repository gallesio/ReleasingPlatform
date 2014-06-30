package services;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FEATURE")
public class Feature {

	private long feat_id;
	private Component component;
	private String feat_name;
	
	public Feature() {}
	
	public Feature(String name, Component component) {
		this.feat_name = name;
		this.component = component;
	}

	@Id @GeneratedValue
	@Column(name = "FEAT_ID")
	public long getId() {
		return feat_id;
	}
	public void setId(long id) {
		this.feat_id = id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Component getComponent() {
		return component;
	}
	public void setComponent(Component component) {
		this.component = component;
	}

	@Column(name = "FEAT_NAME", nullable = false, length = 250)
	public String getName() {
		return feat_name;
	}
	public void setName(String name) {
		this.feat_name = name;
	}
}
