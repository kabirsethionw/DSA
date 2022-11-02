package JavaFiddle;

public class DataTypes {
    public static void main(String[] args) {
        int a = 100;
        long b = 123432;
        System.out.println(b);
        //a = (int)b;
        double c = 1.4566876f;
        a = (int)c;

        String s1 = new String("Hello World");
        String s2 = "Hello World";
        System.out.println("The two strings point to the same SCP literal: " + (s1.intern().hashCode() == s2.hashCode()));
        System.out.println("Comparing using equals: " + (s1.equals(s2)));
        s2.concat(" Of Java");
    }
}
