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
@Table(name = "coop_app_subj_rating")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopAppSubjRating.findAll", query = "SELECT c FROM CoopAppSubjRating c"),
	@NamedQuery(name = "CoopAppSubjRating.findByAppSubjRatingNum", query = "SELECT c FROM CoopAppSubjRating c WHERE c.appSubjRatingNum = :appSubjRatingNum"),
	@NamedQuery(name = "CoopAppSubjRating.findByEffortGrade", query = "SELECT c FROM CoopAppSubjRating c WHERE c.effortGrade = :effortGrade"),
	@NamedQuery(name = "CoopAppSubjRating.findByUnderstandingGrade", query = "SELECT c FROM CoopAppSubjRating c WHERE c.understandingGrade = :understandingGrade"),
	@NamedQuery(name = "CoopAppSubjRating.findByDelMethod", query = "SELECT c FROM CoopAppSubjRating c WHERE c.delMethod = :delMethod"),
	@NamedQuery(name = "CoopAppSubjRating.findByRemarks", query = "SELECT c FROM CoopAppSubjRating c WHERE c.remarks = :remarks"),
	@NamedQuery(name = "CoopAppSubjRating.findByEvalDate", query = "SELECT c FROM CoopAppSubjRating c WHERE c.evalDate = :evalDate")})
public class CoopAppSubjRating implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "app_subj_rating_num")
	private Integer appSubjRatingNum;
	@Basic(optional = false)
    @NotNull
    @Column(name = "effort_grade")
	private int effortGrade;
	@Basic(optional = false)
    @NotNull
    @Column(name = "understanding_grade")
	private int understandingGrade;
	@Basic(optional = false)
    @NotNull
    @Column(name = "del_method")
	private Character delMethod;
	@Size(max = 2147483647)
    @Column(name = "remarks")
	private String remarks;
	@Basic(optional = false)
    @NotNull
    @Column(name = "eval_date")
    @Temporal(TemporalType.DATE)
	private Date evalDate;
	@JoinColumn(name = "subject_code", referencedColumnName = "subject_code")
    @ManyToOne
	private CoopPmeSubject subjectCode;
	@JoinColumn(name = "applicant_no", referencedColumnName = "applicant_no")
    @ManyToOne
	private CoopApplicant applicantNo;

	public CoopAppSubjRating() {
	}

	public CoopAppSubjRating(Integer appSubjRatingNum) {
		this.appSubjRatingNum = appSubjRatingNum;
	}

	public CoopAppSubjRating(Integer appSubjRatingNum, int effortGrade, int understandingGrade, Character delMethod, Date evalDate) {
		this.appSubjRatingNum = appSubjRatingNum;
		this.effortGrade = effortGrade;
		this.understandingGrade = understandingGrade;
		this.delMethod = delMethod;
		this.evalDate = evalDate;
	}

	public Integer getAppSubjRatingNum() {
		return appSubjRatingNum;
	}

	public void setAppSubjRatingNum(Integer appSubjRatingNum) {
		this.appSubjRatingNum = appSubjRatingNum;
	}

	public int getEffortGrade() {
		return effortGrade;
	}

	public void setEffortGrade(int effortGrade) {
		this.effortGrade = effortGrade;
	}

	public int getUnderstandingGrade() {
		return understandingGrade;
	}

	public void setUnderstandingGrade(int understandingGrade) {
		this.understandingGrade = understandingGrade;
	}

	public Character getDelMethod() {
		return delMethod;
	}

	public void setDelMethod(Character delMethod) {
		this.delMethod = delMethod;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getEvalDate() {
		return evalDate;
	}

	public void setEvalDate(Date evalDate) {
		this.evalDate = evalDate;
	}

	public CoopPmeSubject getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(CoopPmeSubject subjectCode) {
		this.subjectCode = subjectCode;
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
		hash += (appSubjRatingNum != null ? appSubjRatingNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopAppSubjRating)) {
			return false;
		}
		CoopAppSubjRating other = (CoopAppSubjRating) object;
		if ((this.appSubjRatingNum == null && other.appSubjRatingNum != null) || (this.appSubjRatingNum != null && !this.appSubjRatingNum.equals(other.appSubjRatingNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopAppSubjRating[ appSubjRatingNum=" + appSubjRatingNum + " ]";
	}
	
}
