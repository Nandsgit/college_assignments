
public class Automaton {

	//Public members
	// final Constant
	public final static int MAX_DISPLAY_WIDTH= 121;
	public int displayWidth;  
	public String finalGen;


	//private members
	private boolean rules[]; //to allocate the rule[8]
	private String thisGen;
	private String extremeBit; // represented as bit "*" or " "

	/*
	 * the Constructor will intialize rules and then convert it to our internal 
	 * bit values as "*" , " " . We also put a seed in form of a single 1 in the 
	 * inf. grids, stating it as first generation.
	 *  
	 */

	public Automaton(int new_rule) {
		rules= new boolean[8];

		setRule(new_rule);

		thisGen= "*";
		extremeBit= " ";

		setDisplayWidth(79);

	}

	public void resetFirstGen() {
		thisGen= "*";
	}

	//to set rules 
	public boolean setRule( int new_rule) {

		if (new_rule< 0 || new_rule>225) {		
			return false;	
		}

		for (int i = 0; i < 8; ++i) {

			int bitEvaluation = 1 << i; //to shift grids represents as bits
			int bitResult= (bitEvaluation & new_rule);

			if (bitResult != 0)
				rules[i]=true;
			else {
				rules[i]=false;	
			}

		}

		return true;

	}

	public boolean setDisplayWidth(int width) {

		//checks for faulty values and center

		if (width< 0 || width %2 != 1) {
			return false;	
		}

		if (width >  MAX_DISPLAY_WIDTH) {
			displayWidth= MAX_DISPLAY_WIDTH;

		}
		else {
			displayWidth= width;
		}

		return true;

	}

	public String toStringCurrentGen() {

		int numSpace;
		String nextString = "";

		String extremeBits = extremeBit;

		if (thisGen.length() < displayWidth) {
			numSpace = (displayWidth - thisGen.length()) / 2;
			for (int k = 0; k < numSpace - 1; ++k) {
				extremeBits += extremeBit;
			}

			nextString = extremeBits + thisGen + extremeBits;
		}

		if (thisGen.length() >= displayWidth) {
			numSpace = (thisGen.length() - displayWidth) / 2;
			int startIndex = numSpace;
			int endIndex = thisGen.length() - startIndex;
			nextString = thisGen.substring(startIndex, endIndex);

		}

		return nextString;

	} 


	public void propagteNewGeneration() {

		String tempGen ="0";
		String nextGen= "";

		//to add 2 spaces to each side of the bits

		thisGen = extremeBit + extremeBit + thisGen + extremeBit + extremeBit;
		
		//System.out.println("This gen is" + thisGen);
		
		
		// converting * and ' ' to 1 & 0

		for (int i = 0; i < thisGen.length(); ++i) {
			if (thisGen.charAt(i) == '*') {
				thisGen = thisGen.replace(thisGen.charAt(i), '1');

			}

			if (thisGen.charAt(i) == ' ') {
				thisGen = thisGen.replace(thisGen.charAt(i), '0');

			}
		}
		//selecting the rules

		for (int j = 1; j < thisGen.length() - 1; ++j) {

			for (int k = 0; k < 3; ++k) {
				tempGen += String.valueOf(thisGen.charAt(j - 1 + k)); //checking neighbour

			}

			//convert binary values to integer

			Integer ruleIndex = Integer.valueOf(tempGen, 2);
			tempGen= "0";

			//applying the rules

			if (rules[ruleIndex] == true) {
				nextGen += "*";

			} else 
				nextGen += " ";
		}
		//to update 
		thisGen= nextGen;

		//adjusting extremebit

		if (extremeBit == "*" && rules[7]) {
			extremeBit = "*";
		} else if (extremeBit == " " && rules[0]) 
			extremeBit= "*";
		else {
			extremeBit= " ";


		}
	}
} 







