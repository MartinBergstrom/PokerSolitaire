package Model;

public class Lock {
	private boolean[] stacks;
	private boolean allLocked;
	private int current;


	public Lock() {
		stacks = new boolean[4];
		allLocked = true;
		stacks[0] = false;
		stacks[1] = false;
		stacks[2] = false;
		stacks[3] = false;
		current = 5;
	}

	public boolean getIndex(int index){
		return stacks[index-1];
	}

	public void lock(int index){
		stacks[index-1] = true;
		if(stacks[0]==true && stacks[1]==true && stacks[2]==true &&stacks[3]==true){
			allLocked = true;
		}else{
			allLocked = false;
		}

	}

	public void lockAll(){
		for(int i = 0; i<4; i++){
			stacks[i] = true;
		}
		allLocked = true;
	}
	public void setCurrent(int index){
		current = index;
	}

	public int current(){
		return current;
	}
	public void unlockAll(){
		for(int i = 0; i<4; i++){
			stacks[i]= false;
		}
		allLocked = false;
	}

	public void unlockAll(int index){
		switch(index -1){
		case 0: 
			//System.out.println("index == 0");
			stacks[1] = false;
			stacks[2] = false;
			stacks[3] = false; 
			break;
		case 1:
			//System.out.println("index == 1");
			stacks[0] = false;
			stacks[2] = false;
			stacks[3] = false; 
			break;
		case 2:
		//	System.out.println("index == 2");
			stacks[1] = false;
			stacks[0] = false;
			stacks[3] = false; 
			break;
		case 3:
		//	System.out.println("index == 3");
			stacks[1] = false;
			stacks[2] = false;
			stacks[0] = false; 
			break;
		}
		allLocked = false;
	}

	public void unLock(int index){
		if(allLocked){
			allLocked = false;
		}
		stacks[index-1] = false;
	}

	public boolean getAllLocked(){
		return allLocked;
	}

	public boolean getLock(int index){
		return stacks[index-1];
	}



}
