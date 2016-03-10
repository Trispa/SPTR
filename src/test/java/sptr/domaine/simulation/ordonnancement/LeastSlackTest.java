/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptr.domaine.simulation.ordonnancement;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
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

/**
 *
 * @author trispa
 */

@RunWith(MockitoJUnitRunner.class)
public class LeastSlackTest {
    @Mock
    private Ressource R1;
    @Mock
    private Ressource R2;
    
    private List<Ressource> ressourceUtiliseP1 = new ArrayList<Ressource>();
    private List<Ressource> ressourceUtiliseP2 = new ArrayList<Ressource>();
    
     
    private Processus p1 ;
    private Processus p2;
    
    private LeastSlack LS;
    private final List<Processus> listProcessus = new ArrayList<>();
    
    
    @Before
    public void initialise(){
        ressourceUtiliseP1.add(R1);
        ressourceUtiliseP2.add(R2);
        p1 =  new Processus("P1", ProcessusId.NOT_SET, 1,3, 2, 1, EtatsProcessus.PRET, ressourceUtiliseP1, TypeProcessus.P01, 3) ;
        p2 = new Processus("P2", ProcessusId.NOT_SET, 1,4, 1, 1, EtatsProcessus.PRET, ressourceUtiliseP2, TypeProcessus.P02, 4) ;
      
        listProcessus.add(p1);
        listProcessus.add(p2);
        LS = new LeastSlack(listProcessus);
    }
    
    @Test
    public void givenAprocessusLisWhenListProcessIsNotNullOnFisrtUnitTimeNextProccessRelachementShoulBelesThanOthersProcess(){
        Processus nextProcessUnitTime1 = LS.getNextProcessus();
        
        System.out.println("relachement a ut 1 pour P1 :"+LS.relachement(p1));
        System.out.println("relachement à ut 1 pour P2 : "+LS.relachement(p2));
     
        
        Processus nextProcessUnitTime2 = LS.getNextProcessus();
        System.out.println("relachement à ut 2 pour P1 :"+LS.relachement(p1));
        System.out.println("relachement à ut 2 pour P2 : "+LS.relachement(p2));
     
        Processus nextProcessUnitTime3 = LS.getNextProcessus();
        System.out.println("relachement à ut 3 pour P1 :"+LS.relachement(p1));
        System.out.println("relachement à ut 3 pour P2 : "+LS.relachement(p2));
     
        Processus nextProcessUnitTime4 = LS.getNextProcessus();
        System.out.println("relachement à ut 4 pour P1 :"+LS.relachement(p1));
        System.out.println("relachement à ut 4 pour P2 : "+LS.relachement(p2));
     
        assertTrue(nextProcessUnitTime1.equals(p1));
        assertTrue(nextProcessUnitTime2.equals(p1));
        assertTrue(nextProcessUnitTime3.equals(p2));
        assertTrue(nextProcessUnitTime4.equals(p2));
        
    }
   
}
