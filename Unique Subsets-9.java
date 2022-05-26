//https://www.codingninjas.com/codestudio/problems/unique-subsets_3625236
only 1 case failed due to time limit


import java.util.*;
public class Solution {
    
        public void helperset(ArrayList<Integer> arrset,int i,ArrayList<Integer> subSet,
                                                   ArrayList<ArrayList<Integer>> ans){ 
        if(i==arrset.size()){
            if(!ans.contains(subSet))
            ans.add(subSet);
            return ;
        }
        subSet.add(arrset.get(i));
        helperset(arrset,i+1,new ArrayList<>(subSet),ans);
        subSet.remove(arrset.get(i));
         helperset(arrset,i+1,new ArrayList<>(subSet),ans);
        
    }
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        // Write your code here..
         ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>> (); 
         ArrayList<Integer> subSet = new ArrayList<Integer>();
        ArrayList<Integer> arrset = new ArrayList<Integer>();
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
           arrset.add(arr[i]);
        }
        Solution x =new Solution();
        x.helperset(arrset,0,subSet,ans);
        Collections.sort(ans, new Comparator<List<Integer>>() { 
            public int compare(List<Integer> o1, List<Integer> o2) { 
                int min = Math.min(o1.size(),o2.size());
                for(int i=0;i<min;i++)
                {
                     if(o1.get(i)!=o2.get(i))
                     {
                         return o1.get(i).compareTo(o2.get(i));
                     }
                }
                return (o1.size()<=o2.size())? -1:1;                
            }
        });
        return ans;
    }

}







//


import java.util.*;

public class Solution {
    private static ArrayList<ArrayList<Integer>> subsets;
    private static ArrayList<Integer> cur;
    private static int count;

    private static void pwr(int st, int[] arr) {
        if (count >= 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            subsets.add(temp);
            for (int i = 0; i < cur.size(); i++) {
                temp.add(cur.get(i));
            }
            subsets.set(count, temp);
            count++;
        }

        for (int i = st; i < arr.length; i++) {

            if ((i == st) || (arr[i] != arr[i - 1])) {

                cur.add(arr[i]);
                pwr(i + 1, arr);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        subsets = new ArrayList<ArrayList<Integer>>();
        cur = new ArrayList<Integer>();
        Arrays.sort(arr);
        count = 0;
        pwr(0, arr);

        return subsets;
    }
}





import java.util.*;

public class Solution {
    private static ArrayList<ArrayList<Integer>> subsets;
    private static ArrayList<Integer> cur;
    private static int count;

    private static void pwr(int st, int[] arr) {
        if (count >= 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            if(subsets.size()>0)
            if(!subsets.contains(temp)){subsets.add(temp);}
            subsets.add(temp);
            for (int i = 0; i < cur.size(); i++) {
                temp.add(cur.get(i));
            }
//             subsets.set(count, temp);
//             count++;
        }

        for (int i = st; i < arr.length; i++) {

            if ((i == st) || (arr[i] != arr[i - 1])) {

                cur.add(arr[i]);
                pwr(i + 1, arr);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        subsets = new ArrayList<ArrayList<Integer>>();
        cur = new ArrayList<Integer>();
        Arrays.sort(arr);
        count = 0;
        pwr(0, arr);

        return subsets;
    }
}
