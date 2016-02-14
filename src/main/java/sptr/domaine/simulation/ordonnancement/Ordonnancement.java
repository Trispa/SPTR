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

public abstract class Ordonnancement  implements Iordonnancement{
    
    protected  TypeStrategie typeStrategie ;
    
    public Ordonnancement(TypeStrategie typeStrategie){
        this.typeStrategie = typeStrategie;
    }
    
    @Override
    public void doRoundRobin(){
    }
    
    @Override
    public void doRateMonotonic(){
    }
    
    @Override
    public void doRateMonotonicHeritage(){
    }
    
    @Override 
    public void doEaliest_dedline_first(){
    }
    @Override
    public void doLeastSlack(){
    }

    
}
