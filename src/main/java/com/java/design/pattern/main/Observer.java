package com.java.design.pattern.main;



//There is an observable with property and behaviours and there are multiple observers(who have subscribed to observable) , if there is
//state change in observable then observers will perform some task i.e act as notifiers

//Observers can opt to be notified or can unsubscribe

//or we can say, when there is some change, we have to send the notification to other devices/classes/functionalities

//Will create Bitcoin class, whenever there is change in bitcoin price, will notify the user
// via email, buy some more bitcoin and tweet for the change

import java.util.ArrayList;
import java.util.List;

interface Subject{
    //to add observers to the observer list
    public void attach(ObserverI observer);

    //to remove observers from the observer list
    public void detach(ObserverI observer);

    //notify() to publish all the changes made by the subject
    public void notify(int priceChange);
}

interface ObserverI{

    // update() to inform all the observer about the changes in the subject i.e bitcoinPriceChange
    public void update(int  newBitcoinPrice);
}
class Bitcoin implements Subject{

    private List<ObserverI> observers = new ArrayList<>();

    public void attach(ObserverI observer){
        observers.add(observer);
    }

    public void detach(ObserverI observer){
        observers.remove(observer);
    }

    public void notify(int newBitcoinPrice){
        for(ObserverI observer : observers){
            observer.update(newBitcoinPrice);
        }
    }

    public void changeInPrice(int newBitcoinPrice){
        System.out.println();
        System.out.println("Bitcoin new Price: "+newBitcoinPrice);
        System.out.println("*********************Notifying the subscribers********************");
        notify(newBitcoinPrice);
    }
}

class Tweet implements ObserverI{

    @Override
    public void update(int newBitcoinPrice) {
        System.out.println("Tweeting about the new price change:"+newBitcoinPrice);
    }
}

class SendEmailToUser implements ObserverI{

    @Override
    public void update(int newBitcoinPrice) {
        System.out.println("Emails are being sent to subscribed users for new price:"+newBitcoinPrice);
    }
}

class BuyBitcoins implements ObserverI{

    @Override
    public void update(int newBitcoinPrice) {
        System.out.println("Buying more bitcoins at the new price:"+newBitcoinPrice);
    }
}

public class Observer {

    public static void main(String[] args) throws InterruptedException {
        BuyBitcoins buyBitcoins  = new BuyBitcoins();
        Tweet tweet = new Tweet();
        SendEmailToUser sendEmailToUser = new SendEmailToUser();

        Bitcoin bitcoin = new Bitcoin();
        bitcoin.attach(buyBitcoins);
        bitcoin.attach(tweet);
        bitcoin.attach(sendEmailToUser);

        for(int i=0;i<=100;i++) {
            bitcoin.changeInPrice(1580000+1000*i);
            Thread.sleep(4000);
        }


    }

}
