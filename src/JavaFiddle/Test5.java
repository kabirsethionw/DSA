package JavaFiddle;

interface A{
    void a();
    void b();
    void c();
    void d();
}

abstract class B implements A{
    public void c(){System.out.println("I am c");}
}

class M extends B{
    public void a(){System.out.println("I am a");} // here we don't need to implement c() as it is being implemented by class B
    public void b(){System.out.println("I am b");}
    public void d(){System.out.println("I am d");}
}

class Test5{

    public static void main(String args[]){
        A a=new M();
        a.a();
        a.b();
        a.c();
        a.d();

    }
}
