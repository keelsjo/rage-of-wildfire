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
    private int capacity = 3;
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
            probeHashTable_add(hashVal, (AnyType)key);
        }
        else{
            this.aL.add(hashVal, (Comparable)key);
        }
    }

    public Object removeValue(Object key) throws UnhashableDataTypeException
    {
        int index = getIndexOf(getHashValue(key), key);
        return this.aL.removeData(index);
    }

    @Override
    public Object[] getValues(Object key) throws UnhashableDataTypeException
    {
        return this.aL.getAllData();
    }
    
    public int getHashValue(Object key) throws UnhashableDataTypeException
    {
        int hashVal = -1;        
        
        if(key instanceof Boolean){
            hashVal = hash((Boolean)key);
        }
        else if(key instanceof String){
            hashVal = hash((String)key);
        }
        else if(key instanceof Integer){
            hashVal = hash((Integer)key);
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
            total += (int)key.charAt(i);
        }
        return total % this.capacity;
    }
    
    private int hash(int key)
    {
        return Math.abs(key) % this.capacity;
    }
    
    private void probeHashTable_add(int index, AnyType t) throws UnhashableDataTypeException
    {
        int count = 0;
        int current = index + 1;
        boolean isAdded = false;        
        
        while(count < this.aL.size()){
            if(current >= capacity - 1){
                current = 0;
            }
            if(this.aL.get(current) == null){
                this.aL.set(index, t);
                isAdded = true;
                break;
            }
            current++;
            count++;
        }
        if(!isAdded){
            Object[] objHash = rehash(this.aL, t);
            this.aL = (ArrayList)objHash[0];
            this.capacity = (int)objHash[1];
        }
    }
    
    private int getIndexOf(int hashValue, Object key){
        int found = -1;        
        int startIndex = hashValue;
        int stopIndex = startIndex == 0 ? this.aL.size() - 1 : startIndex - 1;
               
        
        while(startIndex == stopIndex){
            if(startIndex > capacity){
                startIndex = 0;
            }
            if(this.aL.get(startIndex) == key){
                found = startIndex;
                break;
            }
            startIndex++;
        }
        
        return found;
    }
    
    private boolean isCollision(int hashVal)
    {
        return this.aL.get(hashVal) != null;
    }
    
    private Object[] rehash(ArrayList oldAL, AnyType newValue) throws UnhashableDataTypeException{
        ClosedHashing newHash = new ClosedHashing((this.capacity * 2) + 1);
        int len_oldAL = oldAL.size();
        
        for(int i = 0; i < len_oldAL; i++){
            ClosedHashingElement element = (ClosedHashingElement)oldAL.getHashElement(i);
            
            if(element.getData() != null){
                newHash.addValue(element.getData());
            }
        }
        newHash.addValue(newValue);
        return new Object[] {newHash.aL, newHash.capacity};
    }
}
