package JavaFiddle;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class SingletonAndHowToBreakIt implements Cloneable, Serializable{

    private static SingletonAndHowToBreakIt instance;
    private SingletonAndHowToBreakIt(){}
    public static SingletonAndHowToBreakIt getInstance() { //public static synchronized SingletonAndHowToBreakIt getInstance() for thread safe
        if(instance == null){
            instance = new SingletonAndHowToBreakIt();
        }
        return instance;
    }
//    @Override
//    protected Object readResolve() // uncomment this to overcome #2
//    {
//        return instance;
//    }


//    @Override
//    protected Object clone() throws CloneNotSupportedException { // uncomment this to overcome #1
//        throw new CloneNotSupportedException();
//    }

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        SingletonAndHowToBreakIt single = SingletonAndHowToBreakIt.getInstance();
        System.out.println(single);
        System.out.println(single.clone()); // #1 breaking singleton, Override clone() and in that throw CloneNotSupportedException

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.txt"));
        out.writeObject(single);
        ObjectInput in
                = new ObjectInputStream(new FileInputStream("file.txt"));
        SingletonAndHowToBreakIt newInstance = (SingletonAndHowToBreakIt) in.readObject(); // #2 breaking singleton through serialization and deserialization
        System.out.println(newInstance);

        Constructor constructor = SingletonAndHowToBreakIt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonAndHowToBreakIt newInstance2 = (SingletonAndHowToBreakIt)constructor.newInstance();
        System.out.println(newInstance2); // #3 breaking singleton through reflection
    }
}