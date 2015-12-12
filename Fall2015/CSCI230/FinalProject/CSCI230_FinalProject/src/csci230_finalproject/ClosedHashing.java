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
public class ClosedHashing<AnyType extends Comparable<? super AnyType>> implements HashingInterface
{    
    private final int size = 100;
    ArrayList aL = new ArrayList();

    public ClosedHashing()
    {
    }
    
   @Override
    public void addValue(Object key) throws UnhashableDataTypeException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object removeValue(Object key) throws UnhashableDataTypeException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] getValues(Object key) throws UnhashableDataTypeException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getHashValue(Object key) throws UnhashableDataTypeException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private boolean isCollision(int hashVal, AnyType key)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
