
import java.io.*;
import java.util.*;
class FederalFavorites {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int num = Integer.parseInt(f.readLine());
			if(num==-1){
				break;
			}
			ArrayList<Integer> div = new ArrayList<Integer>();
			int sum = 1;
			int sr = (int)Math.sqrt(num);
			div.add(1);
			for(int i=2;i<Math.sqrt(num);i++){
				if(num%i==0){
					div.add(i);
					div.add(num/i);
					sum+=num/i+i;
				}
			}
			if(sr*sr==num){
				div.add(sr);
				sum+=sr;
			}
			if(sum==num){
				Collections.sort(div);
				System.out.print(num+" = ");
				for(int i=0;i<div.size()-1;i++){
					System.out.print(div.get(i)+" + ");
				}
				System.out.println(div.get(div.size()-1));
			}
			else{
				System.out.println(num+" is NOT perfect.");
			}
		}
	}
}
 