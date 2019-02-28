
Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this in a way such that the resulting number is a power of 2.

 

Example 1:

Input: 1
Output: true
Example 2:

Input: 10
Output: false
Example 3:

Input: 16
Output: true
Example 4:

Input: 24
Output: false
Example 5:

Input: 46
Output: true
 

Note:

1 <= N <= 10^9



since N < 10^9
log2(1000000000) = 29 means only 29 numbers that are power of 2 under 1000000000
29 is not that big of a number so might as well just make an array with the 29 numbers and check if the number entered is one of the 29.
But, we don't need all 29 since we can eliminate numbers that aren't the same digitis, so all we need to do is see how many digits the entered number
find all powers of 2 with that many digits (which usually isn't that many, either 3 or 4.)
than just sort and match.

example : int N = 110273
sort will turn N into String 011237
so finds all the power of two with 6 digits, listed :
2^17	131072
2^18	262144
2^19	524288

then just quickly sort them, and check which one matches while sorting.

011237 == 011237

stops after sorting the first, since it's already a match.

Speed prolly not the fastest but plenty fast, since we only have 29 numbers max to go through, and only sorting 3 or 4 numbers + the entered number itself.
so worse case for the first for loop is 29 which is O(log(N))
the rest takes way less time to change the big O.
thus the run time of
Runtime: 5 ms, faster than 99.33% of Java online submissions for Reordered Power of 2.

Space isn't too much since the ArrayList will only be filled with 3 or 4 numbers.

class Solution {
    public boolean reorderedPowerOf2(int N) {
        String num = Integer.toString(N);
        char [] n = num.toCharArray();
        Arrays.sort(n);
        num = new String(n);
        int digits = 0;
        for(char c : num.toCharArray()) digits++;
        //now populate the power of 2 array
        ArrayList<String> p2arr = new ArrayList();
        for(int i = 1; i <= (int) Math.pow(10, digits); i*=2){
            if(i >= (int) Math.pow(10, digits-1)){
                p2arr.add(Integer.toString(i));
            }
        }
        for(String a : p2arr){
            char [] b = a.toCharArray();
            Arrays.sort(b);
            a = new String(b);
            if(num.equals(a)){
                return true;
            }
        }
        
        return false;
        
    }
}
