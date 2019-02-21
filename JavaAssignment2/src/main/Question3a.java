package main;

public class Question3a {
    //WAP to produce NoClassDefFoundError and ClassNotFoundException exception.
    public static void main(String[] args) {
        try {
            Class.forName("NoClassDefFoundError");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
