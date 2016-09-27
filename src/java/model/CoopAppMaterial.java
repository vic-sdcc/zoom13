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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_app_material")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopAppMaterial.findAll", query = "SELECT c FROM CoopAppMaterial c"),
	@NamedQuery(name = "CoopAppMaterial.findByAppMatNum", query = "SELECT c FROM CoopAppMaterial c WHERE c.appMatNum = :appMatNum"),
	@NamedQuery(name = "CoopAppMaterial.findByDateBorrowed", query = "SELECT c FROM CoopAppMaterial c WHERE c.dateBorrowed = :dateBorrowed"),
	@NamedQuery(name = "CoopAppMaterial.findByDateReturned", query = "SELECT c FROM CoopAppMaterial c WHERE c.dateReturned = :dateReturned")})
public class CoopAppMaterial implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "app_mat_num")
	private Integer appMatNum;
	@Column(name = "date_borrowed")
    @Temporal(TemporalType.DATE)
	private Date dateBorrowed;
	@Column(name = "date_returned")
    @Temporal(TemporalType.DATE)
	private Date dateReturned;
	@JoinColumn(name = "inv_no", referencedColumnName = "inv_no")
    @ManyToOne
	private CoopEducMaterial invNo;
	@JoinColumn(name = "applicant_no", referencedColumnName = "applicant_no")
    @ManyToOne
	private CoopApplicant applicantNo;

	public CoopAppMaterial() {
	}

	public CoopAppMaterial(Integer appMatNum) {
		this.appMatNum = appMatNum;
	}

	public Integer getAppMatNum() {
		return appMatNum;
	}

	public void setAppMatNum(Integer appMatNum) {
		this.appMatNum = appMatNum;
	}

	public Date getDateBorrowed() {
		return dateBorrowed;
	}

	public void setDateBorrowed(Date dateBorrowed) {
		this.dateBorrowed = dateBorrowed;
	}

	public Date getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(Date dateReturned) {
		this.dateReturned = dateReturned;
	}

	public CoopEducMaterial getInvNo() {
		return invNo;
	}

	public void setInvNo(CoopEducMaterial invNo) {
		this.invNo = invNo;
	}

	public CoopApplicant getApplicantNo() {
		return applicantNo;
	}

	public void setApplicantNo(CoopApplicant applicantNo) {
		this.applicantNo = applicantNo;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (appMatNum != null ? appMatNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopAppMaterial)) {
			return false;
		}
		CoopAppMaterial other = (CoopAppMaterial) object;
		if ((this.appMatNum == null && other.appMatNum != null) || (this.appMatNum != null && !this.appMatNum.equals(other.appMatNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopAppMaterial[ appMatNum=" + appMatNum + " ]";
	}
	
}
