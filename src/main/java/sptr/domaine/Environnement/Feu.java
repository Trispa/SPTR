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
public class Feu {
    
    
    private final int numero;
    private final Coordonnee coordonneeIntersection;
    private final PositionGeographique position;
    
    

    public Feu(int numero, Coordonnee coordonneeIntersection, PositionGeographique position) {
        this.numero = numero;
        this.coordonneeIntersection = coordonneeIntersection;
        this.position = position;
    }
    
    public int getNumero() {
        return numero;
    }

    public Coordonnee getCoordonneeIntersection() {
        return coordonneeIntersection;
    }

    public PositionGeographique getPosition() {
        return position;
    }
    
}
