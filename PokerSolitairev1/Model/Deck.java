package Model;


import java.util.ArrayList;

import java.util.Collections;


public class Deck {
	private ArrayList<Card> deck;
	private CurrentCard cc;
	private Lock lock;
	private Counter counter;
	private int indexofcurrent1;
	private int indexofcurrent2;



	public Deck(Lock lock, CurrentCard cc, Counter counter){
		this.cc = cc;
		this.lock = lock;
		this.counter = counter;
		deck = new ArrayList<Card>();
		for(CardValue value: CardValue.values()){
			for(Suit suit: Suit.values()){
				deck.add(new Card(value,suit));
			}			
		}
		indexofcurrent1 = 5;
		indexofcurrent2 = 5;
	}

	public Card getCard(){
		return deck.remove(0);
	}
	public void shuffle(){
		Collections.shuffle(deck);
	}
	public ArrayList<Card> getList(){
		return deck;
	}
	public void setCurrentCard(Card card){

		int current = lock.current();
//		System.out.println(counter.getCount());
//		System.out.println(indexofcurrent1 + " och " + indexofcurrent2);
		cc.setCurrentCard(card);
		int currentcount = counter.getCount();
		if(currentcount == 0){
			lock.unlockAll();
			indexofcurrent1 = 5;
			counter.setCounter(4);
		//	System.out.println("counter nere på 0 i Deck");
		}else if(currentcount == 3){
			lock.unlockAll(current);
			indexofcurrent1 = current; //spara den första
		}else if(currentcount == 2){
			lock.unlockAll(current);
			lock.lock(indexofcurrent1);
			indexofcurrent2 = current; //spara den andra
		} else if(currentcount == 1){ //counter = 1			
			lock.unlockAll(current);
			lock.lock(indexofcurrent1);
			lock.lock(indexofcurrent2);
		}
	}
	
}
