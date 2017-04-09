package View;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Counter;
import Model.CurrentCard;
import Model.Deck;
import Model.DeckStack;
import Model.Lock;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

public class PokerSolitaire extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PokerSolitaire(){
		super("PokerSolitaire");
		setSize(700,350);

		CurrentCard cc = new CurrentCard(null);

		Counter counter = new Counter(4);
		
		Lock lock = new Lock();
		Deck deck = new Deck(lock,cc,counter);
		deck.shuffle();
		
		DeckStack dS1 = new DeckStack(lock,cc,counter,1);
		DeckStack dS2 = new DeckStack(lock,cc,counter,2);
		DeckStack dS3 = new DeckStack(lock,cc,counter,3);
		DeckStack dS4 = new DeckStack(lock,cc,counter,4);
		
		
		DeckStackPanel dSL1 = new DeckStackPanel(dS1);
		DeckStackPanel dSL2 = new DeckStackPanel(dS2);
		DeckStackPanel dSL3 = new DeckStackPanel(dS3);
		DeckStackPanel dSL4 = new DeckStackPanel(dS4);
		TopPanel top = new TopPanel();
		top.add(dSL1);
		top.add(dSL2);
		top.add(dSL3);
		top.add(dSL4);
		
		ScorePanel sP = new ScorePanel();
		ScoreLabel s1 = new ScoreLabel("0",dS1);
		ScoreLabel s2 = new ScoreLabel("0",dS2);
		ScoreLabel s3 = new ScoreLabel("0",dS3);
		ScoreLabel s4 = new ScoreLabel("0",dS4);
		sP.add(s1);
		 sP.add(Box.createHorizontalStrut(120));
		sP.add(s2);
		 sP.add(Box.createHorizontalStrut(120));
		sP.add(s3);
		 sP.add(Box.createHorizontalStrut(120));
			sP.add(Box.createVerticalStrut(30));
		sP.add(s4);

		dS1.addObserver(s1);
		dS2.addObserver(s2);
		dS3.addObserver(s3);
		dS4.addObserver(s4);
		
		
		
		MainDeckLabel mDeck = new MainDeckLabel("Huvudkortleken",deck);
		mDeck.setFocusable(true);
		BotPanel bot = new BotPanel();
	
		dS1.addObserver(mDeck);
		dS2.addObserver(mDeck);
		dS3.addObserver(mDeck);
		dS4.addObserver(mDeck);
		
		bot.add(mDeck);
		
		add(NORTH,top);
		add(CENTER,sP);
		add(SOUTH,bot);
		
	
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
	}
	
	public static void main(String[] args){
		new PokerSolitaire();
	}
}
