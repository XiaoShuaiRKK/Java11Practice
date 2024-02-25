package com.IO.FIle;

import java.io.File;

public class FIleIOTest {
    public static void main(String[] args) {
        listAllFiles(new File("D:\\LL banner"));
    }

    @SuppressWarnings("all")
    private static void listAllFiles(File dir){
        if(dir == null || !dir.exists())
            return;
        if(dir.isFile()){
            System.out.println(dir.getName());
            return;
        }
        for(File file : dir.listFiles())
            listAllFiles(dir);
    }
}
