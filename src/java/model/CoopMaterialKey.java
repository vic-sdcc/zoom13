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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_material_key")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopMaterialKey.findAll", query = "SELECT c FROM CoopMaterialKey c"),
	@NamedQuery(name = "CoopMaterialKey.findByMaterialKeyId", query = "SELECT c FROM CoopMaterialKey c WHERE c.materialKeyId = :materialKeyId")})
public class CoopMaterialKey implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "material_key_id")
	private Integer materialKeyId;
	@JoinColumn(name = "key_id", referencedColumnName = "key_id")
    @ManyToOne(optional = false)
	private CoopKey keyId;
	@JoinColumn(name = "material_id", referencedColumnName = "inv_no")
    @ManyToOne(optional = false)
	private CoopEducMaterial materialId;

	public CoopMaterialKey() {
	}

	public CoopMaterialKey(Integer materialKeyId) {
		this.materialKeyId = materialKeyId;
	}

	public Integer getMaterialKeyId() {
		return materialKeyId;
	}

	public void setMaterialKeyId(Integer materialKeyId) {
		this.materialKeyId = materialKeyId;
	}

	public CoopKey getKeyId() {
		return keyId;
	}

	public void setKeyId(CoopKey keyId) {
		this.keyId = keyId;
	}

	public CoopEducMaterial getMaterialId() {
		return materialId;
	}

	public void setMaterialId(CoopEducMaterial materialId) {
		this.materialId = materialId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (materialKeyId != null ? materialKeyId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopMaterialKey)) {
			return false;
		}
		CoopMaterialKey other = (CoopMaterialKey) object;
		if ((this.materialKeyId == null && other.materialKeyId != null) || (this.materialKeyId != null && !this.materialKeyId.equals(other.materialKeyId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopMaterialKey[ materialKeyId=" + materialKeyId + " ]";
	}
	
}
