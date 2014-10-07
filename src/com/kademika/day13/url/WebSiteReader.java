package com.kademika.day13.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Админ on 01.09.2014.
 */
public class WebSiteReader {
    public static void main(String[] args) throws IOException {
        String nextKine;
        URL url;
        URLConnection urlC = null;
        InputStreamReader inStr = null;
        BufferedReader buffer = null;
        try {
            url = new URL("http://www.google.com");
            urlC = url.openConnection();
            inStr = new InputStreamReader(urlC.getInputStream());
            buffer = new BufferedReader(inStr);
            while ((nextKine = buffer.readLine()) != null) {
                System.out.println(nextKine);
            }
        } catch (MalformedURLException e) {
            System.out.println(" Wrong name of Url" + e.toString());
        } finally {
            if (inStr != null) {
                try {
                    inStr.close();
                    buffer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
