//fibonacci series

//https://www.codingninjas.com/codestudio/problems/nth-fibonacci-number_74156?source=youtube&campaign=Recursion_Fraz&utm_source=youtube&utm_medium=affiliate&utm_campaign=Recursion_Fraz&leftPanelTab=0

import java.util.*;
public class Solution {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		if(n>0)
		 System.out.println(fibo(n));
		else
		System.out.println("0");	
		
	}
	public static int fibo(int n){
		if(n==1||n==2)
			return 1;
		else
			return fibo(n-1)+fibo(n-2);
		    
	}

}
