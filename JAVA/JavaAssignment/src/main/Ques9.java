package main;

public class Ques9 {
    public static void main(String[] args) {
        new Ques9();
    }
    private  Ques9(){
        System.out.println("All housing prices are: ");
        for(House house : House.values()){
            System.out.println(house +" will cost " + house.getPrice()+ " rupees");
        }

    }
}
enum House{
    House_4BHK(20000),
    House_3BHK(15000),
    House_2BHK(10000),
    House_1BHK(5000);

    private int price;
    House(int p){
        price=p;
    }
    int getPrice(){
        return price;
    }
}