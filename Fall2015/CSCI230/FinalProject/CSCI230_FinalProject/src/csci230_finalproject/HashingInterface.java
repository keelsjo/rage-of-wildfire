/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csci230_finalproject;

/**
 * @T type
 * @author Home
 */
public interface HashingInterface<T>
{
    /**
     * 
     * @param t 
     */
    public void addValue( T t );
    
    /**
     * 
     * @param key
     * @return 
     */
    public T removeValue(int key);
    
    /**
     * 
     * @param key
     * @return 
     */    
    public T getValue(int key);
    
    /**
     * 
     * @param newValue
     * @param key
     * @return 
     */
    public Boolean isCollison(T newValue, int key);
}
