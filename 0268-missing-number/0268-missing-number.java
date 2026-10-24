// Bruteforce approach
// class Solution {
//     public int missingNumber(int[] nums) {
//         Arrays.sort(nums);
//         int n=nums.length;
//         for(int i=0; i<n;i++){
//             if(i!=nums[i] )return i;
//         }
//         return n;
//     }
// }

// By using better b Hashing means count frequency
// class Solution {
//     public int missingNumber(int[] nums) {
//       int n=nums.length;
//       int freq[]=new int[n+1];
//       for(int i:nums){
//         freq[i]=1;
//       }
//       for(int i=0;i<n+1;i++){
//         if (freq[i]==0) return i;
//       }
//       return 0;
//     }
// }


// Optimal Solution
class Solution {
    public int missingNumber(int[] nums) {
        //finding the length of the arrray
      int n=nums.length;
      int sumN=(n*(n+1))/2,sum=0;
      for (int i:nums) sum+=i;
      return sumN-sum;
    }
}