package services;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RELEASES")
public class Release {
	
	private long rid;
	private String release_name;
	private String release_owner;
	private String release_status;
	//private Set<Component> components_list;
	//private Set<Feature> features_list;
	
	public Release() {}
	
	public Release(String name, String owner, String status) {
		this.release_name = name;
		this.release_owner = owner;
		this.release_status = status;
	}
	
	public Release(String name, String owner, String status, Set<Component> componentsList, Set<Feature> featuresList) {
		this.release_name = name;
		this.release_owner = owner;
		this.release_status = status;
//		this.components_list = componentsList;
//		this.features_list = featuresList();
	}

	@Id @GeneratedValue
	@Column(name = "RID")
	public long getId() {
		return rid;
	}

	public void setId(long rid) {
		this.rid = rid;
	}

	@Column(name = "RELEASE_NAME", nullable = false, length = 250)
	public String getName() {
		return release_name;
	}

	public void setName(String name) {
		this.release_name = name;
	}

	@Column(name = "RELEASE_OWNER", nullable = false, length = 100)
	public String getOwner() {
		return release_owner;
	}

	public void setOwner(String owner) {
		this.release_owner = owner;
	}

	@Column(name = "RELEASE_STATUS", nullable = false, length = 50)
	public String getStatus() {
		return release_status;
	}

	public void setStatus(String status) {
		this.release_status = status;
	}

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "RELEASE_COMPONENT", joinColumns = { @JoinColumn(name = "RID") }, inverseJoinColumns = { @JoinColumn(name = "COMP_ID") })
//	public Set<Component> getComponentsList() {
//		return components_list;
//	}
//
//	public void setComponentsList(Set<Component> components_list) {
//		this.components_list = components_list;
//	}

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "RELEASE_FEATURE", joinColumns = { @JoinColumn(name = "RID") }, inverseJoinColumns = { @JoinColumn(name = "FEAT_ID") })
//	public Set<Feature> getFeaturesList() {
//		return features_list;
//	}
//
//	public void setFeaturesList(Set<Feature> features_list) {
//		this.features_list = features_list;
//	}
}
