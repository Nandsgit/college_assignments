import java.util.ArrayList;
import java.util.ListIterator;


class SublistInt implements Cloneable {
   private int sum = 0;
   private ArrayList<Integer> originalObjects;
   private ArrayList<Integer> indices;
   
   // constructor
   public SublistInt(ArrayList<Integer> orig) {
      sum = 0;
      originalObjects = orig;
      indices = new ArrayList<Integer>();
   }
   
   int getSum() { return sum; }
   
   // Creates and returns a copy of this object
   public Object clone() throws CloneNotSupportedException {
      SublistInt newObject = (SublistInt)super.clone();
      newObject.indices = (ArrayList<Integer>)indices.clone();
      
      return newObject;
   }
   
   //creating a new Sublist object whose sum is the sum of the 
   //calling object plus the value of the new item added.
   
   public SublistInt addItem( int itemIndexTobeAdded ) {
      if (itemIndexTobeAdded < 0 || itemIndexTobeAdded >= originalObjects.size()) {
         return null;
      }
      
      SublistInt newSublist;
      
      try {
      //type casting
         newSublist = (SublistInt)clone();
      } catch(CloneNotSupportedException e) {
         return null;
      }
      
      newSublist.indices.add(itemIndexTobeAdded);
      newSublist.sum = sum + originalObjects.get(itemIndexTobeAdded);
      return newSublist;
   }
   
   //printing list
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