public class NQueens {
	public int size;
	public int[][] board;

	public NQueens(int n)
	{
		size = n;
		board = new int[size][size];
		for(int i = 0; i<size; i++){
				for(int j = 0; j<size ; j++){
					board[i][j] = 0;
				}
			}
	}

	public boolean placeNQueens() throws Exception
	{
		if(size<=0){
			throw new Exception();
		}else{
			return tryNQueens(board,0);
		}	
	}

	public boolean checkSafe(int[][] board, int row, int col){
		for(int j = 0 ; j < col ; j++){
			if(board[row][j] == 1){
				return false;
			}
		}

		int i,j;

		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
            if (board[i][j] == 1) 
                return false;

		for (i = row, j = col; j >= 0 && i < size; i++, j--) 
            if (board[i][j] == 1) 
                return false;

		return true;
	}

	public boolean tryNQueens(int[][] board, int currentCol){
		if(currentCol >= size){
			return true;
		}else{
		
			for(int i = 0; i<size ; i++){

				if(checkSafe(board,i,currentCol)){
					board[i][currentCol] = 1;
					//printToConsole();
					//System.out.println();
					if(tryNQueens(board,currentCol+1) == true ){
						return true;
					}else{
						board[i][currentCol] = 0;
					}			
				}
			}
		}
	
		return false;

	}

	public void printToConsole(){
		for(int i = 0; i<size; i++){
				for(int j = 0; j<size ; j++){
					if(board[i][j] == 1){
						System.out.print("Q ");
					}else{
						System.out.print("_ ");
					}
					
				}
				System.out.println();
			}
	}


}