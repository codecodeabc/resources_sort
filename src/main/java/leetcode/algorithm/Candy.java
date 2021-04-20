package leetcode.algorithm;

import java.util.Arrays;

/**
 * 135.Candy
 */
public class Candy {

    public static int candy(int[] ratings) {

        int[] cookie = new int[ratings.length];
        Arrays.fill(cookie, 1);
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            if (i - 1 >= 0 && ratings[i-1] < ratings[i]) {
                cookie[i] = cookie[i-1]+1;
            }
        }
        for (int i = ratings.length-1; i >=0; i--) {
            if (i + 1 < ratings.length && ratings[i+1] < ratings[i] && cookie[i] <= cookie[i+1]) {
                cookie[i] = cookie[i+1]+1;
            }
        }
        for(int i = 0;i<cookie.length;i++){
            sum = cookie[i] + sum;
        }
        for(int i = 0;i<cookie.length;i++){
            System.out.print(cookie[i]+" ");
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] rating = {1,3,4,5,2};
        int candy = candy(rating);
        System.out.println(candy);
    }
}
