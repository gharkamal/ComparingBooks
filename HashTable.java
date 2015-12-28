import java.util.ArrayList;
import java.util.List;
/**
 * @author Harkamal Grewal
 * @author Gurpreet Singh
 *
 * This is the Hash Table implementation for the data Counter Interface using Strings
 */
public class HashTable implements DataCounter<String> {
	private Node[] array;
	private int size;
	 private int entries;

	public HashTable() {
		size = nextPrime(100007);
		array = new Node[size];
		entries = 0;
	}
/**
 * 
 * @param data the word
 * @param count how many times have it been used
 * @return the Hash Value for the function
 */
	public int hash(String data, int count ) {
		int hashVal = 0;
		for (int i = 0; data != null && i < data.length(); i++) {
			char found = data.charAt(i);
			hashVal= hashVal + (int) found; 
		}
		if (hashVal <= 0) {
			hashVal += array.length;
		}
		return hashVal;
	}
	
	/**
	 * @param the string to be incremented or added
	 */
	
	public void incCount(String d) {
		Node entry = null;
		if(entries + 1 >= getSize())
		{
			resize();
		}
		int pointer1 = 0;
	   while( pointer1 < size)	    {
            if(array[pointer1] != null && array[pointer1].data.compareTo(d) == 0)
            {
                    entry = array[pointer1];
                    break;
            }
            pointer1++;
	    }
		if(entry == null)
		{
			int hash = hash(d,size);
            if(array[hash] == null)
            {
            	 array[hash] = new Node(d, 1);	
            }      
            else
            {
            	int pointer2 = hash+1;
                    while( pointer2 != hash)
                    {
                            if(pointer2 == size)
                            {
                            	pointer2 = 0;
                            }
                            if(array[pointer2] == null)
                            {
                                    array[pointer2] = new Node(d,1);
                                    hash = pointer2;
                                    break;
                            }
                            pointer2++;
                    }
                    entries++;
            }
		}
         else
        {
          	entry.count++;
         }	
		
		
	}
	private void resize() {
		
		int newSize = nextPrime(size * 2);

		Node[] temp = new Node[newSize];
		Node[] swap = array;
		array= temp;
		temp = swap;

		for (int i = 0; i < array.length; i++) {
			//temp[i] = array[i];
			Node entry = temp[i];
			if(entry != null)
			{
				int index = hash(entry.data, entry.count);
					 array[index].data = entry.data;
			}
		}
		size = newSize;
	}

	/**
	 * @return to get the next prime number that is greater then n
	 */
	private static int nextPrime(int n) {
		if (n % 2 == 0)
			n++;

		for (;!isPrime(n); n += 2)
			;

		return n;
	}

	/**
	 * @return to check if it is a prime number
	 */
	private static boolean isPrime(int n) {
		if (n == 2 || n == 3)
			return true;

		if (n == 1 || n % 2 == 0)
			return false;

		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;

		return true;
	}

	/**
	 * @return the total counts 
	 */
	@SuppressWarnings("unchecked")
	public DataCount<String>[] getCounts() 
	{

		List<DataCount<String>> counts = new ArrayList<DataCount<String>>();

		for (int i = 0; i < array.length; i++)
		{

			if (array[i] != null) {
				counts.add(new DataCount<String>(array[i].getData(),
						array[i].count));
				
			
			}
			
		}
		
		DataCount<String>[] countsArray = new DataCount[counts.size()];

		for (int i = 0; i < counts.size(); i++) 
		{
			countsArray[i] = counts.get(i);
		}
		return countsArray;
	}
	
	/**
	 * @return the size of the array
	 */
	public int getSize() {
		return size;
	}
	

}