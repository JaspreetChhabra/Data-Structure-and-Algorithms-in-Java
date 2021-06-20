package Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Parent {
    int x = 5;
    void method(String a, String b, int v, float d) {
        System.out.println("parent");
    }

    void method2(String a, String b, int v) {
        System.out.println("parent");
    }

    void method3(String a, int v) {
        System.out.println("parent");
    }

    String toString(String tr){
        System.out.println("PARENT");
        return tr;
    }
}

class Child extends Parent{

//    @Override
//    void method(String a, String b, int v, float d) {
//        System.out.println("child");
//    }
//
//    //Overloading
//    //We can define a method like this
//    void method(String a, int b, int v) {
//        System.out.println("child");
//    }
//
//    void method2(String a, String b, int v) {
//        System.out.println("child");
//    }
//
//    void method3(int v, String a) {
//        System.out.println("child");
//    }

    Child(){
        System.out.println("parent");
    }
    Child(String str){
        System.out.println("parent" + str);
    }
    public void childToString(String str1){
        System.out.println("CHILD1");
        this.x = 10;
        System.out.println(super.toString(str1) + "NONALULA");

    }
}


class child2 extends Child{

    child2(){
        System.out.println("parent" + "IOIB JBUJ") ;
    }
    child2(String str){
        System.out.println("Child" + str);
    }
    public void childToString(String str1){
        super.childToString(str1);
        System.out.println(super.toString(str1) + this.x);

    }

}

public class Paren{

    public static void main(String[] args){
//        Child child = new Child();
//        Parent parent = new Parent();
//        child = (Child) parent;
//        child.method("Test", "Test", 1);
        //Exception in thread "main" java.lang.ClassCastException: class Java.Parent
        // cannot be cast to class Java.Child (Java.Parent and Java.Child are in unnamed module of loader 'app')

//        Parent paren = new Child();
//        paren.method2("Test", "Test", 1);
//        paren = parent;
//        paren.method2("Test", "Test", 1);
//
////        Child child1 = new Parent();
//        child.method2("Test", "Test", 1);
//        child.childToString("Test");

        child2 child2 = new child2("TEST");
        //child2.childToString("TEST");

        List<String> map = null;
        map.stream().forEachOrdered(System.out::println);
    }

}
