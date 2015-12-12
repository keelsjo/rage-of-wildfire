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
public interface HashingInterface<AnyType>
{
    /**
     * 
     * @param t
     * @throws UnhashableDataTypeException 
     */
    public void addValue( AnyType key )throws UnhashableDataTypeException;
    
    /**
     * 
     * @param key
     * @return
     * @throws UnhashableDataTypeException 
     */
    public AnyType removeValue(AnyType key) throws UnhashableDataTypeException;
    
    /**
     * 
     * @param key
     * @return
     * @throws UnhashableDataTypeException 
     */  
    public Object[] getValues(AnyType key) throws UnhashableDataTypeException;
    
    /**
     * 
     * @param key
     * @return
     * @throws UnhashableDataTypeException 
     */
    public int getHashValue(AnyType key)throws UnhashableDataTypeException;
}
