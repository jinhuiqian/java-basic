package com.qjh;

/**
 * @author 231
 * @date 2020-07-27 15:22
 */
class Shape {
    public Shape() {
        System.out.print(" Shape ");
    }
}

    class Circle extends Shape{
        public Circle(){
            System.out.print("circle");
        }
    }

    public class Test{
        public static void main(String[] args) {
            Shape d= new Circle();
        }

    }

