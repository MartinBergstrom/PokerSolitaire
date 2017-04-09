package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.Card;
import Model.Deck;
import Model.DeckStack;
import Model.Lock;



public class DeckStackPanel extends JPanel implements MouseListener {
	private DeckStack deckS;
	private Card currentcard;
	private int current; 
	private ArrayList<JLabel> labels;
	private JLayeredPane layeredPane;
	private Point origin; 
	private int offset;


	public DeckStackPanel(DeckStack d){
		super();
		this.deckS = d;
		addMouseListener(this);
		setLayout(new GridLayout(0,1));
		labels = new ArrayList<JLabel>();

		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(140, 180));
		layeredPane.setBorder(BorderFactory.createTitledBorder(
				"CardStack"));

		origin = new Point(0,15); 
		offset = 15;
		
		URL url = PokerSolitaire.class.getResource( "/STARTCARD.gif");
		//System.getProperty("user.dir")+ "/resources1"+ "/STARTCARD.gif"

		JLabel label = createCardLabel(new ImageIcon(url),origin);
		layeredPane.add(label, new Integer(0));
		labels.add(label);
		origin.x += offset;
		origin.y += offset;
	
		//current = 0;
		add(layeredPane);
	}

	public void addLabel(ImageIcon img, int index){
		JLabel label = createCardLabel(img,origin);
		layeredPane.add(label, new Integer(index));
		labels.add(label);
		origin.x += offset;
		origin.y += offset;
	}

	private JLabel createCardLabel(ImageIcon image, Point origin){
		JLabel label = new JLabel(image);
		label.setVerticalAlignment(JLabel.TOP);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setOpaque(true);
		label.setBounds(origin.x, origin.y, 71, 96);
		return label;
	}

	@Override//Man kan komma åt alla korten i deckstack, get() //borde flytta till model
	public void mouseClicked(MouseEvent e) { 
		deckS.whenPressed(currentcard, labels, this);
	}




	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	
	
}
