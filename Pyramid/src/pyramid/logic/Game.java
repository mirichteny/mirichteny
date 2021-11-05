package pyramid.logic;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


/**************
 * 
 * @author Mirich Teny
 *	Coding pyramid through java
 *
 */

public class Game {

		private String gameType;
		private int[] possibleNumbers = {0,1};
		private char difficulty;
		private int playerPoints;
		private int stageLevel;
		private int cardNumber;
		private ArrayList<ArrayList<Integer>> deck = new ArrayList<>(); 
		private ArrayList<ArrayList<String>> fakeDeck;
		/*******
		 * Game default constructor. Responsible for setting all necessary values to 0.
		 */
		
		public Game() {
			
			this.setPlayerPoints(0);
			this.setStageLevel(0);	
			this.createDeck(7);
			fakeDeck = new ArrayList<ArrayList<String>>();
			createDeck(7, String.class);
		}
		/*******
		 * Copy constructor
		 * @param g
		 */
		public Game(Game g) {
			
		}
		
		public ArrayList<ArrayList<Integer>> getDeck(){
			return this.deck;
		}

		public ArrayList<ArrayList<String>> getFakeDeck(){
			return this.fakeDeck; //to Copy to prevent privacy leaks
		}
		
		public void setPlayerPoints(int anAmount) {		
			this.playerPoints = anAmount;
		}
		
		public void increasePlayerPoints(int anAmount) {
			this.playerPoints += anAmount;
		}
		
		public int getPlayerPoints() {
			return this.playerPoints;
		}
		
		public void setStageLevel(int aLevel) {
			this.stageLevel = aLevel;
		}
		
		/*******
		 * random : returns an integer between min and max (inclusive)
		 * @param min : minimum value
 		 * @param max : maximum value
		 * @return random integer value
		 */
		
		public int random(int min, int max) {	
			
			Random rand = new Random();
			int result = rand.nextInt((max - min) + 1) + min;
					
			return result;
		}
		
		/*******
		 * createDeck() : This method takes the private empty deck and fills it 
		 * in a pyramid-like arrangement of cards. The size of the pyramid is dependent on numStages
		 * @param numStages : 
		 */
		
		public void createDeck(int numStages) {
			
			//Adding stages to the pyramid.
			for(int row = 0; row < numStages; row++) {	
				
				getDeck().add(new ArrayList<Integer>());
				
			}
			
			int howManyCardsInLevel = 1;
			
			//Filling each stage with cards
			for(int level = 0; level < numStages; level++) {
				
				ArrayList<Integer> stageLevel = deck.get(level);
												
				for(int k = 0; k < howManyCardsInLevel; k++) {
					stageLevel.add(random(0,1));
				}
				
				if(howManyCardsInLevel > 2) {
					howManyCardsInLevel = howManyCardsInLevel + 2;
				}
				else {
					howManyCardsInLevel++;
				}
				
			}
		}
		
		public void createDeck(int numStages , Object type) {
			
			//Adding stages to the pyramid.
			for(int row = 0; row < numStages; row++) {	
				
				getFakeDeck().add(new ArrayList<String>());
				
			}
			
			int howManyCardsInLevel = 1;
			
			//Filling each stage with cards
			for(int level = 0; level < numStages; level++) {
				
				ArrayList<String> stageLevel = fakeDeck.get(level);
												
				for(int k = 0; k < howManyCardsInLevel; k++) {
					stageLevel.add("X");
				}
				
				if(howManyCardsInLevel > 2) {
					howManyCardsInLevel = howManyCardsInLevel + 2;
				}
				else {
					howManyCardsInLevel++;
				}
				
			}
		}
				
		/*******
		 * displayDeck() : displays deck in a neat fashion
		 * 
		 * 
		 */
		
		
		public void displayDeck() {
			String deck = "";
			
			for(int row = 0; row < getFakeDeck().size(); row++) {
				
				//System.out.println("Current row is: "+ getDeck().get(row));
				
				for(int card = row; card < getFakeDeck().size(); card++) {
					
					if (card > 1) {
						deck = deck + " " + " ";
					}
					else {
						deck = deck + " ";
					}
					
				}
				
				if(row <= 1) {
					for(int j = 0; j < getFakeDeck().get(row).size(); j++) {
						
						deck = deck + getFakeDeck().get(row).get(j) + " ";
					}
					
				}
				else {
					for(int i = 1,card = 0; i < 2*row ; i++,card++) {
						deck = deck + getFakeDeck().get(row).get(card) + " ";
						
					}
				}
				
				deck = deck + "\n";
			}
			System.out.println(deck);
		}
		
		public void displayCheatDeck() {
			String deck = "";
			
			for(int row = 0; row < getDeck().size(); row++) {
				
				//System.out.println("Current row is: "+ getDeck().get(row));
				
				for(int card = row; card < getDeck().size(); card++) {
					
					if (card > 1) {
						deck = deck + " " + " ";
					}
					else {
						deck = deck + " ";
					}
					
				}
				
				if(row <= 1) {
					for(int j = 0; j < getDeck().get(row).size(); j++) {
						
						deck = deck + getDeck().get(row).get(j) + " ";
					}
					
				}
				else {
					for(int i = 1,card = 0; i < 2*row ; i++,card++) {
						deck = deck + getDeck().get(row).get(card) + " ";
						
					}
				}
				
				deck = deck + "\n";
			}
			System.out.println(deck);
		}
		
		/*******
		 * reveals card in a specific location
		 * @param position
		 */
		public int revealCard(int position, int index) {
			
			int answer = getDeck().get(index).get(position);
			
			getFakeDeck().get(index).set(position, answer + "");
			
			return answer;
			
		}
		
		public void showTutorial() {
			String unwantedCard = "0";
			String string = "Your objective is to go through the entire pyramid deck row by row without\ngetting a "+unwantedCard;
			
			System.out.println(string);
			
		}
		
		/*******
		 * This method assumes the stages are dynamically allocated
		 * @param stageAmount
		 * @param arr
		 */
		public void addStage(int stageAmount, ArrayList<Integer> arr) {
			
		}
		
		public ArrayList<Integer> findLatestStage(ArrayList<ArrayList<Integer>> arr ) {
			ArrayList<Integer> dummyArr = new ArrayList<Integer>();
			
			return dummyArr;
		}
		
		public void play(String mode) {
			Boolean lost = false;
			Scanner scanner = new Scanner(System.in);
			
			showTutorial();
			System.out.print("Do you understand how to play? (y/n) : ");
			String understood = scanner.next();
			
			if(understood.contentEquals("y")) {
				//displayCheatDeck(); //To check if the game is actually winnable.
				for(int i = getFakeDeck().size()-1; i >= 0; i--) {
					
					displayDeck();
					System.out.print("Pick a card between " + 0 + " and " + (getDeck().get(i).size() - 1) + " : ");
					int ans = scanner.nextInt();
					
					while(ans < 0 || ans > getDeck().size()) {
						System.out.println("Invalid position entry, please enter again.");
						System.out.print("Pick a card:  ");
						ans = scanner.nextInt();
					}
					int reveal = revealCard(ans, i);
					
					displayDeck();
					if(reveal == 0) {
						lost = true;
						System.out.println("Card was a 0, you lose, game over.");
						break;
					}
					
					if(lost == false) {
						System.out.println("You win! Nice work.");
					}
					
				}
			}
			else {
				System.out.println("Oh, well restart the game and try to understand it.");
			}
			
			scanner.close();
		}
		
		
}
