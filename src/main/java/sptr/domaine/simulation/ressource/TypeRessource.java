/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sptr.domaine.simulation.ressource;

/**
 *
 * @author HP
 */
public enum TypeRessource {
    R01("carte graphique"),
    R02("carte routière"),
    R03("compteur de vitesse"),
    R04("module d'affichage"),
    R05("environnement"),
    R06("GES"),
    R07("GPS"),
    R08("odomètre"),
    R09("radar"),
    R10("régulateur vitesse"),
    R11("station météo"),
    R12("télécommunication");
       
    private String TypeP;
    
    private  TypeRessource(String s) {
        TypeP = s;
    }
    
    private  String getNomTypeRessource() {
        return this.TypeP;
    }
}