/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.sptr.domaine.simulation.ordonnancement;

import static main.java.sptr.domaine.simulation.ordonnancement.TypeStrategie.EARLIEST_DEDLINE_FIRST;
import static main.java.sptr.domaine.simulation.ordonnancement.TypeStrategie.LEAS_SLACK;
import static main.java.sptr.domaine.simulation.ordonnancement.TypeStrategie.RATE_MONOTONIC;
import static main.java.sptr.domaine.simulation.ordonnancement.TypeStrategie.RATE_MONOTONIC_HERITAGE;
import static main.java.sptr.domaine.simulation.ordonnancement.TypeStrategie.ROUND_ROBIN;


public class Ordonnanceur extends Ordonnancement {

    public Ordonnanceur(TypeStrategie typeStrategie) {
        super(typeStrategie);
    }

    @Override
    public void doOrdonnancement(TypeStrategie strategie) {
        if(strategie.equals(ROUND_ROBIN)){
            this.doRoundRobin();
        }
        if(strategie.equals(EARLIEST_DEDLINE_FIRST)){
            this.doEaliest_dedline_first();
        }
        
        if(strategie.equals(RATE_MONOTONIC)){
            this.doRateMonotonic();
        }
        
        if(strategie.equals(RATE_MONOTONIC_HERITAGE)){
            this.doRateMonotonicHeritage();
        }
        
        if(strategie.equals(LEAS_SLACK)){
            this.doLeastSlack();
        } 
    }
    
}
