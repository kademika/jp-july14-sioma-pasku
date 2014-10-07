package com.kademika.day11.f5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.jar.JarInputStream;

/**
 * Created by Админ on 04.07.2014.
 */
public class MakeSomeFile {
    public static void main(String[] args) throws IOException {
//        File file = new File("src/com/kademika/day11/f5/g".replace("/",File.separator));
//        Path path = Paths.get("C:\\Users\\Админ\\Dropbox\\jb-midgardabc\\jc-paskuSam\\src\\com\\kademika\\day11\\f5");
//        Files.createDirectory(path,);
      /*  File file = new File("C:\\Users\\Админ\\Dropbox\\jb-midgardabc\\jc-paskuSam\\src\\com\\kademika\\day11\\f5\\my_directory");
        if(!file.exists()){
            file.mkdir();
            System.out.println("Dir created!!!");
        }else{
            System.out.println("dir already created!!!");
        }
        File file1 = new File("C:\\Users\\Админ\\Dropbox\\jb-midgardabc\\jc-paskuSam\\src\\com\\kademika\\day11\\f5\\my_directory","example.txt");
        if(!file1.exists()){
            file1.createNewFile();
            System.out.println("file created!!!");
        }else{
            System.out.println("file already created!!!");
        }
        String [] sd = {"dsf","sdfs","fsd"};
        System.out.println(System.getProperty("user.dir"));
        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
        for(File f: File.listRoots()){
            System.out.println(f.getAbsolutePath());
        }
        System.out.println(getFilePath());
        System.out.println(getREalFileOir());

*/
        printCopyFile(new File("C:\\Users\\Админ\\Dropbox\\jb-midgardabc\\jc-paskuSam\\src\\com\\kademika\\day11\\f5\\text.txt"));

    }

    public static String getFilePath() {

        File thisFile = new File("src/com/kademika/io/files".replace("/", File.separator), MakeSomeFile.class.getSimpleName() + ".java");
        return thisFile.getAbsolutePath();
    }

    public static String getREalFileOir() {
        return "src/com/kademika/day11/io/files".replace("/", File.separator);
    }

    public static void printCopyFile(File f) throws IOException {
        File file1 = new File("C:\\Users\\Админ\\Dropbox\\jb-midgardabc\\jc-paskuSam\\src\\com\\kademika\\day11\\f5\\", "example.txt");
        if (!file1.exists()) {
            file1.createNewFile();
        }

        StringBuilder i1 = new StringBuilder();
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String i;
            while ((i = bf.readLine()) != null) {
                i1.append(i);
            }
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
//            FileWriter file2 = new FileWriter(file1);
//            PrintWriter pw = new PrintWriter(file2);
//           pw.append(i1);
//            pw.close();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
            bw.write(i1 + "Copy");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder strb;

    public static String printCopyFile(String name) throws IOException {
        strb = new StringBuilder();
        try (
                BufferedInputStream bin = new BufferedInputStream(new FileInputStream(name));
        ) {
            int i;
            while ((i = bin.read()) != -1) {
                strb.append((char) i);
                if (i > 256) {
                    printCopyFile(name);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strb.toString();
    }
}
