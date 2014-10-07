package com.kademika.day11.f11;

import sun.font.StandardTextSource;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by Админ on 15.07.2014.
 */
public class Loncher {
    private static void changeEncoding(File file,String currentCoding,String needingEncoding ){
    StringBuilder builder = new StringBuilder();
        try(BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream(file), currentCoding))){
            String str;
            while(( str = br.readLine())!=null){
    builder.append(str);
            }
            System.out.println(builder);
        }
        catch(FileNotFoundException e){}
        catch(IOException e){}
        try(OutputStreamWriter d =new OutputStreamWriter(new FileOutputStream(file), needingEncoding)){
            d.write(builder.toString());
        }
        catch(FileNotFoundException e){}
        catch(IOException e){}
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("kjl");
//        OutputRedirector fd = new OutputRedirector();
//        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("main.txt",true))));
//        System.out.println(52752);
//        fd.out.write();

        try {
            System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\Админ\\Dropbox\\jb-midgardabc\\jc-paskuSam\\src\\com\\kademika\\day11\\f11\\main.txt")));
            System.out.print("ghjnfsdfsdfjh"+675);
        } catch(Exception e) {}
    }
}
