import java.util.ArrayList;

public class MySorts {

    public static void shuffle(ArrayList al) {
        int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
            //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
            //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }

    public static boolean isSorted(ArrayList<Comparable> data) {
	for (int i=0; i<data.size()-1; i++) {
	    if (data.get(i).compareTo(data.get(i+1))>0) {
		return false;
	    }
	}
	return true;
    }

    //Bubble Sort
    public static void bubbleSortV( ArrayList<Comparable> data ) {
	for (int i=0; i<data.size()-1; i++) {
	    int comp1 = data.size()-2;
	    int comp2 = data.size()-1;
	    for (; comp2>0; comp2--) {
		if (data.get(comp1).compareTo(data.get(comp2))>0) {
		    Comparable temp = data.get(comp1);
		    data.set(comp1,data.get(comp2));
		    data.set(comp2,temp);
		}
		comp1--;
	    }
	}
    }//end bubbleSortV -- O(n^2)
    
    //Selection Sort
    public static void selectionSortV( ArrayList<Comparable> data )
    {
	for (int i=0; i<data.size()-1; i++) {
	    int smallest = i;
	    for (int j=i; j<data.size(); j++) {
		if (data.get(j).compareTo(data.get(smallest))<0) {
		    smallest = j;
		}
	    }
	    Comparable temp = data.get(smallest);
	    data.set(smallest,data.get(i));
	    data.set(i,temp);
	}
    }//end selectionSort -- O(?)

    //Bogo Sort
    public static void bogoSortV( ArrayList<Comparable> data )
    {
	while (!isSorted(data)) {
	    shuffle(data);
	}
    }

    public static void main(String[] args){
	ArrayList bubble = new ArrayList<Integer>();
	bubble.add(7);
	bubble.add(1);
	bubble.add(5);
	bubble.add(12);
	bubble.add(3);
	System.out.println( "ArrayList bubble before sorting:\n" + bubble );
	bubbleSortV(bubble);
	System.out.println( "ArrayList bubble after sorting:\n" + bubble );	
	ArrayList select = new ArrayList<Integer>();
	select.add(7);
	select.add(1);
	select.add(5);
	select.add(12);
	select.add(3);
	System.out.println( "ArrayList select before sorting:\n" + select );
	selectionSortV(select);
	System.out.println( "ArrayList select after sorting:\n" + select );
	ArrayList bogo = new ArrayList<Integer>();
	bogo.add(7);
	bogo.add(1);
	bogo.add(5);
	bogo.add(12);
	bogo.add(3);
	System.out.println( "ArrayList bogo before sorting:\n" + bogo );
	bogoSortV(bogo);
	System.out.println( "ArrayList bogo after sorting:\n" + bogo );
    }
}
