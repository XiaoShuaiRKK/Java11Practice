package com.FinalTest.Test4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainTest {
    public static void main(String[] args) throws IOException {
        Path currentFile = Paths.get("/Volumes/iDisk/Temp/Tmp/temp.txt");
        Path outputFile = Paths.get("/Volumes/iDisk/Temp/Tmp/new.txt");
        Path directory = Paths.get("/Volumes/iDisk/Temp/");
        Files.copy(currentFile,outputFile);
        Files.copy(outputFile,directory);
        Files.delete(outputFile);
    }
}
