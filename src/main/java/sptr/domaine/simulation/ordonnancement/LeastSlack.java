/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptr.domaine.simulation.ordonnancement;

import java.util.List;
import sptr.domaine.simulation.processus.Processus;
import sptr.domaine.simulation.processus.EtatsProcessus;

/**
 *
 * @author trispa
 */
public class LeastSlack implements Ordonnancement{

    private List<Processus> ProcessusListe;
    private List<Processus> ProcessuPret; 
    private int uniteDeTemps = 1;
    LeastSlack(){
        
    }
    public LeastSlack(List<Processus> ProcessusListe, int  uniteDeTemps) {
        this.ProcessusListe = ProcessusListe;
        this.uniteDeTemps = uniteDeTemps;
    }
    
    
    public int  relachement(Processus p)
    {
       int s;
       s = p.getContrainteFin() - p.getTempsCalcul() + 1 - this.uniteDeTemps ;
       uniteDeTemps ++;
       return s ;
     
    }
    

    @Override
    public List<Processus> ProcessusPret(){
         
        
        for(int i = 0; i < ProcessusListe.size(); i++)
            
           {
            if(ProcessusListe.get(i).getEtatPr0pcessus() == EtatsProcessus.PRET)
            {
                ProcessuPret.add(ProcessusListe.get(i));
            }
            
           }   
             
    	return ProcessuPret;
            
        
    }
    
    @Override
    public Boolean estPret(Processus P){
            
          return false;
    }
    
    @Override      
    public Processus getNextProcessus(){    
        
       Processus PlusPrioritaire = null;
       for (Processus ProcessusCourant : ProcessusPret())//ici cette liste contient les processus prets
       {
           
           if(PlusPrioritaire ==null)
           {
               PlusPrioritaire = ProcessusCourant;
           }
           else if (this.relachement(PlusPrioritaire) > this.relachement(ProcessusCourant))
               PlusPrioritaire = ProcessusCourant;
       } 
       return PlusPrioritaire;
    }
}
