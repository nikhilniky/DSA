/*
Summary:
1. In this question, we have to find the maximum length of the string which we can find using all the strings present in arr vector. We are not bothered about the string we form but only about the maximum length. The only criteria is that the string formed shouldn't have repeating characters. 
2. To know the string doesn't have repeating characters, we need to use a selected vector which will tell us whether one character has been previously selected or not. 
3. If a character is previously selected, we will simply ignore that string. Also if a string itself has repeating characters we can't include it inside our final answer string. 
4. To check if the string has repeating characters or if the string has some characters from previously used strings, we need to use a bool compare() function which returns true if the string has unique characters and no overlapping characters with any other taken string. Else returns false 
5. The base case is very simple-
if( i >= arr.size() )
We have traversed through the entire vector of strings so we should return the length of the valid string collected so far 
6. Else we will first check whether we could include currString= arr[i] into our final answer or not using compare() function
7. If currString is not valid, we simply move i to the next index
8. Else we pick currString so we need to mark all the characters of currString as present inside selected vector, increment len by currString.size() and call for i+1
9. And now if we don't currString, we backtrack and unmark all it's characters, decrement len by currString.size() and check for i+1
10. Lastly we return the max of pick and don't pick. 

Time Complexity: O(k * 2^N) [If k is the average length of string present in vector arr and for every string we are either picking it or not picking it that's why,  I think, Time Complexity is O(k* 2^N)
Space Complexity: O(N) [ As we are traversing through the entire arr vector so height of the tree is O(N). Also we will not count the spaces of selected vectors because they are always of 26 size so we don't need to consider their sizes as they are independent of N]

*/

// Approach 1 --
import java.util.HashSet;
public class Solution {
    private static int dfs(String[] strings, String currString, int position) {
        HashSet<Character> st = new HashSet<>();
        for (int i = 0; i < currString.length(); i++) {
            char ch = currString.charAt(i);
            st.add(ch);
        }

        if (st.size() != currString.length()) {
            return 0;
        }

        int res = currString.length();

        for (int currPos = position; currPos < strings.length; currPos++) {
            String str = strings[currPos];
            res = Math.max(res, dfs(strings, str + currString, currPos + 1));
        }

        return res;
    }

    public static int stringConcatenation(String[] arr) {
        String str = "";
        return dfs(arr, str, 0);
    }

}

// // Approach 2 --
import java.util.ArrayList;
public class Solution {

	private static int countSetBits(int bitSet) {
		int count = 0;

		while (bitSet > 0) {
			count += bitSet & 1;
			bitSet >>= 1;
		}

		return count;
	}

	public static int stringConcatenation(String[] arr) {
		ArrayList<Integer> bitArr = new ArrayList<>();
		bitArr.add(0);
		int res = 0;

		for (int i = 0; i < arr.length; i++) {
			String str = arr[i];

			int bitSet = 0;

			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				bitSet |= (1 << (ch - 'a'));
			}

			int n = countSetBits(bitSet);
			if (n < str.length()) {
				continue;
			}

			for (int j = 0; j < bitArr.size(); j++) {
				int currBitSet = bitArr.get(j);
				if ((currBitSet & bitSet) > 0) {
					continue;
				}

				bitArr.add(currBitSet | bitSet);
				res = Math.max(res, countSetBits(currBitSet) + n);
			}
		}

		return res;
	}
}
