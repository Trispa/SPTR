/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptr.domaine.simulation.ordonnancement;

/**
 *
 * @author Erco
 */
public interface Iordonnancement {
 
    void doOrdonnancement(TypeStrategie typeStrategie);
    
    public void doRoundRobin();
    
    public void doRateMonotonic();
    
    public void doRateMonotonicHeritage();
    
    public void doEaliest_dedline_first();
    
    public void doLeastSlack();
    
}
