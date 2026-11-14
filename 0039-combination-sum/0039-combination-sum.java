class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        back(nums, res, temp,target,0);
        return res;
    }
    void back(int nums[], List<List<Integer>> res, List<Integer> temp, int tar,int s){
        if(tar<0)return;
        if(tar==0)res.add(new ArrayList<>(temp));
        for(int i=s; i<nums.length;i++){
            temp.add(nums[i]);
            back(nums,res,temp,tar-nums[i],i);
            temp.remove(temp.size()-1);
        }
    }
}