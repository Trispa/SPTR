/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sptr.domaine.simulation.processus;
        
import java.util.List;
import sptr.domaine.ressource.Ressource;


/**
 *
 * @author Erco
 */
public class Processus {
    
   
    private final String nom;
    private final ProcessusId processusId;
    private final int  ContrainteDebut;
    private final int contrainteFin;
    private  int tempsCalcul;
    private int priorite;
    private EtatsProcessus etatPr0pcessus;
    private final  boolean tempsMAxEcoule = false;
    private List<Ressource> resourceUtilises;
    private final TypeProcessus typeProcessus;
    private final int periode;
    private final boolean estPeriodique = false;

    public Processus(String nom, ProcessusId processusId, int ContrainteDebut, int contrainteFin, int tempsCalcul, int priorite, EtatsProcessus etatPrpcessus, List<Ressource> resourceUtilises, TypeProcessus typeProcessus, int periode) {
        
        this.nom = nom;
        this.processusId = processusId;
        this.ContrainteDebut = ContrainteDebut;
        this.contrainteFin = contrainteFin;
        this.tempsCalcul = tempsCalcul;
        this.priorite = priorite;
        this.etatPr0pcessus = etatPrpcessus;
        this.resourceUtilises = resourceUtilises;
        this.typeProcessus = typeProcessus;
        this.periode = periode;
    }

   

    public String getNom() {
        return nom;
    }

    public ProcessusId getProcessusId() {
        return processusId;
    }

    public int getContrainteDebut() {
        return ContrainteDebut;
    }

    public int getContrainteFin() {
        return contrainteFin;
    }

    public int getTempsCalcul() {
        return tempsCalcul;
    }

    public int getPriorite() {
        return priorite;
    }

    public EtatsProcessus getEtatPr0pcessus() {
        return etatPr0pcessus;
    }

    public boolean isTempsMAxEcoule() {
        return tempsMAxEcoule;
    }

    public List<Ressource> getResourceUtilises() {
        return resourceUtilises;
    }

    public TypeProcessus getTypeProcessus() {
        return typeProcessus;
    }

    public int getPeriode() {
        return periode;
    }

    public boolean isEstPeriodique() {
        return estPeriodique;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    public void setEtatPr0pcessus(EtatsProcessus etatPr0pcessus) {
        this.etatPr0pcessus = etatPr0pcessus;
    }

    public void setResourceUtilises(List<Ressource> resourceUtilises) {
        this.resourceUtilises = resourceUtilises;
    }

    public void setTempsCalcul(int tempsCalcul) {
        this.tempsCalcul = tempsCalcul;
    }
    
    
}
