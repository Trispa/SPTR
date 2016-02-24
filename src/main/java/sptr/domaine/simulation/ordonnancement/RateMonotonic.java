/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptr.domaine.simulation.ordonnancement;

import java.util.List;
import sptr.domaine.simulation.processus.EtatsProcessus;
import sptr.domaine.simulation.processus.Processus;

/**
 *
 * @author trispa
 */
public class RateMonotonic implements Ordonnancement{

    private List<Processus> ProcessusListe; 
    private List<Processus> ProcessusPret; 
    public RateMonotonic(){
        
    }
    public RateMonotonic(List<Processus> ProcessusListe) {
        this.ProcessusListe = ProcessusListe;
    }
    
    @Override
    public List<Processus> ProcessusPret(){
        
        for(int i = 0; i < ProcessusListe.size(); i++)
            
           {
            if(ProcessusListe.get(i).getEtatPr0pcessus() == EtatsProcessus.PRET)
            {
                ProcessusPret.add(ProcessusListe.get(i));
            }
            
           }   
             
    	return ProcessusPret;
    }
    
    @Override
    public Boolean estPret(Processus P){
            
          return false;
    }
    
    @Override 
    public Processus getNextProcessus(){
        
        Processus PlusPrioritaire = null;

		for(Processus ProcessusCourant: ProcessusPret())
		{
			if(PlusPrioritaire == null)
			{
				PlusPrioritaire = ProcessusCourant;
			}
			else if(ProcessusCourant.getPeriode() < PlusPrioritaire.getPeriode())
			{
				PlusPrioritaire = ProcessusCourant;
			}
		}
		
		return PlusPrioritaire;  
	}

       
    
}
