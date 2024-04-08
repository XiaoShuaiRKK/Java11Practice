package com.Stream;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        appleForTest();
        appleStreamTest();
        appleStreamTwoTest();
        appleStreamThreeTest();
    }

    private static void appleStreamTest(){
        List<Apple> apples = new ArrayList<>();
        for(int i=0;i < 100000000;i++){
            apples.add(new Apple(i));
        }
        long time = System.currentTimeMillis();
        apples.stream().parallel().forEach(apple -> apple.setPrice((float) (5.5 * apple.getWeight())));
        System.out.println(System.currentTimeMillis() - time + "ms");
    }

    private static void appleStreamTwoTest(){
        List<Apple> apples = new ArrayList<>();
        for(int i=0;i < 100000000;i++){
            apples.add(new Apple(i));
        }
        long time = System.currentTimeMillis();
        apples.stream().forEach(apple -> apple.setPrice((float) (5.5 * apple.getWeight())));
        System.out.println(System.currentTimeMillis() - time + "ms");
    }

    private static void appleStreamThreeTest(){
        List<Apple> apples = new ArrayList<>();
        for(int i=0;i < 100000000;i++){
            apples.add(new Apple(i));
        }
        long time = System.currentTimeMillis();
        apples.parallelStream().forEach(apple -> apple.setPrice((float) (5.5 * apple.getWeight())));
        System.out.println(System.currentTimeMillis() - time + "ms");
    }

    private static void appleForTest(){
        List<Apple> apples = new ArrayList<>();
        for(int i=0;i < 100000000;i++){
            apples.add(new Apple(i));
        }
        long time = System.currentTimeMillis();
        for(Apple apple : apples){
            apple.setPrice((float) (5.5 * apple.getWeight()));
        }
        System.out.println(System.currentTimeMillis() - time + "ms");
    }

    static class Apple{
        private int weight;
        private float price;

        public Apple(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }
    }
}
