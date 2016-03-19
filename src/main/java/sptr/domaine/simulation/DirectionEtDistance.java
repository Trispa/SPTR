package sptr.domaine.simulation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LiberT
 */
public class DirectionEtDistance {
    
    private Direction direction;
    private int distance;
    
    
    public DirectionEtDistance(Direction d,int dist){
		direction=d;
		distance=dist;
	}
    
    public int getDistance(){
            return distance;
    }
    
    public Direction getDirection(){
		return direction;
	}
    public void setDistance(int dist){
            distance=dist;
    }
    
}
