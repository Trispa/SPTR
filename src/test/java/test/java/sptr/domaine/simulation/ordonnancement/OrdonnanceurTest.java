/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.sptr.domaine.simulation.ordonnancement;

import main.java.sptr.domaine.simulation.ordonnancement.Ordonnanceur;
import main.java.sptr.domaine.simulation.ordonnancement.TypeStrategie;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Erco
 */
@RunWith(MockitoJUnitRunner.class)
public class OrdonnanceurTest {
  
    private final TypeStrategie ROUND_ROBIN = TypeStrategie.ROUND_ROBIN; 
    private final TypeStrategie RATE_MONOTONIC = TypeStrategie.RATE_MONOTONIC;
    private final TypeStrategie RATE_MONOTONIC_HERITAGE = TypeStrategie.RATE_MONOTONIC_HERITAGE;
    private final  TypeStrategie EARLIEST_DEDLINE_FIRST = TypeStrategie.EARLIEST_DEDLINE_FIRST;
    private final TypeStrategie LEAS_SLACK = TypeStrategie.LEAS_SLACK;
    private Ordonnanceur ordonnanceur ;
    
    @Before
    public void initialise(){
        ordonnanceur = Mockito.spy(new Ordonnanceur(ROUND_ROBIN));
    }
    
    @Test
    public void  givenRounRobinStrategiWhenDoOrdonnancementShouldCallRounRobinMethode() {
        
        this.ordonnanceur.doOrdonnancement(ROUND_ROBIN);
        Mockito.verify(this.ordonnanceur, Mockito.times(1)).doRoundRobin();
    }
    @Test
    public void  givenRateMonoticStrategiWhenDoOrdonnancementShouldCallRateMonoticMethode() {
        Ordonnanceur ordonnanceur = Mockito.spy(new Ordonnanceur(RATE_MONOTONIC));
        ordonnanceur.doOrdonnancement(RATE_MONOTONIC);
        Mockito.verify(ordonnanceur, Mockito.times(1)).doRateMonotonic();
    }
    @Test
    public void  givenRateMonoticHeritageStrategiWhenDoOrdonnancementShouldCallRateMonoticHeritageMethode() {
        Ordonnanceur ordonnanceur = Mockito.spy(new Ordonnanceur(RATE_MONOTONIC_HERITAGE));
        ordonnanceur.doOrdonnancement(RATE_MONOTONIC_HERITAGE);
        Mockito.verify(ordonnanceur, Mockito.times(1)).doRateMonotonicHeritage();
    }
    @Test
    public void  givenEaliestDedlineFirstStrategiWhenDoOrdonnancementShouldCallEaliestDedlineFirstMethode() {
        Ordonnanceur ordonnanceur = Mockito.spy(new Ordonnanceur(EARLIEST_DEDLINE_FIRST));
        ordonnanceur.doOrdonnancement(EARLIEST_DEDLINE_FIRST);
        Mockito.verify(ordonnanceur, Mockito.times(1)).doEaliest_dedline_first();
    }
    @Test
    public void  givenLeasSlackStrategiWhenDoOrdonnancementShouldCallLeasSlackMethode() {
        Ordonnanceur ordonnanceur = Mockito.spy(new Ordonnanceur(LEAS_SLACK));
        ordonnanceur.doOrdonnancement(LEAS_SLACK);
        Mockito.verify(ordonnanceur, Mockito.times(1)).doLeastSlack();
    }
}