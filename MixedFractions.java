package ICPC;

import java.util.*;
import java.io.*;
 
public class MixedFractions {
 
        public static void main(String[] args) {
                // TODO Auto-generated method stub
                
                Scanner sc = new Scanner(System.in);
                long[] data = new long[2];
                
                data[0] = sc.nextLong();
                data[1] = sc.nextLong();
                
                while (!((data[0] == 0) && (data[1] == 0)))
                {
                        long wholenum = data[0] / data[1];
                        long remainder = data[0] % data[1];
                        
                        System.out.printf("%d %d / %d\n", wholenum, remainder, data[1]);
                        
                        data[0] = sc.nextLong();
                        data[1] = sc.nextLong();
                }
        }
 
}