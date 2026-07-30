class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            if (nums[i] == target) {
                return i;
            }

            if (nums[j] == target) {
                return j;
            }

            i++;
            j--;
        }

        return -1;
    }
}
