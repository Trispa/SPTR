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
public class LeastSlack extends  StrategieOrdonnancement{


    public LeastSlack(List<Processus> listePrcessus) {
        super(listePrcessus);
    }

    @Override
    protected Processus mettreAJourProchaineProcessus() {
        Processus PlusPrioritaire = null;
       for (Processus ProcessusCourant : this.getListePrcessusPret())//ici cette liste contient les processus prets
       {
           
           if(PlusPrioritaire ==null)
           {
               PlusPrioritaire = ProcessusCourant;
               PlusPrioritaire.setTempsCalcul(PlusPrioritaire.getTempsCalcul()-1); 
                
           }
           else if (this.relachement(PlusPrioritaire) > this.relachement(ProcessusCourant)){
               PlusPrioritaire = ProcessusCourant;
               //PlusPrioritaire.setTempsCalcul(PlusPrioritaire.getTempsCalcul()-1); 
               
           }
           
           
           
       } 
       
      
       return PlusPrioritaire;
    }
   
    public int  relachement(Processus p)
    {
       int s;
       s =   1 + p.getContrainteFin() - this.getUniteTemps()%p.getContrainteFin() - p.getTempsCalculRestant(); 
       //s = p.getContrainteFin() - p.getTempsCalcul() + 1 - this.getUniteTemps() ;
       
       return s ;
     
    }
         
}
