package JavaFiddle;

import java.util.*;
import java.util.stream.Collectors;

class CustomException extends Exception{
    public CustomException(String str){
        super(str);
    }
}
interface MyInterface{
    default void funny(){System.out.println("interface here");}
    void funny1();
}

class myClass implements MyInterface{

    @Override
    public void funny1() {

    }
}

class ClassA{
    ClassA fun(){
      return this;
    }

    public void test() {
        System.out.println("ClassA");
    }
}

class ClassB extends ClassA{
    ClassB fun(){
        return this;
    }

    public void test() {
        System.out.println("ClassB");
    }
}

class ClassC extends ClassA{
    ClassA fun(){
        return this;
    }

    protected void finalize(){System.out.println("object is garbage collected");}

    public void test() throws ArithmeticException {
        System.out.println("ClassC");
    }
}

class ClassWithPvtMember {
    private int sample;

    public int getSample() {
        return sample;
    }

    public void setSample(int sample) {
        this.sample = sample;
    }

    private void testMe(){
        System.out.println("Please Test.");
    }
}

class ClassWithPvtMemberChild extends ClassWithPvtMember{
    public void sampleMethod(){
//        super.testMe();
//        System.out.println(super.sample);
    }
}

class Parent {
    public static void foo(){
        System.out.println("foo in Parent");
    }
    public void bar(){
        System.out.println("bar in Parent");
    }
}

class Child extends  Parent{
    public static void foo(){
        System.out.println("foo in Child");
    }
    public void bar(){
        System.out.println("bar in Child");
    }
}

public class Fiddle {

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();//Creating arraylist
        list.add(1);//Adding object in arraylist
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());

        }

        System.out.println(list.stream().mapToInt(i -> i).toArray()[1]);
        int[] arr = {1,2,3,4,5,6};
        Arrays.asList(1,2,3,4,5,6).stream().map(x->x*x).collect(Collectors.toSet());
        //Arrays.stream(arr).map(i->i*i).collect(Collectors.);
        list.stream().filter(i -> i != null).mapToInt(Integer::intValue).toArray();
        LinkedList<String> list2 = new LinkedList<String>();
        list2.add("1");
        list2.add("3");
        list2.add(1,"2");
        System.out.println(list2.stream().mapToInt(Integer::parseInt).toArray()[1]);
        ClassB test = (new ClassB().fun());
        ClassA c = new ClassA();
        c.test();
        System.gc();
        //throw new CustomException("Testing Exception");

        ClassA A = new ClassB();
        A.test();

        Parent par = new Child();
        Child chi = new Child();
        par.foo();
        chi.foo();
        par.bar();
        chi.bar();
    }
}
