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
 * @author trispa
 */
public   abstract  class ProcessusAbstract {
    protected final String nom;
    protected final ProcessusId processusId;
    protected final int  ContrainteDebut;
    protected final int contrainteFin;
    protected     int tempsCalcul = 0;
    protected     int tempsCalculRestant;
    protected     int priorite = -1;
    protected boolean estSporadique = false;
    protected TypeProcessus type;
    protected EtatsProcessus etatPr0pcessus;
    protected final  boolean tempsMAxEcoule = false;
    protected List<Ressource> resourceUtilises = new ArrayList<>();
    protected List<Communication>communicationAexecuter= new ArrayList<>();
    protected List<String> sequenceAexecuter = new ArrayList<>();
    protected final TypeProcessus typeProcessus;
    protected  int periode;

}
