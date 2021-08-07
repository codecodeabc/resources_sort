package knowledge.io.buffer;


import java.nio.ByteBuffer;

public class BufferTest {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(46);
        buffer.put((byte) 0);
        buffer.put((byte) 2);
        buffer.put((byte) 4);
        buffer.put((byte) 5);
        byte b = buffer.get(0);
        System.out.println(b);
        byte b1 = buffer.get(2);
        System.out.println(b1);
    }
}
