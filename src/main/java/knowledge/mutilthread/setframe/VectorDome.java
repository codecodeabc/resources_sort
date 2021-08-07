package knowledge.mutilthread.setframe;

import java.util.Vector;

/**
 * vector 动态数组，能同步访问
 */
public class VectorDome {

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));  
        }
    }

}
