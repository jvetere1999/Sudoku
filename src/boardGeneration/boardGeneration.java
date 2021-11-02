package boardGeneration;

import java.util.ArrayList;
import java.util.Collections;

public class boardGeneration {
    private int[] grid;

    public int[] generateBoard(){

        ArrayList<Integer> arr = new ArrayList<Integer>(9);
        grid = new int[81];

        for(int i = 1; i <=9; i++){
            arr.add(i);
        }

        for(int i = 0; i<81; i++){
            if(i%9==0) Collections.shuffle(arr);

            int perBox = ((i / 3) % 3) * 9 + ((i % 27) / 9) * 3 + (i / 27) * 27 + (i % 3);

            grid[perBox] = arr.get(i % 9);
        }

        boolean[] sorted = new boolean[81];

        for(int i = 0; i < 9; i++){

            boolean backtrack = false;

            for(int a = 0; a < 2; a++){

                boolean[] registered = new boolean[10];

                int rowOrigin = i * 9;
                int colOrigin = i;

                ROW_COL: for(int j = 0; j < 9; j++){

                    int step = (a % 2 == 0? rowOrigin + j: colOrigin + j * 9);
                    int num = grid[step];

                    if(!registered[num])
                        registered[num] = true;
                    else{
                        for(int y = j; y >= 0; y--){

                            int scan = (a % 2 == 0 ? i * 9 + y: i + 9 * y);

                            if(grid[scan] == num){

                                for(int z = (a % 2 == 0 ? (i % 3 + 1) *3: 0); z < 9; z++){

                                    if(a % 2 == 1 && z % 3 <= i % 3)
                                        continue;

                                    int boxOrigin = ((scan % 9) / 3) * 3 + (scan / 27) * 27;
                                    int boxStep = boxOrigin + (z / 3) * 9 + (z % 3);
                                    int boxNum = grid[boxStep];
                                    if((!sorted[scan] && !sorted[boxStep] && !registered[boxNum]) || (sorted[scan] && !registered[boxNum] && (a % 2 == 0 ? boxStep % 9 == scan % 9: boxStep / 9 == scan / 9 ))){
                                        grid[scan] = boxNum;
                                        grid[boxStep] = num;
                                        registered[boxNum] = true;
                                        continue ROW_COL;
                                    }
                                    else if( z == 0){
                                        int searchingNo = num;

                                        boolean[]
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
