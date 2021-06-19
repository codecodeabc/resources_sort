package leetcode.topk;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopkWord {
    public static  List<String> getTopK(String[] words, int k){
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet()
                .stream()
                .sorted((o1,o2) ->{
                    if(o1.getValue().equals(o2.getValue())){
                        return o1.getKey().compareTo(o2.getKey());
                    }else{
                        return o2.getKey().compareTo(o1.getKey());
                    }
                })
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String[] words = new String[] {"a","b","c","a","e","e"};
        System.out.println(getTopK(words,2));
    }
}
