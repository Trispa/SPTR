/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptr.domaine.Environnement;

/**
 *
 * @author trispa
 */
public class Conducteur {
    
    private final int phaseDemandeConduteur;
    private final int periodeDemandeConducteur;
    
    public Conducteur(int phaseDemandeConduteur, int periodeDemandeConducteur) {
        this.phaseDemandeConduteur = phaseDemandeConduteur;
        this.periodeDemandeConducteur = periodeDemandeConducteur;
    }

    public int getPhaseDemandeConduteur() {
        return phaseDemandeConduteur;
    }

    public int getPeriodeDemandeConducteur() {
        return periodeDemandeConducteur;
    }
    
    
}
