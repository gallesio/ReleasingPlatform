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
	@Column(name = "comp_id")
	Long comp_id;
	
	@Column(name = "comp_name")
	String comp_name;
	
	@Column(name = "comp_type")
	String comp_type;
	
	@Column(name = "comp_ref")
	String comp_ref;
	
	public Long getId() {
		return comp_id;
	}
	
	public void setId(Long id) {
		this.comp_id = id;
	}
	
	public String getName() {
		return comp_name;
	}
	
	public void setName(String name) {
		this.comp_name = name;
	}
	
	public String getType() {
		return comp_type;
	}
	
	public void setType(String type) {
		this.comp_type = type;
	}
	
	public String getRef() {
		return comp_ref;
	}
	
	public void setRef(String ref) {
		this.comp_ref = ref;
	}
}
