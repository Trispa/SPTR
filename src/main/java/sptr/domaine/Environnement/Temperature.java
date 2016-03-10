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
public class Temperature {
    private int temperature;

    public Temperature() {
    }

    public Temperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Temperature{" + "temperature=" + temperature + "}\n";
    }
    
    
    
}
