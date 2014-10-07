package com.kademika.day12.f3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Админ on 26.07.2014.
 */
public class Some {


    public static void main(String[] args) {
        int i=0;
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            String s = br.readLine();
//        System.out.print("Enter Integer:");
            System.out.print("How much do you want to withdraw?");

            i = Integer.parseInt(br.readLine());
        }
        catch(Exception e){
            System.err.println("Invalid Format!");
        }
        System.out.println(i);
    }
}