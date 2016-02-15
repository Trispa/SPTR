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
public class ProcessusId {
    
    public Long id;
    public static final ProcessusId  NOT_SET = new ProcessusId(null);
    
    public ProcessusId(Long id){
        this.id = id;
    }

    public ProcessusId(){
    
    }
    
    public boolean equals(ProcessusId anotherProcessusId){
        if(this.id == null && anotherProcessusId.id == null){
            return true;
        }
        if(this.id != anotherProcessusId.id){
           return this.id.equals(anotherProcessusId.id);
        }
        return false;
    }
        
}
    

