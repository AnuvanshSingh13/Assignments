package main;

public class Ques8 {
    public static void main(String[] args) {
        StringBuffer str= new StringBuffer("IndiaIsMyCountry");
        System.out.println("original String = " + str);
        str.reverse();
        System.out.println("reverse String " + str);
        str.delete(4,10); //Delete the index from  specified start and extends to the character at index end-1
        System.out.println("Deleted String From index 4 to 9: "+str);
    }
}
