/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demobranch;

import java.util.*;
import java.io.*;

/**
 *
 * @author Mausam
 */
public class DemoBranch {
public static ArrayList<String> arrayword = new ArrayList<String>();
public static ArrayList<String> arrayallwords = new ArrayList<String>(); 

     public static boolean isValidFilePath(String filePath) {
        File file = new File(filePath);
        if (file.exists() && !file.isDirectory()) {
            return true;
        } else {
            return false;
        }
    }

    public static void Getfilepath() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input file name with extention .txt :: ");
        String filepath = sc.next();
        if (!isValidFilePath(filepath)) {
            System.out.println("Please enter valid file path");
            Getfilepath();
        } else {
            Readfiledata(filepath);
        }
    }
    
    public static void Readfiledata(String filepath) throws FileNotFoundException {
        File inputFile = new File(filepath);
        Scanner sc = new Scanner(inputFile);
        while (sc.hasNext()) {
            String words = sc.next();
            arrayword.add(words);
        }
        for (int i = 0; i < arrayword.size(); i++)
            arrayword.set(i,arrayword.get(i).replaceAll("[^a-zA-Z0-9]",""));
        
        while(arrayword.contains("")) 
              arrayword.remove("");
               
        Getuniquewords();
    }

    public static void Getuniquewords() {
        Set<String> uniqueWords = new HashSet<String>(arrayword);
        arrayallwords.addAll(arrayword);
        arrayword.removeAll(arrayword);
        arrayword.addAll(uniqueWords);
        Collections.sort(arrayword);
        System.out.println("\n1. List Of unique word : \n ");
        for (String repeatation : arrayword) {

            if (Collections.frequency(arrayallwords, repeatation) == 1) {
                System.out.println(repeatation);
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Getfilepath();
    }
}
