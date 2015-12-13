/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csci230_finalproject;

/**
 * 
 * @author Home
 * @param <AnyType> 
 */
public class ClosedHashingElement<AnyType extends Comparable<? super AnyType >>
{
    // instance variables
    private AnyType data = null;
    private boolean isTombstone = false;

    /**
     * 
     */
    public ClosedHashingElement() {
    }
    
    public void setData(AnyType data){
        if(this.data != null && data == null){
            this.isTombstone = true;
        }
        this.data = data;        
    }
    
    public AnyType getData(){
        return this.data;
    }
    
    public boolean getIsTombstone(){
        return this.isTombstone;
    }
}
