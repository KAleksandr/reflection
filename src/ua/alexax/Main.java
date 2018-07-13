package ua.alexax;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass(5, "Peter");
        int number = myClass.getNumber();
        String name = null; // no getName
        System.out.println(number + " " + name);
        System.out.println(myClass);
        printData(myClass);
        try{
            Field field = myClass.getClass().getDeclaredField("name");
            field.setAccessible(true);
            field.set(myClass,(String)"New name");
            name = (String) field.get(myClass);

        }
        catch (NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
        }
        System.out.println(number + " " + name);
        System.out.println(myClass);
        printData(myClass);

        System.out.println(MyClass.class.getName());

    }
    public static void printData(Object myClass){

        try {
            Method method = myClass.getClass().getDeclaredMethod("printData");
            method.setAccessible(true);
            method.invoke(myClass);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
