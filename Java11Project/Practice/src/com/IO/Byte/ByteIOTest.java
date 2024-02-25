package com.IO.Byte;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ByteIOTest {
    public static void main(String[] args) {
        copyFile("D:\\img 平常\\hao.jpg","D:\\img 平常\\no\\hao.jpg");
    }

    private static void copyFile(String src,String dist){
        try(FileInputStream in = new FileInputStream(src);FileOutputStream out = new FileOutputStream(dist))
        {
            byte[] buffer = new byte[20 * 1024];
            while (in.read(buffer,0,buffer.length) != -1){
                in.skip(10L);
                System.out.println(buffer.length);
                out.write(buffer);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
