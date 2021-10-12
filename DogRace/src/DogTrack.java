public class DogTrack {
		private int fidoPos;
		private int spotPos; 
		private int roverPos;
		private int trackSize;

	public DogTrack(int intTrackSize) {
		trackSize = intTrackSize;
	}
	public void playGame() {
		initGame();
		while(!isOver()) {
			showTrack();
			moveDogs();
		}
		showTrack();
		showWinners();
	}
	private int spin() {
		return (int)Math.floor(Math.random() * 5)+1;
	}
	private void moveDogs() {
		fidoPos = move(fidoPos,spin());
		spotPos = move(spotPos,spin());
		roverPos = move(roverPos,spin());
	}
	private boolean isOver() {
		if(fidoPos == trackSize-1 || spotPos == trackSize-1 || roverPos == trackSize-1) {
			return true;
		}
		else {
			return false;
		}
	}
	private void showTrack() {
		for(int i = 0; i < trackSize; i++) {
			if(i == fidoPos) {
				System.out.print("F");
			}
			else {
				System.out.print("o");
			}
		}
		System.out.print("\n");
		for(int i = 0; i < trackSize; i++) {
			if(i == spotPos) {
				System.out.print("S");
			}
			else {
				System.out.print("o");
			}
		}
		System.out.print("\n");
		for(int i = 0; i < trackSize; i++) {
			if(i == roverPos) {
				System.out.print("R");
			}
			else {
				System.out.print("o");
			}
		}
		System.out.print("\n");
		for(int i = 0; i < trackSize; i++) {
			System.out.print("-");
		}
		System.out.print("\n");
	}
	private void showWinners() {
		if(fidoPos == trackSize - 1) {
			System.out.println("Fido Wins!");
		}
		if(spotPos == trackSize - 1) {
			System.out.println("Spot Wins!");
		}
		if(roverPos == trackSize - 1) {
			System.out.println("Rover Wins!");
		}
	}
	private int move(int dogPos, int spin) {
		
		if(dogPos + spin == trackSize/3 || dogPos + spin == (2*trackSize)/3) {
			if(dogPos == 0) {
				
			}
			else {
			dogPos = dogPos - 1; 
			}
		}
		else if(dogPos < 0) {
			dogPos = 0;
		}
		else {
			dogPos = dogPos + spin;
		}
	
		if(dogPos > trackSize - 1) {
			dogPos = trackSize - 1;
		}
		return dogPos;
	}
	private void initGame() {
		fidoPos = 0;
		spotPos = 0; 
		roverPos = 0;
	}
}
