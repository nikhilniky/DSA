//https://www.codingninjas.com/codestudio/problems/reverse-the-array_1262298

//Without recusrion own method


import java.util.ArrayList;
import java.util.*;

public class Solution 
{
    public static void reverseArray(ArrayList<Integer> arr, int m)
    {
	    int n=arr.size();
		List<Integer> narr=arr.subList(m+1,n);
		 Collections.reverse(narr);
    }
}


//Recursion 
