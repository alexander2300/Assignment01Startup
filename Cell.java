class Wall {

	protected boolean up, down, left, right;

	Wall()
	{
		//by default, we add the walls
		up = down = left = right = true;
	}

	public void removeWall(char c)
	{
		if(c == 'l') left = false;
		else if (c == 'r') right = false;
		else if (c == 'u') up = false;
		else if (c == 'd') down = false;
		else
			return;
	}
	public void addWall(char c)
	{
		if(c == 'l') left = true;
		else if (c == 'r') right = true;
		else if (c == 'u') up = true;
		else if (c == 'd') down = true;
		else
			return;
	}

}


public class Cell {

	protected int i;
	protected int j;
	protected boolean emptyCell; // true -> cell is empty, false -> cell is occupied
	protected char objName;
	protected Wall cWall;
	protected boolean visited;
	protected int priority;

	public Cell(int i, int j){
		this.i = i;
		this.j = j;
		this.emptyCell = true; // by default we assume that the cell is empty
		this.objName = ' '; // since the cell is empty, no one is occupying it
		cWall = new Wall();
		this.visited = false;
		this.priority = 1;
	}

	public boolean putObject(char objName)
	{
		if (objName != 'P' && objName != 'D' && objName != 'S' && objName != 'B' && objName != 'A') {
			System.out.println("You are trying to put invalid/unknown object in a cell");
			return false; //operation unsuccessful
		}
		else {
			this.objName = objName;
			this.emptyCell = false;
			return true; //operation successful
		}
	}


	public void replaceObject()
	{
		if(!isEmpty())
		{
			this.emptyCell = true;
			this.objName = ' ';
		}
	}

	public char whoIsHere() {
		return this.objName;
	}

	public boolean isEmpty()
	{
		return emptyCell;
	}


	


}
