package com.IO.Serializable;

import java.io.*;
import java.lang.ref.SoftReference;

public class SerializableIOTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Info info = new Info("InfoA",20);
        String path = "D:\\Temp\\info.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path));
        objectOutputStream.writeObject(info);
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        Info infomation = (Info) objectInputStream.readObject();
        objectOutputStream.close();
        System.out.println(infomation);

    }

    private static class Info implements Serializable{
        private final String name;
        //transient关键字保护了字段不被序列化
        private transient final int num;

        public Info(String name, int num) {
            this.name = name;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "name='" + name + '\'' +
                    ", num=" + num +
                    '}';
        }
    }
}
