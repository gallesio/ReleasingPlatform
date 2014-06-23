package services;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "component")
public class Component {
	
	@Id @GeneratedValue
	@Column(name = "id")
	int id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "type")
	String type;
	
	@Column(name = "ref")
	String ref;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getRef() {
		return ref;
	}
	
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	public Component() {
		this(0, "component-test-list", "comp-type-test", "comp-ref-test");
	}
	
	public Component(int id, String name, String type, String ref) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.ref = ref;
	}
}
