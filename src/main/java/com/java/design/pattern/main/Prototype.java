package com.java.design.pattern.main;

/*Prototype is a creational design pattern that lets you copy existing objects without '
making your code dependent on their classes.*/

/* The concept is to copy an existing object rather than creating a new instance
 from scratch, something that may include costly operations. The existing object
 acts as a prototype and contains the state of the object. The newly copied object
 may change same properties only if required. This approach saves costly resources
 and time, especially when object creation is a heavy process.*/

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* One of the best available ways to create an object from existing objects
  is the clone() method. Clone is the simplest approach to implement a prototype pattern.
  However, it is your call to decide how to copy existing object based on your business model.*/


/*

PROTYPE = FACTORY + MAP

 */


enum RegisterType{
    A3,A4,A5;
}

@Data
class RegisterModel{
    private int noOfPages;
    private int price;

    private String facts;

    @Override
    protected RegisterModel clone() throws CloneNotSupportedException {
        RegisterModel model = new RegisterModel();
        model.noOfPages= this.noOfPages;
        model.price=this.price;
        model.facts=this.facts;
        return model;
    }
}

class RegisterFactory{

    private Map<RegisterType,RegisterModel> registerMap = new HashMap<>();

    public void addRegister(RegisterType type,RegisterModel registerModel){
        registerMap.put(type,registerModel);
    }

    public RegisterModel getRegister(RegisterType type){
        return registerMap.get(type);
    }

}


public class Prototype {

    public static void main(String[] args) throws CloneNotSupportedException {

        RegisterModel a3Register = new RegisterModel();
        a3Register.setPrice(100);
        a3Register.setNoOfPages(180);


        RegisterModel a4Register = new RegisterModel();
        a4Register.setPrice(120);
        a4Register.setNoOfPages(200);


        RegisterModel a5Register = new RegisterModel();
        a5Register.setPrice(150);
        a5Register.setNoOfPages(250);

        RegisterFactory registerFactory = new RegisterFactory();
        registerFactory.addRegister(RegisterType.A3,a3Register);
        registerFactory.addRegister(RegisterType.A4,a4Register);
        registerFactory.addRegister(RegisterType.A5,a5Register);

        //creating 50 a4 register from existing model with some xyz facts
        List<RegisterModel> a4XYZFactsRegister = new ArrayList<>();
        for(int i=0;i<50;i++){
            RegisterModel registerModel =  registerFactory.getRegister(RegisterType.A4).clone();
            registerModel.setFacts("xyz unknown facts");
            a4XYZFactsRegister.add(registerModel);
        }

        //creating 25 a4 register from existing model with some mno facts
        List<RegisterModel> a4MNOFactsRegister = new ArrayList<>();
        for(int i=0;i<25;i++){
            RegisterModel registerModel =  registerFactory.getRegister(RegisterType.A4).clone();
            registerModel.setFacts("mno unknown facts");
            a4MNOFactsRegister.add(registerModel);
        }

        System.out.println(a4XYZFactsRegister.size() + " "+ a4XYZFactsRegister);
        System.out.println(a4MNOFactsRegister.size()+" "+ a4MNOFactsRegister);





    }
}
