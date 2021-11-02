package BoardLogic;


import ServerSide.SudokuGridGenerator;

import static ServerSide.SudokuGridGenerator.isPerfect;

public class Board {
    private Space[][] board = new Space[9][9];
    private boolean valid = true;

    public Board() {
       this.fillGrid();

    }

    public void setValue(int value, int row, int col){
        System.out.println(value);
        board[row] [col].setValue(value);
    }

    public int getValue(int row, int col){
        return board[row] [col].getValue();
    }

    private boolean checkIfValid(int row, int col) throws Exception {

        Space toCheck = board[row] [col];

        return checkRow(toCheck) && checkCol(toCheck) && checkNinth(toCheck);
    }

    private boolean checkNinth( Space toCheck) throws Exception {
        return switch (toCheck.getNinth()) {
            case 1 -> ninthHelper(toCheck, 0, 0, 3, 3);
            case 2 -> ninthHelper(toCheck, 3, 0, 6, 3);
            case 3 -> ninthHelper(toCheck, 6, 0, 9, 3);
            case 4 -> ninthHelper(toCheck, 0, 3, 3, 6);
            case 5 -> ninthHelper(toCheck, 0, 6, 3, 9);
            case 6 -> ninthHelper(toCheck, 3, 3, 6, 6);
            case 7 -> ninthHelper(toCheck, 6, 3, 9, 6);
            case 8 -> ninthHelper(toCheck, 3, 6, 6, 9);
            case 9 -> ninthHelper(toCheck, 6, 6, 9, 9);
            default -> throw new Exception("" +
                    "____________________________" +
                    "|Deadman error in algorithm|" +
                    "|__________________________|");
        };
    }
    private boolean ninthHelper(Space toCheck, int row, int col, int limX, int limY){

        for ( int trow = row; trow < limX; trow++){

            for( int tcol = col; tcol < limY; tcol++){

                System.out.println(board[trow] [tcol].getValue()+"\t|\t"+toCheck.getValue() );

                if (toCheck.getRow() != trow && toCheck.getCol() != tcol)
                    if( toCheck.getValue() == board[trow] [tcol].getValue())
                        return false;
            }
        }

        return true;
    }
    private boolean checkRow(Space toCheck){

        final int row = toCheck.getRow();

        for ( int col = 0; col < 9; col++){

            System.out.println(board[row] [col].getValue()+"\t|\t"+toCheck.getValue() );

            if(board[row] [col].getValue() == toCheck.getValue() && toCheck.getCol() != col)
                return false;

        }

        return true;
    }

    private boolean checkCol(Space toCheck){
        final int col = toCheck.getCol();

        for ( int row = 0; row < 9; row++){
            System.out.println(board[row] [col].getValue()+"\t|\t"+toCheck.getValue() );
            if(board[row] [col].getValue() == toCheck.getValue() && toCheck.getCol() != row)
                return false;

        }

        return true;
    }

    private void fillGrid(){
        SudokuGridGenerator sudoku = new SudokuGridGenerator();
        int[] grid = sudoku.generateGrid();
        if(isPerfect(grid)){
            System.out.println("PERFECT GRID");
            int gridIndex = 0;
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 9; y++) {
                    board[x][y].setValue(grid[gridIndex]);
                    gridIndex++;
                }
            }
        }
        System.out.println(this);
    }
    public void removeSpaces(char d){


    }

    @Override
    public String toString(){

        String rtr = " _____________________________________\n";
        for( int row = 0; row < 9; row++ ){
            for( int col = 0; col < 9; col++ ){
                if ( board[row][col].getValue() == 0 )
                    rtr = rtr + " | -";

                else
                    rtr = rtr + (" | " + board[row][col].getValue());
            }

            rtr = rtr + " |\n |___________________________________|\n";

        }

        return rtr;
    }
    public void debugger(int row, int col, int value) throws Exception {
    }

}
