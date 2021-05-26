
import cs_1c.*;
import java.text.*;
import java.util.*;

// For part C: most of the code stays the same used in
// part A and B, except the sublist class
public class SublistGenerics {
	
   public static void testIntGenericizing(int target) {
      ArrayList<Integer> dataSet = new ArrayList<Integer>();
      ArrayList<SublistGener<Integer>> choices = new ArrayList<SublistGener<Integer>>();
      int k, j, numSets, max, kBest, masterSum, newSum;
      boolean foundPerfect;
      
      NumberFormat tidy = NumberFormat.getInstance(Locale.US);
      tidy.setMaximumFractionDigits(4);
      long startTime, stopTime; 
      
      dataSet.add(2); dataSet.add(12); dataSet.add(22);
      dataSet.add(5); dataSet.add(15); dataSet.add(25);
      dataSet.add(9); dataSet.add(19); dataSet.add(29);

      startTime = System.nanoTime();

      choices.clear();
      System.out.println("Target time: " + target);
      
      SublistGener<Integer> sublist = new SublistGener<Integer>(dataSet);
      
      masterSum = 0;
      for (k = 0; k < dataSet.size(); k++) {
         masterSum += dataSet.get(k);
      }
      
      //This is a test to remove the target if its larger than
      //the sum of all elements in master set
      if (masterSum <= target) {
         for (k = 0; k < dataSet.size(); k++) {
            sublist = sublist.addItem(k, dataSet.get(k));
         }
         sublist.showSublist();
         
         stopTime = System.nanoTime();
         System.out.println("Algorithm Elapsed Time: "
            + tidy.format( (stopTime - startTime) / 1e9) + " seconds.\n");
         
         return;
      }
      
      choices.add(sublist);
      max = kBest = 0;
      foundPerfect = false;
      for (k = 0; k < dataSet.size() && !foundPerfect; k++) {
         numSets = choices.size();
         for (j = 0; j < numSets; j++) {
            newSum = choices.get(j).getSum() + dataSet.get(k);
            if (newSum <= target) {
               choices.add(choices.get(j).addItem(k, dataSet.get(k)));
               if (newSum > max) {
                  kBest = choices.size() - 1;
                  max = newSum;
               }
            }
            if (newSum == target) {
               foundPerfect = true;
               break;
            }
         }
      }

      choices.get(kBest).showSublist(); 
      
      stopTime = System.nanoTime();
      System.out.println("Algorithm Elapsed Time: "
         + tidy.format( (stopTime - startTime) / 1e9) + " seconds.\n");
   }
   
   public static void testITunesGenericizing(int target) {
      ArrayList<iTunesEntry> dataSet = new ArrayList<iTunesEntry>();
      ArrayList<SublistGener<iTunesEntry>> choices 
         = new ArrayList<SublistGener<iTunesEntry>>();
      int k, j, numSets, max, kBest, arraySize, masterSum, newSum;
      boolean foundPerfect;
      
      NumberFormat tidy = NumberFormat.getInstance(Locale.US);
      tidy.setMaximumFractionDigits(4);
      long startTime, stopTime; 
      
      iTunesEntryReader tunesInput = new iTunesEntryReader("itunes_file.txt");

      if (tunesInput.readError())
      {
         System.out.println("couldn't open " + tunesInput.getFileName()
            + " for input.");
         return;
      }

      startTime = System.nanoTime();
      
      arraySize = tunesInput.getNumTunes();
      for (k = 0; k < arraySize; k++)
         dataSet.add(tunesInput.getTune(k));

      choices.clear();
      System.out.println("Target time: " + target);
      
      SublistGener<iTunesEntry> sublist = new SublistGener<iTunesEntry>(dataSet);
      
      masterSum = 0;
      for (k = 0; k < dataSet.size(); k++) {
         masterSum += dataSet.get(k).getTime();
      }
      
      // test to quickly dispose of the case in which the target is
      // larger than the sum of all elements in the master set
      if (masterSum <= target) {
         for (k = 0; k < dataSet.size(); k++) {
            sublist = sublist.addItem(k, dataSet.get(k).getTime());
         }
         sublist.showSublist();
         
         stopTime = System.nanoTime();
         System.out.println("Algorithm Elapsed Time: "
            + tidy.format( (stopTime - startTime) / 1e9) + " seconds.\n");
         
         return;
      }
      
      choices.add(sublist);
      max = kBest = 0;
      foundPerfect = false;
      for (k = 0; k < dataSet.size() && !foundPerfect; k++) {
         numSets = choices.size();
         for (j = 0; j < numSets; j++) {
            newSum = choices.get(j).getSum() + dataSet.get(k).getTime();
            if (newSum <= target) {
               choices.add(choices.get(j).addItem(k, dataSet.get(k).getTime()));
               if (newSum > max) {
                  kBest = choices.size() - 1;
                  max = newSum;
               }
            }
            if (newSum == target) {
               foundPerfect = true;
               break;
            }
         }
      }

      choices.get(kBest).showSublist(); 
      
      stopTime = System.nanoTime();
      System.out.println("Algorithm Elapsed Time: "
         + tidy.format( (stopTime - startTime) / 1e9) + " seconds.\n");
   }
}

//class SublistGener<E> implements Cloneable {
//   private int sum = 0;
//   private ArrayList<E> originalObjects;
//   private ArrayList<Integer> indices;
//   
//   public SublistGener(ArrayList<E> orig) {
//      sum = 0;
//      originalObjects = orig;
//      indices = new ArrayList<Integer>();
//   }
//   
//   int getSum() { return sum; }
//   
//   public Object clone() throws CloneNotSupportedException {
//      SublistGener<E> newObject = (SublistGener<E>)super.clone();
//      newObject.indices = (ArrayList<Integer>)indices.clone();
//      return newObject;
//   }
//   
//   // takes an int as the second parameter 
//   // to represent the value of the new item
//   public SublistGener<E> addItem( int itemIndexTobeAdded, int intVal ) {
//      if (itemIndexTobeAdded < 0
//          || itemIndexTobeAdded >= originalObjects.size()) {
//         return null;
//      }
//      
//      SublistGener<E> genericsSublist;
//      
//      try {
//         genericsSublist = (SublistGener<E>)clone();
//      } catch(CloneNotSupportedException e) {
//         return null;
//      }
//      genericsSublist.indices.add(itemIndexTobeAdded);
//      genericsSublist.sum = sum + intVal;
//      return genericsSublist;
//   }
//   
//   public void showSublist() {
//      ListIterator<Integer> p;
//      int index = 0;
//      
//      System.out.println("Sublist -----------------------------");
//      System.out.println("  sum: " + sum);
//      for (p = indices.listIterator(); p.hasNext(); ) {
//         index = p.next();
//         System.out.println("  array[" + index + "] = " 
//            + originalObjects.get(index));
//      }
//      System.out.println();
//   }
//}
//
