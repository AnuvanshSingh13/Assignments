package main;

public class Ques11 {public static void main(String[] args) {
       /* Create 3 sub class of bank SBI,BOI,ICICI all 4 should have method called getDetails which provide there
         specific details like rateofinterest etc,print details of every banks*/

    System.out.println("Bank Name: N/A\nRate of interest: " + new Bank().getDetails().getRateOfInterest());
    //fetching detail for all bank general rates
    System.out.println("Bank Name: ICICI\nRate of interest: " + new ICICI().getDetails().getRateOfInterest());
    //fetching detail for ICICI bank rates
    System.out.println("Bank Name: BOI\nRate of interest: " + new BOI().getDetails().getRateOfInterest());
    //fetching detail for BOI bank rates
    System.out.println("Bank Name: SBI\nRate of interest: " + new SBI().getDetails().getRateOfInterest());
    //fetching detail for SBI bank rates
}
}
class Bank {
    Float rateOfInterest;

    public float getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(Float rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    Bank getDetails() {
        Bank bank = new Bank();
        bank.setRateOfInterest(3.0f);   //setting rate of 3.0%
        return bank;
    }
}class SBI extends Bank {
    Float rateOfInterest;

    public float getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(Float rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    Bank getDetails() {
        Bank bank = new SBI();
        ((SBI) bank).setRateOfInterest(4.0f);       //setting rate of 4.0%
        return bank;
    }
}class BOI extends Bank {

    Float rateOfInterest;

    public float getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(Float rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    Bank getDetails() {
        Bank bank = new BOI();
        ((BOI) bank).setRateOfInterest(4.3f);       //setting rate of 4.3%
        return bank;
    }
}

class ICICI extends Bank {
    Float rateOfInterest;

    public float getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(Float rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    Bank getDetails() {
        Bank bank = new ICICI();
        ((ICICI) bank).setRateOfInterest(4.5f);     //setting rate of 4.5%
        return bank;
    }
}
