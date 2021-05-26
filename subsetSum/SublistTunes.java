import cs_1c.*;
import java.util.*;

public class SublistTunes  {
	
  private int sum = 0;
  private ArrayList<iTunesEntry> originalObjects;
  private ArrayList<Integer> indices;
  
  public SublistTunes(ArrayList<iTunesEntry> orig) {
     sum = 0;
     originalObjects = orig;
     indices = new ArrayList<Integer>();
  }
  
  int getSum() { return sum; }
  
  public Object clone() throws CloneNotSupportedException {
	 SublistTunes newObject = (SublistTunes)super.clone();
     newObject.indices = (ArrayList<Integer>)indices.clone();
     
     return newObject;
  }
  
  public SublistTunes addItem( int itemIndexTobeAdded ) {
     if (itemIndexTobeAdded < 0
         || itemIndexTobeAdded >= originalObjects.size()) {
        return null;
     }
     
     SublistTunes newSublist;
     
     try {
        newSublist = (SublistTunes)clone();
     } catch(CloneNotSupportedException e) {
        return null;
     }
     
     newSublist.indices.add(itemIndexTobeAdded);
     newSublist.sum = sum + originalObjects.get(itemIndexTobeAdded).getTime();
     return newSublist;
  }
  
  public void showSublist() {
	      ListIterator<Integer> p;
	      int index = 0;
	      
	      System.out.println("Sublist -----------------------------");
	      System.out.println("  sum: " + sum);
	      for (p = indices.listIterator(); p.hasNext(); ) {
	         index = p.next();
	         System.out.println("  array[" + index + "] = " 
	            + originalObjects.get(index));
	      }
	      System.out.println();
	   }
}
