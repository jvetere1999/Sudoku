package BoardLogic;

public class Space {
    private int row;
    private int col;

    private int value;

    private int ninth;

    public Space(int row,  int col, int value){

        if( row < 3 && col < 3) ninth = 1;
        else if( row < 3 && col < 6) ninth = 2;
        else if( row < 3 && col < 9) ninth = 3;
        else if( row < 6 && col < 3) ninth = 4;
        else if( row < 9 && col < 3) ninth = 5;
        else if( row < 6 && col < 6) ninth = 6;
        else if( row < 6 && col < 9) ninth = 7;
        else if( row < 9 && col < 6) ninth = 8;
        else if( row < 9 && col < 9) ninth = 9;

        this.row = row;
        this.col = col;

        this.value = value;
    }
    public Space(int row,  int col){

        if( row < 3 && col < 3) ninth = 1;
        else if( row < 3 && col < 6) ninth = 2;
        else if( row < 3 && col < 9) ninth = 3;
        else if( row < 6 && col < 3) ninth = 4;
        else if( row < 6 && col < 6) ninth = 5;
        else if( row < 6 && col < 9) ninth = 6;
        else if( row < 9 && col < 3) ninth = 7;
        else if( row < 9 && col < 6) ninth = 8;
        else if( row < 9 && col < 9) ninth = 9;

        this.row = this.row;
        this.col = this.col;

        this.value = ninth;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getNinth() {
        return ninth;
    }
}
