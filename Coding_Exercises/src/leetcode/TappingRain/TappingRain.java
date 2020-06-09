package leetcode.TappingRain;

import java.util.Arrays;

public class TappingRain {

    public static int trap(int[] height) {

        int area = 0;
        int left = 0;
        int right = 0;
        int center = 0;



        // set left-side and right-side starting pointer
        // and the highest point
        for (int i = 0; i < height.length; i++) {
            if (height[i] > 0) {
                left = i;
                break;
            }
        }
        for (int i = height.length-1; i > 0; i--) {
            if (height[i] > 0) {
                right = i;
                break;
            }
        }

        for (int i = 0; i < height.length; i++) {
            if(height[i]>height[center])
                center = i;
        }

        int i;
        int tempArea;
        while (left < center) {
            i = left + 1;
            tempArea = 0;
            while (height[left] > height[i]) {
                tempArea += height[left] - height[i];
                i++;
            }
            left = i;
            area += tempArea;
        }


        while (right > center) {
            i = right - 1;
            tempArea = 0;
            while (height[right] > height[i]) {
                tempArea += height[right] - height[i];
                i--;
            }
            right = i;
            area += tempArea;

        }


        return area;
    }

    public static void main(String[] args) {
        int[] test1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(trap(test1));
    }
}
