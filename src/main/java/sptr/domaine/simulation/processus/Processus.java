/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sptr.domaine.simulation.processus;
        
import java.util.ArrayList;
import java.util.List;
import sptr.domaine.simulation.communication.Communication;
import sptr.domaine.simulation.ressource.Ressource;


/**
 *
 * @author Erco
 */
public class Processus {
    
    
    private final String nom;
    private final ProcessusId processusId;
    private final int  ContrainteDebut;
    private final int contrainteFin;
    private     int tempsCalcul = 0;
    private     int tempsCalculRestant;
    private     int priorite = -1;
    private boolean estSporadique = false;
    private TypeProcessus type;
    private EtatsProcessus etatPr0pcessus;
    private final  boolean tempsMAxEcoule = false;
    private List<Ressource> resourceUtilises = new ArrayList<>();
    private List<Communication>communicationAexecuter= new ArrayList<>();
    private List<String> sequenceAexecuter = new ArrayList<>();
    private final TypeProcessus typeProcessus;
    private  int periode;

    public Processus(TypeProcessus type, int periode) {
        this.periode = periode;
        this.type = type;
        
        if(type == TypeProcessus.P01){
           this.processusId = new ProcessusId(new Long(1));
           this.nom = type.getNomTypeProcessus();
           this.periode = periode;
           this.estSporadique =  false;
           this.etatPr0pcessus = EtatsProcessus.PRET;
           this.tempsCalcul = 4;
           this.tempsCalculRestant = this.tempsCalcul;
           this.contrainteFin = periode;
           this.sequenceAexecuter.add("R05");
           this.sequenceAexecuter.add("E");
           this.sequenceAexecuter.add("C01");
           this.sequenceAexecuter.add("R08");
           this.sequenceAexecuter.add("E");	
        }
        else if(type == TypeProcessus.P02){
            this.processusId = new ProcessusId(new Long(2));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  false;
            this.etatPr0pcessus = EtatsProcessus.PRET;
            this.tempsCalcul = 6;
            this.tempsCalculRestant = this.tempsCalcul;
            this.contrainteFin = periode;
            this.sequenceAexecuter.add("R02");
            this.sequenceAexecuter.add("R07");
            this.sequenceAexecuter.add("R05");
            for(int i = 0; i < this.tempsCalcul-3; i++)
			{
				this.sequenceAexecuter.add("E"); // E*
			}
            this.sequenceAexecuter.add("C02");
            this.sequenceAexecuter.add("R03");
         }
        else if(type == TypeProcessus.P03){
            this.processusId = new ProcessusId(new Long(3));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  true;
            this.etatPr0pcessus = EtatsProcessus.SUSPENDU;
            this.sequenceAexecuter.add("R03");
            this.sequenceAexecuter.add("C06");
            this.sequenceAexecuter.add("C01");
            this.sequenceAexecuter.add("C09");
            for(int  i = 0; i < this.tempsCalcul -1 ; i++){
            	this.sequenceAexecuter.add("R10");
            	
            }
            this.sequenceAexecuter.add("C04");	
         }
        else if(type == TypeProcessus.P04){
            this.processusId = new ProcessusId(new Long(1));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  true;
            this.etatPr0pcessus = EtatsProcessus.SUSPENDU;
            this.tempsCalcul = 4;
            for(int  i = 0; i < this.tempsCalcul -1 ; i++){
            	this.sequenceAexecuter.add("E");
            	
            }
            this.contrainteFin = 30;
         }
        else if(type == TypeProcessus.P05){
            this.processusId = new ProcessusId(new Long(5));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  true;
            this.etatPr0pcessus = EtatsProcessus.SUSPENDU;
            this.tempsCalcul = 5;
            this.tempsCalculRestant = this.tempsCalcul;
            this.contrainteFin = periode;
            this.sequenceAexecuter.add("C04");
            this.sequenceAexecuter.add("R06");
            this.sequenceAexecuter.add("C05");;	
         }
        else if(type == TypeProcessus.P02){
            this.processusId = new ProcessusId(new Long(5));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  true;
            this.etatPr0pcessus = EtatsProcessus.SUSPENDU;
            this.tempsCalcul = 5;
            this.tempsCalculRestant = this.tempsCalcul;
            this.contrainteFin = periode;
            this.sequenceAexecuter.add("R05");
            this.sequenceAexecuter.add("E");
            this.sequenceAexecuter.add("C01");
            this.sequenceAexecuter.add("R08");
            this.sequenceAexecuter.add("E");	
         }
        else if(type == TypeProcessus.P02){
            this.processusId = new ProcessusId(new Long(1));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  false;
            this.etatPr0pcessus = EtatsProcessus.PRET;
            this.tempsCalcul = 4;
            this.tempsCalculRestant = this.tempsCalcul;
            this.contrainteFin = periode;
            this.sequenceAexecuter.add("R05");
            this.sequenceAexecuter.add("E");
            this.sequenceAexecuter.add("C01");
            this.sequenceAexecuter.add("R08");
            this.sequenceAexecuter.add("E");	
         }
        else if(type == TypeProcessus.P02){
            this.processusId = new ProcessusId(new Long(1));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  false;
            this.etatPr0pcessus = EtatsProcessus.PRET;
            this.tempsCalcul = 4;
            this.tempsCalculRestant = this.tempsCalcul;
            this.contrainteFin = periode;
            this.sequenceAexecuter.add("R05");
            this.sequenceAexecuter.add("E");
            this.sequenceAexecuter.add("C01");
            this.sequenceAexecuter.add("R08");
            this.sequenceAexecuter.add("E");	
         }
        else if(type == TypeProcessus.P02){
            this.processusId = new ProcessusId(new Long(1));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  false;
            this.etatPr0pcessus = EtatsProcessus.PRET;
            this.tempsCalcul = 4;
            this.tempsCalculRestant = this.tempsCalcul;
            this.contrainteFin = periode;
            this.sequenceAexecuter.add("R05");
            this.sequenceAexecuter.add("E");
            this.sequenceAexecuter.add("C01");
            this.sequenceAexecuter.add("R08");
            this.sequenceAexecuter.add("E");	
         }
        else if(type == TypeProcessus.P02){
            this.processusId = new ProcessusId(new Long(1));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  false;
            this.etatPr0pcessus = EtatsProcessus.PRET;
            this.tempsCalcul = 4;
            this.tempsCalculRestant = this.tempsCalcul;
            this.contrainteFin = periode;
            this.sequenceAexecuter.add("R05");
            this.sequenceAexecuter.add("E");
            this.sequenceAexecuter.add("C01");
            this.sequenceAexecuter.add("R08");
            this.sequenceAexecuter.add("E");	
         }
        else if(type == TypeProcessus.P02){
            this.processusId = new ProcessusId(new Long(1));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  false;
            this.etatPr0pcessus = EtatsProcessus.PRET;
            this.tempsCalcul = 4;
            this.tempsCalculRestant = this.tempsCalcul;
            this.contrainteFin = periode;
            this.sequenceAexecuter.add("R05");
            this.sequenceAexecuter.add("E");
            this.sequenceAexecuter.add("C01");
            this.sequenceAexecuter.add("R08");
            this.sequenceAexecuter.add("E");	
         }
        else if(type == TypeProcessus.P02){
            this.processusId = new ProcessusId(new Long(1));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  false;
            this.etatPr0pcessus = EtatsProcessus.PRET;
            this.tempsCalcul = 4;
            this.tempsCalculRestant = this.tempsCalcul;
            this.contrainteFin = periode;
            this.sequenceAexecuter.add("R05");
            this.sequenceAexecuter.add("E");
            this.sequenceAexecuter.add("C01");
            this.sequenceAexecuter.add("R08");
            this.sequenceAexecuter.add("E");	
         }
        else if(type == TypeProcessus.P02){
            this.processusId = new ProcessusId(new Long(1));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  false;
            this.etatPr0pcessus = EtatsProcessus.PRET;
            this.tempsCalcul = 4;
            this.tempsCalculRestant = this.tempsCalcul;
            this.contrainteFin = periode;
            this.sequenceAexecuter.add("R05");
            this.sequenceAexecuter.add("E");
            this.sequenceAexecuter.add("C01");
            this.sequenceAexecuter.add("R08");
            this.sequenceAexecuter.add("E");	
         }
        else if(type == TypeProcessus.P02){
            this.processusId = new ProcessusId(new Long(1));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  false;
            this.etatPr0pcessus = EtatsProcessus.PRET;
            this.tempsCalcul = 4;
            this.tempsCalculRestant = this.tempsCalcul;
            this.contrainteFin = periode;
            this.sequenceAexecuter.add("R05");
            this.sequenceAexecuter.add("E");
            this.sequenceAexecuter.add("C01");
            this.sequenceAexecuter.add("R08");
            this.sequenceAexecuter.add("E");	
         }
                
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
