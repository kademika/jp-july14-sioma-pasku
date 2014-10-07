package com.kademika.day11.CheckClass;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by Админ on 24.07.2014.
 */
public class Bla {
    public static void check( File file){
        File[] fd;

        if(file.isDirectory()) {
//             fd = file.getFiles();
        }
    }
    private static String str;
    static int spc_count=-1;
    static void Process(Class nam, File aFile)throws Exception{
        spc_count++;
        String spcs = "";
        for (int i = 0; i < spc_count; i++)
            spcs += " ";
        if(aFile.isFile()){
            if(Class.forName(aFile.getName()).getClassLoader().equals(nam) ){
              str += aFile.getName();
            }
        }
        else if (aFile.isDirectory()) {
            System.out.println(spcs + "[DIR] " + aFile.getName());
            File[] listOfFiles = aFile.listFiles();
            if(listOfFiles!=null) {
                for (int i = 0; i < listOfFiles.length; i++)
                    Process(nam,listOfFiles[i]);
            } else {
                System.out.println(spcs + " [ACCESS DENIED]");
            }
        }
        spc_count--;
    }


    public static void check( String file){
        StringBuilder str= new StringBuilder();
//        try(BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file))){
//            File f1 = new File();
//            File []f =bf.g
//        if(file.isDirectory()) {
//            File[] fd = file.g
//        }
//        }catch(Exception c){c.printStackTrace();}
        try {
            Path startPath = Paths.get(file);
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir,
                                                         BasicFileAttributes attrs) {
                    System.out.println("Dir: " + dir.toString());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    System.out.println("File: " + file.toString());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException e) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();

        }}
    final static int BUFFER = 2048;
    private static String str1;
    public static void readFile( String srcFolder, File file){
        try{

            BufferedInputStream origin = null;
            BufferedOutputStream dest = new BufferedOutputStream(new FileOutputStream(file));
            byte data[] = new byte[BUFFER];
            //check all filles or directory
            JarFile subDir = new JarFile(new File(srcFolder));
            Enumeration entries = subDir.entries();
            while (entries.hasMoreElements()) {
                JarEntry sd = (JarEntry) entries.nextElement();
                // get a list of files from current directory
                File f = new File(srcFolder + "/" + sd);
                if (f.isDirectory()) {
                    String files[] = f.list();
                    for (int i = 0; i < files.length; i++) {
                        System.out.println("Extracting: " + files[i]);
                        FileInputStream fi = new FileInputStream(srcFolder + "/" + sd + "/" + files[i]);
                        origin = new BufferedInputStream(fi, BUFFER);
                        JarEntry entry = new JarEntry(sd + "/" + files[i]);
                        int count;
                        while ((count = origin.read(data, 0, BUFFER)) != -1) {
                            dest.write(data, 0, count);
                            dest.flush();
                        }

                    }
                } else //it is just a file
                {
                    FileInputStream fi = new FileInputStream(f);
                    origin = new BufferedInputStream(fi, BUFFER);
                    JarEntry entry = new JarEntry(sd);
                    if(sd.getClass().getClassLoader().equals("Number")){
                        str +=sd.getName();
                    }
//                    int count;
//                    while ((count = origin.read(data, 0, BUFFER)) != -1) {
//                        dest.write(data, 0, count);
//                        dest.flush();
//                    }

                }
            }
            origin.close();
            dest.flush();
            dest.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
      //  check("D:\\sioma\\потолки");
//        Number
        try {
//            Process(Number.class,new File("C:\\Program Files\\Java\\jdk1.7.0_60\\resources.jar\\java.lang"));
            readFile("resources.jar",new File("C:\\Users\\Админ\\Dropbox\\jb-midgardabc\\jc-paskuSam\\src\\com\\kademika\\day11\\zip\\fd.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(str1);
    }
}
