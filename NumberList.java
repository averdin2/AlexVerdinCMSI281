/** An object of this class represents a number list, i.e., an ordered collection
    of integers, each of Java class <a href="http://docs.oracle.com/javase/7/docs/api/java/lang/Long.html">Long</a>, 
    with duplicates permitted. Be sure to read the Java documentation on
    <a href="http://docs.oracle.com/javase/7/docs/api/java/util/Collection.html">interface java.util.Collection</a>.
*/

public class NumberList implements java.util.Collection {
private Long[] longArray;
    /** Constructs an empty number list. */
    public NumberList(){
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        longArray = new Long[0];
       // throw new UnsupportedOperationException();
    }


    /** Constructs a number list from an array of Longs. */
    public NumberList( Long[] l ){
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        longArray = new Long[l.length];
        for (int i = 0; i < l.length; i++) {
            longArray[i] = l[i];
        }
       // throw new UnsupportedOperationException();
    }
    
    /** Increases by one the number of instances of the given element in this collection. */
    public boolean add ( Object obj ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        if(!(obj instanceof Long)) {
            return false;
        } else {
            Long[] plusOne = new Long[longArray.length + 1];
            for(int i = 0; i < longArray.length; i++) {
                plusOne[i] = longArray[i];
            }
            plusOne[plusOne.length - 1] = (long)obj;
            longArray = plusOne;
            return true;
        }
       // throw new UnsupportedOperationException();
    }
    

    /** Adds all of the elements of the given number list to this one. */
    public boolean addAll ( java.util.Collection c  ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        Object[] cArray = c.toArray();
        int j = 0;
        int k = 0;
        while (j == 0 || k < cArray.length - 1) {
            if (!(cArray[k] instanceof Long)) {
                j++;
                return false;
            } else {
                k++;
            }
        }
        Long[] plusC = new Long[longArray.length + cArray.length];
        for(int i = 0; i < longArray.length; i++) {
                plusC[i] = longArray[i];
            }
        for(int i = 0; i < cArray.length - 1; i++) {
            plusC[longArray.length + i] = (long)cArray[i];
            longArray = plusC;
           // return true;
        }
        return true;

        
    }
 

    /** Removes all of the elements from this collection. */
    public void clear () {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        longArray = new Long[0];

        
    }
 

    /** Returns true iff this number list contains at least one instance of the specified element. */
    public boolean contains ( Object obj ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        for(int i = 0; i < longArray.length; i++) {
            if(longArray[i] == obj) {
                return true;
            }
        }
        return false;
       // throw new UnsupportedOperationException();
    }
 


    /** Returns true iff this number list contains at least one instance of each element 
        in the specified list. Multiple copies of some element in the argument do not
        require multiple copies in this number list. */
    public boolean containsAll ( java.util.Collection c ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        Object[] cArray = c.toArray();
        for(int j = 0; j < cArray.length; j++) {
            for(int i = 0; i < longArray.length; i++) {
                if(i == longArray.length - 1 && cArray[j] != longArray[i]) {
                    return false;
                } else {
                    if(cArray[j] == longArray[i]) {
                        break;
                    }
                }
            }
        } return true;
       /* for(int i = 0; i < longArray.length - 1; i++) {
            for(int j = 0; j <= cArray.length - 1; j++) {
                int k = i;
                if(longArray[k] == longArray[j]) {
                    if(j == longArray.length - 1) {
                        return true;
                    }
                } k++;
        }
    } return false;*/

     
    }
 
 


    /** Compares the specified object with this collection for equality. */
    public boolean equals ( Object obj ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        if(longArray.length > 1) {
            return false;
        } else {
            if(!(longArray[0] == obj)) {
                return false;
            }       
        }
        return true;
        
    }
 



    /** Returns the hashcode value for this collection. */
    public int hashCode () {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }



    /** Returns true if this collection contains no elements. */
    public boolean isEmpty () {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        if(longArray.length == 0) {
            return true;
        }
        return false;
        
    }



    /** Returns an iterator over the elements in this collection. Replicated elements should
        be "iterated over" just once. */
    public java.util.Iterator iterator () {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }



    /** Removes a single instance of the specified element from 
        this collection, if it is present. */
    public boolean remove ( Object obj ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        for(int i = 0; i < longArray.length; i++) {
            if(longArray[i] == obj) {
                longArray[i] = null;
                return true;
            }
        }
        return false;
        
    }



    /** Removes all of this collection's elements that are also contained 
        in the specified collection. */
    public boolean removeAll ( java.util.Collection c ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        Object[] cArray = c.toArray();
        for(int j = 0; j < cArray.length; j++) {
            for(int i = 0; i < longArray.length; i++) {
                if(j == cArray.length - 1 && cArray[j] != longArray[i]) {
                    return false;
                } else {
                    if(cArray[j] == longArray[i]) {
                        longArray[i] = null;
                    }
                }
            }
        } return true;
        
    }




	/** Retains only the elements in this collection that are contained in the specified collection. 
		 In other words, removes from this collection all of its elements that are not contained in the 
		 specified collection. */
	public boolean retainAll ( java.util.Collection c ) {
        Object[] cArray = c.toArray();
        for(int j = 0; j < cArray.length; j++) {
            for(int i = 0; i < longArray.length; i++) {
                if(j == cArray.length - 1 && cArray[j] == longArray[i]) {
                    return false;
                } else {
                    if(cArray[j] != longArray[i]) {
                        longArray[i] = null;
                    }
                }
            }
        } return true;
        
		
	}


    /** Returns the number of elements in this number list, including duplicates. */
    public int sizeIncludingDuplicates () {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
       return longArray.length;
        
    }
    
    

    /** Returns a NumberList[] containing all of the elements in this collection, not including duplicates. */
    public Long[] toArray () {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        for(int i = 0; i < longArray.length; i++) {
            for(int j = i+1; j < longArray.length; j++) {
                if(longArray[i] == longArray[j]) {
                    longArray[j] = null;
                    i++;
                    break;
                }
            }
        }
        Long[] tempArray = new Long[longArray.length];
        for(int i = 0; i < tempArray.length; i++) {
            for(int j = i+1; j < tempArray.length; j++) {
                if(longArray[j] == null) {
                    break;
                } else {
                    tempArray[i] = longArray[j];
                }
            }
        }
        return tempArray;

        
    }



    /** Not supported for this class. */
    public NumberList[] toArray ( Object[] obj ) {
        throw new UnsupportedOperationException();
    }




    /** Returns the number of elements in this number list, not including duplicates. */
    public int size () {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        int iCount = 0;
        for(int i = 0; i < longArray.length; i++) {
            for(int j = i+1; j < longArray.length; j++) {
                if(longArray[i] == longArray[j]) {
                    longArray[j] = null;
                }
            }
        }
        for(int k = 0; k < longArray.length; k++) {
            if(longArray[k] instanceof Long) {
                iCount++;
            }
        } return iCount;
        
    }   





    /** Returns the number of instances of the given element in this number list. */
    public int count ( Object obj ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        int iCount = 0;
        for(int i = 0; i < longArray.length; i++) {
            if(longArray[i] == obj) {
                iCount++;
            }
        }
        return iCount;
        
    }
    

    
    /** This returns a stringy version of this number list. */
    public String toString () { // overrides Object.toString()
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        String stringyNumberList = "";
        for(int i = 0; i < longArray.length; i++) {
            if(i == longArray.length - 1) {
                stringyNumberList = stringyNumberList + longArray[i];
            } else {
            stringyNumberList = stringyNumberList + longArray[i] + ",";
            }  
        }
        return stringyNumberList;
        
    }


    
    /** This so-called "static factory" returns a new number list comprised of the numbers in the specified array.
        Note that the given array is long[], not Long[]. */
    public static NumberList fromArray ( long[] l ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        NumberList list = new NumberList();
        list.longArray = new Long[l.length];
        for(int i = 0; i < list.longArray.length; i++) {
            list.longArray[i] = (Long)l[i];
        }
        return list;
        
    }

    
    /** This main method is just a comprehensive test program for the class. */
    public static void main ( String[] args ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }
    
}
