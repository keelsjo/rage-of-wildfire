package csci230_finalproject;

/**
 * ArrayList Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2015
 *
 * @param <AnyType>
 */
public class ArrayList<AnyType extends Comparable<? super AnyType>> implements List<AnyType> {
     
    // instance variables
    private Object[] array;
    private int size = 0;
    private final static int INITIAL_CAPACITY = 11;
    private int capacity;
    
    /**
     * Constructs an empty list with an initial capacity
     * (for this assignment initial capacity is 10 - see 
     * constant instance variable)
     * 
     */
    public ArrayList() {
    	
    	array = new Object[ INITIAL_CAPACITY ];
        capacity = INITIAL_CAPACITY;
    	
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
    	array = new Object[ manualCapacity ];
        this.capacity = manualCapacity;    	
    } // end constructor
 
    /**
     * Appends the specified element to the end of this list.
     * 
     * @param t
     */
    public void add( AnyType t) {
         
    	if ( size >= capacity )
        {
            grow();
        }
    	array[size]=t;
        size++;
         
    } // end add() method
 
    /**
     * Inserts the specified element at the specified position in this list.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, AnyType t) throws IndexOutOfBoundsException {
         
        if(index > size || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            array[index] = t;
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
         
        if(index > (size - 1))
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            array[index] = t;
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

        if(index > (size - 1) || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            AnyType found = (AnyType)array[index];
            for(int i = index; i < (size - 1); i++)
            {
                array[i] = array[i + 1];
            }
            size--;

            if ((size * 2) + 1 <= capacity)
            {
                shrink();
            }        
            return found;    
        }           	
    }// end remove() method
 
    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType get(int index) throws IndexOutOfBoundsException {

        if(index > (size - 1) || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            return (AnyType)array[index];    
        }
    } // end get() method
 
    /**
     * Returns the number of elements in this list. 
     * 
     * @return
     */
    public int size() {
         
        return size;
         
    } // end size() method
 
    /**
     * Returns true if this list contains no elements.
     * 
     * @return
     */
    public Boolean isEmpty() {
         
        return ( size == 0 );
         
    } // end isEmpty() method
     
     
    /**
     * Removes all of the elements from this list.
     * and the initial capacity is set back to 10
     * 
     */
    public void clear() {         
       this.array = new Object[ INITIAL_CAPACITY ];
       this.size = 0;
       this.capacity = INITIAL_CAPACITY;
    } // end clear method
    
    /**
     * Double the capacity of the array
     * 
     */
    private void grow() {
    	
    	Object[] newArray = new Object[size * 2];
        
        for(int i = 0; i < size; i++)
        {
            newArray[i] = array[i];
        } 
        this.array = newArray;
        this.capacity = newArray.length;
    } // end grow() method
    
    
    /**
     * Half the capacity of the array
     * 
     */
    private void shrink() {
    	Object[] newArray = new Object[(int)Math.ceil(size / 2)];
        
        for(int i = 0; i < newArray.length; i++)
        {
            newArray[i] = array[i];
        } 
        this.array = newArray;
        this.capacity = newArray.length;
    } // end shrink() method

    @Override
    public AnyType removeData(AnyType t)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] getAllData()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} // end ArrayList class definition
