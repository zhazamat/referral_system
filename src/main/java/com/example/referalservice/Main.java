package com.example.referalservice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
            List<Integer> listA
                    = new ArrayList<Integer>();
            List<Integer>listB=new ArrayList<>();
            BufferedReader bfA = new BufferedReader(
                    new FileReader("a.txt"));
        Date currentTime = new Date();
        BufferedReader bfB = new BufferedReader(
                new FileReader("b.txt"));
            String line = bfA.readLine(),line1=bfB.readLine();
            while (line != null&&line1!=null) {
                listA.add(Integer.parseInt(line));
                listB.add(Integer.parseInt(line1));
                line = bfA.readLine();
                line1=bfB.readLine();
            }
            bfA.close();
        bfB.close();

            Integer[] array
                    = listA.toArray(new Integer[0]);
        Integer[] array1
                = listB.toArray(new Integer[0]);
    for (Integer i : array) {
                for(Integer j:array1){
                    if(array[i]+array1[j]==1990){

                        System.out.println(array[i]+" "+array1[j]);
return;
            }
        }

    }

    }
}