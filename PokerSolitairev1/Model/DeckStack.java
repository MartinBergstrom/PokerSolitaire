package Model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import View.DeckStackPanel;
import View.ScoreLabel;

//Klass för att spara korten man lägger ut i en hög, räkna ihop poängen
public class DeckStack extends Observable{
	private ArrayList<Card> theCards;
	private Lock lock;
	private CurrentCard cc;
	private Counter counter;
	private int index;
	private ScoreCalculator sC;
	private int nbrcards;
	private int current;


	public DeckStack(Lock lock, CurrentCard cc, Counter count, int index ) {
		this.lock = lock;
		this.cc=cc;
		this.counter = count;
		this.index = index;
		theCards = new ArrayList<Card>();
		sC = new ScoreCalculator();
		nbrcards = 5;
		current = 0;
	
	
	}
	
	public void whenPressed(Card currentcard, ArrayList<JLabel> labels, DeckStackPanel panel){
		if(current < 5){
			try{
				currentcard = addCard();	
			}catch(Exception e1){
				System.err.println(e1.getMessage());
				JOptionPane.showMessageDialog(null, "Ogiltigt drag");
				return;
			}
			if(current >= 1){
				Card previousCard = get(current-1);
				panel.addLabel(previousCard.toImage(),current);
			}
			current++;
	
			labels.get(labels.size()-1).setIcon(currentcard.toImage()); //första labeln
		}else{
			JOptionPane.showMessageDialog(null, "Spelet är slut, alla högar är fyllda");
		}
	}
	
	public Card addCard(){ //returnerar current
		if(!lock.getLock(index)){//Om denna högen ej är låst, lägg till
			if(nbrcards != 0){ 
				Card c = cc.getCurrent();
				lock.lockAll(); //lås alla korten
				lock.setCurrent(index);
				theCards.add(c);
				counter.countDown();
				nbrcards--;
				setChanged();
				notifyObservers();
				return c;
			
			}
			System.out.println("Högen är full");
			return null;
		} 
		else{
			throw new NullPointerException();
		}
		
	
	}
	
	public Card getCurrentCard(){
		return cc.getCurrent();
	}
	
	public Card get(int i){
		return theCards.get(i);
	}
	public int calculateScore(){
		return sC.calculate(theCards);
		
	}

}
