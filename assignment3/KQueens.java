import java.util.Arrays;

//import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class KQueens {

    //Use these constants in your code
    final static int QUEEN = 1;
    final static int WALL = -1;
    final static int EMPTY = 0;


    /**
     * Checks if the input parameters are valid
     *
     * @param k number of queens
     * @param rows number of rows to be on a board
     * @param cols number of columns to be on a board
     * @param walls locations of walls on a board
     * @return true if all parameters are valid, false otherwise.
     */
    public static boolean isValidInput(int k, int rows, int cols, int[][] walls){
        boolean isValid = true;
        int numOfWalls =0;
		//conditions of illegal inputs
		if(rows<1|cols<1|k<1|walls==null||walls.length!=rows)
			isValid = false;
		//condition if one of the arrays is null or longer than the board
		else {
			for(int i=0;i<walls.length&isValid;i=i+1){
				if(walls[i]==null)
					isValid=false;
				else {
					for(int j=0;j<walls[i].length&isValid;j=j+1){
						if(walls[i].length>cols)
							isValid=false;
						//condition if the value in wall is negative or bigger than the boards limit
						else if(walls[i][j]<0|walls[i][j]>=cols)
								isValid=false;
						//count the number of walls
						else
							numOfWalls=numOfWalls + 1;
					}	
				}
			}
		}
			
		return (isValid&rows*cols-numOfWalls>=k);
    }

    /**
     * Creates a board of size rows x cols with walls
     *
     * @param rows number of rows in board. Assume valid value.
     * @param cols number of columns in board. Assume valid value.
     * @param walls locations of walls on board. Assume valid value.
     * @return rows x cols board with walls
     */
    public static int[][] createBoard(int rows, int cols, int[][] walls){
        int [][]board = new int [rows][cols];
		for(int i=0;i<walls.length;i=i+1){
			for(int j=0;j<walls[i].length;j=j+1){
				//insert walls location
				board[i][walls[i][j]]=WALL;
			}
		}
		return board;
    }

    /**
     * Print the representation of a board with queens and walls
     *
     * @param board to be printed. Assume valid value.
     */
    public static void printBoard(int[][] board){
    	if(board.length==0)
    		System.out.println("There is no solution");
    	else {
    		for(int i=0;i<board.length;i=i+1){
    			for(int j=0;j<board[i].length;j=j+1){
    				if(board[i][j]==WALL)
    					System.out.print('X'+" ");
    				if(board[i][j]==EMPTY)
    					System.out.print('*'+" ");
    				if(board[i][j]==QUEEN)
    					System.out.print('Q'+" ");
    			}
			System.out.println();
    		}
    	}
    }

    /**
     * Validate that the walls in board match the walls locations in walls
     *
     * @param walls locations of walls in board. Assume valid value.
     * @param board a board with walls
     * @return true if walls on boards match the walls locations, false otherwise
     */
    public static boolean validateWalls(int[][] walls, int[][] board){
        boolean validate = true;
		int numOfWalls=0;
		int numOfWallsBoard=0;
		//check if board is null
		if(board!=null) {
		//check if every wall from the wall array exist in the board
			for(int i=0;i<walls.length;i=i+1){
				for(int j=0;j<walls[i].length;j=j+1){
					//count the number of walls in the walls array
					//if one of the cells in board is null
					numOfWalls=numOfWalls+1;
					if(board[i]==null) 
						validate=false;
					else if(board[i][walls[i][j]]!=WALL)
					validate=false;
				}
			}
			//just in case that the first validation is true, continue to the next validation
			if (validate) {
				//count the number of walls in the board array
				for(int i=0;i<board.length;i=i+1){
					for(int j=0;j<board[i].length;j=j+1){
						if(board[i][j]==WALL)
							numOfWallsBoard=numOfWallsBoard+1;		
					}
				}
			}
		}
		return (validate&numOfWalls==numOfWallsBoard);
    }



    /**
     * Check if the queen located in board[row][col] is threatened by another queen on the board
     *
     * @param board a queen is located on this board
     * @param row the row in which the queen is located
     * @param col the column in which the queen is located
     * @return true if queen is threatened, false otherwise
     */
    public static boolean isQueenThreatened(int[][] board, int row, int col){
        boolean isThreatened = false;
		int index = 1;
		//check for a queen in the same row to the left
		for(int i=col-1;i>=0&!isThreatened&index!=-1;i=i-1){
			if(board[row][i]==WALL)
				index=-1;
			else {
				if(board[row][i]==QUEEN)
					isThreatened=true;
			}
		}
		index = 1;
		//check for a queen in the same row to the right
		for(int i=col+1;i<board[row].length&!isThreatened&index!=-1;i=i+1){
			if(board[row][i]==WALL)
				index = -1;
			else {
				if(board[row][i]==QUEEN)
					isThreatened=true;
			}
		}
		index = 1;
		//check for a queen in the same collum from above
		for(int i=row-1;i>=0&!isThreatened&index!=-1;i=i-1){
			if(board[i][col]==WALL)
				index = -1;
			else {
			if(board[i][col]==QUEEN)
				isThreatened=true;
			}
		}
		index =1;
		//check for a queen in the same collum from below
		for(int i=row+1;i<board.length&!isThreatened&index!=-1;i=i+1){
			if(board[i][col]==WALL)
				index =-1;
			else {
			if(board[i][col]==QUEEN)
				isThreatened=true;
			}
		}
		index =1;
		//check for a queen in the diagonals (4 directions)
		while(row+index<board.length&col+index<board[row].length&index!=-1){
			if(board[row+index][col+index]==WALL)
				index = -1;
			else {
				if(board[row+index][col+index]==QUEEN)
					isThreatened=true;
				index=index+1;
			}
		}
		index=1;
		while(row-index>=0&col-index>=0&index!=-1){
			if(board[row-index][col-index]==WALL) 
				index = -1;
			else {
				if(board[row-index][col-index]==QUEEN)
					isThreatened=true;
				index=index+1;
			}
		}
		index=1;
		while(row-index>=0&col+index<board[row].length&index!=-1){
			if(board[row-index][col+index]==WALL)
				index= -1;
			else {
				if(board[row-index][col+index]==QUEEN)
					isThreatened=true;
				index=index+1;
			}
		}
		index=1;
		while(row+index<board.length&col-index>=0&index!=-1){
			if(board[row+index][col-index]==WALL) 
				index = -1;
			else {
				if(board[row+index][col-index]==QUEEN)
					isThreatened=true;
				index=index+1;
			}
		}
		return isThreatened;
    }


    /**
     * Check if board is a legal solution for k queens
     *
     * @param board a solution for the k-queens problem. Assume board not null and not empty, and each cell not null.
     * @param k number of queens that must be on the board. Assume k>=1.
     * @param rows number of rows that must be on the board. Assume rows>=1.
     * @param cols number of columns that must be on the board. Assume cols>=1.
     * @param walls locations of walls that must be on board. Assume valid value.
     * @return true if board is a legal solution for k queens, otherwise false
     */
    public static boolean isLegalSolution(int[][] board, int k, int rows, int cols, int[][] walls){
    	//check if the input is legal and validate the walls in board
        boolean isSolution=isValidInput(k,rows,cols,walls)&&validateWalls(walls,board)&&(board.length==rows&board[0].length==cols);
        if(isSolution) {
        	for(int i=0;i<rows&isSolution;i=i+1){
        		for(int j=0;j<cols&isSolution;j=j+1){
        			//check if the board contain illegal values
        			if(board[i][j]!=QUEEN&board[i][j]!=EMPTY&board[i][j]!=WALL)
        				isSolution=false;
        			if(board[i][j]==QUEEN){
        				//check that every queen is not Threatened 
        				isSolution=!isQueenThreatened(board,i,j);
        				k=k-1;
        			}
				}
			}
		}
		return(isSolution&k==0);
    }

    /**
     * Adds queen to cell board[row][col] if the board obtained by adding the queen is legal
     *
     * @param board represents a partial solution for k'<k queens. Assume valid value.
     * @param row queen must be added to this row. Assume valid value.
     * @param col queen must be added to this column. Assume valid value.
     * @return true if queen was added, otherwise false.
     */
    public static boolean addQueen(int[][] board, int row, int col){
		boolean isPossible = false;
		//if its a free slot to place the queen
        if(board[row][col]==EMPTY&!isQueenThreatened(board,row,col)){
			board[row][col]=QUEEN;
			isPossible=true;
		}
		return isPossible;
    }

    /**
     * Solves the k queens problem.
     *
     * @param k number of queens to be located on the board
     * @param rows number of rows in the board
     * @param cols number of columns in the board
     * @param walls locations of walls on the board
     * @return board that is a legal solution, empty board if there is no solution
     */
    public static int[][] kQueens(int k, int rows, int cols, int[][] walls){
    	int [][] board=new int[0][0];
		if(isValidInput(k,rows,cols,walls)){
			board = createBoard(rows, cols, walls);
			//if the input is legal send the board to the recursive function from the beginning of the board
			kQueens(board,k,0,0,0);
		}
		return board;
	}

    /**
     * Recursive helper function for the k queens problem
     * @param board
     * @param k
     * @param row
     * @param col
     * @param numOfQueens
     * @return
     */
    private static boolean kQueens(int[][] board, int k, int row, int col, int numOfQueens){
    	boolean kQueens=false;
    	//the condition to stop the program's run 
		if(k==numOfQueens)
			kQueens=true;
		//if its still not the end of the board
    	if(!(row==board.length-1&col==board[row].length))
    	{
    		//if its the end of a row go for the beginning of the next row
    		if(col==board[row].length) {
    			col=0;
    			row=row+1;
    		}
    		//if its possible to add queen in this square,check if there is a solution starts from this square
    		if(addQueen(board,row,col)) {
    			//if not, clear the square from the queen and check for a solution starts in the next square
    			if(!kQueens(board,k-1,row,col+1,numOfQueens)) {
    				board[row][col]=EMPTY;
    				kQueens=kQueens(board,k,row,col+1,numOfQueens);
    			}
    			//if it found a solution return true
    			else
    				kQueens=true;
    		}
    		//if its not possible to add a queen check for a solution starts in the next square
    		else kQueens=kQueens(board,k,row,col+1,numOfQueens);
    	}
        return kQueens;
    }

}
















