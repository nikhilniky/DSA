
//https://www.codingninjas.com/codestudio/problems/power-set_1062667
Using recursion

import java.util.*;
 
public class Solution { 
    public void helperset(ArrayList<Integer> arr,int i,ArrayList<Integer> subSet,
                                                   ArrayList<ArrayList<Integer>> ans){ 
        if(i==arr.size()){
            ans.add(subSet);
            return ;
        }
        subSet.add(arr.get(i));
        helperset(arr,i+1,new ArrayList<>(subSet),ans);
         subSet.remove(arr.get(i));
         helperset(arr,i+1,new ArrayList<>(subSet),ans);
        
    }
	public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
		// WRITE YOUR CODE HERE
         ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>> (); 
         ArrayList<Integer> subSet = new ArrayList<Integer>();
        Solution n =new Solution();
        n.helperset(arr,0,subSet,ans);
        return ans;
        
	}
}

