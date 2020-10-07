import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author fahmidahamid
 *
 */


/* Some good resources
 * https://rosettacode.org/wiki/Maze_generation#Java
 * I have taken some idea for implementing the printMazeBoard(...)
 */

class MazeBoard
{
	private int d;
	private Cell[][] board;
	private Random rg;

//Creates a new MazeBoard
	public MazeBoard(int d){
		this.rg = new Random();
		this.d = d;
		board = new Cell[d][d];

		/*
		 * Initially all the cells have walls all around them
		 */
		for(int i = 0; i < d; i++)
			for(int j = 0; j < d; j++)
				board[i][j] = new Cell(i,j);
	}

	//Adds robots to the maze with random numbers of bots
	public void populate(){
		int pNum = 0;
		int cNum = 0;
		int sNum = 0;
		int dNum = 0;
		//Decides how many bots to add based on maze size
		int botNum = (int)(d*d*0.05);
		while(botNum > 0){
			if(pNum == dNum) pNum++;
			else if(pNum > cNum) cNum++;
			else if(cNum > sNum) sNum++;
			else if(sNum > dNum) dNum++;
			botNum--;
		}

		this.populate(pNum,cNum,sNum,dNum);
	}

	//Adds robots to the maze given a specified number of each type
	public void populate(int pNum, int cNum, int sNum, int dNum){
		//Add the rest of the bot types
		for(int i = 0;i<=pNum-1;i++){
			this.updateCell(rg.nextInt(d),rg.nextInt(d), new PoliceBot("p"+i));
		}

		for(int i = 0;i<=cNum-1;i++){
			this.updateCell(rg.nextInt(d),rg.nextInt(d), new ScientistBot("c"+i));
		}

		for(int i = 0;i<=sNum-1;i++){
			this.updateCell(rg.nextInt(d),rg.nextInt(d), new StudentBot("s"+i));
		}

		for(int i = 0;i<=dNum-1;i++){
			this.updateCell(rg.nextInt(d),rg.nextInt(d), new DoctorBot("d"+i));
		}

		//Alice and Bob are added last since they'll always be at the same place in a maze
		this.updateCell(0,0, new BobBot(d));
		this.updateCell(d-1,d-1, new AliceBot());
	}

	//Updates the cells with their new contents
	public boolean updateCell(int i, int j, Robot r)
	{
		if((i < this.d && i >= 0) && (j<this.d && j >= 0)) {
			board[i][j].putRobot(r);
			return true;
		}
		else
			return false;
	}

	public void printMazeBoard()
	{
		for(int i = 0; i < this.d; i++) {
				// draw the north edge
				for (int j = 0; j < this.d; j++) {
					System.out.print("+---");
				}
				System.out.println("+");
				// draw the west edge
				for (int j = 0; j < this.d; j++) {
					if(this.board[i][j].isEmpty()) {
						System.out.print("| " + board[i][j].whoIsHere() + " ");
					}
					else {
						 System.out.print("|   ");
					}
				}
				System.out.println("|");
		 }
		// draw the bottom line
		for (int j = 0; j < this.d; j++) {
			System.out.print("+---");
		}
		System.out.println("+");
	}


	public void primsAlgorithm(int rootx, int rooty)

	{
//needs the actual code here



	}

}


public class DemoMazeBoard {

	public static void main(String[] args) {
		System.out.println("Enter the preferred maze size: ");
		Scanner scr = new Scanner(System.in);
		int d = scr.nextInt();
		if(d >= 4 && d <= 10)
		{

		 MazeBoard mzb = new MazeBoard(d);
		 mzb.populate();

		 mzb.printMazeBoard();
		 mzb.primsAlgorithm(0, 0);
		}


	}
}
