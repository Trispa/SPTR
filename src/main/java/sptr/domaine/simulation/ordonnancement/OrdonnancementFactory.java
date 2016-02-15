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
public class OrdonnancementFactory extends OrdonnancementAbstractFactory{

    @Override
    Ordonnancement getStrategieOrdonnancement(TypeStrategie strategie) {
        
        if(strategie == null){
            return null;
        }
        if(strategie.equals(TypeStrategie.EARLIEST_DEDLINE_FIRST)){
            return new EarliestDeadlineFirst();
        }else if (strategie.equals(TypeStrategie.LEAS_SLACK)){
            return new LeastSlack();
            
        }else if(strategie.equals(TypeStrategie.RATE_MONOTONIC)){
            return new RateMonotonic();
        }else if(strategie.equals(TypeStrategie.RATE_MONOTONIC_HERITAGE)){
            return new RateMonotonicHeritage();
        }
        else if(strategie.equals(TypeStrategie.ROUND_ROBIN)){
            return new RoundRobin();
        }
        
        return null;
    }
    
    Ordonnancement getOrdonnancement(TypeStrategie strategie){
        return null;
    }
    
    
    
}
