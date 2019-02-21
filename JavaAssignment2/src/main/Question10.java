package main;

import java.util.LinkedList;
import java.util.Queue;

public class Question10 {
    /*
      Design classes having attributes and method(only skeleton) for a coffee shop. There are three different actors in
      our scenario and i have listed the different actions they do also below

    * Customer
      - Pays the cash to the cashier and places his order, get a token number back
      - Waits for the intimation that order for his token is ready
      - Upon intimation/notification he collects the coffee and enjoys his drink
                ( Assumption:  Customer waits till the coffee is done, he wont timeout and cancel the order.
                Customer always likes the drink served. Exceptions like he not liking his coffee,
                he getting wrong coffee are not considered to keep the design simple.)

    * Cashier
      - Takes an order and payment from the customer
      - Upon payment, creates an order and places it into the order queue
      - Intimates the customer that he has to wait for his token and gives him his token
                ( Assumption: Token returned to the customer is the order id.
                Order queue is unlimited. With a simple modification, we can design for a limited queue size)

    * Barista
     - Gets the next order from the queue
     - Prepares the coffee
     - Places the coffee in the completed order queue
     - Places a notification that order for token is ready
    */

    public static void main(String[] args) {
        System.out.println("Welcome in Coffee Shop");
        Customer.createOrder();     //making customer to create an order
    }
}

class Customer {
    /*Customer
      - Pays the cash to the cashier and places his order, get a token number back
      - Waits for the intimation that order for his token is ready
      - Upon intimation/notification he collects the coffee and enjoys his drink
            ( Assumption:  Customer waits till the coffee is done, he wont timeout and cancel the order.
                    Customer always likes the drink served. Exceptions like he not liking his coffee,
              he getting wrong coffee are not considered to keep the design simple.)*/

    private static double balance = 1000d;   //assuming that customer had balance of 1000 units

    private static void payCash(int amount) {
        balance = balance - amount;
    }

    static void createOrder() {
        //lets assume that customer places an order for itemId=2 having amount=120
        payCash(120);       //paying amount
        int orderId = Cashier.takeOrder(2, 120);      //making an order to cashier and receiving orderId
        System.out.println("Your Order No: " + orderId + " is being prepared");
        if (orderId != -1)      //orderId is -1 only for failed transactions
            Barista.getOrder(orderId);     //upon successful order process, Barista gets the order and initiates its process
    }

    static void collectCoffee(int itemId, int ordreId) {
        //collect coffee having item id equal to 'itemId'
        Barista.completeOrderQueue.poll();
        System.out.println("Order no " + ordreId + " for item no: " + itemId + " has been collected");

    }

}

class Cashier {
    /*Cashier
      - Takes an order and payment from the customer
      - Upon payment, creates an order and places it into the order queue
      - Intimates the customer that he has to wait for his token and gives him his token
            ( Assumption: Token returned to the customer is the order id.
                    Order queue is unlimited. With a simple modification, we can design for a limited queue size)*/

    private static int orderId = 0;
    private static double income = 0;

    static int takeOrder(Integer itemId, double amount) {
        if (amount > 0) {
            //when payment is received successfully it adds the item in the orderQueue
            income = income + amount;
            Barista.orderQueue.add(itemId);
            //generating token for orderId
            return generateToken();     //returns order id for successfully placed order using generateToken()
        } else
            return -1;   //orderId value -1 corresponds to payment failure
    }

    private static int generateToken() {
        return ++orderId;
    }

}

class Barista {
   /* Barista
     - Gets the next order from the queue
     - Prepares the coffee
     - Places the coffee in the completed order queue
     - Places a notification that order for token is ready*/

    private static boolean coffeeIsPrepared = false;
    static Queue<Integer> orderQueue = new LinkedList<>();
    static Queue<Integer> completeOrderQueue = new LinkedList<>();

    static void getOrder(int orderId) {
        prepareCofee(orderQueue.peek(), orderId);
        //looking for next order in the queue
        //preparing order
    }


    private static void prepareCofee(int itemId, int orderId) {
        coffeeIsPrepared = true;  //let's assume that coffee is prepared
        if (coffeeIsPrepared) {
            sendNotification(itemId, orderId);     //send notification when coffee is prepared
            orderQueue.remove();    //removes item from order queue
            completeOrderQueue.add(itemId);     //adding complete order to its queue
        }
    }

    private static void sendNotification(int itemId, int orderId) {
        //sends a notification to user
        System.out.println("Order no " + orderId + " for item no: " + itemId + " is ready");
        Customer.collectCoffee(itemId, orderId);
    }
}