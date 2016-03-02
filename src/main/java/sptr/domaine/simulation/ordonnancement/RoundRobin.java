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

    public RoundRobin(List<Processus> listePrcessus) {
        super(listePrcessus);
    }

    @Override
    protected Processus mettreAJourProchaineProcessus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   
    
}
