public class DogTrack {
	private int fidoPos;
	private int spotPos;
	private int roverPos;
	private int trackSize;

	/**
	 * contructs a Dog Track object with track size
	 * 
	 * @param intTrackSize is used to create the track
	 */
	public DogTrack(int intTrackSize) {
		trackSize = intTrackSize;
	}

	/**
	 * Method to play the games with the private methods
	 */
	public void playGame() {
		initGame();
		while (!isOver()) {
			showTrack();
			moveDogs();
		}
		showTrack();
		showWinners();
	}

	/**
	 * Returns a random value between 1-5 using Math.random
	 * 
	 * @return returns a random value between 1-5 using Math.random
	 */
	private int spin() {
		return (int) Math.floor(Math.random() * 5) + 1;
	}

	/**
	 * changes the positions for all of the dogs using the spin and move methods
	 */
	private void moveDogs() {
		fidoPos = move(fidoPos, spin());
		spotPos = move(spotPos, spin());
		roverPos = move(roverPos, spin());
	}

	/**
	 * returns boolean based on whether or not any of the dogs have finished the
	 * race
	 * 
	 * @return returns boolean based on whether or not any of the dogs have finished
	 *         the race
	 */
	private boolean isOver() {
		// if position of fido or position of spot or position of rover is equal to the
		// final tile of the track, then the game is over. Otherwise it is not over.
		if (fidoPos == trackSize - 1 || spotPos == trackSize - 1 || roverPos == trackSize - 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Prints out the locations of all of the dogs
	 */
	private void showTrack() {
		// runs a for loop for the size of the track
		for (int i = 0; i < trackSize; i++) {
			// if the iteration of the for loop is equal to the position of fido, then print
			// an F, otherwise print an o.
			if (i == fidoPos) {
				System.out.print("F");
			} else {
				System.out.print("o");
			}
		}
		// prints new line
		System.out.print("\n");
		// runs a for loop for the size of the track
		for (int i = 0; i < trackSize; i++) {
			// if the iteration of the for loop is equal to the position of spot, then print
			// an S, otherwise print an o.
			if (i == spotPos) {
				System.out.print("S");
			} else {
				System.out.print("o");
			}
		}
		// prints new line
		System.out.print("\n");
		// runs a for loop for the size of the track
		for (int i = 0; i < trackSize; i++) {
			// if the iteration of the for loop is equal to the position of Rover, then
			// print an R, otherwise print an o.
			if (i == roverPos) {
				System.out.print("R");
			} else {
				System.out.print("o");
			}
		}
		// prints new line
		System.out.print("\n");
		// runs a for loop for the size of the track
		for (int i = 0; i < trackSize; i++) {
			// prints a dash
			System.out.print("-");
		}
		// prints new line
		System.out.print("\n");
	}

	/**
	 * Checks to see which dog has reached the end of the track and prints which
	 * dogs won
	 */
	private void showWinners() {
		// if fido is at the end of the track, it prints that fido won
		if (fidoPos == trackSize - 1) {
			System.out.println("Fido Wins!");
		}
		// if spot is at the end of the track, it prints that spot won
		if (spotPos == trackSize - 1) {
			System.out.println("Spot Wins!");
		}
		// if rover is at the end of the track, it prints that rover won
		if (roverPos == trackSize - 1) {
			System.out.println("Rover Wins!");
		}
	}

	/**
	 * Moves dog based on the dog, and a number that it moved
	 * 
	 * @param dogPos takes the position of a dog and adds to it to create a new
	 *               position
	 * @param spin   takes a integer, usually from the spin method for the amount
	 *               that the dog will move
	 * @return returns an integer for the new dogPosition
	 */
	private int move(int dogPos, int spin) {
		// if the dog's new position is equal to a third of the track or is equal to two
		// thirds of the track the code inside runs otherwise the spin value is added to
		// the dog position
		if (dogPos + spin == trackSize / 3 || dogPos + spin == (2 * trackSize) / 3) {
			// if the dogs position is 0 then it the dog does not move otherwise it goes
			// back one space
			if (dogPos == 0) {

			} else {
				dogPos = dogPos - 1;
			}
		} else {
			dogPos = dogPos + spin;
		}
		// if the dog position every goes beyond the track then it sets it to the end of
		// the track
		if (dogPos > trackSize - 1) {
			dogPos = trackSize - 1;
		}
		// returns the new position for the dog
		return dogPos;
	}

	/**
	 * initializes game with 0 for the value of all of the dog positions
	 */
	private void initGame() {
		fidoPos = 0;
		spotPos = 0;
		roverPos = 0;
	}
}
