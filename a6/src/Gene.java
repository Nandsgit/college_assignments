//import cs_1c.EBookEntry;
public class Gene {

     private String name;
     private int startingBasePair;

//     public static final int MIN_STRING = 1;
//     public static final int MAX_STRING = 300;
//     public static final int MAX_ENTRY_LENGTH = 10000;
//     public static final int MAX_ID = 100000;

     // comparable tools
     public static final int SORT_BY_NAME = 0;
     public static final int SORT_BY_BASEPAIR = 1;

     private static int sortKey = SORT_BY_NAME; 

     // default constructor
     Gene()
     {
        name = "";
        startingBasePair = 0;
     }
     Gene(String name, int bp) {
         this.name = name; 
         this.startingBasePair = bp; 
     }

     // accessors
     public String getName()  { return name; }
     public int getStartingBasePair()  { return startingBasePair; }   

//     // mutators
//     public boolean setTitle(String strArg)
//     {
//        if ( !validString(strArg) )
//           return false;
//        title = strArg;
//        return true;
//     }
//     public boolean setCreator(String strArg)
//     {
//        if ( !validString(strArg) )
//           return false;
//        creator = strArg;
//        return true;
//     }
//     public boolean setSubject(String strArg)
//     {
//        if ( !validString(strArg) )
//           return false;
//        subject = strArg;
//        return true;
//     }
//     public boolean setEtextNum(int intArg)
//     {
//        if (intArg < 1 || intArg > MAX_ID)
//           return false;
//        eTextNum = intArg;
//        return true;
//     }

     public static boolean setSortType( int whichType )
     {
        switch (whichType)
        {
        case SORT_BY_NAME:
        case SORT_BY_BASEPAIR:
           sortKey = whichType;
           return true;
        default:
           return false;
        }
     }

     public int compareTo(Gene other)
     {
        switch (sortKey)
        {
        case SORT_BY_NAME:
           return (name.compareToIgnoreCase(other.name));
        case SORT_BY_BASEPAIR:
           return (startingBasePair - other.startingBasePair);
        default:
           return 0;
        }
     }

     public String toString()
     {
         return name + " starting at base pair " + startingBasePair;
     }
     
//     // utility for testing all String mutator  args
//     private static boolean validString(String strArg)
//     {
//        if (strArg == null)
//           return false;
//        if (strArg.length() < MIN_STRING || strArg.length() > MAX_STRING)
//           return false;
//        return true;
//     }
}
