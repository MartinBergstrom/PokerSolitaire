package View;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import Model.DeckStack;

public class ScoreLabel extends JLabel implements Observer {
	private DeckStack deckS;

	public ScoreLabel(String txt, DeckStack deckS) {
		super(txt);
		this.deckS = deckS;

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.setText(Integer.toString(deckS.calculateScore()));
	
		
	}
	

	
	

}
