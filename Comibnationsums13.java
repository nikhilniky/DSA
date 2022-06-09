///https://www.codingninjas.com/codestudio/problems/combination-sum-iii_5038357
import java.util.ArrayList;

public class Solution {
 
 void help(int i,int k , int n , ArrayList <Integer> subSet,
                  ArrayList <ArrayList<Integer>> ans ,int sum ){
     
     if(sum>n){
         return ;
     }
     if(k==0){
         if(sum==n){
             ans.add(subSet);
         }
     //    else{
             return;
      //   }
     }
//      if(k<0){return ;}
//      if(sum==n)
//      {
//          if(k==0){
//              ans.add(subSet);
//          }
//          return;
//      }
     if(i==10){
         return;
     }
     ////count++;
     //conisder ith elemt
     sum+=i;
     subSet.add(i);
     help(i+1,k-1,n,subSet,ans,sum);
     sum-=i;
     subSet.remove(subSet.size() - 1);
     //count--; 
     //ignore ith elememnt
     help(i+1,k,n,subSet,ans,sum);
     
 }
          
    static ArrayList<ArrayList<Integer>> combinationSum3(int k, int n) {
        ArrayList<Integer> subSet= new ArrayList<>();
   ArrayList<ArrayList<Integer>>  ans= new ArrayList<ArrayList<Integer>> ();
       // int i=1;
        Solution call = new Solution();
        call.help(1,k,n,subSet,ans,0);
        return ans;
    }
}
