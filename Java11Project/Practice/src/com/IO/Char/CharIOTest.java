package com.IO.Char;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CharIOTest {
    public static void main(String[] args) {
        readFileContent("E:\\backEnd\\Note\\Java\\spring\\SpringMVC笔记.md");
    }

    private static void readFileContent(String path){
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null)
                System.out.println(line);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
