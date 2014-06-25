package services;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feature")
public class Feature {
	
	@Id @GeneratedValue
	@Column(name = "feat_id")
	Long feat_id;
	
	@Column(name = "comp_id")
	Long comp_id;
	
	@Column(name = "feat_name")
	String feat_name;

	public Long getFeat_id() {
		return feat_id;
	}

	public void setFeat_id(Long id) {
		this.feat_id = id;
	}

	public Long getComp_id() {
		return comp_id;
	}

	public void setComp_id(Long id) {
		this.comp_id = id;
	}

	public String getFeat_name() {
		return feat_name;
	}

	public void setFeat_name(String name) {
		this.feat_name = name;
	}
}
