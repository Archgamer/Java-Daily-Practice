public class ContainMostWater {
        /* initial Elements */
        public int maxArea(int[] height) {
            int maxArea = 0;
            int left = 0; /*Pointer1*/
            int right = height.length - 1;  /*Pointer2*/

            while (left < right) {
                int area = Math.min(height[left], height[right]) * (right - left); /*Calculate the area between the two pointers*/
                maxArea = Math.max(maxArea, area); /*Update the maximum area if the current area is larger*/

                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return maxArea;
    }
}
