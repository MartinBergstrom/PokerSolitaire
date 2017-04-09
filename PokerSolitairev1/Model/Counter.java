package Model;

public class Counter {
	private int index;

	public Counter(int index) {
		this.index = index;
	}
	
	public void countDown(){
		if(index == 0){
			System.out.println("Counter nere på 0!");
		}
		index--;
	}
	
	public int getCount(){
		return index;
	}
	
	public void setCounter(int i){
		index = i;
	}
	
	

}
