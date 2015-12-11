package csci230_finalproject;


/**
 * Singly LinkedList Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2015
 *
 * @param <AnyType>
 */
public class SinglyLinkedList<AnyType extends Comparable<? super AnyType>> implements List<Node<AnyType>> {
	
	// instance variables
	private Node<AnyType> headNode = null;
	private int size = 0;

	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param t
	 */
	public void add(Node<AnyType> t) {
		
		if ( isEmpty() ) 
                {
                    headNode = t;
                } 
                else
                {
                    get( size-1 ).setNextNode( t );
                }		
		size++;
		
	} // end add() method

	/**
	 * Inserts the specified element at the specified position in this list.
	 * 
	 * @param index
	 * @param t
	 * @throws IndexOutOfBoundsException
	 */
	public void add(int index, Node<AnyType> t) throws IndexOutOfBoundsException 
        {
            if(index > size || index < 0)
            {
                throw new IndexOutOfBoundsException();
            }
            else if(index == size)
            {
                add(t);
            }
            else if (index == 0)
            {
                t.setNextNode(headNode);
                headNode = t;
                size++;
            }
            else
            {
                Node<AnyType> tempPrev = get(index-1);
                t.setNextNode(tempPrev.getNextNode());
                tempPrev.setNextNode(t);  
                size++;
            }
	} // end add() method

	/**
	 * Replaces the element at the specified position in this list with the specified element.
	 * 
	 * @param index
	 * @param t
	 * @throws IndexOutOfBoundsException
	 */
	public void set(int index, Node<AnyType> t) throws IndexOutOfBoundsException 
        {		
            if(index >= size || index < 0)
            {
                throw new IndexOutOfBoundsException();
            }
            else if (index == 0)
            {
                headNode.setData(t.getData());
            }
            else
            {
                get(index).setData(t.getData());
            }         		
	} // end set() method

	/**
	 * Removes the element at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public Node<AnyType> remove( int index ) throws IndexOutOfBoundsException 
        {
            Node<AnyType> removed = null;
            
            if(index >= size || index < 0 || size == 0)
            {
                throw new IndexOutOfBoundsException();
            }
            else if (index == 0)
            {
                removed = headNode;
                
                headNode = headNode.getNextNode();
                removed.setNextNode(null);
                size--;
            }
            else
            {
                Node<AnyType> tempPrev = get(index-1);
                removed = tempPrev.getNextNode();
                tempPrev.setNextNode(removed.getNextNode());
                removed.setNextNode(null);
                size--;
            }
            return removed;
	} // end remove() method

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public Node<AnyType> get(int index) throws IndexOutOfBoundsException 
        {
            Node<AnyType> gotten = headNode;
            
            if(index >= size || index < 0 || size == 0)
            {
                throw new IndexOutOfBoundsException();
            }
            else
            {
                for (int i = 0; i < index; i++)
                {
                    gotten = gotten.getNextNode();
                }
            }
            return gotten;
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
		
		return size == 0;
		
	} // end isEmpty() method
	
	
	/**
	 * Removes all of the elements from this list.
	 * 
	 */
	public void clear() {
		headNode = null;
                size = 0;
	} // end clear method
} // end SinglyLinkedList class definition