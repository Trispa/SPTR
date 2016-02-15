/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptr.domaine.Environnement;

/**
 *
 * @author trispa
 */
public class Trafic {
    private final int numero;
    private final Coordonnee cordonneIntersectionDepart;
    private final Coordonnee cordonneIntersectionArrivee;
    private final int vitesseVehicule;
    private final int periodeDesDebuts;
    private final int delais;


    public Trafic(int numero, Coordonnee cordonneIntersectionDepart, Coordonnee cordonneIntersectionArrivee, int vitesseVehicule, int periodeDesDebuts, int delais) {
        this.numero = numero;
        this.cordonneIntersectionDepart = cordonneIntersectionDepart;
        this.cordonneIntersectionArrivee = cordonneIntersectionArrivee;
        this.vitesseVehicule = vitesseVehicule;
        this.periodeDesDebuts = periodeDesDebuts;
        this.delais = delais;
    }
    
    
    public int getNumero() {
        return numero;
    }

    public Coordonnee getCordonneIntersectionDepart() {
        return cordonneIntersectionDepart;
    }

    public Coordonnee getCordonneIntersectionArrivee() {
        return cordonneIntersectionArrivee;
    }

    public int getVitesseVehicule() {
        return vitesseVehicule;
    }

    public int getPeriodeDesDebuts() {
        return periodeDesDebuts;
    }

    public int getDelais() {
        return delais;
    }
}
