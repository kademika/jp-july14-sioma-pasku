package com.kademika.day11.f6;


import java.io.*;

/**
 * Created by Админ on 07.07.2014.
 */
public class BufferReader  {

    public String read(String FileName) {
        StringBuilder strb= new StringBuilder();
        try(
            BufferedInputStream bin = new BufferedInputStream(new FileInputStream(FileName));
        ){
            int i;
            while((i=bin.read()) != -1){
                strb.append((char)i);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return strb.toString();
    }
}
