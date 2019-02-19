package main;

public class Ques4 {
    
    public static void main(String[] args) {
        charecterpercentage("Train Runs @ Speed Of 100 km/hour in our Country.");
        
    }

    private static void charecterpercentage(String s) {
        int charecter= s.length();

        int uppercase=0;
        int lowercase=0;
        int digits=0;
        int others=0;
        for(int i=0;i<s.length();i++){
            Character ch=s.charAt(i);

            if(Character.isUpperCase(ch)){
                uppercase++;
            
            }else if(Character.isLowerCase(ch)){
                lowercase++;

            }else if(Character.isDigit(ch)){
                digits++;

            }else{
                others++;
            }
        }
        double upperper=(uppercase*100.0)/charecter;
        double lowerper=(lowercase*100.0)/charecter;
        double digitper=(digits*100.0)/charecter;
        double otherper=(others*100.0)/charecter;
        System.out.println("In String the percentage of ");
        System.out.println("uppercase "+upperper+"%");
        System.out.println("lowercase "+lowerper+"%");
        System.out.println("digit "+digitper+"%");
        System.out.println("others "+otherper+"%");




    }
}
