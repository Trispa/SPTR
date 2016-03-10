/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sptr.domaine.simulation.communication;

import sptr.domaine.simulation.processus.Processus;


/**
 *
 * @author Erco
 */
public class Cummunication {
   
    // Des enum?
    
    private static int numero =0;
    private String nom;
    private String nature; //bloquant ou pas
    private boolean estUtilise = false;
    private Processus emeteur;
    private Processus recepteur;
    
    public Cummunication(Processus emeteur, Processus recepteur) {
        this.emeteur = emeteur;
        this.recepteur = recepteur;
        //this.numero++;
    }
    
    public String determinerNature() {
        return nature;
    }
    
}