package JavaFiddle;

import jdk.dynalink.Operation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MyClass{
    private int field1;
    private String field2;

    private void ImPrivateMethod(){
        System.out.println("Alert: I'm private method.");
    }

    public static int sum(int num1, int num2){
        return num1 + num2;
    }

    public MyClass(int field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public MyClass(){}

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public void setField1(int field1) {
        System.out.println("I was invoked");
        this.field1 = field1;
    }

    public int getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }
}

public class Reflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class someClass = new MyClass().getClass();
        // of class.forName("MyClass"); or MyClass.class.getClass();
        System.out.println(someClass.getName());
        System.out.println("Is the class primitive: " + int.class.isPrimitive());

        Method[] methods = MyClass.class.getClass().getMethods();
        for(Method method : methods){
            System.out.println(method.getName());
        }

        Constructor constructor = someClass.getConstructor(int.class, String.class);
        MyClass inst = (MyClass) constructor.newInstance(12, "Hello");
        System.out.println(inst instanceof MyClass);

        Method method = someClass.getMethod("sum", int.class, int.class);
        System.out.println(method.invoke(inst, 123,321));

        Method method2 = someClass.getDeclaredMethod("ImPrivateMethod");
        method2.setAccessible(true);
        method2.invoke(inst);

        //javap Class_name   to display information about the fields, constructors and methods present in a class file.
        //javap -c Class_name   disassembled code. The code that reflects the java bytecode.
//        -help	prints the help message.
//        -l	prints line number and local variable
//        -c	disassembles the code
//                -s	prints internal type signature
//        -sysinfo	shows system info (path, size, date, MD5 hash)
//                -constants	shows static final constants
//        -version	shows version information
    }
}
