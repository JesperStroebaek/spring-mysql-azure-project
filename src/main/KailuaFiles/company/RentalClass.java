package com.springmysqlazureprojectTest;

import java.sql.*;
import java.util.Scanner;

public class RentalClass {


    private String user = "kailua@kailuacarrental";
    private String password = "Gruppe4#";
    private String DATABASE_URL = "jdbc:mysql://kailuacarrental.mysql.database.azure.com:3306/kailua_car_rental";

    public void updateRentalContract()throws SQLException{
        String attributeToUpdate = attributeToUpdate();
        int ID = rentalID();
        startUpdate(attributeToUpdate,ID);}

    public void startUpdate(String attributeToUpdate, int rentalID)throws SQLException{
        Scanner scan = new Scanner(System.in);
        Connection connection = DriverManager.getConnection(DATABASE_URL,user,password);
        System.out.println("Enter the new data for the "+attributeToUpdate);
        String updatedData;
        updatedData= scan.next();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE rental_contract SET "+attributeToUpdate +
                " = '"+updatedData+"'"+
                "WHERE rental_contract_id="+rentalID+";");
        preparedStatement.executeUpdate();
        connection.close(); }

    public String attributeToUpdate(){
        Scanner scan = new Scanner(System.in);
        String attributeToUpdate = null;
        System.out.println("What do you wish to update?\n1. To Date\n2. Km driven when returned");
        int answer = scan.nextInt();
        switch (answer) {
            case 1: attributeToUpdate = "to_date"; break;
            case 2: attributeToUpdate = "km_driven_returned"; break;
        } return attributeToUpdate; }

    public int rentalID()throws SQLException{
       Scanner scan = new Scanner(System.in);
        selectRentalContracts();
        System.out.println("Enter the rental contract ID of the contract you wish to update");
        int ID = scan.nextInt();
        return ID; }

    public void addRentalContract()throws SQLException{
        System.out.println("Enter rental contract information: ");
        int customerID;
        int carID;
        String fromDate;
        String toDate;
        Scanner scan = new Scanner(System.in);
        System.out.println("Customer ID: ");
        customerID = scan.nextInt();
        System.out.println("Car ID:");
        carID = scan.nextInt();
        System.out.println("From date: ");
        fromDate = scan.next();
        System.out.println("To date: ");
        toDate = scan.next();
        Connection con = DriverManager.getConnection(DATABASE_URL, "root", "Gdk94xjs#");
        Statement statement = con.createStatement();
        statement.executeUpdate("INSERT INTO rental_contract VALUES(DEFAULT ,"+customerID+","+carID+", '"+fromDate+"', '"+toDate+"', DEFAULT)");
        con.close(); }

    public void deleteRentalContract()throws SQLException{
        Scanner scan = new Scanner(System.in);
        Connection connection = DriverManager.getConnection(DATABASE_URL,user,password);
        selectRentalContracts();
        int carID;
        System.out.println("Enter the ID of the car you wish to delete");
        carID = scan.nextInt();
        //lav en print
        Statement statement = connection.createStatement();
        String sql = ("DELETE FROM rental_contract WHERE rental_contract_id="+carID);
        statement.executeUpdate(sql);
        System.out.println("Rental contract deleted ..");
        System.out.println("Database after deletion: ");
        selectRentalContracts();
        Controller controller = new Controller();
        controller.rentalContracts(); }

   public void selectRentalContracts()throws SQLException {
   Connection connection = DriverManager.getConnection(DATABASE_URL,user,password);
   Statement statement = connection.createStatement();
   ResultSet resultSet;
   resultSet = statement.executeQuery("SELECT * FROM rental_contract");
   while (resultSet.next()) {
       String rentalContractID = resultSet.getString("rental_contract_id");
       String customerID = resultSet.getString("customer_customer_id");
       String carID = resultSet.getString("cars_car_id");
       String fromDate = resultSet.getString("from_date");
       String toDate = resultSet.getString("to_date");
       String kmDrivenReturned = resultSet.getString("km_driven_returned");
       System.out.println("rental_contract_id="+rentalContractID+" customer_id="+customerID+" carID="+carID+" from_date="+fromDate+" to_date="
               +toDate+" km_driven_when_returned="+kmDrivenReturned);
   }
   connection.close();
       System.out.println("");
   }

}
