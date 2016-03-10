/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptr.domaine.simulation.ordonnancement;


import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import sptr.domaine.simulation.ressource.Ressource;
import sptr.domaine.simulation.processus.EtatsProcessus;
import sptr.domaine.simulation.processus.Processus;
import sptr.domaine.simulation.processus.ProcessusId;
import sptr.domaine.simulation.processus.TypeProcessus;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author trispa
 */

@RunWith(MockitoJUnitRunner.class)
public class EarliestDeadlineFirstTest {
    
    @Mock
    private Ressource R1;
    @Mock
    private Ressource R2;
    
    private List<Ressource> ressourceUtiliseP1 = new ArrayList<Ressource>();
    private List<Ressource> ressourceUtiliseP2 = new ArrayList<Ressource>();
    
    private Processus p1 ;
    private Processus p2;
    private EarliestDeadlineFirst edf ;
    private final List<Processus> listProcessus = new ArrayList<>();
    
    @Before
    public void initialise(){
        ressourceUtiliseP1.add(R1);
        ressourceUtiliseP2.add(R2);
        p1 =  new Processus("P1", ProcessusId.NOT_SET, 1,3, 2, 1, EtatsProcessus.PRET, ressourceUtiliseP1, TypeProcessus.P01, 0) ;
        p2 = new Processus("P2", ProcessusId.NOT_SET, 1,4, 1, 1, EtatsProcessus.PRET, ressourceUtiliseP2, TypeProcessus.P02, 0) ;
      
        listProcessus.add(p1);
        listProcessus.add(p2);
        edf = new EarliestDeadlineFirst(listProcessus);
       
        
    }
    
    @Test
    public void givenAProcessListWhenProcessListNotNullGetNexprocessusShoulReturnExpectedProcess(){
        
        
        Processus nextProcessusUnitTime1 = edf.getNextProcessus();
        Processus nextProcessusUnitTime2 = edf.getNextProcessus();
        Processus nextProcessusUnitTime3 = edf.getNextProcessus();
        
        
        assertTrue(nextProcessusUnitTime1.equals(p1));// à la premiere unité de temps p1 doit s'éxecuter
        assertFalse(nextProcessusUnitTime1.equals(p2));// à la premiere unité de temps p3 ne doit pas  s'éxecuter
        
        assertTrue(nextProcessusUnitTime2.equals(p1));// à la second unité de temps p1 doit s'éxecuter
        assertFalse(nextProcessusUnitTime2.equals(p2));// à la second unité de temps p1 doit s'éxecuter
            
        assertTrue(nextProcessusUnitTime3.equals(p2)); // à la troisieme unité de temps p2 doit s'executer
        assertFalse(nextProcessusUnitTime3.equals(p1));// à la second unité de temps p1 ne  doit pas s'éxecuter
        
        
    }
}
