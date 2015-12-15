package csci230_finalproject;

import java.util.Arrays;
/**
 * ArrayList Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2015
 *
 * @param <AnyType>
 */
public class ArrayList<AnyType extends Comparable<? super AnyType>> implements List<AnyType>{
     
    // instance variables
    private ClosedHashingElement[] array;
    private final static int INITIAL_CAPACITY = 11;
    private int capacity;
    
    /**
     * Constructs an empty list with an initial capacity
     * (for this assignment initial capacity is 10 - see 
     * constant instance variable)
     * 
     */
    public ArrayList() {
    	
    	array = new ClosedHashingElement[ INITIAL_CAPACITY ];
        capacity = INITIAL_CAPACITY;
        arrayFill();
    	
    } // end constructor
    
    /**
     * Constructs an empty list with an initial capacity provided by calling
     * function
     * 
     * 
     * @param manualCapacity
     */
    public ArrayList(int manualCapacity) {
    	manualCapacity = manualCapacity % 2 == 0 ? manualCapacity + 1 : manualCapacity;
    	array = new ClosedHashingElement[ manualCapacity ];
        this.capacity = manualCapacity;    
        arrayFill();
    } // end constructor
 
    /**
     * Appends the specified element to the end of this list.
     * 
     * @param t
     */
    public void add( AnyType t) {
         
    	throw new UnsupportedOperationException("Removed for this implementation");
         
    } // end add() method
 
    /**
     * Inserts the specified element at the specified position in this list.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, AnyType t) throws IndexOutOfBoundsException {
         
        if(index > capacity || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            array[index].setData(t);
        }        
    } // end add() method
 
    /**
     * Replaces the element at the specified position in this list with the specified element.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void set(int index, AnyType t) throws IndexOutOfBoundsException {
         
        if(index > (capacity - 1))
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            array[index].setData(t);
        }               
    } // end set() method
 
    /**
     * Removes the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    
    public AnyType remove( int index ) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Removed for this implementation");
    }// end remove() method
 
    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType get(int index) throws IndexOutOfBoundsException {

        if(index > (capacity - 1) || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            return (AnyType)array[index].getData();    
        }
    } // end get() method
    
    public ClosedHashingElement getHashElement(int index) throws IndexOutOfBoundsException {

        if(index > (capacity - 1) || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            return array[index];    
        }
    }
 
    /**
     * Returns the number of elements in this list. 
     * 
     * @return
     */
    public int size() {
         
        return capacity;
         
    } // end capacity() method
 
    /**
     * Returns true if this list contains no elements.
     * 
     * @return
     */
    public Boolean isEmpty() {
         
        return ( capacity == 0 );
         
    } // end isEmpty() method
     
     
    /**
     * Removes all of the elements from this list.
     * and the initial capacity is set back to 10
     * 
     */
    public void clear() {         
       this.array = new ClosedHashingElement[ INITIAL_CAPACITY ];
       this.capacity = INITIAL_CAPACITY;
    } // end clear method
    
    /**
     * Double the capacity of the array
     * 
     */
    private void grow() {    	
    	throw new UnsupportedOperationException("Removed for this implementation");
    } // end grow() method
    
    
    /**
     * Half the capacity of the array
     * 
     */
    private void shrink() {
    	throw new UnsupportedOperationException("Removed for this implementation");
    } // end shrink() method

    public AnyType removeData(AnyType t)
    {
        int index = (Integer)t;
        
        if(index > (capacity - 1) || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            AnyType found = (AnyType)array[index];
            array[index].setData(null);              
            return found;    
        }           	
    }

    public Object[] getAllData()
    {
        Object[] found = new Object[this.capacity];
        ClosedHashingElement element;
                
        for(int i = 0; i < this.capacity; i++){
            element = this.array[i];
            
            if(element.getData() != null){
                found[i] = element.getData();
            }
            else if(element.getData() == null && element.getIsTombstone()){
                found[i] = "Tombstone";
            }
            else{
                found[i] = "null";
            }
        }
        return found;
    }
    
    private void arrayFill(){
        for(int i = 0; i < this.capacity; i++){
            this.array[i] = new ClosedHashingElement();
        }
    }
} // end ArrayList class definition
