package main;

import BoardLogic.Board;

public class Main {
    public static void main(String[] args) throws Exception {
        Board test = new Board();
//        test.setValue(69, 0 ,0 );
//        for(int x = 0; x < 9; x++){
//            test.setValue( x+1, 0, x);
//            System.out.println(test.toString());
//        }
//         v = 9;
//        for(int x = 0; x < 9; x++){
//            test.setValue( v--, x, 0);
//            System.out.println(test.toString());
//        }
        int v = 1;
        for(int x = 0; x<3;x++){
            for(int y =0; y<3; y++){
                test.setValue( v++, x, y);
                System.out.println(test);
            }
        }
        test.debugger(0,0,12);
    }
}
