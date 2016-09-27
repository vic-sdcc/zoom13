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
 * @author vic
 */
@Entity
@Table(name = "coop_sched_key")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopSchedKey.findAll", query = "SELECT c FROM CoopSchedKey c"),
    @NamedQuery(name = "CoopSchedKey.findByEducPmeId", query = "SELECT c FROM CoopSchedKey c WHERE c.educPmeId = :educPmeId")})
public class CoopSchedKey implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "educ_pme_id")
    private Integer educPmeId;
    @JoinColumn(name = "key_id", referencedColumnName = "key_id")
    @ManyToOne(optional = false)
    private CoopKey keyId;
    @JoinColumn(name = "app_schedno", referencedColumnName = "app_skedno")
    @ManyToOne(optional = false)
    private CoopAppSched appSchedno;

    public CoopSchedKey() {
    }

    public CoopSchedKey(Integer educPmeId) {
        this.educPmeId = educPmeId;
    }

    public Integer getEducPmeId() {
        return educPmeId;
    }

    public void setEducPmeId(Integer educPmeId) {
        this.educPmeId = educPmeId;
    }

    public CoopKey getKeyId() {
        return keyId;
    }

    public void setKeyId(CoopKey keyId) {
        this.keyId = keyId;
    }

    public CoopAppSched getAppSchedno() {
        return appSchedno;
    }

    public void setAppSchedno(CoopAppSched appSchedno) {
        this.appSchedno = appSchedno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (educPmeId != null ? educPmeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopSchedKey)) {
            return false;
        }
        CoopSchedKey other = (CoopSchedKey) object;
        if ((this.educPmeId == null && other.educPmeId != null) || (this.educPmeId != null && !this.educPmeId.equals(other.educPmeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopSchedKey[ educPmeId=" + educPmeId + " ]";
    }
    
}
