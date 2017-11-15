package csu.cas.poac.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "plan")
public class Plan implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	long id;
	@Column(name="name")
	String name;
	@Column(name="timestart")
	String timestart;
	@Column(name="timestop")
	String timestop;
	

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTimestart() {
		return timestart;
	}

	public void setTimestart(String timestart) {
		this.timestart = timestart;
	}

	public String getTimestop() {
		return timestop;
	}

	public void setTimestop(String timestop) {
		this.timestop = timestop;
	}
	

	
}
