package com.kademika.day11.zip;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.*;

/**
 * Created by Админ on 16.07.2014.
 */
public class Zip {

    public void zipFiles(File f, String fileName) {
        File file1 = new File("C:\\Users\\Админ\\Dropbox\\jb-midgardabc\\jc-paskuSam\\src\\com\\kademika\\day11\\zip\\", fileName + ".zip");
        if (!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (Exception e) {
            }
        }
        File file2 = new File("C:\\Users\\Админ\\Dropbox\\jb-midgardabc\\jc-paskuSam\\src\\com\\kademika\\day11\\zip\\"+fileName + ".zip\\", fileName + ".txt");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Exception e) {
            }
        }
//        List<File>result = new ArrayList<>();
//        for(int i=0;i<f.length; i++){
//       try( ZipInputStream zipFile = new ZipInputStream(new FileInputStream(f[i]))){
//        ZipEntry zipEntry;
//
//        while ((zipEntry = zipFile.getNextEntry()) != null) {
//            result.add(inputStreamToFile(zipFile.createZipEntry(name+".zip")));
//        }}catch(Exception r){}
//    }
//        try(
//       ZipOutputStream zipOutStream = new ZipOutputStream(new FileOutputStream(f, true));
//        FileInputStream fis = new FileInputStream(fileName);
//       ){
//            ZipEntry entry = new ZipEntry(fileName+"zip");
//        if (!entry.isDirectory()) {
//            zipOutStream.putNextEntry(entry);
//            BufferedInputStream bis = new BufferedInputStream(fis);
//            byte data[] = new byte[65000];
//            int count = 0;
//            while ((count = bis.read(data, 0, 65000)) != -1) {
//                zipOutStream.write(data);
//            } //end while
//            bis.close();
//        }}catch(Exception e){}
//        zipOutStream.closeEntry();
//        zipOutStream.flush();
//        zipOutStream.finish();
//        zipOutStream.close();
//        fis.close();
//        fileOutStream.close();
        // input file
//        try (FileInputStream in = new FileInputStream(f);
//
//             // out put file
//             ZipOutputStream out = new ZipOutputStream(new FileOutputStream(fileName + ".zip"))) {
//
//            // name the file inside the zip  file
//
//
//            // buffer size
//            byte[] b = new byte[1024];
//            int count;
//
//            while ((count = in.read(b)) > 0) {
//                System.out.println();
//                out.write(b, 0, count);
//                out.putNextEntry(new ZipEntry(fileName + ".txt"));
//            }
//        } catch (Exception e) {
//        }
    }

    final static int BUFFER = 2048;

    public static boolean addZipArchive(String srcFolder) {

        try {
            //create a zipFile
            BufferedInputStream origin = null;
            FileOutputStream dest = new FileOutputStream(new File(srcFolder + ".zip"));
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            byte data[] = new byte[BUFFER];
            //check all filles or directory
            File subDir = new File(srcFolder);
            String subdirList[] = subDir.list();
            for (String sd : subdirList) {
                // get a list of files from current directory
                File f = new File(srcFolder + "/" + sd);
                if (f.isDirectory()) {
                    String files[] = f.list();
                    for (int i = 0; i < files.length; i++) {
                        System.out.println("Adding: " + files[i]);
                        FileInputStream fi = new FileInputStream(srcFolder + "/" + sd + "/" + files[i]);
                        origin = new BufferedInputStream(fi, BUFFER);
                        ZipEntry entry = new ZipEntry(sd + "/" + files[i]);
                        out.putNextEntry(entry);
                        int count;
                        while ((count = origin.read(data, 0, BUFFER)) != -1) {
                            out.write(data, 0, count);
                            out.flush();
                        }

                    }
                } else //it is just a file
                {
                    FileInputStream fi = new FileInputStream(f);
                    origin = new BufferedInputStream(fi, BUFFER);
                    ZipEntry entry = new ZipEntry(sd);
                    out.putNextEntry(entry);
                    int count;
                    while ((count = origin.read(data, 0, BUFFER)) != -1) {
                        out.write(data, 0, count);
                        out.flush();
                    }

                }
            }
            origin.close();
            out.flush();
            out.close();
        } catch (Exception e) {
e.printStackTrace();
        }


        return true;
    }

    /*public void unZip(File f) {
        byte[] buffer = new byte[1024];
        try {
            ZipFile zip = new ZipFile(f);
            Enumeration entries = zip.entries();

            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                System.out.println("Extracting:" + entry.getName());

                write(zip.getInputStream(entry),
                        new BufferedOutputStream (new
                                FileOutputStream(entry.getName())));
            }

            zip.close();
        }
        catch (IOException e) {
            System.out.println("Exception:");
            e.printStackTrace();
            return;
        }
    }*/
    public static void write(InputStream in, OutputStream out)
            throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) >= 0)
            out.write(buffer, 0, len);
        in.close();
        out.close();
    }
    public void unZip(File srcFolder){
        try{
            File file2 = new File("C:\\Users\\Админ\\Dropbox\\jb-midgardabc\\jc-paskuSam\\src\\com\\kademika\\day11\\zip\\", srcFolder.getName().substring(0,srcFolder.getName().indexOf(".")) );
            if (!file2.exists()) {
                try {
                    file2.mkdir();
                } catch (Exception e) {
                }
            }
           BufferedInputStream origin = null;
        BufferedOutputStream dest = new BufferedOutputStream(new FileOutputStream(file2));
        byte data[] = new byte[BUFFER];
        //check all filles or directory
        ZipFile subDir = new ZipFile(srcFolder);
        Enumeration entries = subDir.entries();
            while (entries.hasMoreElements()) {
                ZipEntry sd = (ZipEntry) entries.nextElement();
            // get a list of files from current directory
            File f = new File(srcFolder + "/" + sd);
            if (f.isDirectory()) {
                String files[] = f.list();
                for (int i = 0; i < files.length; i++) {
                    System.out.println("Extracting: " + files[i]);
                    FileInputStream fi = new FileInputStream(srcFolder + "/" + sd + "/" + files[i]);
                    origin = new BufferedInputStream(fi, BUFFER);
                    ZipEntry entry = new ZipEntry(sd + "/" + files[i]);
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
                ZipEntry entry = new ZipEntry(sd);
                int count;
                while ((count = origin.read(data, 0, BUFFER)) != -1) {
                    dest.write(data, 0, count);
                    dest.flush();
                }

            }
        }
        origin.close();
        dest.flush();
        dest.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
     public void extractFolder(File zipFile) throws ZipException, IOException
    {
        System.out.println(zipFile);
        int BUFFER = 2048;
//        File file = new File(zipFile);

        ZipFile zip = new ZipFile("C:\\Users\\Админ\\Dropbox\\jb-midgardabc\\jc-paskuSam\\src\\com\\kademika\\day11\\zip\\"+zipFile);
        String newPath = zipFile.getName().substring(0, zipFile.getName().length() - 4);

        new File("C:\\Users\\Админ\\Dropbox\\jb-midgardabc\\jc-paskuSam\\src\\com\\kademika\\day11\\zip\\"+newPath).mkdir();
        Enumeration zipFileEntries = zip.entries();

        // Process each entry
        while (zipFileEntries.hasMoreElements())
        {
            // grab a zip file entry
            ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
            String currentEntry = entry.getName();
            File destFile = new File("C:\\Users\\Админ\\Dropbox\\jb-midgardabc\\jc-paskuSam\\src\\com\\kademika\\day11\\zip\\"+newPath, currentEntry);
            //destFile = new File(newPath, destFile.getName());
            File destinationParent = destFile.getParentFile();

            // create the parent directory structure if needed
            destinationParent.mkdirs();

            if (!entry.isDirectory())
            {
                BufferedInputStream is = new BufferedInputStream(zip
                        .getInputStream(entry));
                int currentByte;
                // establish buffer for writing file
                byte data[] = new byte[BUFFER];

                // write the current file to disk
                FileOutputStream fos = new FileOutputStream(destFile);
                BufferedOutputStream dest = new BufferedOutputStream(fos,
                        BUFFER);

                // read and write until last byte is encountered
                while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
                    dest.write(data, 0, currentByte);
                }
                dest.flush();
                dest.close();
                is.close();
            }

            if (currentEntry.endsWith(".zip"))
            {
                // found a zip file, try to open
                extractFolder(new File(destFile.getAbsolutePath()));
            }
        }
    }
}
