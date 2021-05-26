import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import cs_1c.iTunesEntry;
import cs_1c.iTunesEntryReader;

/*
 * Nand Kishore Khuswaha
 * Assignment 1
 * Java 1C
 */
public class Foothill {
   public static void main(String[] args) throws Exception {
	   //Part A
	   
	   //test 1
	   		int target = 72;
	      ArrayList<Integer> dataSet = new ArrayList<Integer>();

	      dataSet.add(2); dataSet.add(12); dataSet.add(22);
	      dataSet.add(5); dataSet.add(15); dataSet.add(25);
	      dataSet.add(9); dataSet.add(19); dataSet.add(29);
	      
	      SubsetSum.subsetSumInt(target,dataSet); 
	      //test 2
	      target = 8;
	      SubsetSum.subsetSumInt(target,dataSet); 
	      //test 3
	      target = 90;
	      SubsetSum.subsetSumInt(target,dataSet); 
	      //test 4
	      target= 600;
	      SubsetSum.subsetSumInt(target,dataSet);
	      

	      
	      
	      int arraySize, k; 
	      int targetTunes = 3600;
	      ArrayList<iTunesEntry> dataSetTunes = new ArrayList<iTunesEntry>();
	      
	      // for formatting and timing
	      NumberFormat tidy = NumberFormat.getInstance(Locale.US);
	      tidy.setMaximumFractionDigits(4);
	      long startTime, stopTime; 
	      
	      // read the iTunes Data - you may need to modify with full filepath
	      iTunesEntryReader tunesInput = new iTunesEntryReader("itunes_file.txt");

	      // test the success of the read:
	      if (tunesInput.readError())
	      {
	         System.out.println("couldn't open " + tunesInput.getFileName()
	            + " for input.");
	         return;
	      }


	      // load the dataSet ArrayList with the iTunes:
	      arraySize = tunesInput.getNumTunes();
	      for (k = 0; k < arraySize; k++)
	         dataSetTunes.add(tunesInput.getTune(k));
	    
	      startTime = System.nanoTime();
	      SubsetSum.subsetSumTunes(targetTunes, dataSetTunes);
	      
	      stopTime = System.nanoTime();
          System.out.println("Algorithm Elapsed Time: "
             + tidy.format( (stopTime - startTime) / 1e9) + " seconds.\n");
          
      }
      
            
//      //Part B
//      System.out.println("**************************PART B****************************");
//      int[] testTargetsTunes = {3600, 2547, 1000, 1900, 0, 60000};
//      SublistTunes subTunes= new SublistTunes();
//      
//      for (int k = 0; k < testTargets.length; k++) {
//    	  subTunes.subsetSumTunes(testTargetsTunes[k]);
//      }
//      
//      //Part C
//      
//      System.out.println("*****************Test for part C********************");
//      
//      int[] intTestTargets = {72, 8 ,0, 90, 600};
//      int[] iTunesTestTargets = {3600, 2547, 1000, 1900, 0, 60000};
//      SublistGenerics subGenerics = new SublistGenerics();
//      
//      for (int k = 0; k < intTestTargets.length; k++) {
//    	  subGenerics.testIntGenericizing(intTestTargets[k]);
//      }
//      for (int k = 0; k < iTunesTestTargets.length; k++) {
//    	  subGenerics.testITunesGenericizing(iTunesTestTargets[k]);   
//      }    
//   } 
}
/* Paste of the run below:
**************************PART A****************************
Target time: 72
Sublist -----------------------------
  sum: 72
  array[0] = 2
  array[2] = 22
  array[3] = 5
  array[4] = 15
  array[6] = 9
  array[7] = 19

Target time: 8
Sublist -----------------------------
  sum: 7
  array[0] = 2
  array[3] = 5

Target time: 0
Sublist -----------------------------
  sum: 0

Target time: 90
Sublist -----------------------------
  sum: 90
  array[0] = 2
  array[1] = 12
  array[2] = 22
  array[3] = 5
  array[4] = 15
  array[5] = 25
  array[6] = 9

Target time: 600
Sublist -----------------------------
  sum: 138
  array[0] = 2
  array[1] = 12
  array[2] = 22
  array[3] = 5
  array[4] = 15
  array[5] = 25
  array[6] = 9
  array[7] = 19
  array[8] = 29

**************************PART B****************************
Target time: 3600
Sublist -----------------------------
  sum: 3600
  array[0] = Carrie Underwood | Cowboy Casanova |  3:56
  array[1] = Carrie Underwood | Quitter |  3:40
  array[2] = Rihanna | Russian Roulette |  3:48
  array[4] = Foo Fighters | Monkey Wrench |  3:50
  array[5] = Eric Clapton | Pretending |  4:43
  array[6] = Eric Clapton | Bad Love |  5:08
  array[7] = Howlin' Wolf | Everybody's In The Mood |  2:58
  array[8] = Howlin' Wolf | Well That's All Right |  2:55
  array[9] = Reverend Gary Davis | Samson and Delilah |  3:36
  array[11] = Roy Buchanan | Hot Cha |  3:28
  array[12] = Roy Buchanan | Green Onions |  7:23
  array[13] = Janiva Magness | I'm Just a Prisoner |  3:50
  array[14] = Janiva Magness | You Were Never Mine |  4:36
  array[15] = John Lee Hooker | Hobo Blues |  3:07
  array[16] = John Lee Hooker | I Can't Quit You Baby |  3:02

Algorithm Elapsed Time: 0.0422 seconds.

Target time: 2547
Sublist -----------------------------
  sum: 2547
  array[0] = Carrie Underwood | Cowboy Casanova |  3:56
  array[1] = Carrie Underwood | Quitter |  3:40
  array[2] = Rihanna | Russian Roulette |  3:48
  array[4] = Foo Fighters | Monkey Wrench |  3:50
  array[5] = Eric Clapton | Pretending |  4:43
  array[6] = Eric Clapton | Bad Love |  5:08
  array[8] = Howlin' Wolf | Well That's All Right |  2:55
  array[9] = Reverend Gary Davis | Samson and Delilah |  3:36
  array[11] = Roy Buchanan | Hot Cha |  3:28
  array[12] = Roy Buchanan | Green Onions |  7:23

Algorithm Elapsed Time: 0.0025 seconds.

Target time: 1000
Sublist -----------------------------
  sum: 1000
  array[3] = Foo Fighters | All My Life |  4:23
  array[5] = Eric Clapton | Pretending |  4:43
  array[7] = Howlin' Wolf | Everybody's In The Mood |  2:58
  array[14] = Janiva Magness | You Were Never Mine |  4:36

Algorithm Elapsed Time: 0.0005 seconds.

Target time: 1900
Sublist -----------------------------
  sum: 1900
  array[2] = Rihanna | Russian Roulette |  3:48
  array[3] = Foo Fighters | All My Life |  4:23
  array[4] = Foo Fighters | Monkey Wrench |  3:50
  array[5] = Eric Clapton | Pretending |  4:43
  array[6] = Eric Clapton | Bad Love |  5:08
  array[7] = Howlin' Wolf | Everybody's In The Mood |  2:58
  array[9] = Reverend Gary Davis | Samson and Delilah |  3:36
  array[10] = Reverend Gary Davis | Twelve Sticks |  3:14

Algorithm Elapsed Time: 0.0009 seconds.

Target time: 0
Sublist -----------------------------
  sum: 0

Algorithm Elapsed Time: 0.0001 seconds.

*****************Test for part C********************
Target time: 72
Sublist -----------------------------
  sum: 72
  array[0] = 2
  array[2] = 22
  array[3] = 5
  array[4] = 15
  array[6] = 9
  array[7] = 19

Algorithm Elapsed Time: 0.0011 seconds.

Target time: 8
Sublist -----------------------------
  sum: 7
  array[0] = 2
  array[3] = 5

Algorithm Elapsed Time: 0.0002 seconds.

Target time: 0
Sublist -----------------------------
  sum: 0

Algorithm Elapsed Time: 0.0001 seconds.

Target time: 90
Sublist -----------------------------
  sum: 90
  array[0] = 2
  array[1] = 12
  array[2] = 22
  array[3] = 5
  array[4] = 15
  array[5] = 25
  array[6] = 9

Algorithm Elapsed Time: 0.0005 seconds.

Target time: 600
Sublist -----------------------------
  sum: 138
  array[0] = 2
  array[1] = 12
  array[2] = 22
  array[3] = 5
  array[4] = 15
  array[5] = 25
  array[6] = 9
  array[7] = 19
  array[8] = 29

Algorithm Elapsed Time: 0.0003 seconds.

Target time: 3600
Sublist -----------------------------
  sum: 3600
  array[0] = Carrie Underwood | Cowboy Casanova |  3:56
  array[1] = Carrie Underwood | Quitter |  3:40
  array[2] = Rihanna | Russian Roulette |  3:48
  array[4] = Foo Fighters | Monkey Wrench |  3:50
  array[5] = Eric Clapton | Pretending |  4:43
  array[6] = Eric Clapton | Bad Love |  5:08
  array[7] = Howlin' Wolf | Everybody's In The Mood |  2:58
  array[8] = Howlin' Wolf | Well That's All Right |  2:55
  array[9] = Reverend Gary Davis | Samson and Delilah |  3:36
  array[11] = Roy Buchanan | Hot Cha |  3:28
  array[12] = Roy Buchanan | Green Onions |  7:23
  array[13] = Janiva Magness | I'm Just a Prisoner |  3:50
  array[14] = Janiva Magness | You Were Never Mine |  4:36
  array[15] = John Lee Hooker | Hobo Blues |  3:07
  array[16] = John Lee Hooker | I Can't Quit You Baby |  3:02

Algorithm Elapsed Time: 0.0445 seconds.

Target time: 2547
Sublist -----------------------------
  sum: 2547
  array[0] = Carrie Underwood | Cowboy Casanova |  3:56
  array[1] = Carrie Underwood | Quitter |  3:40
  array[2] = Rihanna | Russian Roulette |  3:48
  array[4] = Foo Fighters | Monkey Wrench |  3:50
  array[5] = Eric Clapton | Pretending |  4:43
  array[6] = Eric Clapton | Bad Love |  5:08
  array[8] = Howlin' Wolf | Well That's All Right |  2:55
  array[9] = Reverend Gary Davis | Samson and Delilah |  3:36
  array[11] = Roy Buchanan | Hot Cha |  3:28
  array[12] = Roy Buchanan | Green Onions |  7:23

Algorithm Elapsed Time: 0.0026 seconds.

Target time: 1000
Sublist -----------------------------
  sum: 1000
  array[3] = Foo Fighters | All My Life |  4:23
  array[5] = Eric Clapton | Pretending |  4:43
  array[7] = Howlin' Wolf | Everybody's In The Mood |  2:58
  array[14] = Janiva Magness | You Were Never Mine |  4:36

Algorithm Elapsed Time: 0.0005 seconds.

Target time: 1900
Sublist -----------------------------
  sum: 1900
  array[2] = Rihanna | Russian Roulette |  3:48
  array[3] = Foo Fighters | All My Life |  4:23
  array[4] = Foo Fighters | Monkey Wrench |  3:50
  array[5] = Eric Clapton | Pretending |  4:43
  array[6] = Eric Clapton | Bad Love |  5:08
  array[7] = Howlin' Wolf | Everybody's In The Mood |  2:58
  array[9] = Reverend Gary Davis | Samson and Delilah |  3:36
  array[10] = Reverend Gary Davis | Twelve Sticks |  3:14

Algorithm Elapsed Time: 0.0007 seconds.

Target time: 0
Sublist -----------------------------
  sum: 0

Algorithm Elapsed Time: 0.0001 seconds.

Target time: 60000
Sublist -----------------------------
  sum: 22110
  array[0] = Carrie Underwood | Cowboy Casanova |  3:56
  array[1] = Carrie Underwood | Quitter |  3:40
  array[2] = Rihanna | Russian Roulette |  3:48
  array[3] = Foo Fighters | All My Life |  4:23
  array[4] = Foo Fighters | Monkey Wrench |  3:50
  array[5] = Eric Clapton | Pretending |  4:43
  array[6] = Eric Clapton | Bad Love |  5:08
  array[7] = Howlin' Wolf | Everybody's In The Mood |  2:58
  array[8] = Howlin' Wolf | Well That's All Right |  2:55
  array[9] = Reverend Gary Davis | Samson and Delilah |  3:36
  array[10] = Reverend Gary Davis | Twelve Sticks |  3:14
  array[11] = Roy Buchanan | Hot Cha |  3:28
  array[12] = Roy Buchanan | Green Onions |  7:23
  array[13] = Janiva Magness | I'm Just a Prisoner |  3:50
  array[14] = Janiva Magness | You Were Never Mine |  4:36
  array[15] = John Lee Hooker | Hobo Blues |  3:07
  array[16] = John Lee Hooker | I Can't Quit You Baby |  3:02
  array[17] = Snoop Dogg | That's The Homie |  5:43
  array[18] = Snoop Dogg | Gangsta Luv |  4:17
  array[19] = The Rubyz | Ladies and Gentleman |  3:21
  array[20] = The Rubyz | Watch the Girl |  3:12
  array[21] = Veggie Tales | Donuts for Benny |  3:04
  array[22] = Veggie Tales | Our Big Break |  1:09
  array[23] = Berliner Philharmoniker | Brahms: Symphony No. 1 in C Minor Op. 68 |  13:59
  array[24] = Berliner Philharmoniker | Brahms: Symphony No. 4 in E Minor Op. 98 |  13:20
  array[25] = Yo-yo Ma | Bach: Suite for Cello No. 1 in G Major Prelude |  2:21
  array[26] = Yo-yo Ma | Simple Gifts |  2:34
  array[27] = Ry Cooter | Alimony |  2:55
  array[28] = Ry Cooter | France Chance |  2:48
  array[29] = Aaron Watson | The Road |  3:24
  array[30] = Terra Incognita | Clone |  4:58
  array[31] = Terra Incogni | Lizard Skin |  4:30
  array[32] = Blue Record | Bullhead's Psalm |  1:19
  array[33] = Blue Record | Ogeechee Hymnal |  2:35
  array[34] = Mastadon | Oblivion |  5:48
  array[35] = Mastadon | The Bit |  4:55
  array[36] = Sean Kingston | Fire Burning |  3:59
  array[37] = Sean Kingston | My Girlfriend |  3:24
  array[38] = T-Pain | Take Your Shirt Off |  3:48
  array[39] = Lil Jon | Give It All U Got |  3:38
  array[40] = Jay-Z | What We Talkin' About |  4:03
  array[41] = Jay-Z | Empire State of Mind |  4:36
  array[42] = Snoop Dog | Think About It |  3:37
  array[43] = Snoop Dog | Lil' Crips |  3:15
  array[44] = Jeff Golub | Shuffleboard |  3:30
  array[45] = Jeff Golub | Goin' On |  5:56
  array[46] = Jeff Golub | Fish Fare |  4:59
  array[47] = Caraivana | Noites Cariocas |  4:12
  array[48] = Caraivana | Tico-Tico No Fuba |  2:27
  array[49] = John Patitucci | Monk/Trane |  7:14
  array[50] = John Patitucci | Sonny Side |  7:25
  array[51] = Nina Simone | Pirate Jenny |  6:42
  array[52] = Nina Simone | The Other Woman |  3:06
  array[53] = Nina Simone | Feeling Good |  2:57
  array[54] = John Coltrane | A Love Supreme Part 1 |  7:42
  array[55] = John Coltrane | In a Sentimental Mood |  4:16
  array[56] = AOL Dejando Huellas | Dime Si te Vas Con El |  3:24
  array[57] = AOL Dejando Huella | Te Amo Tanto |  3:12
  array[58] = McCoy Tyner | Blues On the Corner |  6:07
  array[59] = McCoy Tyner | Afro Blue |  12:22
  array[60] = Kanye West | Stronger |  5:11
  array[61] = Kanye West | Good Life |  3:27
  array[62] = Steely Dan | Black Cow |  5:10
  array[63] = Steely Dan | Kid Charlemagne |  4:38
  array[64] = Steely Dan | Haitian Divorce |  5:51
  array[65] = Herbie Hancock | Nefertiti |  7:31
  array[66] = Herbie Hancock | Rockit |  5:25
  array[67] = Herbie Hancock | Chameleon |  15:41
  array[68] = Return to Forever | Medieval Overture |  5:13
  array[69] = Suzanne Vega | Luka |  3:51
  array[70] = Suzanne Vega | Small Blue Thing |  3:55
  array[71] = Bonnie Raitt | Something to Talk About |  3:47
  array[72] = Bonnie Raitt | I Can't Make You Love Me |  5:31
  array[73] = Natalie Cole | This Will Be |  2:51
  array[74] = Natalie Cole | Unforgettable |  3:31
  array[75] = Jet | Timothy |  4:20
  array[76] = Jet | Rip It Up |  3:20
  array[77] = Was (Not Was) | Where Did Your Heart Go? |  5:47
  array[78] = Was (Not Was) | I Blew Up The United States |  3:50

Algorithm Elapsed Time: 0.0015 seconds.

 */
