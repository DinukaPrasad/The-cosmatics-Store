package com.mycompany.cs2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class manager implements Function {
    
    protected char taskcon;
    protected int srccon;
    protected String id,pass,srcword;
    protected boolean logcon,found,loop;
    
    @Override
    public char home(String uname){
        
        boolean x = true;
        
        manager mg = new manager();
        Scanner in = new Scanner(System.in);
              
        System.out.println("########################################################");
        System.out.println("\t\t\tMANAGER DASHBORD\n");
        System.out.println("Have a nice day "+uname.toUpperCase()+" !");
        
        System.out.println("\n\t1) Product Database\n\t2) Search Item\n\t3) Stock\n\t4) Create ID\n\t5) Add New Product\n\t6) Logout");
        
        do{
            System.out.print("\n>> Enter Task No : ");
            mg.taskcon = in.next().charAt(0);
            
            if(mg.taskcon == '1' || mg.taskcon == '2' || mg.taskcon == '3' || mg.taskcon == '4' || mg.taskcon == '5' || mg.taskcon == '6')
            { 
                return mg.taskcon;
            }
            else
            {
                System.out.println("\nIncorrect task ID !!!");
                x = false;
            }
        
        
        }while(!(x));
        
        return '0';
    }
    
    
    @Override
    public String login(String roll){
        
        //objects
        Scanner in = new Scanner(System.in);
        manager mg = new manager();
        
        do
        {
            System.out.println("########################################################");
            System.out.println("\t\t\t"+roll.toUpperCase()+" VERIFICATION\n");

            //user inputs
            System.out.print("\t>> Employee ID : ");
            mg.id = in.nextLine();
            System.out.print("\t>> Password : ");
            mg.pass = in.nextLine();
        
            //file obj
            File file = new File("C:\\Users\\Beast_99\\Documents\\NetBeansProjects\\CS2\\src\\main\\java\\com\\mycompany\\id\\"+roll+"\\"+mg.id+".txt");
                
            //password cheker    
                try{
                try (Scanner reader = new Scanner(new FileReader(file))) {
                    String L1 = reader.nextLine();
                    String L2 = reader.nextLine();
                    
                    if(mg.pass.equals(L1))
                    {
                        mg.logcon = true;
                        System.out.println("\n\tLOGIN SUCCESSFULL !");
                        return L2;
                    }
                    else
                    {
                        mg.logcon = false;
                        System.out.println("\n\tPASSWORD INCORRECT !!!");
                    }
                }
                
                }catch(IOException e){
                    System.out.println("\n\tINCORRECT USER ID !!! ");
                }    
        }while(!(mg.logcon));   // login loop
        
        return "----";
    }
    
    
    @Override
    public boolean showdata()
    {
        manager mg = new manager(); // class obj
        String[] line = new String[5];
        Scanner in = new Scanner(System.in);
        
        System.out.println("########################################################");
        System.out.println("\t\t\tPRODUCT DATA BASE\n");
        System.out.println("| ID | CATEGORY | PRICE | NAME |");
        
        try{
            try (Scanner rd = new Scanner(new FileReader (mg.prodpath))) {
                while(rd.hasNextLine())
                {
                    line[0] = rd.next();
                    line[1] = rd.next();
                    line[2] = rd.next();
                    line[3] = rd.next();
                    line[4] = rd.next();
                    
                    System.out.println(" "+line[0] + "\t" + line[1] +"\t"+ line[2]+"\t"+ line[4]);
                }
                rd.close();
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
        
        return true;
        
    }
    
    
    @Override
    public boolean searchdata()
    {
        
        manager cs = new manager();
        Scanner in = new Scanner(System.in);
        
        System.out.println("########################################################");
        System.out.println("\t\t\tSEARCH OPTION\n");
        
        do{
            System.out.println("\t1) Name\n\t2) Price\n\t3) Category");
            cs.srccon = in.nextInt();

                //get inputs
                Scanner name = new Scanner(System.in);
                
                //file reader
                File file = new File(cs.prodpath);
                
                try{
                    String[] word = new String[5];
                    int resultno = 0;
                   
                    System.out.print("\tSearch : ");
                    cs.srcword = name.nextLine();
                    
                    Scanner scn = new Scanner(new FileReader(file));
                    
                    while(scn.hasNextLine())
                    {
                        word[0] = scn.next();
                        word[3] = scn.next();
                        word[2] = scn.next();
                        word[4] = scn.next();
                        word[1] = scn.next();
                        
                        
                        if(cs.srcword.equals(word[cs.srccon]))
                        {
                            resultno++;
                            cs.found = true ;
                            System.out.println("\nResult "+resultno+":"+" # ID       - "+word[0]+
                                                              "\n\t  # Name     - "+word[1]+
                                                              "\n\t  # Price    - "+word[2]+
                                                              "\n\t  # Category - "+word[3]+
                                                              "\n\t  # Quantity - "+word[4]); 
                        }
                    }
                    scn.close();
                    
                }catch(Exception e){
                    System.out.println("");
                    
                }
        
            // Check Item found status 
            if(cs.found == false )
            { 
                System.out.println("Item Not Found !!!");
            }
            else
            {
                System.out.println("Item Found !!!");           
            }
            
            // research condition
            Scanner src = new Scanner(System.in);
            System.out.println("\n\t# Research\n  Yes(y) No(n)");
            char resrc = src.next().charAt(0);
            
            if(resrc == 'y' || resrc == 'Y')
            {
               cs.loop = true;
            }
            else
            {
                cs.loop = false;
                return true;
            }
        }while(cs.loop);
        
        return false;
    }
    
    public boolean searchdata(String itemID)
    {
        manager mg = new manager(); // class obj
        Scanner in = new Scanner(System.in);
        
        try{ 
            
          String[] line = new String[5];  // catch txt values
  
          Scanner stock = new Scanner(new FileReader(mg.prodpath)); // file reader
          
            while(stock.hasNextLine() && mg.found == false)
            {
                line[0] = stock.next();
                line[1] = stock.next();
                line[2] = stock.next();
                line[3] = stock.next();
                line[4] = stock.next();
                
                if(itemID.equals(line[0]))
                {
                    System.out.println("\t# Name   - "+ line[4] + "\n\t# Quontity - " + line[3] );
                    mg.found = true;
                }
            }
        }catch(Exception e){
            
            System.out.println(e);
        }
        
        if(mg.found == false )
        { 
            System.out.println("INCORRECT ITEM ID !");
        }
        
        System.out.println("\n\t# Research\n  Yes(y) No(n)");
            char resrc = in.next().charAt(0);
            
            if(resrc == 'y' || resrc == 'Y')
            {
               
               return true;
            }
            else
            {
          
                return false;
            }
        
    }
    
    @Override
    public boolean adddata()
    {
        String uid,upass,roll,name;
        
        manager mg = new manager();
        Scanner in = new Scanner(System.in);
        
        System.out.println("########################################################");
        System.out.println("\t\t\tID CREATE PAGE");
        
        do
        {
            System.out.print("\t> Job roll : ");
        roll = in.nextLine();
        System.out.print("\t> Name : ");
        name = in.nextLine();
        System.out.print("\t> user ID : ");
        uid = in.nextLine();
        System.out.print("\t> Password : ");
        upass = in.nextLine();
        
        // write data
        try{
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(mg.idpth+roll+"\\"+uid+".txt",true))) {
                writer.write(upass);
                writer.newLine();
                writer.write(name);
                System.out.println("Account Create Successfull!!");
                
                writer.close();
            }
            
        }catch(IOException e){
            System.out.println(e);
        }
            
            Scanner con = new Scanner(System.in);
            System.out.println("1) Create new ID    2) Exit");
            char conx = con.next().charAt(0);
            
            if(conx == '1')
            {
                mg.loop = true;
            }
            else
            {
                mg.loop = false;
                return true;
            }
            
        }while(mg.loop);
        
        return false;   
    }
    
    public boolean adddata(String id,String name,String cat,int qt ,float price)
    {        
        manager mg = new manager();   //clss obj
        Scanner in = new Scanner(System.in);   //input obj
        
        try{
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(mg.prodpath,true))) {
                writer.newLine();
                writer.append(id+" "+cat+" "+price+" "+qt+" "+name);
                System.out.println("Successfull!!\n");
                writer.close();
            }
            
        }catch(IOException e){
            System.out.println(e);
        }
        
        System.out.println("1) Add New Item   2) Exit");
            char resrc = in.next().charAt(0);
            
            if(resrc == '1')
            {
               
               return true;
            }
            else
            {
          
                return false;
            }
    
    }
    

            
}
