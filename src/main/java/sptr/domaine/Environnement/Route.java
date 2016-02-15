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
public class Route {
    
    private int num;
    private Coordonnee coordonneeDebut;
    private Coordonnee coordonneeFin;
    private int vitesseMax;

    public Route(int num, Coordonnee positionDebut, Coordonnee positionFin, int vitesseMax) {
        this.num = num;
        this.coordonneeDebut = positionDebut;
        this.coordonneeFin = positionFin;
        this.vitesseMax = vitesseMax;
    }

    public int getNum() {
        return num;
    }

    public int getVitesseMax() {
        return vitesseMax;
    }
    
    
    
}
