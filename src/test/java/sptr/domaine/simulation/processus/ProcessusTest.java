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
import sptr.domaine.ressource.Ressource;

/**
 *
 * @author trispa
 */
@RunWith(MockitoJUnitRunner.class)
public class ProcessusTest {
    
    @Mock
    ProcessusId pId;
    @Mock
    Ressource R1;
    private Processus p;
    
    private List<Ressource>ListRessource = new ArrayList<>();
    
    @Before
    public void  initialise(){
        ListRessource.add(R1);
        p = new Processus("P1", pId, 1, 5, 2, 3, EtatsProcessus.SUSPENDU, ListRessource, TypeProcessus.P1, 6);
    }
    
    
    @Test
    public void getterAndSetterTestJustForFun(){
        
        int b = p.getContrainteDebut();
        int d = p.getPeriode();
        int t = p.getPeriode();
        int prio = p.getPriorite();
        int id = p.getPriorite();
        String nom = p.getNom();
        EtatsProcessus eta = p.getEtatPr0pcessus();
        TypeProcessus type = p.getTypeProcessus();
        
        assertTrue(nom.equals ("P1"));
        
    }
}
