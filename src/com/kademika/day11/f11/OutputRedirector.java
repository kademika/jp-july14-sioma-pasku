package com.kademika.day11.f11;

import java.io.*;
import java.lang.reflect.Method;

/**
 * Created by Админ on 16.07.2014.
 */
public class OutputRedirector {

    /* args[0] - class to launch, args[1]/args[2] file to direct System.out/System.err to */
    public static void main(String[] args) throws Exception {  // error checking omitted for brevity
        System.setOut(outputFile(args[1]));
        System.setErr(outputFile(args[2]));
        Class app = Class.forName(args[0]);
        Method main = app.getDeclaredMethod("main", new Class[]{(new String[1]).getClass()});
        String[] appArgs = new String[args.length - 3];
        System.arraycopy(args, 3, appArgs, 0, appArgs.length);
        main.invoke(null, appArgs);
    }

    PrintStream out;

    public OutputRedirector() throws FileNotFoundException {
        out = outputFile("C:\\Users\\Админ\\Dropbox\\jb-midgardabc\\jc-paskuSam\\src\\com\\kademika\\day11\\f11\\main.txt");
    }

    protected static PrintStream outputFile(String name) throws FileNotFoundException {
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(name, true)));
        try (BufferedWriter file = new BufferedWriter(new FileWriter("C:\\Users\\Админ\\Dropbox\\jb-midgardabc\\jc-paskuSam\\src\\com\\kademika\\day11\\f11\\main.txt"))) {

            System.setOut(out);
            file.write( System.out+ " ");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }
}