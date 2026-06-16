class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        
        int mid = left + (right - left) / 2;
        
        // Recursively sort the left and right halves
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        
        // Merge the sorted halves
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        // Create a temporary array to store the merged result
        int[] temp = new int[right - left + 1];
        
        int i = left;      // Initial index of first subarray
        int j = mid + 1;   // Initial index of second subarray
        int k = 0;         // Initial index of merged array
        
        // Copy data to temp array
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        
        // Copy remaining elements of left subarray, if any
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        
        // Copy remaining elements of right subarray, if any
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        
        // Copy the sorted elements back into the original array
        System.arraycopy(temp, 0, nums, left, temp.length);
    }
}