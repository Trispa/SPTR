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
public class OrdonnancementFactory extends OrdonnancementAbstractFactory{

    @Override
    StrategieOrdonnancement getStrategieOrdonnancement(TypeStrategie strategie ,List<Processus> listePrcessus) {
        
        if(strategie == null){
            return null;
        }
        else if(strategie.equals(TypeStrategie.EARLIEST_DEDLINE_FIRST)){
            return new EarliestDeadlineFirst(listePrcessus);
        }else if (strategie.equals(TypeStrategie.LEAS_SLACK)){
            return new LeastSlack(listePrcessus);
            
        }else if(strategie.equals(TypeStrategie.RATE_MONOTONIC)){
            return new RateMonotonic(listePrcessus);
        }else if(strategie.equals(TypeStrategie.RATE_MONOTONIC_HERITAGE)){
            return new RateMonotonicHeritage(listePrcessus);
        }
        else if(strategie.equals(TypeStrategie.ROUND_ROBIN)){
            return new RoundRobin(listePrcessus);
        }
        
        return null;
    }
    
}
