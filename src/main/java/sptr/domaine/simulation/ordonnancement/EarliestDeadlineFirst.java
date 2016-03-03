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
        for(Processus processusCourrant :  this.getListePrcessusPret())
        {
            if(processusPrioritaire == null){
                processusPrioritaire = processusCourrant;
            }
            else if((processusCourrant.getContrainteFin() - (this.getUniteTemps() + processusCourrant.getContrainteFin())) % processusCourrant.getContrainteFin() < (processusPrioritaire.getContrainteFin() - (this.getUniteTemps() + processusPrioritaire.getContrainteFin())) %processusPrioritaire.getContrainteFin())
                processusPrioritaire = processusCourrant;
            
        }
        
         System.out.println("le temps de calcule est"+this.getUniteTemps());
        return processusPrioritaire ;
    }
     
}
