
https://www.codingninjas.com/codestudio/problems/factorial-of-a-number_1115779

Code: in java
import java.util.*;

class Solution {
	
	public static void main(String args[]) {
   Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		if(n>=0)
			System.out.println(recursive(n));
		else
				System.out.println("Error");
	}
	 static int recursive(int x)
		{
			if(x==1||x==0)
			return 1;
			else
				return x*recursive(x-1);
		}	
	}



