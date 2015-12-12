/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csci230_finalproject;

/**
 * @AnyType type
 * @author Home
 */
public interface HashingInterface<AnyType>
{
    /**
     * 
     * @param t 
     */
    public void addValue( AnyType t );
    
    /**
     * 
     * @param key
     * @return 
     */
    public AnyType removeValue(int key);
    
    /**
     * 
     * @param key
     * @return 
     */    
    public AnyType getValue(int key);
    
    /**
     * 
     * @param newValue
     * @param key
     * @return 
     */
    public Boolean isCollison(AnyType newValue, int key);
    
    /**
     * 
     * @param key
     * @return 
     */
    public int hash(AnyType key);
}
