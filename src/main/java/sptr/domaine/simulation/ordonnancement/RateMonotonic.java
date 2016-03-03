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
public class RateMonotonic extends  StrategieOrdonnancement{


    public RateMonotonic(List<Processus> listePrcessus) {
        super(listePrcessus);
    }

    @Override
    protected Processus mettreAJourProchaineProcessus() {
          Processus PlusPrioritaire = null;

		for(Processus ProcessusCourant: this.getListePrcessusPret())
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
       

