/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csci230_finalproject;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * 
 * @author Home
 * @param <AnyType> 
 */
public class OpenHashing<AnyType extends Comparable<? super AnyType>> implements HashingInterface<AnyType>
{
    private final int size = 100;
    private final SinglyLinkedList[] array;

    public OpenHashing()
    {
        this.array = new SinglyLinkedList[size];
        Arrays.fill(this.array, new SinglyLinkedList());
    }

    public void addValue(AnyType key) throws UnhashableDataTypeException
    {
        this.array[getHashValue(key)].add(new Node(key));
    }

    public AnyType removeValue(AnyType key) throws UnhashableDataTypeException
    {
        SinglyLinkedList sLL = this.array[getHashValue(key)];
        
        return (AnyType)sLL.removeData(key);
    }

    public Object[] getValues(AnyType key) throws UnhashableDataTypeException
    {
        ArrayList<AnyType> found = new ArrayList();
        return this.array[getHashValue(key)].getAllData();
    }
        
    public int getHashValue(AnyType  key)throws UnhashableDataTypeException
    {
        int hashVal = -1;        
        
        if(key instanceof Boolean){
            hashVal = hash((Boolean)key);
        }
        else if(key instanceof String || key instanceof Character ){
            hashVal = hash((String)key);
        }
        else if(
                key instanceof Float || 
                key instanceof Double ||
                key instanceof Byte || 
                key instanceof Short || 
                key instanceof Integer || 
                key instanceof Long){
            hashVal = hash((Long)key);
        }
        else{
            throw new UnhashableDataTypeException();
        }                
        return hashVal;
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
}
