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
    private int capacity = 101;
    private final int probeStep = 2;
    ArrayList aL; 

    public ClosedHashing()
    {
        this.aL = new ArrayList(capacity);
    }
    
    public ClosedHashing(int manualCapacity)
    {
        this.capacity = manualCapacity;
        this.aL = new ArrayList(capacity);
    }
    
    public void addValue(Object key) throws UnhashableDataTypeException
    {
        int hashVal = getHashValue(key);
        
        if(isCollision(hashVal)){
            this.aL.add(hashVal, (Comparable)key);
        }
        else{
            probeHashTable_add(hashVal + probeStep, (AnyType)key);
        }
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
        return key ? (1 % this.capacity) : (0 % this.capacity);
    }
    
    private int hash(String key)
    {
        int total = 0;
        
        for(int i = 0; i < key.length(); i++){
            total = (int)key.charAt(i);
        }
        return total % this.capacity;
    }
    
    private int hash(long key)
    {
        return (int)key % this.capacity;
    }
    
    private void probeHashTable_add(int index, AnyType t) throws UnhashableDataTypeException
    {
        int startIndex = index - probeStep;
        int stopIndex = (startIndex) > (capacity - 2) ? 0 : startIndex + 1;
        boolean isAdded = false;        
        
        while(index == stopIndex){
            if(index > capacity){
                index = index % probeStep;
            }
            if(this.aL.get(index) == null){
                this.aL.set(index, t);
                isAdded = true;
                break;
            }
            index += probeStep;
        }
        if(!isAdded){
            Object[] objHash = rehash(this.aL, t);
            this.aL = (ArrayList)objHash[0];
            this.capacity = (int)objHash[1];
        }
    }
    
    private boolean isCollision(int hashVal)
    {
        return this.aL.get(hashVal) == null;
    }
    
    private Object[] rehash(ArrayList oldAL, AnyType newValue) throws UnhashableDataTypeException{
        ClosedHashing newHash = new ClosedHashing((this.capacity * 2) + 1);
        int len_oldAL = oldAL.size();
        
        for(int i = 0; i < len_oldAL; i++){
            if(oldAL.get(i) != null){
                newHash.addValue(oldAL.get(i));
            }
        }
        newHash.addValue(newValue);
        return new Object[] {newHash.aL, newHash.capacity};
    }
}
