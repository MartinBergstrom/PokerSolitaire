package Model;

import java.util.ArrayList;
import java.util.Arrays;

//class to calucate the score of a pile of cards
public class ScoreCalculator {
	private Card[] cards;
	private int size;
	private final int PAIR = 1;
	private final int TWOPAIR = 3;
	private final int FLUSH = 5;
	private final int THREEOAK = 6;
	private final int FULLHOUSE = 10;
	private final int STRAIGHT = 12;
	private final int FOUROAK = 16;
	private final int STRAIGHTFLUSH = 30; 
	private final int ROYALFLUSH = 50; //gl hf

	private int rankOfFoundInThreeOAK;

	public ScoreCalculator() {	
		this.cards = new Card[5];
		size = 0;

	}

	/**
	 * Calculates the score of the current cards and returns the value
	 * @return
	 */
	public int calculate(ArrayList<Card> cardList){
		for(int i= 0; i<cardList.size(); i++){
			cards[i] = cardList.get(i);
		}
		size = cardList.size();
		int result = 0;
		if(isRoyal())                //Ugliest code evvah?
			result = ROYALFLUSH;
		else if(isStraightFlush())
			result = STRAIGHTFLUSH;
		else if(isFourOfAKind())
			result = FOUROAK;
		else if(isStraight())
			result = STRAIGHT;
		else if(isFullHouse())
			result = FULLHOUSE;
		else if(isThreeOfAKind())
			result = THREEOAK;
		else if(isFlush())
			result = FLUSH;
		else if(isTwoPair())
			result = TWOPAIR;
		else if(isPair())
			result = PAIR;

		return result;
	}


	/**
	 * Checks if there exists pair in the card deck
	 * @return
	 */
	private boolean isPair(){ 
		boolean found = false;

		for(int i = 0; i< size; i++){
			Card temp = cards[i]; 
			for(int j = size-1; j>i; j--){
				if(temp.getInt() == cards[j].getInt()){
					found = true;
				}
			}
		}
		return found;
	}


	private boolean isTwoPair() { 
		boolean found = false;
		int count = 0;
		int rankOfFound = 0;

		for(int i = 0; i< size; i++){
			Card temp = cards[i]; 
			for(int j = size-1; j>i; j--){
				if(temp.getInt() == cards[j].getInt()){
					if(count == 1 && rankOfFound != temp.getInt())
						count = 2;
					else
						count = 1;
					rankOfFound = temp.getInt();
					break;
				}
			}
		}

		found = count == 2? true: false;
		return found;
	}


	private boolean isFlush() {
		boolean found = false;

		if(size == 5){
			found = true;
			Suit currentSuit = null;
			Card temp = cards[0];
			currentSuit = temp.getSuit();
			for(int i = 1; i< size; i++){
				if(cards[i].getSuit() != currentSuit) {
					found = false;
					break;
				}
			}
		}

		return found;
	}

	private boolean isThreeOfAKind() { 
		boolean found = false;
		rankOfFoundInThreeOAK = 0;

		for(int i = 0; i< size; i++){
			Card temp = cards[i]; 
			for(int j = size-1; j>i; j--){
				if(temp.getInt() == cards[j].getInt()){
					if(rankOfFoundInThreeOAK == temp.getInt()){
						found = true;
					}
					rankOfFoundInThreeOAK = temp.getInt();
				}
			}
		}
		if(!found)
			rankOfFoundInThreeOAK = 0;
		return found;
	}

	private boolean isFullHouse() {
		boolean found = false;
		if(size == 5 && rankOfFoundInThreeOAK != 0){
			for(int i = 0; i< size; i++){
				Card temp = cards[i]; 
				for(int j = size-1; j>i; j--){
					if(temp.getInt() == cards[j].getInt() && temp.getInt() != rankOfFoundInThreeOAK ){
						found = true;
					}
				}
			}
		}	
		return found;	
	}

	private boolean isStraight() {
		boolean found = false;
		if(size == 5){
			Arrays.sort(cards);
			int prevNbr = cards[0].getInt();
			for(int i = 1; i< 5; i++){
				if(cards[i].getInt() == (prevNbr + 1)){
					found = true;
					prevNbr++;
				}else{
					found = false;
					break;
				}
			}

		}
		return found;
	}

	private boolean isFourOfAKind() {
		boolean found = false;
		if(!(size == 0)){
			Card[] tempArray = new Card[size];
			for(int i = 0; i< size; i++){
				tempArray[i] = cards[i];
			}
			Arrays.sort(tempArray);


		}
	

		return found;
	}

	private boolean isStraightFlush() {
		boolean found = false;

		return found;
	}

	private boolean isRoyal() {
		boolean found = false;

		return found;
	}





}
