/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import model.CoopPmeType;

/**
 *
 * @author vic
 */
@Entity
@Table(name = "coop_app_sched")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopAppSched.findAll", query = "SELECT c FROM CoopAppSched c"),
    @NamedQuery(name = "CoopAppSched.findByAppSkedno", query = "SELECT c FROM CoopAppSched c WHERE c.appSkedno = :appSkedno"),
    @NamedQuery(name = "CoopAppSched.findBySkedStatus", query = "SELECT c FROM CoopAppSched c WHERE c.skedStatus = :skedStatus"),
    @NamedQuery(name = "CoopAppSched.findByScheduledTimeFrom", query = "SELECT c FROM CoopAppSched c WHERE c.scheduledTimeFrom = :scheduledTimeFrom"),
    @NamedQuery(name = "CoopAppSched.findByScheduledDate", query = "SELECT c FROM CoopAppSched c WHERE c.scheduledDate = :scheduledDate"),
    @NamedQuery(name = "CoopAppSched.findByScheduleTimeTo", query = "SELECT c FROM CoopAppSched c WHERE c.scheduleTimeTo = :scheduleTimeTo"),
    @NamedQuery(name = "CoopAppSched.findByActTitle", query = "SELECT c FROM CoopAppSched c WHERE c.actTitle = :actTitle"),
    @NamedQuery(name = "CoopAppSched.findByActVenue", query = "SELECT c FROM CoopAppSched c WHERE c.actVenue = :actVenue")})
public class CoopAppSched implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appSchedno")
    private Collection<CoopSchedKey> coopSchedKeyCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "app_skedno")
    private Integer appSkedno;
    @Size(max = 10)
    @Column(name = "sked_status")
    private String skedStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "scheduled_time_from")
    @Temporal(TemporalType.TIME)
    private Date scheduledTimeFrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "scheduled_date")
    @Temporal(TemporalType.DATE)
    private Date scheduledDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "schedule_time_to")
    @Temporal(TemporalType.TIME)
    private Date scheduleTimeTo;
    @Size(max = 50)
    @Column(name = "act_title")
    private String actTitle;
    @Size(max = 50)
    @Column(name = "act_venue")
    private String actVenue;
    @JoinTable(name = "coop_sched_key", joinColumns = {
        @JoinColumn(name = "app_schedno", referencedColumnName = "app_skedno")}, inverseJoinColumns = {
        @JoinColumn(name = "key_id", referencedColumnName = "key_id")})
    @ManyToMany
    private Collection<CoopKey> coopKeyCollection;
    @JoinColumn(name = "type_id", referencedColumnName = "type_id")
    @ManyToOne
    private CoopPmeType typeId;

    public CoopAppSched() {
    }

    public CoopAppSched(Integer appSkedno) {
        this.appSkedno = appSkedno;
    }

    public CoopAppSched(Integer appSkedno, Date scheduledTimeFrom, Date scheduledDate, Date scheduleTimeTo) {
        this.appSkedno = appSkedno;
        this.scheduledTimeFrom = scheduledTimeFrom;
        this.scheduledDate = scheduledDate;
        this.scheduleTimeTo = scheduleTimeTo;
    }

    public Integer getAppSkedno() {
        return appSkedno;
    }

    public void setAppSkedno(Integer appSkedno) {
        this.appSkedno = appSkedno;
    }

    public String getSkedStatus() {
        return skedStatus;
    }

    public void setSkedStatus(String skedStatus) {
        this.skedStatus = skedStatus;
    }

    public Date getScheduledTimeFrom() {
        return scheduledTimeFrom;
    }

    public void setScheduledTimeFrom(Date scheduledTimeFrom) {
        this.scheduledTimeFrom = scheduledTimeFrom;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public Date getScheduleTimeTo() {
        return scheduleTimeTo;
    }

    public void setScheduleTimeTo(Date scheduleTimeTo) {
        this.scheduleTimeTo = scheduleTimeTo;
    }

    public String getActTitle() {
        return actTitle;
    }

    public void setActTitle(String actTitle) {
        this.actTitle = actTitle;
    }

    public String getActVenue() {
        return actVenue;
    }

    public void setActVenue(String actVenue) {
        this.actVenue = actVenue;
    }

    @XmlTransient
    public Collection<CoopKey> getCoopKeyCollection() {
        return coopKeyCollection;
    }

    public void setCoopKeyCollection(Collection<CoopKey> coopKeyCollection) {
        this.coopKeyCollection = coopKeyCollection;
    }

    public CoopPmeType getTypeId() {
        return typeId;
    }

    public void setTypeId(CoopPmeType typeId) {
        this.typeId = typeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appSkedno != null ? appSkedno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopAppSched)) {
            return false;
        }
        CoopAppSched other = (CoopAppSched) object;
        if ((this.appSkedno == null && other.appSkedno != null) || (this.appSkedno != null && !this.appSkedno.equals(other.appSkedno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.CoopAppSched[ appSkedno=" + appSkedno + " ]";
    }

    @XmlTransient
    public Collection<CoopSchedKey> getCoopSchedKeyCollection() {
        return coopSchedKeyCollection;
    }

    public void setCoopSchedKeyCollection(Collection<CoopSchedKey> coopSchedKeyCollection) {
        this.coopSchedKeyCollection = coopSchedKeyCollection;
    }
    
}
