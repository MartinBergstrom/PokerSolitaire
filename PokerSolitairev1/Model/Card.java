package Model;

import java.net.URL;

import javax.swing.ImageIcon;

import View.PokerSolitaire;

public class Card implements Comparable<Card>{
	private CardValue cV;
	private Suit suit;



	public Card(CardValue cV, Suit suit) {
		this.cV = cV;
		this.suit = suit;
	}

	public Suit getSuit(){
		return suit;
	}

	public ImageIcon toImage(){
		URL url = PokerSolitaire.class.getResource( "/"+getValue() +""+ getSuit()+".gif");
		//System.getProperty("user.dir")+ "/resources1" + "/"+getValue() +""+ getSuit()+".gif"
		return new ImageIcon(url);

	}

	public void setSuit(Suit s){
		suit = s;
	}

	public CardValue getValue(){
		return cV;
	}
	
	public int getInt(){
		return cV.getCardValue();
	}
	public void setValue(CardValue v){
		cV=v;
	}

	public String toLabel(){
		return getValue() + " of " + getSuit();
	}

	@Override
	public int compareTo(Card other) {
		return this.getInt() - other.getInt();
	}


}
