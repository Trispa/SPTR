/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptr.domaine.simulation.ordonnancement;

import java.util.ArrayList;
import java.util.List;
import sptr.domaine.simulation.processus.EtatsProcessus;
import sptr.domaine.simulation.processus.Processus;

/**
 *
 * @author trispa
 */
public abstract class StrategieOrdonnancement {
    
    protected List<Processus> listePrcessus =  new ArrayList<>();
    protected List<Processus> listePrcessusPret =  new ArrayList<>();
    protected List<Processus> listePrcessusBlocke =  new  ArrayList<>();
    protected List<Processus> listePrcessusSuspendu =  new ArrayList<>();
    protected List<Processus> listePrcessustermine =  new ArrayList<>();
    
    protected int ppcm;
    protected int uniteTemps = 0;
    
    protected StrategieOrdonnancement(List<Processus> listePrcessus){
        
        this.listePrcessus = listePrcessus;
        
        for(Processus p: this.listePrcessus){
            
            if(p.getEtatPr0pcessus().equals(EtatsProcessus.BLOQUE)){
                listePrcessusBlocke.add(p);
            }
            else if (p.getEtatPr0pcessus().equals(EtatsProcessus.PRET)){
                listePrcessusPret.add(p);
            }
            else if(p.getEtatPr0pcessus().equals(EtatsProcessus.SUSPENDU)){
                listePrcessusSuspendu.add(p);
            }
            else if (p.getEtatPr0pcessus().equals(EtatsProcessus.TERMINE)){
                listePrcessustermine.add(p);
            }
        }
    }
        
        //should be overrited  by sub classes
    protected abstract Processus mettreAJourProchaineProcessus(); 
        
    public Processus getNextProcessus(){
            
        if(this.listePrcessus != null ){
                
            this.listePrcessusPret.stream().forEach((p) -> {
                if(p.getEtatPr0pcessus().equals(EtatsProcessus.BLOQUE)){
                    this.listePrcessusBlocke.add(p);
                    this.listePrcessusPret.remove(p);
                }
                else if (p.getEtatPr0pcessus().equals(EtatsProcessus.SUSPENDU)){
                    this.listePrcessusSuspendu.add(p);
                    this.listePrcessusPret.remove(p);
                }
                else if(p.getEtatPr0pcessus().equals(EtatsProcessus.TERMINE)){
                    this.listePrcessustermine.add(p);
                    this.listePrcessusPret.remove(p);
                }
            });
            
            this.listePrcessusBlocke.stream().forEach((p)->{
                if(p.getEtatPr0pcessus().equals(EtatsProcessus.PRET)){
                    this.listePrcessusPret.add(p);
                    this.listePrcessusBlocke.remove(p);
                }
                else if(p.getEtatPr0pcessus().equals(EtatsProcessus.SUSPENDU)){
                    this.listePrcessusSuspendu.add(p);
                    this.listePrcessusBlocke.remove(p);
                }
                else if(p.getEtatPr0pcessus().equals(EtatsProcessus.TERMINE)){
                    this.listePrcessustermine.add(p);
                    this.listePrcessusBlocke.remove(p);
                }
            });
            
            this.listePrcessusSuspendu.stream().forEach((p)->{
                
                if(p.getEtatPr0pcessus().equals(EtatsProcessus.PRET)){
                    this.listePrcessusPret.add(p);
                    this.listePrcessusSuspendu.remove(p);
                }
                else if (p.getEtatPr0pcessus().equals(EtatsProcessus.BLOQUE)){
                    this.listePrcessusBlocke.add(p);
                    this.listePrcessusSuspendu.remove(p);
                }
                else if (p.getEtatPr0pcessus().equals(EtatsProcessus.TERMINE)){
                    this.listePrcessustermine.add(p);
                    this.listePrcessusSuspendu.remove(p);
                }
            });
            this.listePrcessustermine.stream().forEach((p)->{
                if(p.getEtatPr0pcessus().equals(EtatsProcessus.BLOQUE)){
                    this.listePrcessusBlocke.add(p);
                    this.listePrcessustermine.remove(p);
                }
                else if (p.getEtatPr0pcessus().equals(EtatsProcessus.PRET)){
                    this.listePrcessusPret.add(p);
                    this.listePrcessustermine.remove(p);
                }
                else if (p.getEtatPr0pcessus().equals(EtatsProcessus.SUSPENDU)){
                    this.listePrcessusSuspendu.add(p);
                    this.listePrcessustermine.remove(p);
                }
            });
            
        }
        
        this.uniteTemps ++; // on incremente les unité de temps à chaque mise à jour
        return mettreAJourProchaineProcessus();
    }

    public List<Processus> getListePrcessus() {
        return listePrcessus;
    }

    public List<Processus> getListePrcessusPret() {
        return listePrcessusPret;
    }

    public List<Processus> getListePrcessusBlocke() {
        return listePrcessusBlocke;
    }

    public List<Processus> getListePrcessusSuspendu() {
        return listePrcessusSuspendu;
    }

    public List<Processus> getListePrcessustermine() {
        return listePrcessustermine;
    }

    public int getPpcm() {
        return ppcm;
    }

    public int getUniteTemps() {
        return uniteTemps;
    }
    public void setUniteTemps(int unitTemps){
        this.uniteTemps = unitTemps;
    }
    
    
            
    
}
