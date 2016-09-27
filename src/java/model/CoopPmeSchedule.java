/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_pme_schedule")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopPmeSchedule.findAll", query = "SELECT c FROM CoopPmeSchedule c"),
	@NamedQuery(name = "CoopPmeSchedule.findByPmeSchedId", query = "SELECT c FROM CoopPmeSchedule c WHERE c.pmeSchedId = :pmeSchedId"),
	@NamedQuery(name = "CoopPmeSchedule.findByPmeSchedTitle", query = "SELECT c FROM CoopPmeSchedule c WHERE c.pmeSchedTitle = :pmeSchedTitle"),
	@NamedQuery(name = "CoopPmeSchedule.findByPmeSchedDate", query = "SELECT c FROM CoopPmeSchedule c WHERE c.pmeSchedDate = :pmeSchedDate"),
	@NamedQuery(name = "CoopPmeSchedule.findByPmeSchedVenue", query = "SELECT c FROM CoopPmeSchedule c WHERE c.pmeSchedVenue = :pmeSchedVenue"),
	@NamedQuery(name = "CoopPmeSchedule.findByPmeSchedDesc", query = "SELECT c FROM CoopPmeSchedule c WHERE c.pmeSchedDesc = :pmeSchedDesc"),
	@NamedQuery(name = "CoopPmeSchedule.findByPmeSchedTimeFrom", query = "SELECT c FROM CoopPmeSchedule c WHERE c.pmeSchedTimeFrom = :pmeSchedTimeFrom"),
	@NamedQuery(name = "CoopPmeSchedule.findByPmeSchedTimeTo", query = "SELECT c FROM CoopPmeSchedule c WHERE c.pmeSchedTimeTo = :pmeSchedTimeTo")})
public class CoopPmeSchedule implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pme_sched_id")
	private Integer pmeSchedId;
	@Size(max = 50)
    @Column(name = "pme_sched_title")
	private String pmeSchedTitle;
	@Column(name = "pme_sched_date")
    @Temporal(TemporalType.DATE)
	private Date pmeSchedDate;
	@Size(max = 30)
    @Column(name = "pme_sched_venue")
	private String pmeSchedVenue;
	@Size(max = 2147483647)
    @Column(name = "pme_sched_desc")
	private String pmeSchedDesc;
	@Column(name = "pme_sched_time_from")
    @Temporal(TemporalType.DATE)
	private Date pmeSchedTimeFrom;
	@Column(name = "pme_sched_time_to")
    @Temporal(TemporalType.DATE)
	private Date pmeSchedTimeTo;

	public CoopPmeSchedule() {
	}

	public CoopPmeSchedule(Integer pmeSchedId) {
		this.pmeSchedId = pmeSchedId;
	}

	public Integer getPmeSchedId() {
		return pmeSchedId;
	}

	public void setPmeSchedId(Integer pmeSchedId) {
		this.pmeSchedId = pmeSchedId;
	}

	public String getPmeSchedTitle() {
		return pmeSchedTitle;
	}

	public void setPmeSchedTitle(String pmeSchedTitle) {
		this.pmeSchedTitle = pmeSchedTitle;
	}

	public Date getPmeSchedDate() {
		return pmeSchedDate;
	}

	public void setPmeSchedDate(Date pmeSchedDate) {
		this.pmeSchedDate = pmeSchedDate;
	}

	public String getPmeSchedVenue() {
		return pmeSchedVenue;
	}

	public void setPmeSchedVenue(String pmeSchedVenue) {
		this.pmeSchedVenue = pmeSchedVenue;
	}

	public String getPmeSchedDesc() {
		return pmeSchedDesc;
	}

	public void setPmeSchedDesc(String pmeSchedDesc) {
		this.pmeSchedDesc = pmeSchedDesc;
	}

	public Date getPmeSchedTimeFrom() {
		return pmeSchedTimeFrom;
	}

	public void setPmeSchedTimeFrom(Date pmeSchedTimeFrom) {
		this.pmeSchedTimeFrom = pmeSchedTimeFrom;
	}

	public Date getPmeSchedTimeTo() {
		return pmeSchedTimeTo;
	}

	public void setPmeSchedTimeTo(Date pmeSchedTimeTo) {
		this.pmeSchedTimeTo = pmeSchedTimeTo;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (pmeSchedId != null ? pmeSchedId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopPmeSchedule)) {
			return false;
		}
		CoopPmeSchedule other = (CoopPmeSchedule) object;
		if ((this.pmeSchedId == null && other.pmeSchedId != null) || (this.pmeSchedId != null && !this.pmeSchedId.equals(other.pmeSchedId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopPmeSchedule[ pmeSchedId=" + pmeSchedId + " ]";
	}
	
}
