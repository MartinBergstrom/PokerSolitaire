package Model;

public class CurrentCard {
	private Card card;

	public CurrentCard(Card card) {
		super();
		this.card = card;
	}
	
	public void setCurrentCard(Card card){
		this.card = card;
	}
	
	public Card getCurrent(){
		return card;
	}
	
	

}
