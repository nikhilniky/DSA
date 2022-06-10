//https://www.codingninjas.com/codestudio/problems/letter-combinations-of-a-phone-number_983623

import java.util.ArrayList;

public class Solution 
{
    public static void combinationsHelper(String digits, String[] digToStr, int i, String temp, ArrayList<String> ans)
    {
        if(i == digits.length()){ //checks first time i=0, digits means given string,
            ans.add(temp);
            return;
        }
        
        int val = digits.charAt(i) - '0'; // first time it will take s=23 so 2
        
        for(int j = 0 ; j < digToStr[val].length() ; j++)
        { // //digtostr[2].length =3 if use directly 3 casues issue where 7 and 9 has 4 values(PQRS,WXYZ)
            temp += digToStr[val].charAt(j);  //""+digtostr[2].char(0) --> (a,b,c)--> temp=a
            combinationsHelper(digits,digToStr,i+1,temp,ans);//23,a-z,1,temp=a,ans
            temp = temp.substring(0, temp.length() - 1); //empty temp
        }
    }

    public static ArrayList<String> combinations(String s)
    {
        String[] digToStr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
        int n =  s.length(); //2
        String temp = new String();
        ArrayList<String> ans = new ArrayList<>();
        if(n == 0) {
           return ans;
        }
        combinationsHelper(s,digToStr,0,temp,ans); //(23,digstr,0,temp,ans)
    
        return ans;    
    }
}
