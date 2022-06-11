/*The problem states that we need to make exactly k subsets from the given array whose sum is same. So the reqSum of each subset is sumOfAllElements / k.

2. Now, we can solve this question using two ways. Either we can give the chance to each element whether to be included in bucket 1,2,3... k. 
In this way, we can have a solution whose time complexity will be O(k^N) which is very bad. Hence we think of further optimising our solution.

3. The second thought process can be- instead of asking each element whether they want to be filled in bucket number 1,2,3...till k we can fill them bucket wise.
This is to say, we will first fill bucket 1, then we will move to bucket 2 and so on. Once our bucketCount == k +1 , 
it means we can make distribute the given array in k subsets, we will return true.

4. Another base condition will be, if bucketSum == reqSum, we will increment bucketCount by 1 and ask recursion to find remaining buckets whose sum is equal to reqSum
but i should start from 0 and bucketSum should also start from 0. However, if bucketSum > reqSum, we don't need to move further, we can simply return false.

5. We also need a vector to keep track of all the elements we have picked for one particular bucket. We can call it by alreadypicked.

6. Now we just need to check whether one particular element is picked for one bucket or not. If yes, we try to find thr answer for i + 1 index

7.  If not we have two choices.  We will first pick the element by incrementing our sum and try to find the answer of i + 1 elements.

8. Else we will backtrack, decrement the sum and don't pick the i-th element at all and try to find for i+1 elements

9. At the end, we need to return OR of pick || don'tPick.

10. This code, however needs to be further optimised before getting submitted by using the memorization technique of DP.

Time Complexity: O(2^N*K) { This is because we are filling all the buckets one by one and everytime one bucket is filled we start again from 0th index}

Space Complexity: O(K*N) { We will keep on exploring all the possibilities until k buckets are not filled completely)*/




//own try with help of youtube video
import java.util.*;

public class Solution {
    
    public static boolean help(int i, int bucketNum,int bucketSum,
                               int[] nums,int reqSum,int K,ArrayList<Integer> alreadyPicked){
       if(bucketNum==K+1) return true;
       if(bucketSum== reqSum){
            help(0,bucketNum+1,0,nums,reqSum,K,alreadyPicked);
       }
        if(i>nums.length) return false;
        if(bucketSum>reqSum) return false;
       if(alreadyPicked.contains(nums[i]))
        {
            return help(i+1,bucketNum,bucketSum,nums,reqSum,K,alreadyPicked);
        }
       else{
           //pick
           alreadyPicked.add(nums[i]);
           bucketSum+=nums[i];
           boolean op1= help(i+1,bucketNum,bucketSum,nums,reqSum,K,alreadyPicked);
           //ignore
           alreadyPicked.remove(alreadyPicked.size());
           bucketSum-=nums[i];
           boolean op2= help(i+1,bucketNum,bucketSum,nums,reqSum,K,alreadyPicked);
           return op1 | op2;
       }
       // return false;
    }
	public static boolean canPartitionKSubsets(int[] nums, int n, int K) {
		// Write your code here.
          List numbers = Arrays.asList(nums);
        int size=numbers.size();
        int sum =0;
        for(int j=0;j<size;j++){
            sum+=nums[j];
        }
        int reqSum=sum/K;
        if(sum%K !=0) return false;
        ArrayList<Integer> alreadyPicked= new ArrayList<Integer>();
        boolean result= help(0,1,0,nums,reqSum,K,alreadyPicked);
        return result;
	}
}



///success answwer
public class Solution {

    private static boolean canPartitionKSubsetsHelper(int[] nums, int K, boolean[] vis, int targetSubsetSum,
            int curSubsetSum, int checkIdx) {

        if (K == 0) {
            return true;
        }

        if (curSubsetSum == targetSubsetSum) {
            return canPartitionKSubsetsHelper(nums, K - 1, vis, targetSubsetSum, 0, 0);
        }

        for (int i = checkIdx; i < nums.length; i++) {
            if (vis[i] == false && curSubsetSum + nums[i] <= targetSubsetSum) {
                vis[i] = true;
                if (canPartitionKSubsetsHelper(nums, K, vis, targetSubsetSum, curSubsetSum + nums[i], i + 1)) {
                    return true;
                }

                vis[i] = false;
            }

        }

        return false;
    }

    public static boolean canPartitionKSubsets(int[] nums, int n, int K) {
        int sum = 0;
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }

        if (sum % K != 0 || maxNum > sum / K) {
            return false;
        }

        boolean[] vis = new boolean[n];
        return canPartitionKSubsetsHelper(nums, K, vis, sum / K, 0, 0);
    }

}
