package services;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RELEASE_CONSTRUCTIONS")
public class ReleaseConstruction {
	
	private long rel_cons_id;
	private String rel_cons_name;
	private String rel_cons_owner;
	private String rel_cons_status;
	private String rel_cons_codelevel;
//	private Release release;
	
	public ReleaseConstruction() {}
	
	public ReleaseConstruction(String name, String owner, String status, String codeLevel) {
		this.rel_cons_name = name;
		this.rel_cons_owner = owner;
		this.rel_cons_status = status;
		this.rel_cons_codelevel = codeLevel;
	}
	
//	public ReleaseConstruction(String name, String owner, String status, String codeLevel, Release release) {
//		this.rel_cons_name = name;
//		this.rel_cons_owner = owner;
//		this.rel_cons_status = status;
//		this.rel_cons_codelevel = codeLevel;
//		this.release = release;
//	}

	@Id @GeneratedValue
	@Column(name = "REL_CONS_ID")
	public long getId() {
		return rel_cons_id;
	}

	public void setId(long id) {
		this.rel_cons_id = id;
	}

	@Column(name = "REL_CONS_NAME", nullable = false, length = 250)
	public String getName() {
		return rel_cons_name;
	}

	public void setName(String name) {
		this.rel_cons_name = name;
	}

	@Column(name = "REL_CONS_OWNER", nullable = false, length = 100)
	public String getOwner() {
		return rel_cons_owner;
	}

	public void setOwner(String owner) {
		this.rel_cons_owner = owner;
	}

	@Column(name = "REL_CONS_STATUS", nullable = false, length = 50)
	public String getStatus() {
		return rel_cons_status;
	}

	public void setStatus(String status) {
		this.rel_cons_status = status;
	}

	@Column(name = "REL_CONS_CODELEVEL", nullable = false, length = 50)
	public String getCodeLevel() {
		return rel_cons_codelevel;
	}

	public void setCodeLevel(String codeLevel) {
		this.rel_cons_codelevel = codeLevel;
	}

	
//	public Release getRelease() {
//		return release;
//	}
//
//	public void setRelease(Release release) {
//		this.release = release;
//	}
	
}
