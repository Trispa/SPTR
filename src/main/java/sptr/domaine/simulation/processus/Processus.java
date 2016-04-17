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
    
    
    private  String nom;
    private  ProcessusId processusId;
  	private  int  ContrainteDebut = 0;
    private  int contrainteFin = 0;
    private  int tempsCalcul = 0;
    private  int tempsCalculRestant = 0;
    private  int priorite = -1;
    private  boolean estSporadique = false;
    private TypeProcessus type;
    private EtatsProcessus etatPr0pcessus;
    private   boolean tempsMAxEcoule = false;
    private List<Ressource> resourceUtilises = new ArrayList<>();
    private List<Communication>communicationAexecuter= new ArrayList<>();
    private List<String> sequenceAexecuter = new ArrayList<>();
    private  TypeProcessus typeProcessus;
    private  int periode;

    public Processus(TypeProcessus type, int periode) {
        this.periode = periode;
        this.type = type;
        this.contrainteFin = 30;
        
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
            this.processusId = new ProcessusId(new Long(4));
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
            this.tempsCalcul = 1;
            this.tempsCalculRestant = this.tempsCalcul;
            this.contrainteFin = 5;
            this.sequenceAexecuter.add("C04");
            this.sequenceAexecuter.add("R06");
            this.sequenceAexecuter.add("C05");
         }
        else if(type == TypeProcessus.P06){
            this.processusId = new ProcessusId(new Long(6));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  true;
            this.etatPr0pcessus = EtatsProcessus.SUSPENDU;
            this.tempsCalcul = 3;
            this.tempsCalculRestant = this.tempsCalcul;
            this.contrainteFin = 30;
            this.sequenceAexecuter.add("C10");
			this.sequenceAexecuter.add("C05");
			this.sequenceAexecuter.add("R08");
			this.sequenceAexecuter.add("R06");
			this.sequenceAexecuter.add("E");
         }
        else if(type == TypeProcessus.P07){
            this.processusId = new ProcessusId(new Long(7));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  false;
            this.etatPr0pcessus = EtatsProcessus.PRET;
            this.tempsCalcul = 5;
            this.tempsCalculRestant = this.tempsCalcul;
            this.sequenceAexecuter.add("R03");
			this.sequenceAexecuter.add("R09");
			this.sequenceAexecuter.add("R07");
			this.sequenceAexecuter.add("R05");
			this.sequenceAexecuter.add("E");
			this.sequenceAexecuter.add("C06");
			this.sequenceAexecuter.add("C02");
            this.contrainteFin = periode;	
         }
        else if(type == TypeProcessus.P08){
            this.processusId = new ProcessusId(new Long(8));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  true;
            this.etatPr0pcessus = EtatsProcessus.SUSPENDU;
            this.tempsCalcul = 3;
            this.tempsCalculRestant = this.tempsCalcul;
            this.sequenceAexecuter.add("R03");
            this.sequenceAexecuter.add("C08");
            for(int i = 0; i < tempsCalcul - 2; i ++)
			{
				this.sequenceAexecuter.add("E"); //  E*
			}
		
			this.sequenceAexecuter.add("R12");
			this.contrainteFin = 100;
         }
        else if(type == TypeProcessus.P09){
            this.processusId = new ProcessusId(new Long(9));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.tempsCalcul = 2;
            this.estSporadique =  false;
            this.etatPr0pcessus = EtatsProcessus.PRET;
            this.tempsCalcul = 30;
            this.sequenceAexecuter.add("R12");
            this.sequenceAexecuter.add("R04");	
         }
        else if(type == TypeProcessus.P10){
            this.processusId = new ProcessusId(new Long(10));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  false;
            this.etatPr0pcessus = EtatsProcessus.PRET;
            this.tempsCalcul = 5;
            this.tempsCalculRestant = this.tempsCalcul;
			this.sequenceAexecuter.add("R01");
			this.sequenceAexecuter.add("R02");
			this.sequenceAexecuter.add("R01");
			this.sequenceAexecuter.add("C11");
			this.sequenceAexecuter.add("R04");
			this.sequenceAexecuter.add("E");
			this.sequenceAexecuter.add("C07");	
            this.contrainteFin = periode;
         }
        else if(type == TypeProcessus.P11){
            this.processusId = new ProcessusId(new Long(11));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  true;
            this.etatPr0pcessus = EtatsProcessus.SUSPENDU;
            this.tempsCalcul = 4;
            this.tempsCalculRestant = this.tempsCalcul;
            //C12 R11 R09 R03 E C08
			this.sequenceAexecuter.add("C12");
			this.sequenceAexecuter.add("R11");
			this.sequenceAexecuter.add("R09");
			this.sequenceAexecuter.add("R03");
			this.sequenceAexecuter.add("E");
			this.sequenceAexecuter.add("C08");
			this.contrainteFin = 7;	
         }
        else if(type == TypeProcessus.P12){
            this.processusId = new ProcessusId(new Long(12));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  false;
            this.etatPr0pcessus = EtatsProcessus.PRET;
            this.tempsCalcul = 4;
            this.tempsCalculRestant = this.tempsCalcul;
            //C03 R03 C12 C09 R01 R04 C11 R06 C10 
			this.sequenceAexecuter.add("C03");
			this.sequenceAexecuter.add("R03");
			this.sequenceAexecuter.add("C12");
			this.sequenceAexecuter.add("C09");
			this.sequenceAexecuter.add("R01");
			this.sequenceAexecuter.add("R04");
			this.sequenceAexecuter.add("C11");
			this.sequenceAexecuter.add("R06");
			this.sequenceAexecuter.add("C10");
            this.contrainteFin = periode;
         }
        else if(type == TypeProcessus.P13){
            this.processusId = new ProcessusId(new Long(13));
            this.nom = type.getNomTypeProcessus();
            this.periode = periode;
            this.estSporadique =  false;
            this.etatPr0pcessus = EtatsProcessus.PRET;
            this.tempsCalcul = 4;
			this.tempsCalculRestant = this.tempsCalcul;
			//C07 R05 R11 E R04
			this.sequenceAexecuter.add("C07");
			this.sequenceAexecuter.add("R05");
			this.sequenceAexecuter.add("R11");
			this.sequenceAexecuter.add("E");
			this.sequenceAexecuter.add("R04");
			this.contrainteFin = 7;	
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

    public boolean isEstSporadique() {
        return this.estSporadique;
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
    public int getTempsCalculRestant() {
  		return tempsCalculRestant;
  	}



  	public void setTempsCalculRestant(int tempsCalculRestant) {
  		this.tempsCalculRestant = tempsCalculRestant;
  	}



	public void setContrainteFin(int contrainteFin) {
		this.contrainteFin = contrainteFin;
	}

    
}
