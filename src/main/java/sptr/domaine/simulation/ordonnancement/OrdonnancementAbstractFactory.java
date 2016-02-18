/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptr.domaine.simulation.ordonnancement;

import java.util.List;
import sptr.domaine.simulation.processus.Processus;


/**
 *
 * @author trispa
 */
public abstract class OrdonnancementAbstractFactory {
    
    
    abstract Ordonnancement getStrategieOrdonnancement(TypeStrategie strategie, List<Processus> listePrcessus);
    
}
