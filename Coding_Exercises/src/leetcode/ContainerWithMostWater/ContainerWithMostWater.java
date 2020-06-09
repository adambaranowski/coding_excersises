package leetcode.ContainerWithMostWater;

import java.util.*;

public class ContainerWithMostWater {
    public static int maxArea(int[] heights){
        int area = 0;
        int x;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
               x =  (j-i)*Math.min(heights[i], heights[j]);
               if(x>area)
                   area = x;
            }
        }
        return area;
    }

    public static int maxArea1(int[] heights){
        int area = 0;
        int x;

        int left = 0; //left pointer
        int right = heights.length-1; //right pointer

        while(left < right){

            x = (right - left)*Math.min(heights[right], heights[left]);
            if(x>area)
                area=x;

            //update pointers setup
            if(heights[left]<=heights[right])
                left++;
            else
                right--;
        }
        return area;
    }



    public static void main(String[] args) {
        int[] test1 = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(test1));
        System.out.println(maxArea1(test1));
    }
}
