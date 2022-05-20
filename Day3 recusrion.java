//go down to find recursion also
//https://www.codingninjas.com/codestudio/problems/find-power-of-a-number_893198




//without recursion 
import java.util.*;
class Solution {
	public static long Pow(int X, int N) {
		//Write your code here
     if(X<=10 && N<=10){
		if(X==0||N==0){
			return 1;
		}
		else{
			int Y=X;
        for(int i=1;i<N;i++){
	     X=X*Y;
           }
		 return X;
	    }
	 }
		return 1;
	}
}


//With recursion


class Solution {
	public static long Pow(int X, int N) {
		if(X==0||N==0){
			return 1;
		}
		else{
			long partial=Pow(X,N-1);
		 return X*partial;
	    }
	}
}
