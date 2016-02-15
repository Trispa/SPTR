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
public class LeastSlack implements Ordonnancement{

    private List<Processus> ProcessusListe; 

    LeastSlack(){
        
    }
    public LeastSlack(List<Processus> ProcessusListe) {
        this.ProcessusListe = ProcessusListe;
    }
    
    

    @Override
    public List<Processus> ProcessusPret(){
        
        return null;
    }
    
    @Override
    public Boolean estPret(Processus P){
            
          return false;
    }
    
    @Override 
    public Processus getNextProcessus(){
        return null;
    }
    
    
}
