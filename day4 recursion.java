
//https://www.codingninjas.com/codestudio/problems/check-palindrome_4219630
//palindrome using recursion
//two pointer approach 
// we will start comparing first and last letter of the string
//it will be O(n/2) time complexity



public class Solution {
    public static void main(String []args){
        Solution ans= new Solution();
        String obj="level";
        ans.isPalindrome(obj);
    }
	public static Boolean Palindrome(int i, int j,String s) {
		if(i>=j) return true;
    if(s.charAt(i)!=s.charAt(j)) return false;
    return Palindrome(i+1,j-1,s);
	} 
	
    public static Boolean isPalindrome(String s) {
		return Palindrome(0,s.length()-1,s);

	}

}
