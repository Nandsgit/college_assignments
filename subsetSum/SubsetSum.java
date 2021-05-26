
import java.util.ArrayList;
import cs_1c.iTunesEntry;
import cs_1c.iTunesEntryReader;

public class SubsetSum {

	static void subsetSumInt(int TARGET, ArrayList<Integer> dataset) {
		ArrayList<SublistInt> choices = new ArrayList<SublistInt>();
		int k, j, numSets, max, kBest, masterSum;
		boolean foundPerfect;

		// code supplied by student

		// Removes all of the elements from this list
		choices.clear();

		System.out.println("Target time: " + TARGET);

		SublistInt intSublist = new SublistInt(dataset);

		masterSum = 0;
		for (k = 0; k < dataset.size(); k++) {
			masterSum += dataset.get(k);
		}

		// test to remove target if it is
		// larger than the sum of all elements in the master set
		if (masterSum <= TARGET) {
			for (k = 0; k < dataset.size(); k++) {
				intSublist = intSublist.addItem(k);
			}
			intSublist.showSublist();
			return;
		}

		choices.add(intSublist);
		max = kBest = 0;
		foundPerfect = false;
		for (k = 0; k < dataset.size() && !foundPerfect; k++) {
			numSets = choices.size();
			for (j = 0; j < numSets; j++) {
				int newSum = choices.get(j).getSum() + dataset.get(k);
				if (newSum <= TARGET) {
					choices.add(choices.get(j).addItem(k));
					if (newSum > max) {
						kBest = choices.size() - 1;
						max = newSum;
					}
				}
				if (newSum == TARGET) {
					foundPerfect = true;
					break;
				}
			}
		}
		choices.get(kBest).showSublist();

	}

	public static void subsetSumTunes(int target, ArrayList<iTunesEntry> dataSetTunes) {

		ArrayList<iTunesEntry> dataSet = new ArrayList<iTunesEntry>();
		ArrayList<SublistTunes> choices = new ArrayList<SublistTunes>();
		int k, j, numSets, max, kBest, masterSum, newSum;
		boolean foundPerfect;

		dataSet = dataSetTunes;

		choices.clear();
		System.out.println("Target time: " + target);

		SublistTunes sublist = new SublistTunes(dataSet);
		iTunesEntryReader tunesInput = new iTunesEntryReader("itunes_file.txt");

		masterSum = 0;
		for (k = 0; k < dataSet.size(); k++) {
			masterSum = masterSum + dataSet.get(k).getTime();
		}

		// checking to see if sum of all numbers is greater than target
		if (masterSum < target) {
			System.out.println("Sum of all digits is lower than the target \n");

		} else {
			// removing values larger than target
			if (masterSum <= target) {
				for (k = 0; k < dataSet.size(); k++) {
					sublist = sublist.addItem(k);
				}
				sublist.showSublist();
				return;
			}

			// System.out.println("showing sublist ");
			sublist.showSublist();

			choices.add(sublist);
			max = 0;
			kBest = 0;
			foundPerfect = false;
			for (k = 0; k < dataSet.size() && !foundPerfect; k++) {
				numSets = choices.size();
				// System.out.println("numSets = " + numSets);

				for (j = 0; j < numSets; j++) {
					// System.out.println("J= " + j);
					// System.out.println("choises get J: " + choices.get(j));
					//
					// System.out.println("choises get k: " + dataSet.get(k));
					//

					newSum = choices.get(j).getSum() + dataSet.get(k).getTime();
					if (newSum <= target) {
						choices.add(choices.get(j).addItem(k));
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
		}

	}

	// static void subsetSumTunes(int TARGET, ArrayList<iTunesEntry> dataset){
	//
	// ArrayList<SublistTunes> choices = new ArrayList<SublistTunes>();
	// int k, j, numSets, max, kBest, masterSum;
	// boolean foundPerfect;
	// choices.clear();
	// System.out.println("Target time: " + TARGET);
	//
	// // code supplied by student
	//
	//
	// iTunesEntryReader tunesInput = new iTunesEntryReader("itunes_file.txt");
	// //
	// if (tunesInput.readError()) {
	// System.out.println("couldn't open " + tunesInput.getFileName()
	// + "for input.");
	// return;
	// }
	//
	//// startTime = System.nanoTime();
	//
	// int arraySize = tunesInput.getNumTunes();
	// for (k = 0; k < arraySize; k++)
	// dataset.add(tunesInput.getTune(k));
	//
	// choices.clear();
	// System.out.println("Target time: " + TARGET);
	//
	// SublistTunes sublist = new SublistTunes(dataset);
	//
	// masterSum = 0;
	// for (k = 0; k < dataset.size(); k++) {
	// masterSum += dataset.get(k).getTime();
	// }
	//
	// // test to quickly dispose of the case in which the target is
	// // larger than the sum of all elements in the master set
	// if (masterSum <= TARGET) {
	// for (k = 0; k < dataset.size(); k++) {
	// sublist = sublist.addItem(k);
	// }
	// sublist.showSublist();
	//
	//
	// return;
	// }
	//
	// choices.add(sublist);
	// max = kBest = 0;
	// foundPerfect = false;
	// for (k = 0; k < dataset.size() && !foundPerfect; k++) {
	// numSets = choices.size();
	// for (j = 0; j < numSets; j++) {
	// int newSum = choices.get(j).getSum() + dataset.get(k).getTime();
	// if (newSum <= TARGET) {
	// choices.add(choices.get(j).addItem(k));
	// if (newSum > max) {
	// kBest = choices.size() - 1;
	// max = newSum;
	// }
	// }
	// if (newSum == TARGET) {
	// foundPerfect = true;
	// break;
	// }
	// }
	// }
	//
	//
	// choices.get(kBest).showSublist();
	// }

	// public static void subsetSumTunes(int target) {
	//
	// ArrayList<iTunesEntry> dataSet = new ArrayList<iTunesEntry>();
	// ArrayList<Sublist> choices = new ArrayList<Sublist>();
	// int k, j, numSets, max, kBest, arraySize, masterSum, newSum;
	// boolean foundPerfect;
	//
	// NumberFormat tidy = NumberFormat.getInstance(Locale.US);
	// tidy.setMaximumFractionDigits(4);
	// long startTime, stopTime;
	//
	// iTunesEntryReader tunesInput = new iTunesEntryReader("itunes_file.txt");
	//
	// if (tunesInput.readError()) {
	// System.out.println("couldn't open " + tunesInput.getFileName()
	// + "for input.");
	// return;
	// }
	//
	// startTime = System.nanoTime();
	//
	// arraySize = tunesInput.getNumTunes();
	// for (k = 0; k < arraySize; k++)
	// dataSet.add(tunesInput.getTune(k));
	//
	// choices.clear();
	// System.out.println("Target time: " + target);
	//
	// Sublist sublist = new Sublist(dataSet);
	//
	// masterSum = 0;
	// for (k = 0; k < dataSet.size(); k++) {
	// masterSum += dataSet.get(k).getTime();
	// }
	//
	// // test to quickly dispose of the case in which the target is
	// // larger than the sum of all elements in the master set
	// if (masterSum <= target) {
	// for (k = 0; k < dataSet.size(); k++) {
	// sublist = sublist.addItem(k);
	// }
	// sublist.showSublist();
	//
	// stopTime = System.nanoTime();
	// System.out.println("Algorithm Elapsed Time: "
	// + tidy.format( (stopTime - startTime) / 1e9) + " seconds.\n");
	//
	// return;
	// }
	//
	// choices.add(sublist);
	// max = kBest = 0;
	// foundPerfect = false;
	// for (k = 0; k < dataSet.size() && !foundPerfect; k++) {
	// numSets = choices.size();
	// for (j = 0; j < numSets; j++) {
	// newSum = choices.get(j).getSum() + dataSet.get(k).getTime();
	// if (newSum <= target) {
	// choices.add(choices.get(j).addItem(k));
	// if (newSum > max) {
	// kBest = choices.size() - 1;
	// max = newSum;
	// }
	// }
	// if (newSum == target) {
	// foundPerfect = true;
	// break;
	// }
	// }
	// }
	//
	// choices.get(kBest).showSublist();
	//
	// stopTime = System.nanoTime();
	// System.out.println("Algorithm Elapsed Time: "
	// + tidy.format( (stopTime - startTime) / 1e9) + " seconds.\n");
	// }
	//
	// }
	//
	// class Sublist implements Cloneable {
	// private int sum = 0;
	// private ArrayList<iTunesEntry> originalObjects;
	// private ArrayList<Integer> indices;
	//
	// public Sublist(ArrayList<iTunesEntry> orig) {
	// sum = 0;
	// originalObjects = orig;
	// indices = new ArrayList<Integer>();
	// }
	//
	// int getSum() { return sum; }
	//
	// public Object clone() throws CloneNotSupportedException {
	// Sublist newObject = (Sublist)super.clone();
	// newObject.indices = (ArrayList<Integer>)indices.clone();
	//
	// return newObject;
	// }
	//
	// public Sublist addItem( int itemIndexTobeAdded ) {
	// if (itemIndexTobeAdded < 0
	// || itemIndexTobeAdded >= originalObjects.size()) {
	// return null;
	// }
	//
	// Sublist newSublist;
	//
	// try {
	// newSublist = (Sublist)clone();
	// } catch(CloneNotSupportedException e) {
	// return null;
	// }
	//
	// newSublist.indices.add(itemIndexTobeAdded);
	// newSublist.sum = sum + originalObjects.get(itemIndexTobeAdded).getTime();
	// return newSublist;
	// }
	//
	// public void showSublist() {
	// ListIterator<Integer> p;
	// int index = 0;
	//
	// System.out.println("Sublist -----------------------------");
	// System.out.println(" sum: " + sum);
	// for (p = indices.listIterator(); p.hasNext(); ) {
	// index = p.next();
	// System.out.println(" array[" + index + "] = "
	// + originalObjects.get(index));
	// }
	// System.out.println();
	// }
	//

	// Subset sum for itunes is in SublistTunes
	// subset sum for part c is in SublistGenerics
}
