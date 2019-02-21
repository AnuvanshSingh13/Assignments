package main;

public class Question4 {
    //WAP to create singleton class.
    private static Question4 myobj;



    private Question4() {

    }

    public static Question4 getInstance() {
        if(myobj==null){
            myobj = new Question4();

        }
        return myobj;
    }

    public void test() {
        System.out.println("Singleton class");
    }

    public static void main(String[] args) {
        Question4 m=getInstance();
        m.test();
    }
}
