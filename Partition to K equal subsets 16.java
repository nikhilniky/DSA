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
