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
public class EarliestDeadlineFirst extends StrategieOrdonnancement{

    public EarliestDeadlineFirst(List<Processus> listePrcessus) {
        super(listePrcessus);
    }

    @Override
    protected Processus mettreAJourProchaineProcessus() {
        
        Processus processusPrioritaire = null ;
        int prochaineEcheanceProcessusPrioritaire = 0;
        int prochaineEcheanceProcessusCourrant  = 0;
  
        for(Processus processusCourrant :  this.getListePrcessusPret())
        {
            if(processusPrioritaire == null){
                processusPrioritaire = processusCourrant;
            }
            else 
                prochaineEcheanceProcessusCourrant =   (processusCourrant.getContrainteFin() - (this.getUniteTemps() + processusCourrant.getContrainteFin())) % processusCourrant.getContrainteFin();
                prochaineEcheanceProcessusPrioritaire =(processusPrioritaire.getContrainteFin() - (this.getUniteTemps() + processusPrioritaire.getContrainteFin())) %processusPrioritaire.getContrainteFin();
                
                if(prochaineEcheanceProcessusCourrant < prochaineEcheanceProcessusPrioritaire){
                processusPrioritaire = processusCourrant;
            }
        }
        
        return processusPrioritaire ;
    }
    

    

    
    
  
    
}
