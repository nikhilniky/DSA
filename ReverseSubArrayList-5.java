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
import java.util.*;

public class Solution 
{
	public void reverse(int l , int r,ArrayList<Integer> array)
	{
		if(l>=r) {
			return ;
		}
		Collections.swap(array,l,r);
		reverse(l+1,r-1,array);
	}
    public static void reverseArray(ArrayList<Integer> arr, int m)
    {
        // Write your code here.
		Solution rev = new Solution(); 
		rev.reverse(m+1,arr.size()-1,arr);
	 
    }

}
