package View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Model.Card;
import Model.Deck;
import Model.Lock;

public class MainDeckLabel extends JLabel implements MouseListener, KeyListener, Observer{
	private Deck deck;
	private boolean locked;


	public MainDeckLabel(String txt, Deck deck){
		super(txt);
		this.deck = deck;
		addMouseListener(this);
		addKeyListener(this);
		URL url = Deck.class.getResource( "/STARTCARD.gif");
		this.setIcon(new ImageIcon(url));
		locked = false;
	}

	//Observa DeckStack, om tryck så update
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(!locked){
			requestFocus();
			try{
				Card card = deck.getCard();
				deck.setCurrentCard(card);
				this.setText(card.toLabel());
				this.setIcon(card.toImage());
				locked = true;
			}catch(Exception e){
				System.out.println("Slut på kortleken");
			}	
		}

	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(!locked){
			if(arg0.getKeyCode()==KeyEvent.VK_SPACE){
				try{
					Card card = deck.getCard();
					deck.setCurrentCard(card);
					this.setText(card.toLabel());
					this.setIcon(card.toImage());
					//locked = true;
				}catch(Exception e){
					System.out.println("Slut på kortleken");
				}	
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {


	}

	@Override
	public void update(Observable arg0, Object arg1) {
		locked = false;

	}



}
