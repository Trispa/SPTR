/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptr.domaine.simulation.processus;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import sptr.domaine.simulation.ressource.Ressource;

/**
 *
 * @author trispa
 */
@RunWith(MockitoJUnitRunner.class)
public class ProcessusTest {
    
   
     @Mock
    Ressource R1;
    private Processus p;
    private ProcessusId pId ;
    private List<Ressource>ListRessource = new ArrayList<>();
    
    @Before
    public void  initialise(){
        pId = new ProcessusId();
   
        ListRessource.add(R1);
        p = new Processus("P1", pId, 1, 5, 2, 3, EtatsProcessus.SUSPENDU, ListRessource, TypeProcessus.P01, 6);
    }
    
    
    @Test
    public void getterAndSetterTestJustForFun(){
        
        int b = p.getContrainteDebut();
        int d = p.getContrainteFin();
        int t = p.getPeriode();
        int prio = p.getPriorite();
        ProcessusId id = p.getProcessusId();
        String nom = p.getNom();
        EtatsProcessus eta = p.getEtatPr0pcessus();
        TypeProcessus type = p.getTypeProcessus();
        
        assertTrue(nom.equals ("P1"));
        assertTrue(d == 5);
        assertTrue(b == 1);
        assertTrue(t == 6);
        assertTrue(prio == 3);
        assertTrue(id.equals(pId));
        assertTrue(eta.equals(EtatsProcessus.SUSPENDU));
        assertTrue(type.equals(TypeProcessus.P01));
        assertTrue(TypeProcessus.P01.getNomTypeProcessus().equals("Auto-verification"));
        
        
    }
}
