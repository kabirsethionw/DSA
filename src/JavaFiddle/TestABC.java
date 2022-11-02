package JavaFiddle;

import java.util.ArrayList;

class MyEntry{
    public MyEntry(int key, int value) {
        this.key = key;
        this.value = value;
    }

    int key;
    int value;
}

public class TestABC {
    private int size;
    private Object[] enteries;

    TestABC(int size){
        this.size = size;
        enteries = new Object[size];
    }

    private int getHash(int key){
        return key%this.size;
    }

    public void add(int key, int value){
        int index = getHash(key);
        MyEntry entry = new MyEntry(key, value);
        if(enteries[index] == null){
            enteries[index] = entry;
        }
        else if(enteries[index] instanceof  MyEntry){
            // make arrayList
            ArrayList<MyEntry> list = new ArrayList<>();
            MyEntry oldEntry = (MyEntry) enteries[index];
            list.add(oldEntry);
            list.add(entry);
            enteries[index] = list;
        }
        else {
            ArrayList<MyEntry> list = (ArrayList<MyEntry>) enteries[index];
            list.add(entry);
            //enteries[index] = list;
        }

    }

    public int get(int key){
        int index = getHash(key);
        if(enteries[index] == null){
            return -1;
        }
        else if(enteries[index] instanceof MyEntry){
            MyEntry elem = (MyEntry)enteries[index];
            return elem.value;
        }
        else{
            ArrayList<MyEntry> list = (ArrayList<MyEntry>) enteries[index];
            //System.out.println(list.size());
            for(MyEntry elem: list){
                int key1 = elem.key;
                if(key1 == key){
                    return elem.value;
                }
            }
        }
        return -1;

    }

    public int getSize(){
        return this.size;
    }

    public static void main(String[] args) {
        TestABC map = new TestABC(10);
        map.add(6, 100);
        //
        map.add(16,200);
        System.out.println(map.get(6));
    }
}
