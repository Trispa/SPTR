/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptr.domaine.simulation.processus;

/**
 *
 * @author trispa
 */
public enum TypeProcessus {

    
    P01("Auto-verification"),
    P02("Calcul du chemin"),
    P03("Changement de vitesse"),
    P04("Climat"),
    P05("Contrôle des émission"),
    P06("Envoi de bilan"),
    P07("Evitement de collision"),
    P08("Gestion des appels"),
    P09("Messagerie"),
    P10("Sécurité A"),
    P11("Sécurité B"),
    P12("Suivit du chemin"),
    P13("Syteme electrique");
    
    
    private final  String TypeP;
    
    private TypeProcessus(String s){
        this.TypeP = s;
    }
    
    public String getNomTypeProcessus (){
        return this.TypeP;
    }
    
}
