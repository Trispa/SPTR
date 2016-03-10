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
public class Coordonnee {
    
    private final int CoordonneeX;
    private final int CoordonneeY;

    public Coordonnee(int CoordonneeX, int CoordonneeY) {
        this.CoordonneeX = CoordonneeX;
        this.CoordonneeY = CoordonneeY;
    }

    public int getCoordonneeX() {
        return CoordonneeX;
    }

    public int getCoordonneeY() {
        return CoordonneeY;
    }

    @Override
    public String toString() {
        return "Coordonnee{" + "CoordonneeX=" + CoordonneeX 
                + ", CoordonneeY=" + CoordonneeY + "}\n";
    }
    
    
    
    
}
