import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        // 1. Sort to enable the two-pointer approach
        Arrays.sort(nums);
        int n = nums.length;
        // Initialize with the sum of the first triplet
        int ans = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            // Optimization: Skip duplicate 'i' values to save time
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1; // Left pointer
            int k = n - 1; // Right pointer

            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];

                // If we find an exact match, return immediately
                if (total == target) {
                    return total;
                }

                // Update 'ans' if the current 'total' is closer to the target
                if (Math.abs(target - total) < Math.abs(target - ans)) {
                    ans = total;
                }

                if (total < target) {
                    j++;
                    // Optimization: Skip duplicate 'j' values
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else {
                    k--;
                    // Optimization: Skip duplicate 'k' values
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return ans;
    }

}