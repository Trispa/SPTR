/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptr.domaine.simulation.ordonnancement;

/**
 *
 * @author trispa
 */
public abstract class OrdonnancementAbstractFactory {
    
    abstract Ordonnancement getStrategieOrdonnancement(TypeStrategie strategie);
    
}
