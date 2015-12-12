package csci230_finalproject;

/**
 * 
 * Exception used in binary search tree coding assignment.
 * 
 * This exception is thrown when a duplicate element (i.e. 
 * an existing node in the binary search tree has the same 
 * element value.
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2015
 *
 */
@SuppressWarnings("serial")
public class UnhashableDataTypeException extends Exception {

	public UnhashableDataTypeException() {
		super( "Illegal Data Type" );
	}
	
} // end DuplicateElementException class definition
