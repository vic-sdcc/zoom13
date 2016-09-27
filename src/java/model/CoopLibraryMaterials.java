/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_library_materials")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopLibraryMaterials.findAll", query = "SELECT c FROM CoopLibraryMaterials c"),
	@NamedQuery(name = "CoopLibraryMaterials.findByMaterialId", query = "SELECT c FROM CoopLibraryMaterials c WHERE c.materialId = :materialId"),
	@NamedQuery(name = "CoopLibraryMaterials.findByMaterialAuthor", query = "SELECT c FROM CoopLibraryMaterials c WHERE c.materialAuthor = :materialAuthor"),
	@NamedQuery(name = "CoopLibraryMaterials.findByMaterialDesc", query = "SELECT c FROM CoopLibraryMaterials c WHERE c.materialDesc = :materialDesc"),
	@NamedQuery(name = "CoopLibraryMaterials.findByMaterialTitle", query = "SELECT c FROM CoopLibraryMaterials c WHERE c.materialTitle = :materialTitle"),
	@NamedQuery(name = "CoopLibraryMaterials.findByMaterialQuantity", query = "SELECT c FROM CoopLibraryMaterials c WHERE c.materialQuantity = :materialQuantity")})
public class CoopLibraryMaterials implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "material_id")
	private Integer materialId;
	@Size(max = 20)
    @Column(name = "material_author")
	private String materialAuthor;
	@Size(max = 2147483647)
    @Column(name = "material_desc")
	private String materialDesc;
	@Size(max = 50)
    @Column(name = "material_title")
	private String materialTitle;
	@Column(name = "material_quantity")
	private Integer materialQuantity;
	@JoinColumn(name = "type_id", referencedColumnName = "type_id")
    @ManyToOne
	private CoopPmeType typeId;
	@JoinColumn(name = "subject_code", referencedColumnName = "subject_code")
    @ManyToOne
	private CoopPmeSubject subjectCode;
	@JoinColumn(name = "ou_code", referencedColumnName = "ou_code")
    @ManyToOne
	private CoopOrgUnit ouCode;

	public CoopLibraryMaterials() {
	}

	public CoopLibraryMaterials(Integer materialId) {
		this.materialId = materialId;
	}

	public Integer getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}

	public String getMaterialAuthor() {
		return materialAuthor;
	}

	public void setMaterialAuthor(String materialAuthor) {
		this.materialAuthor = materialAuthor;
	}

	public String getMaterialDesc() {
		return materialDesc;
	}

	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
	}

	public String getMaterialTitle() {
		return materialTitle;
	}

	public void setMaterialTitle(String materialTitle) {
		this.materialTitle = materialTitle;
	}

	public Integer getMaterialQuantity() {
		return materialQuantity;
	}

	public void setMaterialQuantity(Integer materialQuantity) {
		this.materialQuantity = materialQuantity;
	}

	public CoopPmeType getTypeId() {
		return typeId;
	}

	public void setTypeId(CoopPmeType typeId) {
		this.typeId = typeId;
	}

	public CoopPmeSubject getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(CoopPmeSubject subjectCode) {
		this.subjectCode = subjectCode;
	}

	public CoopOrgUnit getOuCode() {
		return ouCode;
	}

	public void setOuCode(CoopOrgUnit ouCode) {
		this.ouCode = ouCode;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (materialId != null ? materialId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopLibraryMaterials)) {
			return false;
		}
		CoopLibraryMaterials other = (CoopLibraryMaterials) object;
		if ((this.materialId == null && other.materialId != null) || (this.materialId != null && !this.materialId.equals(other.materialId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopLibraryMaterials[ materialId=" + materialId + " ]";
	}
	
}
