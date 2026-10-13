class MyHashSet {

    private boolean[] set;

    public MyHashSet() {
        set = new boolean[1000001];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }
}

public class Main {

    public static void main(String[] args) {

        MyHashSet obj = new MyHashSet();

        // Add elements
        obj.add(10);
        obj.add(20);
        obj.add(30);

        // Check elements
        System.out.println(obj.contains(10)); // true
        System.out.println(obj.contains(15)); // false
        System.out.println(obj.contains(20)); // true

        // Remove element
        obj.remove(20);

        // Check again
        System.out.println(obj.contains(20)); // false
        System.out.println(obj.contains(30)); // true
    }
}
OUTPUT:
true
false
true
false
true
