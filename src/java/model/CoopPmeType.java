/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vic
 */
@Entity
@Table(name = "coop_pme_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopPmeType.findAll", query = "SELECT c FROM CoopPmeType c"),
    @NamedQuery(name = "CoopPmeType.findByTypeId", query = "SELECT c FROM CoopPmeType c WHERE c.typeId = :typeId"),
    @NamedQuery(name = "CoopPmeType.findByTypeName", query = "SELECT c FROM CoopPmeType c WHERE c.typeName = :typeName"),
    @NamedQuery(name = "CoopPmeType.findByTypeDesc", query = "SELECT c FROM CoopPmeType c WHERE c.typeDesc = :typeDesc"),
    @NamedQuery(name = "CoopPmeType.findByFromType", query = "SELECT c FROM CoopPmeType c WHERE c.fromType = :fromType")})
public class CoopPmeType implements Serializable {
    @OneToMany(mappedBy = "typeId")
    private Collection<CoopAppSched> coopAppSchedCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "type_id")
    private Integer typeId;
    @Size(max = 20)
    @Column(name = "type_name")
    private String typeName;
    @Size(max = 2147483647)
    @Column(name = "type_desc")
    private String typeDesc;
    @Column(name = "from_type")
    private Character fromType;

    public CoopPmeType() {
    }

    public CoopPmeType(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public Character getFromType() {
        return fromType;
    }

    public void setFromType(Character fromType) {
        this.fromType = fromType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeId != null ? typeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopPmeType)) {
            return false;
        }
        CoopPmeType other = (CoopPmeType) object;
        if ((this.typeId == null && other.typeId != null) || (this.typeId != null && !this.typeId.equals(other.typeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopPmeType[ typeId=" + typeId + " ]";
    }

    @XmlTransient
    public Collection<CoopAppSched> getCoopAppSchedCollection() {
        return coopAppSchedCollection;
    }

    public void setCoopAppSchedCollection(Collection<CoopAppSched> coopAppSchedCollection) {
        this.coopAppSchedCollection = coopAppSchedCollection;
    }
    
}
