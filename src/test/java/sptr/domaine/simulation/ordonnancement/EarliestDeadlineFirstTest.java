/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptr.domaine.simulation.ordonnancement;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import sptr.domaine.simulation.processus.Processus;

/**
 *
 * @author trispa
 */
@RunWith(MockitoJUnitRunner.class)
public class EarliestDeadlineFirstTest {
    
    @Mock
    Processus P;
    
    private final TypeStrategie ROUND_ROBIN = TypeStrategie.ROUND_ROBIN; 
    private final TypeStrategie RATE_MONOTONIC = TypeStrategie.RATE_MONOTONIC;
    private final TypeStrategie RATE_MONOTONIC_HERITAGE = TypeStrategie.RATE_MONOTONIC_HERITAGE;
    private final TypeStrategie EARLIEST_DEDLINE_FIRST = TypeStrategie.EARLIEST_DEDLINE_FIRST;
    private final TypeStrategie LEAS_SLACK = TypeStrategie.LEAS_SLACK;
    
    private EarliestDeadlineFirstTest edf;
    
    
}
