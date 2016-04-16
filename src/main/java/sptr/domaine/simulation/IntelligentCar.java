/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptr.domaine.simulation;

import javax.swing.text.Position;

/**
 *
 * @author trispa
 */
public class IntelligentCar implements Car{
    
    
    private static IntelligentCar car = null;
    private float vitesse = 0;
    private Position position = null;
    private float distanceParcourue = 0;
    
    
    private IntelligentCar(){
        
    }
    
    public static IntelligentCar getInstance(){
        if(car ==  null){
            car = new IntelligentCar();
        }
        
        return car;
    }
    
    

    @Override
    public void avance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void arrete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean estEnChemin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void poursuisChemin(int duree) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNouvellePosition(int duree) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
