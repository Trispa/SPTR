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
    private Processus p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13;
    private ProcessusId pId ;
    private List<Ressource>ListRessource = new ArrayList<>();
    int d;
    int t ;
    EtatsProcessus etat ;
    String nom ;
    ProcessusId id ;
    @Before
    public void  initialise(){
        ListRessource.add(R1);
        p1 = new Processus(TypeProcessus.P01, 4);
        p2 = new Processus(TypeProcessus.P02, 4);
        p3 = new Processus(TypeProcessus.P03, 4);
        p4 = new Processus(TypeProcessus.P04, 4);
        p5 = new Processus(TypeProcessus.P05, 3);
        p6 = new Processus(TypeProcessus.P06, 4);
        p7 = new Processus(TypeProcessus.P07, 4);
        p8 = new Processus(TypeProcessus.P08, 3);
        p9 = new Processus(TypeProcessus.P09, 4);
        p10 = new Processus(TypeProcessus.P10,3);
        p11 = new Processus(TypeProcessus.P11,3);
        p12 = new Processus(TypeProcessus.P12, 4);
        p13 = new Processus(TypeProcessus.P13, 4);
    }
    
    
    @Test
    public void getterAndSetterP01(){

        pId = new ProcessusId(new Long(1));
        d= p1.getContrainteFin();
        t = p1.getPeriode();
        
        id = p1.getProcessusId();
        nom = p1.getNom();
        etat = p1.getEtatPr0pcessus();
        assertTrue(nom.equals ("Auto-verification"));
        assertTrue(d == 4);
        assertTrue(t == 4);
        assertTrue(id.equals(pId));
        assertTrue(etat.equals(EtatsProcessus.PRET));

    
    }
    @Test
    public void getterAndSetterP02(){

        pId = new ProcessusId(new Long(2));
        d = p2.getContrainteFin();
        t = p2.getPeriode();
        id = p2.getProcessusId();
        nom = p2.getNom();
        etat = p2.getEtatPr0pcessus();
         
        assertTrue(nom.equals ("Calcul du chemin"));
        assertTrue(d == 4);
        assertTrue(t == 4);
        assertTrue(id.equals(pId));
        assertTrue(etat.equals(EtatsProcessus.PRET));
    }
    @Test
    public void getterAndSetterP03(){

        pId = new ProcessusId(new Long(3));
        d = p3.getContrainteFin();
        t = p3.getPeriode();
        id = p3.getProcessusId();
        nom = p3.getNom();
        etat = p3.getEtatPr0pcessus();
         
        assertTrue(nom.equals ("Changement de vitesse"));
        assertTrue(d == 30);
        assertTrue(t == 4);
        assertTrue(id.equals(pId));
        assertTrue(etat.equals(EtatsProcessus.SUSPENDU));
    }
    @Test
    public void getterAndSetterP04(){

        pId = new ProcessusId(new Long(4));
        d = p4.getContrainteFin();
        t = p4.getPeriode();
        id = p4.getProcessusId();
        nom = p4.getNom();
        etat = p4.getEtatPr0pcessus();
         
        assertTrue(nom.equals ("Climat"));
        assertTrue(d == 30);
        assertTrue(t == 4);
        assertTrue(id.equals(pId));
        assertTrue(etat.equals(EtatsProcessus.SUSPENDU));
    }
}
