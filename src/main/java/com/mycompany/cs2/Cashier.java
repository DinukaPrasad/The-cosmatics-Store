package com.mycompany.cs2;

import java.util.Scanner;



public class Cashier extends manager {
    
    // variables
    protected char dashcon;
    

    

     public char chome(String uname)
    {
        boolean x = true;
        
        Cashier cs = new Cashier();
        Scanner in = new Scanner(System.in);
              
        System.out.println("########################################################");
        System.out.println("\t\t\tCASHIER DASHBOARD\n");
        System.out.println("Have a nice day "+uname.toUpperCase()+" !");
        
        System.out.println("\n\t1) Product Database\n\t2) Search Item\n\t3) Stock\n\t4) Logout");
        
        do{
            System.out.print("\n>> Enter Task No : ");
            cs.taskcon = in.next().charAt(0);
            
            if(cs.taskcon == '1' || cs.taskcon == '2' || cs.taskcon == '3'|| cs.taskcon == '4')
            {
                
                return cs.taskcon;
            }
            else
            {
                System.out.println("\nINCORRECT TASK NO !!!");
                x = false;
            }
        
        
        }while(!(x));
        
        return '0';
    }   
}
