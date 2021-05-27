import java.util.Scanner;

public class Foothill {
	
	public static void main(String[] args) {
		
		Automaton automata;
		int choice;
		Scanner keyboard = new Scanner(System.in);
		
		do {
			System.out.println("Enter a rule (0-255) : ");
			choice= keyboard.nextInt();
			keyboard.nextLine();
		} while ( choice < 0 || choice > 255);
		automata = new Automaton(choice);
		automata.setDisplayWidth(79);
		
		System.out.println( "rule" + choice + "\n start");
		
		for (int i = 0; i < 100; i++) {
			System.out.println(automata.toStringCurrentGen());
			automata.propagteNewGeneration();
			
		}
		
		System.out.println(" End of line");
	}

}
