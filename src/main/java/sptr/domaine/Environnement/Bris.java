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
public class Bris {
    
    private final int phase;
    private final int periode;

    public Bris(int phase, int periode) {
        this.phase = phase;
        this.periode = periode;
    }

    public int getPhase() {
        return phase;
    }

    public int getPeriode() {
        return periode;
    }

    @Override
    public String toString() {
        return "Bris{" + "phase=" + phase + ", periode=" + periode + "}\n";
    }
    
    
}
