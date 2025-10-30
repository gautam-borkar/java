package example;

public class Singleton {
    private static Singleton instance = null;

    private Singleton(){
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class){
            instance = new Singleton();
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        Singleton s1 = Singleton.getInstance();

        if (s == s1){
            System.out.println("Singleton");
        }
    }
}