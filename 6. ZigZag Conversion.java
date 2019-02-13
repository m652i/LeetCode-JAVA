The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

============================================================================================================

class Solution {
    public String convert(String s, int n) 
    {
        if(n == 1) return s;
            
        int zaglen = n + n - 2;             //or 2n - 2
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j*zaglen+i < len; j++)
            {
                sb.append(s.charAt((j*zaglen) + i));
                if(i != 0 && i != n-1 && ((j+1)*zaglen)-i < len){
                    sb.append(s.charAt(((j+1)*zaglen)-i));
                }
            }    
        }
        return sb.toString();

    }
}
