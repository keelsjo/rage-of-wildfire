/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csci230_finalproject;

import java.util.Arrays;

/**
 *
 * @author Home
 */
public class OpenHashing<AnyType> implements HashingInterface<AnyType>
{
    private int size = 100;
    private Object[] array;

    public OpenHashing()
    {
        this.array = new Object[size];
        Arrays.fill(this.array, new SinglyLinkedList());
    }

    public void addValue(AnyType t)
    {
        
    }

    @Override
    public AnyType removeValue(int key)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AnyType getValue(int key)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean isCollison(AnyType newValue, int key)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int hash(boolean key)
    {
        return key ? (1 % this.size) : (0 % this.size);
    }
    
    private int hash(String key)
    {
        int total = 0;
        
        for(int i = 0; i < key.length(); i++){
            total = (int)key.charAt(i);
        }
        return total % this.size;
    }
    
    private int hash(long key)
    {
        return (int)key % this.size;
    }
    
    private int hash(double key)
    {
        return (int)key % this.size;
    }    

    public int hash(AnyType key)
    {
        
    }
}
