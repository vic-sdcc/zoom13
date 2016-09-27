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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_activity")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopActivity.findAll", query = "SELECT c FROM CoopActivity c"),
	@NamedQuery(name = "CoopActivity.findByActNum", query = "SELECT c FROM CoopActivity c WHERE c.actNum = :actNum"),
	@NamedQuery(name = "CoopActivity.findByActName", query = "SELECT c FROM CoopActivity c WHERE c.actName = :actName"),
	@NamedQuery(name = "CoopActivity.findByActObj", query = "SELECT c FROM CoopActivity c WHERE c.actObj = :actObj"),
	@NamedQuery(name = "CoopActivity.findByActDateFrom", query = "SELECT c FROM CoopActivity c WHERE c.actDateFrom = :actDateFrom"),
	@NamedQuery(name = "CoopActivity.findByActDateTo", query = "SELECT c FROM CoopActivity c WHERE c.actDateTo = :actDateTo"),
	@NamedQuery(name = "CoopActivity.findByActDetails", query = "SELECT c FROM CoopActivity c WHERE c.actDetails = :actDetails"),
	@NamedQuery(name = "CoopActivity.findByActLocation", query = "SELECT c FROM CoopActivity c WHERE c.actLocation = :actLocation")})
public class CoopActivity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "act_num")
	private Integer actNum;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "act_name")
	private String actName;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "act_obj")
	private String actObj;
	@Basic(optional = false)
    @NotNull
    @Column(name = "act_date_from")
    @Temporal(TemporalType.DATE)
	private Date actDateFrom;
	@Column(name = "act_date_to")
    @Temporal(TemporalType.DATE)
	private Date actDateTo;
	@Size(max = 2147483647)
    @Column(name = "act_details")
	private String actDetails;
	@Size(max = 30)
    @Column(name = "act_location")
	private String actLocation;
	@JoinColumn(name = "act_type_code", referencedColumnName = "act_type_code")
    @ManyToOne
	private CoopActivityType actTypeCode;

	public CoopActivity() {
	}

	public CoopActivity(Integer actNum) {
		this.actNum = actNum;
	}

	public CoopActivity(Integer actNum, String actName, String actObj, Date actDateFrom) {
		this.actNum = actNum;
		this.actName = actName;
		this.actObj = actObj;
		this.actDateFrom = actDateFrom;
	}

	public Integer getActNum() {
		return actNum;
	}

	public void setActNum(Integer actNum) {
		this.actNum = actNum;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getActObj() {
		return actObj;
	}

	public void setActObj(String actObj) {
		this.actObj = actObj;
	}

	public Date getActDateFrom() {
		return actDateFrom;
	}

	public void setActDateFrom(Date actDateFrom) {
		this.actDateFrom = actDateFrom;
	}

	public Date getActDateTo() {
		return actDateTo;
	}

	public void setActDateTo(Date actDateTo) {
		this.actDateTo = actDateTo;
	}

	public String getActDetails() {
		return actDetails;
	}

	public void setActDetails(String actDetails) {
		this.actDetails = actDetails;
	}

	public String getActLocation() {
		return actLocation;
	}

	public void setActLocation(String actLocation) {
		this.actLocation = actLocation;
	}

	public CoopActivityType getActTypeCode() {
		return actTypeCode;
	}

	public void setActTypeCode(CoopActivityType actTypeCode) {
		this.actTypeCode = actTypeCode;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (actNum != null ? actNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopActivity)) {
			return false;
		}
		CoopActivity other = (CoopActivity) object;
		if ((this.actNum == null && other.actNum != null) || (this.actNum != null && !this.actNum.equals(other.actNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopActivity[ actNum=" + actNum + " ]";
	}
	
}
