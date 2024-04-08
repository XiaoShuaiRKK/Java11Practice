package com.FinalTest.Test7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        BiPredicate<Path, BasicFileAttributes> pred = ((path, basicFileAttributes) -> basicFileAttributes.isDirectory());
        int depth = 1;
        try (var stream = Files.find(Paths.get("/Volumes/iDisk/Temp/Continent"),depth,pred)) {
            stream.forEach(System.out::println);
        }catch (IOException e){

        }
    }
}
