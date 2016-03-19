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
public class RoundRobin  extends  StrategieOrdonnancement{
    
    protected List<Processus> ListeProcessusPret = this.getListePrcessusPret();
    protected int TrancheTemps =4;//Durée de mon tranche de temps pour chaque processus
    protected int TempsRestant = TrancheTemps ; //temps qui reste avant que le prochain processus s'installe
    protected int i = 0;
    protected Processus ProchainProcessus = null;
    
    
    public RoundRobin(List<Processus> listePrcessus) {
        super(listePrcessus);
    }

    @Override
    protected Processus mettreAJourProchaineProcessus() 
    {
        
        
        
        if(ListeProcessusPret != null && !ListeProcessusPret.isEmpty())
	{
			if(ProchainProcessus == null)
                        {
				ProchainProcessus = ListeProcessusPret.get(i);
			}

				
			if(TempsRestant == 0 && ListeProcessusPret.contains(ProchainProcessus) )
                        {
				// On fait une rotation
				if(i++ >= ListeProcessusPret.size() - 1)
					i=0;
					
				ProchainProcessus = ListeProcessusPret.get(i);
				TempsRestant = TrancheTemps - 1;

			}
			else if(!ListeProcessusPret.contains(ProchainProcessus))
                        {

				if(i++ >= ListeProcessusPret.size() - 1)
					i = 0;
				ProchainProcessus = ListeProcessusPret.get(i);
				TempsRestant = TrancheTemps - 1;
				
			}
			else
                        {
				TempsRestant --;
			}
	}
		else
			ProchainProcessus = null;
		
                return ProchainProcessus;
}
        
        
        
        
        
        
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    

}

    

   
    

