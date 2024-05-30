package com.mycompany.cs2;                                                      //abstraction , polimoprisam only

import java.util.Scanner;

public class CS2 extends Cashier{
    
    //variabls 
    private char rollcon,taskno;
    private String passfile,loguser;
    private boolean loopcon,mainloop;
    
    // main method
    public static void main(String[] args) {  
        
      CS2 cs = new CS2();  //class obj
     
     do{
    // Welcome page body
     System.out.println("########################################################\n\t\t Welcome To Cosmatics Store \n\n\t\t\t LOGIN PAGE\n\tSelect Your Roll\n\t 1.Cashier\n\t 2.Manager\n\t 3.Exit" );
     
     Scanner in = new Scanner(System.in); //user input obj
     
     cs.rollcon = in.next().charAt(0);   
     
     
         
        switch(cs.rollcon)
        {
        case '1' ->
        {    
            cs.passfile = "cashier";
            
            cs.loguser = cs.login(cs.passfile);
            
            // cashier home loop
            do{
                
                cs.taskno = cs.chome(cs.loguser);
            
            switch(cs.taskno)
            {
                case '1' ->  //show database
                {     
                    cs.loopcon = cs.showdata();
                    break;
                }
                
                case '2' -> //search
                {
                   cs.loopcon = cs.searchdata();
                   break;
                }
                
                case '3' -> //stock 
                {
                    
                    Scanner sin = new Scanner(System.in);
                    
                    System.out.println("########################################################");
                    System.out.println("\t\t\tPRODUCT STOCKS");
                    
                    do{
                        System.out.print("Enter item ID :");
                        String itemID = sin.nextLine();
                        cs.loopcon = cs.searchdata(itemID);
                        
                    }while(cs.loopcon);
                    
                    cs.loopcon = true;
                    break;
                }
                case '4' -> 
                {
                    System.out.println("\n\t\tSUCCESFULLY LOGOUT !!");
                    
                    cs.loopcon = false;
                    
                    break;
                }
            }
                
            }while(cs.loopcon);
            
           cs.mainloop = true;   
           
           break;
        }
        case '2' ->         
        {
            cs.passfile ="manager";
            
            cs.loguser = cs.login(cs.passfile);
            
            do
            {
                cs.taskno = cs.home(cs.loguser);
            
                switch(cs.taskno)
                {
                
                case '1' -> {  
                    cs.logcon = cs.showdata();
                    break;
                }
                
                case '2' -> {
                    cs.loopcon = cs.searchdata();
                    break;
                }
                
                case '3' -> {
                    
                    Scanner sin = new Scanner(System.in);
                    
                    System.out.println("########################################################");
                    System.out.println("\t\t\tPRODUCT STOCKS");
                    
                    do{
                        System.out.print("Enter item ID :");
                        String itemID = sin.nextLine();
                        cs.loopcon = cs.searchdata(itemID);
                        
                    }while(cs.loopcon);
                    
                    cs.loopcon = true;
                    
                    break;
                }
                case '4' -> {
                    
                    cs.loopcon = cs.adddata();
                    break;
                }
                case '5' -> {
                   
                    
                    System.out.println("########################################################");
                    System.out.println("\t\t\tPRODUCT DATABASE");
                    
                    do
                    {
                    Scanner ain = new Scanner(System.in);
                        
                    System.out.print("\t> Item ID  : ");
                    String id = ain.nextLine();
                    System.out.print("\t> Name     : ");
                    String name = ain.nextLine();
                    System.out.print("\t> Catagory : ");
                    String cat = ain.nextLine();
                    System.out.print("\t> Price    : ");
                    float price = ain.nextFloat();
                    System.out.print("\t> Quontity : ");
                    int qt = ain.nextInt();
                    
                    cs.loopcon = cs.adddata(id, name, cat, qt, price);
                        
                    }while(cs.loopcon);
                    
                   cs.loopcon = true;
                   
                   break;
                   
                }
                case '6' -> 
                {
                    System.out.println("SUCCESFULLY LOGOUT !!");
                    
                    cs.loopcon = false;
                    
                    break;
                }
                default -> {
                    
                    System.out.println("INCORRECT TASK NO !!");
                    cs.loopcon = true;
                    
                }
                
                }
                
            }while(cs.loopcon);
            
            cs.mainloop = true;
            
            break;
        }
        case '3' -> {
            System.out.println("\t\t\tSYSTEM SHUTDOWN!!");
            cs.mainloop = false;
            
            break;
        }
        default -> {
            System.out.println("Incorrect Number!!"); 
            cs.mainloop = true;
            
            break;
        }
            
     }
      
    }while(cs.mainloop);
     
    } 
    
   
}


//no encapsulation