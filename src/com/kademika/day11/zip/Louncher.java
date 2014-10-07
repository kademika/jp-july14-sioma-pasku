package com.kademika.day11.zip;

import java.io.File;

/**
 * Created by Админ on 16.07.2014.
 */
public class Louncher {


    public static void main(String[] args)throws Exception{
        Zip v = new Zip();
//        v.zipFiles(new File("вап.txt"),"hj");
//        v.addZipArchive("C:\\Users\\Админ\\Dropbox\\jb-midgardabc\\jc-paskuSam\\src\\com\\kademika\\day11\\zip\\hj");
//        v.unZip(new File("hj.zip"));
        v.extractFolder(new File("hj.zip"));

    }
}
