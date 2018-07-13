package ua.alexax;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CreateClassRefl {
    public static void main(String[] args) {
        MyClass myClass = null;
        try{
            Class clazz = Class.forName(MyClass.class.getName());
            Class[] params = {int.class, String.class};
            myClass = (MyClass) clazz.getConstructor(params).newInstance(1, "default2");

            //get constructor
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor constructor : constructors) {
                Class[] paramTypes = constructor.getParameterTypes();
                for (Class paramType : paramTypes) {
                    System.out.print(paramType.getName() + " ");
                }
                System.out.println();
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();

        }
        System.out.println(myClass);

    }
}
