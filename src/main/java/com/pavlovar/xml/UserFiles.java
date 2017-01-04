package com.pavlovar.xml;

import java.util.NavigableMap;

public class UserFiles {

    public static TxtUtility txtUtility = new TxtUtility("|");
    public static String pathToDocuments = "/Users/artempavlovskyi/Documents/";

    public static void main(String[] args) {


        TxtFile txtFile = new TxtFile(pathToDocuments + "newFile.txt");

        txtUtility.create(txtFile.getName());
//        txtUtility.write(txtFile, " sameLine 2");
        txtUtility.read("./newFile.txt");

        NavigableMap map;


    }


}
