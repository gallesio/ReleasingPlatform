package services;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPONENT")
public class Component {
	
	private long comp_id;
	private String comp_name;
	private String comp_type;
	private String comp_ref;
	
	public Component() {}
	
	public Component(String name, String type, String ref) {
		this.comp_name = name;
		this.comp_type = type;
		this.comp_ref  = ref;
	}
	
	@Id @GeneratedValue
	@Column(name = "COMP_ID")
	public long getId() {
		return comp_id;
	}
	public void setId(long id) {
		this.comp_id = id;
	}
	
	@Column(name = "COMP_NAME", nullable = false, length = 250)
	public String getName() {
		return comp_name;
	}
	public void setName(String name) {
		this.comp_name = name;
	}
	
	@Column(name = "COMP_TYPE", nullable = false, length = 50)
	public String getType() {
		return comp_type;
	}
	public void setType(String type) {
		this.comp_type = type;
	}
	
	@Column(name = "COMP_REF", nullable = false, length = 50)
	public String getRef() {
		return comp_ref;
	}
	public void setRef(String ref) {
		this.comp_ref = ref;
	}
}
