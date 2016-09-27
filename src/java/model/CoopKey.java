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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vic
 */
@Entity
@Table(name = "coop_key")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopKey.findAll", query = "SELECT c FROM CoopKey c"),
    @NamedQuery(name = "CoopKey.findByKeyId", query = "SELECT c FROM CoopKey c WHERE c.keyId = :keyId"),
    @NamedQuery(name = "CoopKey.findByKeyTag", query = "SELECT c FROM CoopKey c WHERE c.keyTag = :keyTag")})
public class CoopKey implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "key_id")
    private Integer keyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "key_tag")
    private String keyTag;

    public CoopKey() {
    }

    public CoopKey(Integer keyId) {
        this.keyId = keyId;
    }

    public CoopKey(Integer keyId, String keyTag) {
        this.keyId = keyId;
        this.keyTag = keyTag;
    }

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public String getKeyTag() {
        return keyTag;
    }

    public void setKeyTag(String keyTag) {
        this.keyTag = keyTag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (keyId != null ? keyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopKey)) {
            return false;
        }
        CoopKey other = (CoopKey) object;
        if ((this.keyId == null && other.keyId != null) || (this.keyId != null && !this.keyId.equals(other.keyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopKey[ keyId=" + keyId + " ]";
    }
    
}
