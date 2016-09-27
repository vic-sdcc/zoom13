/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import model.CoopAppSched;
import model.CoopKey;
import model.CoopMaterialKey;
import model.CoopPmeSubject;
import model.CoopPmeType;
import model.CoopSchedKey;
import service.CoopAppSchedFacadeREST;
import service.CoopKeyFacadeREST;
import service.CoopMaterialKeyFacadeREST;
import service.CoopPmeSubjectFacadeREST;
import service.CoopPmeTypeFacadeREST;
import service.CoopSchedKeyFacadeREST;

/**
 *
 * @author mis
 */
@ManagedBean
@SessionScoped
public class ScheduleBean implements Serializable{

    @PersistenceUnit
    EntityManagerFactory emf;

    @EJB
    private CoopSchedKeyFacadeREST coopSchedKeyFacadeREST;
    private CoopSchedKey schedKey = new CoopSchedKey();
    @EJB
    private CoopKeyFacadeREST coopKeyFacadeREST;
    private CoopKey key = new CoopKey();
    @EJB
    private CoopMaterialKeyFacadeREST coopMaterialKeyFacadeREST;
    private CoopMaterialKey matKey = new CoopMaterialKey();
    @EJB
    private CoopAppSchedFacadeREST coopAppSchedFacadeREST;
    private CoopAppSched appSched = new CoopAppSched();
    private List<CoopAppSched> appschedList;
    private DataModel<CoopAppSched> appschedModel;
    private CoopAppSched selectedAppSchedule;
    @EJB
    private CoopPmeSubjectFacadeREST coopPmeSubjectFacadeREST;
    private CoopPmeSubject pmeSub = new CoopPmeSubject();
    private List<CoopPmeSubject> subjCode;
    @EJB
    private CoopPmeTypeFacadeREST coopPmeTypeFacadeREST;
    private CoopPmeType pmeTyp = new CoopPmeType();
    private List<CoopPmeType> pmeType;

    private ArrayList<CoopKey> keyTag = new ArrayList<>();
    private List<CoopKey> keyTagList;

    private Date timefrom, timeTo;
    private Integer selectedTypeId;

    //keyTag***************************************************************
    public void addTxtBoxkey() {
        getKeyTag().add(new CoopKey());
    }

    public void removeTxtBoxkey() {
        if (getKeyTag().size() > 0) {
            getKeyTag().remove(getKeyTag().size() - 1);
        }
    }

    public ArrayList<CoopKey> getKeyTag() {
        return keyTag;
    }

    public void setKeyTag(ArrayList<CoopKey> keyTag) {
        this.keyTag = keyTag;
    }

    //**************************************************************************
    public void init() {
        appschedList = coopAppSchedFacadeREST.findAll();
        subjCode = emf.createEntityManager().createQuery("SELECT c FROM CoopPmeSubject c").getResultList();
        pmeType = emf.createEntityManager().createQuery("SELECT c FROM CoopPmeType c WHERE c.fromType = 'A'").getResultList();
        setKeyTagList(coopKeyFacadeREST.findAll());
    }

    public void beanclear() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("scheduleBean", null);
    }

    /**
     * Creates a new instance of ScheduleBean
     */
    public ScheduleBean() {
        appSched = new CoopAppSched();
    }

    public CoopKeyFacadeREST getCoopKeyFacadeREST() {
        return coopKeyFacadeREST;
    }

    public void setCoopKeyFacadeREST(CoopKeyFacadeREST coopKeyFacadeREST) {
        this.coopKeyFacadeREST = coopKeyFacadeREST;
    }

    public CoopKey getKey() {
        return key;
    }

    public void setKey(CoopKey key) {
        this.key = key;
    }

    public CoopMaterialKey getMatKey() {
        return matKey;
    }

    public void setMatKey(CoopMaterialKey matKey) {
        this.matKey = matKey;
    }

    public CoopPmeSubjectFacadeREST getCoopPmeSubjectFacadeREST() {
        return coopPmeSubjectFacadeREST;
    }

    public void setCoopPmeSubjectFacadeREST(CoopPmeSubjectFacadeREST coopPmeSubjectFacadeREST) {
        this.coopPmeSubjectFacadeREST = coopPmeSubjectFacadeREST;
    }

    public CoopPmeSubject getPmeSub() {
        return pmeSub;
    }

    public void setPmeSub(CoopPmeSubject pmeSub) {
        this.pmeSub = pmeSub;
    }

    public CoopPmeTypeFacadeREST getCoopPmeTypeFacadeREST() {
        return coopPmeTypeFacadeREST;
    }

    public void setCoopPmeTypeFacadeREST(CoopPmeTypeFacadeREST coopPmeTypeFacadeREST) {
        this.coopPmeTypeFacadeREST = coopPmeTypeFacadeREST;
    }

    public CoopPmeType getPmeTyp() {
        return pmeTyp;
    }

    public void setPmeTyp(CoopPmeType pmeTyp) {
        this.pmeTyp = pmeTyp;
    }

    public CoopMaterialKeyFacadeREST getCoopMaterialKeyFacadeREST() {
        return coopMaterialKeyFacadeREST;
    }

    public void setCoopMaterialKeyFacadeREST(CoopMaterialKeyFacadeREST coopMaterialKeyFacadeREST) {
        this.coopMaterialKeyFacadeREST = coopMaterialKeyFacadeREST;
    }

    public CoopAppSchedFacadeREST getCoopAppSchedFacadeREST() {
        return coopAppSchedFacadeREST;
    }

    public void setCoopAppSchedFacadeREST(CoopAppSchedFacadeREST coopAppSchedFacadeREST) {
        this.coopAppSchedFacadeREST = coopAppSchedFacadeREST;
    }

    public CoopAppSched getAppSched() {
        return appSched;
    }

    public void setAppSched(CoopAppSched appSched) {
        this.appSched = appSched;
    }

    public List<CoopAppSched> getAppschedList() {
        return appschedList;
    }

    public void setAppschedList(List<CoopAppSched> appschedList) {
        this.appschedList = appschedList;
    }

    public DataModel<CoopAppSched> getAppschedModel() {
        return appschedModel;
    }

    public void setAppschedModel(DataModel<CoopAppSched> appschedModel) {
        this.appschedModel = appschedModel;
    }

    public CoopAppSched getSelectedAppSchedule() {
        return selectedAppSchedule;
    }

    public void setSelectedAppSchedule(CoopAppSched selectedAppSchedule) {
        this.selectedAppSchedule = selectedAppSchedule;
    }

    public String save() {
        pmeTyp.setTypeId(selectedTypeId);
        appSched.setTypeId(pmeTyp);
        coopAppSchedFacadeREST.create(appSched);

        for (int i = 0; i != keyTag.size(); i++) {
            schedKey.setAppSchedno(appSched);
            schedKey.setKeyId(keyTag.get(i));
            coopSchedKeyFacadeREST.create(schedKey);
        }

        appSched = new CoopAppSched();
        beanclear();
        return "/xhtml/addSchedule?faces-redirect=true";
    }

    public String delete() {
        tagsRemove();
        coopAppSchedFacadeREST.remove(selectedAppSchedule);
        selectedAppSchedule = new CoopAppSched();
        beanclear();
        return "/xhtml/viewSchedule?faces-redirect=true";
    }

    public String edit() {
        tagsRemove();

        for (int i = 0; i != keyTag.size(); i++) {
            schedKey.setAppSchedno(selectedAppSchedule);
            schedKey.setKeyId(keyTag.get(i));
            coopSchedKeyFacadeREST.create(schedKey);
        }

        pmeTyp.setTypeId(selectedTypeId);
        selectedAppSchedule.setTypeId(pmeTyp);
        coopAppSchedFacadeREST.edit(selectedAppSchedule);
        selectedAppSchedule = new CoopAppSched();
        beanclear();
        return "/xhtml/viewSchedule?faces-redirect=true";
    }

    public Date getTimefrom() {
        return timefrom;
    }

    public void setTimefrom(Date timefrom) {
        this.timefrom = timefrom;
    }

    public Date getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Date timeTo) {
        this.timeTo = timeTo;
    }

    public List<CoopPmeSubject> getSubjCode() {
        return subjCode;
    }

    public void setSubjCode(List<CoopPmeSubject> subjCode) {
        this.subjCode = subjCode;
    }

    public List<CoopPmeType> getPmeType() {
        return pmeType;
    }

    public void setPmeType(List<CoopPmeType> pmeType) {
        this.pmeType = pmeType;
    }

    public Integer getSelectedTypeId() {
        return selectedTypeId;
    }

    public void setSelectedTypeId(Integer selectedTypeId) {
        this.selectedTypeId = selectedTypeId;
    }

    public List<CoopKey> getKeyTagList() {
        return keyTagList;
    }

    public void setKeyTagList(List<CoopKey> keyTagList) {
        this.keyTagList = keyTagList;
    }

    private List<CoopKey> keyList;
    private DataModel<CoopKey> keyModel;

    public void tagsGet() {
        Query CoopKeyQuery = emf.createEntityManager().createQuery("SELECT e FROM CoopSchedKey c "
                + "JOIN c.appSchedno d JOIN c.keyId e "
                + "WHERE d.appSkedno = : " + selectedAppSchedule.getAppSkedno());
        keyList = CoopKeyQuery.getResultList();
        keyModel = new ListDataModel(keyList);

        if (keyModel.getRowCount() > 0) {
            for (int i = 0; i != keyModel.getRowCount(); i++) {
                CoopKey q = (CoopKey) emf.createEntityManager().createQuery("SELECT e FROM CoopSchedKey c "
                        + "JOIN c.appSchedno d JOIN c.keyId e "
                        + "WHERE d.appSkedno = : " + selectedAppSchedule.getAppSkedno()).getResultList().get(i);
                keyTag.add(q);
            }
        }
    }

    public void tagsRemove() {
        Query CoopKeyQuery = emf.createEntityManager().createQuery("SELECT e FROM CoopSchedKey c "
                + "JOIN c.appSchedno d JOIN c.keyId e "
                + "WHERE d.appSkedno = : " + selectedAppSchedule.getAppSkedno());
        keyList = CoopKeyQuery.getResultList();
        keyModel = new ListDataModel(keyList);

        if (keyModel.getRowCount() > 0) {
            for (int i = 0; i != keyModel.getRowCount(); i++) {
                CoopSchedKey q = (CoopSchedKey) emf.createEntityManager().createQuery("SELECT c FROM CoopSchedKey c "
                        + "JOIN c.appSchedno d JOIN c.keyId e "
                        + "WHERE d.appSkedno = : " + selectedAppSchedule.getAppSkedno()).getResultList().get(0);
                coopSchedKeyFacadeREST.remove(q);
            }
        }
    }

    public void CodeType() {
        keyTag = new ArrayList<>();
        tagsGet();
        setSelectedTypeId(selectedAppSchedule.getTypeId().getTypeId());
    }

    public void addBtn() {
        beanclear();
        ConfigurableNavigationHandler configurableNavigationHandler = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        configurableNavigationHandler.performNavigation("addSchedule?faces-redirect=true");
    }

    public void viewBtn() {
        beanclear();
        ConfigurableNavigationHandler configurableNavigationHandler = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        configurableNavigationHandler.performNavigation("viewSchedule?faces-redirect=true");
    }

    public void cancelBtn() {
        beanclear();
        ConfigurableNavigationHandler configurableNavigationHandler = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        configurableNavigationHandler.performNavigation("mainSchedule?faces-redirect=true");
    }

    public List<CoopKey> keyList(Integer appSkedNo) {
        Query CoopKeyQuery = emf.createEntityManager().createQuery("SELECT e FROM CoopSchedKey c "
                + "JOIN c.appSchedno d JOIN c.keyId e "
                + "WHERE d.appSkedno = : " + appSkedNo);
        keyList = CoopKeyQuery.getResultList();

        return keyList;
    }

}
