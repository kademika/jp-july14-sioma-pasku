package com.kademika.day13.f3;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Админ on 01.09.2014.
 */
public class Utils {

    public static int transroprify(int data) {
        if (Character.isLetter((data))) {
            return data ^ ' ';
        }
        return data;
    }

    public static void process(SocketChannel sc) {
        try  {
            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
            while ((sc.read(buffer)) != -1) {
                buffer.flip();//we working with buffer with buffer.limit and we can begin write data to buffer
                for(int i=0; i<buffer.limit(); i++){
                    buffer.put(i,(byte) transroprify(buffer.get(i)));
                }
                sc.write(buffer);
                buffer.clear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
