package DesignPatterns;

/**
 * Created by sasanka on 9/19/16.
 */
class Singleton {
    private static Singleton object;

    private Singleton() {
    }

    static Singleton get() {
        if (object == null) {
            object = new Singleton();
        }

        return object;
    }
}

class Test {
    public static void main(String args[]) {
        Singleton s = Singleton.get();
    }
}

