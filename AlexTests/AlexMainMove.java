import java.util.*;

public class AlexMainMove {

	public static void main(String[] args) {
		boolean endgame = false;

		Board Board = new Board(20);
      Hero Hero = new Hero(100, 10);

		char move = 'n';// creates new board
		if (move == 'n') {
			Board.populateEmptyBoard(Board);
			Board.printBoard(Board);
		}

		while (!endgame) {
			System.out.println("W - up\nS - down\nA - left\nD - Right");

			Scanner input = new Scanner(System.in);
			move = input.next().charAt(0);

			if (move == 'w') {
				if(Board.getContent(Board, Hero.getHeroYPos(), Hero.getHeroXPos() - 1) == true){
					Board.movePlayerUp(Board, Hero.getHeroYPos(), Hero.getHeroXPos());
            } else {
               System.out.println("pressed w but can't move UP");

            }
            Board.printBoard(Board);

			} else if (move == 's') {
				System.out.println("pressed s");
			} else if (move == 'a') {
				System.out.println("pressed a");
			} else if (move == 'd') {
				System.out.println("pressed d");
			}
		}
	}
}