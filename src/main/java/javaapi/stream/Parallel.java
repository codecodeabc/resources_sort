package javaapi.stream;

import java.util.Arrays;

public class Parallel {
    public static void main(String[] args) {
        int m = 2;
        long[] array = new long[]{1,2,3};
        long total = Arrays.stream(array)
                .parallel()
                .reduce(2, (acc, next) -> acc * next);
        // 每个块都会乘 identity :2
        System.out.println(total);
    }
}
