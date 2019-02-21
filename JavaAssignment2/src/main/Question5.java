package main;

public class Question5 implements Cloneable {
    int rollno;
    String name;

    Question5(int rollno,String name){
        this.rollno=rollno;
        this.name=name;
    }

    public Question5(Question5 obj) {
        rollno=obj.rollno;
        name=obj.name;
    }

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

    public static void main(String args[]){
        try{
            Question5 s1=new Question5(101,"amit");

            Question5 s2=(Question5)s1.clone();

            System.out.println(s1.rollno+" "+s1.name);
            System.out.println(s2.rollno+" "+s2.name);
            Question5 s3=new Question5(s1);
            s3.showData();


        }catch(CloneNotSupportedException c){}

    }

    private void showData() {
        System.out.println(rollno+" "+name);

    }
}
