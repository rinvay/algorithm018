class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null ) {
            return;
        }
        
        int n = nums.length;
        int numOf0 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                numOf0++;
            } else if (numOf0 > 0){
                nums[i-numOf0] = nums[i];
                nums[i] = 0;
            }
        }
        
    }
}