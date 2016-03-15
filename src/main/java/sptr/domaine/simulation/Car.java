/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptr.domaine.simulation;

/**
 *
 * @author Erco
 */
public interface  Car {
    
 
    
    public void avance();
    
    public void arrete();
    
    public boolean estEnChemin();
    
    public void poursuisChemin(int duree);
    
    public void setNouvellePosition(int duree);
    
    
    
}
