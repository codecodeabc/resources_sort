package leetcode.algorithm;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 435.no overlapping
 */
public class NoOverLapping {

    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <= 1)
            return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] z, int[] b) {
                return z[1] - b[1];
            }
        });
        int sum = 0;
        int index = 0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] >=intervals[index][1]){
                index = i;
                continue;
            }else{
                sum++;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1,100},
                {11,22},
                {1,11},
                {2,12}
        };
        int i1 = eraseOverlapIntervals(a);
        System.out.println(i1);
    }
}
