package com.springmysqlazureprojectTest;

public class UI {

    public void menuFINAL(){
        //power point, RENTAL CONTRACT, CAR, 
    }

    public void selectDatabase(){
        printString("\n \n SELECT DATABASE:\n1. CARS\n2. CUSTOMERS\n3. RENTAL CONTRACTS \n9. BACK"); }

    public void rentalDeals(){
        printString("\n1. PRINT RENTAL CONTRACTS \n2. ADD CONTRACTS DEAL\n3. UPDATE RENTAL CONTRACTS\n4. DELETE RENTAL CONTRACTS" +
                "\n9. BACK");
    }

    public void customers(){
        printString("\n1. PRINT CUSTOMERS \n2. ADD CUSTOMER\n3. UPDATE CUSTOMER INFORMATION\n4. DELETE CUSTOMER\n9. BACK");
    }

    public void updateCustomer(){
        printString("What do you wish to update?\n1. zip code\n2. city\n3. phone\n4. email");
    }

    public void updateCar(){
        printString("What do you wish to update?\n1. km driven\n2. availability\n3. leather seats\n4. air condition");
    }

    public void cars(){
        printString("\n1. PRINT CARS \n2. ADD CAR\n3. UPDATE CAR INFORMATION\n4. DELETE CAR\n9. BACK");
    }

    public String printString(String s){
        System.out.println(s);
        return s;
    }

}
