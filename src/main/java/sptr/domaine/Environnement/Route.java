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
    
    private final int num;
    private final Coordonnee coordonneeDebut;
    private final Coordonnee coordonneeFin;
    private final int vitesseMax;

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

    @Override
    public String toString() {
        return "Route{" + "num=" + num + 
                ", coordonneeDebut=" + coordonneeDebut + 
                ", coordonneeFin=" + coordonneeFin + 
                ", vitesseMax=" + vitesseMax + '}';
    }
    
    
    
}
