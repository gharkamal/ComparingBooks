/**
 * @author Harkamal Grewal
 * @author Gurpreet Singh
 * 
 * @param <E> type of data whose count we are recording.
 */
class DataCount<E extends Comparable<E>> implements Comparable<DataCount<E>> {
    
    /**
     * The data element whose count we are recording.
     */
    E data;

    /**
     * The count for the data element.
     */
    int count;

    /**
     * Create a new data count.
     * 
     * @param data the data element whose count we are recording.
     * @param count the count for the data element.
     */
    DataCount(E data, int count) {
        this.data = data;
        this.count = count;
    }

	@SuppressWarnings("rawtypes")
	@Override
	public int compareTo(DataCount<E> one) {
	
		 DataCount o = (DataCount) one;
		 String a = (String) this.data;
		 String d = (String) o.getData();
	        int check = 0;
	        if(this.getCount() > o.getCount())
	        {
	            check = 1;
	        }
	        else if(this.getCount() < o.getCount())
	        {
	            check = -1;
	        }
	        else if(this.getCount() == o.getCount())
	        {
	        	int length = Math.min(a.length(), d.length());
	    		for (int i = 0; i < length; i++) {
	    			if (a.charAt(i) > d.charAt(i)) {
	    				return -1;
	    			}
	    			else if (a.charAt(i) < d.charAt(i))
	    			{
	    				return 1;
	    			}	
	    		}
	        }
	        return check;
	    }
/**
 * gets the data in the string 
 * @return data
 */
	public E getData() {
		return data;
	}
/**
 * gets the count 
 * @return count
 */
	public int getCount() {
		return count;
	}
}

/**
 * Interface for a data structure that allows you to count the number of times
 * you see each piece of data.
 * 
 * @param <E> The type of data to be counted.
 */
public interface DataCounter<E extends Comparable<E>> {

    /**
     * Increment the count for a particular data element.
     * 
     * @param data data element whose count to increment.
     */
    public void incCount(E data);

    /**
     * The number of unique data elements in the structure.
     * 
     * @return the number of unique data elements in the structure.
     */
    public int getSize();

    /**
     *  An array of all of the data counts in the DataCounter structure. 
     * @return an array of the data counts.
     */
    public DataCount<E>[] getCounts();

}
