package ICPC;

import java.io.*;
import java.util.*;
public class FlipFive {
    public static int[] memo = new int[600];
        public static void main(String[] args) throws IOException{
                BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
                int numTests = Integer.parseInt(f.readLine());
                for(int i=0;i<numTests;i++){
                        int[] board = new int[9];
                        memo = new int[600];
                        int[] vals = {1,2,4,8,16,32,64,128,256};
                        for(int row = 0; row < 3; row++){
                                String line = f.readLine();
                                for(int col = 0; col < 3; col ++){
                                        if(line.charAt(col)=='*'){
                                                board[3*row+col]=1;
                                        }
                                        else{
                                                board[3*row+col]=0;
                                        }
                                }
                        }
                        int state = arrayToState(board);
                        //System.out.println(state);
                        int[][] inverts = new int[9][9];
                        for(int x=0;x<3;x++){
                                for(int y=0;y<3;y++){
                                        if(x-1>=0){
                                                inverts[3*x+y][3*(x-1)+y]=1;
                                        }
                                        if(x+1<3){
                                                inverts[3*x+y][3*(x+1)+y]=1;
                                        }
                                        if(y-1>=0){
                                                inverts[3*x+y][3*x+(y-1)]=1;
                                        }
                                        if(y+1<3){
                                                inverts[3*x+y][3*x+(y+1)]=1;
                                        }
                                        inverts[3*x+y][3*x+y]=1;
                                }
                        }
                        /*for(int x=0;x<9;x++){
                                for(int y=0;y<9;y++){
                                        System.out.print(inverts[x][y]);
                                        
                                }
                                System.out.println();
                        }*/
                        int min = Integer.MAX_VALUE;
                        for(int moveSet=0;moveSet<512;moveSet++){
                                int[] individualMoves = stateToArray(moveSet);
                                /*for(int d:individualMoves){
                                        System.out.print(d+" ");
                                }
                                System.out.println();*/
                                boolean works=true;
                                for(int position=0;position<9;position++){
                                        int current = board[position];
                                        
                                        for(int move=0;move<9;move++){
                                                if(individualMoves[move]==1){
                                                        current+=inverts[move][position];
                                                        current%=2;
                                                }
                                        }
                                        if(current!=0){
                                                works=false;
                                        }
                                }
                                if(works){
                                        //System.out.println(moveSet);
                                        min = Math.min(min,sum(individualMoves));
                                }
                                
                        }
                        System.out.println(min);
                        
                        
                        
                }
        }
        public static int sum(int[] array){
                int sum = 0;
                for(int j:array){
                        sum += j;
                }
                return sum;
        }
        public static int arrayToState(int[] array){
                int result = 0;
                for(int i=0;i<9;i++){
                        if(array[i]==1){
                                result += (int)(Math.pow(2,i));
                        }
                }
                return result;
        }
        public static int[] stateToArray(int state){
                int[] result = new int[9];
                int stateCopy = state;
                for(int i=8;i>=0;i--){
                        int power = (int)(Math.pow(2,i));
                        if(power<=stateCopy){
                                result[i]=1;
                                stateCopy-=power;
                        }
                        else{
                                result[i]=0;
                        }
                }
                return result;
        }
}
 