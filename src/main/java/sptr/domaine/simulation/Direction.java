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
public enum Direction 
{
    Est,Ouest,Nord,Sud;
    public static Direction inverse(Direction DirInv){
    
        if (DirInv ==Nord)
            return Sud;
        else if (DirInv ==Sud)
            return Nord;
        else if (DirInv ==Est)
            return Ouest;
        else 
            return Est;
    }
    
}
