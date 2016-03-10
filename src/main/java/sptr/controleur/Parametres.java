/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptr.controleur;

/**
 *
 * @author bhacaz
 */
public class Parametres {
    
    private int simulation;
    private int positionDepartX;
    private int positionDepartY;
    private int positionArriveX;
    private int positionArriveY;
    private int communication;
    private int autoReparation;
    private int collision;
    private int echelle;
    private int vitesse;
    private int acceleration;
    private int consommation;
    private int feuJaune;
    private int temperatureMin;
    private int temperatureMax;
    private String strategie;
    
    public Parametres(){}
    
    public Parametres(int uniteTempsSimu, int positionDepartX, 
            int positionDepartY, int positionArriveX, 
            int positionArriveY, int communication, 
            int autoReparation, int collision, int echelle, int vitesse, 
            int acceleration, int consommation, int feuJaune, 
            int temperatureMin, int temperatureMax, String strategie) {
        this.simulation = uniteTempsSimu;
        this.positionDepartX = positionDepartX;
        this.positionDepartY = positionDepartY;
        this.positionArriveX = positionArriveX;
        this.positionArriveY = positionArriveY;
        this.communication = communication;
        this.autoReparation = autoReparation;
        this.collision = collision;
        this.echelle = echelle;
        this.vitesse = vitesse;
        this.acceleration = acceleration;
        this.consommation = consommation;
        this.feuJaune = feuJaune;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.strategie = strategie;
    }

    public int getSimulation() {
        return simulation;
    }

    public void setSimulation(int simulation) {
        this.simulation = simulation;
    }

    public int getPositionDepartX() {
        return positionDepartX;
    }

    public void setPositionDepartX(int positionDepartX) {
        this.positionDepartX = positionDepartX;
    }

    public int getPositionDepartY() {
        return positionDepartY;
    }

    public void setPositionDepartY(int positionDepartY) {
        this.positionDepartY = positionDepartY;
    }

    public int getPositionArriveX() {
        return positionArriveX;
    }

    public void setPositionArriveX(int positionArriveX) {
        this.positionArriveX = positionArriveX;
    }

    public int getPositionArriveY() {
        return positionArriveY;
    }

    public void setPositionArriveY(int positionArriveY) {
        this.positionArriveY = positionArriveY;
    }

    public int getCommunication() {
        return communication;
    }

    public void setCommunication(int communication) {
        this.communication = communication;
    }

    public int getAutoReparation() {
        return autoReparation;
    }

    public void setAutoReparation(int autoReparation) {
        this.autoReparation = autoReparation;
    }

    public int getCollision() {
        return collision;
    }

    public void setCollision(int collision) {
        this.collision = collision;
    }

    public int getEchelle() {
        return echelle;
    }

    public void setEchelle(int echelle) {
        this.echelle = echelle;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getConsommation() {
        return consommation;
    }

    public void setConsommation(int consommation) {
        this.consommation = consommation;
    }

    public int getFeuJaune() {
        return feuJaune;
    }

    public void setFeuJaune(int feuJaune) {
        this.feuJaune = feuJaune;
    }

    public int getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(int temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public int getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(int temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public String getStrategie() {
        return strategie;
    }

    public void setStrategie(String strategie) {
        this.strategie = strategie;
    }

    @Override
    public String toString() {
        return "Parametres{" + "simulation=" + simulation + 
                "\n, positionDepartX=" + positionDepartX +
                "\n, positionDepartY=" + positionDepartY + 
                "\n, positionArriveX=" + positionArriveX + 
                "\n, positionArriveY=" + positionArriveY + 
                "\n, communication=" + communication + 
                "\n, autoReparation=" + autoReparation + 
                "\n, collision=" + collision + 
                "\n, echelle=" + echelle + ", vitesse=" + vitesse + 
                "\n, acceleration=" + acceleration +
                "\n, consommation=" + consommation + ", feuJaune=" + feuJaune + 
                "\n, temperatureMin=" + temperatureMin + 
                "\n, temperatureMax=" + temperatureMax + 
                "\n, strategie=" + strategie + "}\n";
    }
    
    
    
}
