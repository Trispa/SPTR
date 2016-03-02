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
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import sptr.domaine.simulation.processus.Processus;

/**
 *
 * @author trispa
 */

@RunWith(MockitoJUnitRunner.class)
public class EarliestDeadlineFirstTest {
    
    @Mock 
    private Processus p1;
    @Mock
    private Processus p2;
    @Mock
    private Processus p3;
    
    private 
    EarliestDeadlineFirst edf ;
    private final List<Processus> listProcessus = new ArrayList<>();
    
    @Before
    public void initialise(){
        listProcessus.add(p1);
        listProcessus.add(p2);
        edf = new EarliestDeadlineFirst(listProcessus);
        
    }
    
    @Test
    public void givenAProcessListWhenProcessListNotNullGetNexprocessusShoulReturnExpectedProcess(){
        
        Mockito.when(this.p1.getContrainteFin()).thenReturn(3);
        Mockito.when(this.p2.getContrainteFin()).thenReturn(4);
        edf.getNextProcessus();
        assertTrue(edf.getNextProcessus().equals(p1));
        
    }
}
