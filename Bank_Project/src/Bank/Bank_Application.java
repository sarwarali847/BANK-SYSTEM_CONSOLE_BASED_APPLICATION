package Bank;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Bank_Application{
	
	
	ArrayList<Bank> data=new ArrayList<Bank>();
	Scanner sc=new Scanner(System.in);
	private String username;
	private String password;
	private String contact;
	private double deposit,deposit2,amnt_transfer;
	private double deposite_temp,Initial_deposit=0;
	LocalDate date1,date2,date3;
	LocalTime time1,time2,time3;
    private double credit;
    private  String name;
    private String add;
    private String payee_user1,payee_user2;
    private int f2=0,f3=0;
    int count=0;
    
	
	 
	 
	//Register
	void register() throws IOException{
		 
		String cont;
		String uname;
		String pname;
		System.out.println();
		System.out.print("Enter name:");
		name=sc.next();
		System.out.print("Enter address:");
		add=sc.next();
		boolean d=false;
		
		while(d==false) {
		System.out.print("Enter contact:");
		cont=sc.next();
		String exp4="\\d{10}";
		d=cont.matches(exp4);
		if(d==false)
		{
			System.err.println("Enter contact again!");
		}
		contact=cont;
	    }
		
		boolean b2=false,b1=false;
		
		while(b2==false) {	
		System.out.print("Set username : ");
		uname=sc.next();
		String exp1="\\D{1,}";
		b2=uname.matches(exp1);
		if(b2==false)
			System.err.println("Enter username again!");
		username=uname;
		
		}
		while(b1==false)
		{
		
		System.out.print("Set a password (minimum 8 chars; minimum 1 digit, 1 lowercase, 1 \r\n"
				           + "uppercase, 1 special character[!@#$%^&*_]) :");
		pname=sc.next();
		String ex2="\\w{1,8}\\W{1}\\d{1,4}";
	    b1=pname.matches(ex2);
	    if(b1==false)
	    	System.err.println("Enter password again!");
	    password=pname;
		}

	//Initial Deposit
		
	 System.out.print("Enter initial deposit:");
	 Initial_deposit=sc.nextDouble();
	 LocalDate d1 = LocalDate.now(); 
	 date1=d1;
	 LocalTime t1 = LocalTime.now();
	 time1=t1;
	 count++;
	 deposit=Initial_deposit;
	 deposit2=Initial_deposit;
	 System.out.println();
	 
	 data.add(new Bank(name,add,contact,username,password, deposit));
	 
	 System.out.println((name)+" , Registration Successful....... ");
	 
	 //String details in file
	 
	 File file1=new File("Files/data.db");
		BufferedWriter br=new BufferedWriter(new FileWriter(file1,true));
	    for(Bank val:data)
	    {
		  br.write(String.valueOf(val));
		  br.newLine();
		}
		
		br.close();
	 
	
	} 
	 //Deposit
	 void deposit_() {
		 double depo;
		 Scanner sc3=new Scanner(System.in);
		 System.out.print("Enter amount:");
		 depo=sc.nextDouble();
		 System.out.println("Rs. "+depo+" deposited successfully..");
		 credit=depo; 
		 f3=1;
		 deposit=deposit2+depo;
		 LocalDate d2 = LocalDate.now(); 
		 date2=d2;
		 LocalTime t2 = LocalTime.now();
		 time2=t2;
	 }
	 
	 //Transfer
	 void transfer() {
		 
		 Scanner sc4=new Scanner(System.in);
		 double amnt_transfer;
		 //String payee_user1, payee_user2;
		 System.out.print("Add payee:");
		 payee_user1=sc4.nextLine();
		 System.out.println(payee_user1+", Added successfully!");
		 System.out.print("Enter payee user name:");
		 payee_user2=sc4.nextLine();
		 if(payee_user1.equals(payee_user2))
		 {
			 System.out.print("Enter amount to transfer:");
			 amnt_transfer=sc4.nextDouble();
			 if(amnt_transfer>deposit)
				 System.out.println("Insufficent amount!");
			 else
			 {
			 System.out.println(amnt_transfer+", Transferred to "+payee_user1+" successfully.");
			 deposit2=amnt_transfer;
			 deposit=deposit-amnt_transfer;
			 f2=1;
			 LocalDate d3 = LocalDate.now(); 
			 date3=d3;
			 LocalTime t3 = LocalTime.now();
			 time3=t3;
			 }
		 }
		 else
		 {
			 System.out.println("Username doesn't exist.");
		 }
		 
	
	 }
	 

	//History
	 void history() {
		
		 if(f3==1)
		 {
		 System.out.println("Rs. "+credit+" credited to your account. Balance -Rs. "+deposit+" as on "+date2+" at "+time2);
		 }
		 if(f2==1)
		 {
		 System.out.println("Rs. -"+deposit2+" Transferred to "+payee_user1+". Balance -Rs. "+deposit+" as on "+date3+" at "+time3);
		 }
		 
		 System.out.println("Initial Deposit - Rs. "+deposit2+" as on "+date1+" at "+time1);
		 
	 }
	 
	 //Shoe Balance
	 
	 void balance() {
		 System.out.println("Available amount Rs "+deposit+".");
	 }
	 
	 
	 //User information
	 void userInformation() {
		 boolean b3=false;
		 String pass ="";
		 while(b3==false)
			{
			System.out.print("Enter Password:");
			sc.nextLine();
			pass=sc.nextLine();
			String ex3="\\w{1,8}\\W{1}\\d{1,4}";
		    b3=pass.matches(ex3);
		    if(b3==false)
		    	System.err.println("Enter password again!");
			}
	 
	    for(Bank val:data)
	    {  
	    	
	    	if(password.equals(val.password_))
	    	{
	    		System.out.println(val);
	    		break;
	    	}
	    		
	    }
		
	 
	 
	 }
	 
	 
	 //Database
	 void dataBase() {
		 Iterator<Bank> db=data.iterator();
		 while(db.hasNext())
		 {
			 System.out.println(db.next());
		 }
	 }
	 
	 //Update
	 
	void change_address(){
		Scanner sc=new Scanner(System.in);
		String add2;
		System.out.println("Enter new address:");
		add2=sc.nextLine();
		add=add2;
	}
	
	void change_contact() {
		Scanner sc=new Scanner(System.in);
		String contact2;
       boolean d=false;
		while(d==false) 
		{
		System.out.print("Enter new contact:");
		contact2=sc.nextLine();
		String exp4="\\d{10}";
		d=contact.matches(exp4);
		contact=contact2;
	    }
	}
	
	void change_username() {
		Scanner sc=new Scanner(System.in);
		boolean b2=false;
		while(b2==false) {
			
		System.out.print("Set new username : ");
		String uname = sc.nextLine();
		String exp1="\\w{1,}";
		b2=uname.matches(exp1);
		username=uname;
		}	
	}
	
	void change_password() {
		Scanner sc=new Scanner(System.in);
	    boolean b1=false;
	    while(b1==false)
	    {
		
		System.out.print("Set new password (minimum 8 chars; minimum 1 digit, 1 lowercase, 1 \r\n"
				           + "uppercase, 1 special character[!@#$%^&*_]) :");
		String pname = sc.nextLine();
		String ex2="\\w{1,8}\\W{1}\\d{1,4}";
	    b1=pname.matches(ex2);
	    password=pname;	
	     }
	 }
		
	
	public static void main(String[] args) {
		Bank_Application ba=new Bank_Application();
		int ch,c;
		do 
		{
		Scanner sc=new Scanner(System.in);
		System.out.println("----------------");
		System.out.println("BANK OF MY BANK");
		System.out.println("----------------");
		System.out.println();
		System.out.println("1. Register account."+"\n"+"2. Login."+"\n"+"3. Update accounts."+"\n"+"4. Exit.");
		System.out.println();
		System.out.print("Enter your choice:");
		ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			try {
				ba.register();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 2:
		     Scanner sc2=new Scanner(System.in);
			 String uname2 = "",pname2="";
			 boolean check1=false,check2=false;;
			 while(check1==false)
			 {
			 System.out.print("Enter user name:");
			 uname2=sc2.next();
			 check1=uname2.equals(ba.username);
				  
				  if((uname2.equals(ba.username))==false)
				  { 
					  System.err.println("Wrong Username!");
				  }
			 }
				 while(check2==false)
				 {
			      System.out.print("Enter Password:");
			       pname2=sc2.next();
				   check2=pname2.equals(ba.password);
				  if((pname2.equals(ba.password))==false)
				  { 
					  System.err.println("Wrong Password!");
				  }
				 }
			
			if(uname2.equals(ba.username) && pname2.equals(ba.password))
			{
				do {
				System.out.println();
				System.out.println("--------------");
				System.out.println("W E L C O M E ");
				System.out.println("--------------");
				System.out.println();
				System.out.println("1. Deposit."+"\n"+"2. Transfer."+"\n"+"3. Last 5 Transactions."+"\n"+"4. User information."+"\n"+"5. Show balance."+"\n"+"6. Show Database."+"\n"+"7. Log out.");
				System.out.println();
				System.out.print("Enter choice:");
				c=sc2.nextInt();
				switch(c)
				{
				case 1:
					ba.deposit_();
					break;
				case 2:
					ba.transfer();
					break;
				case 3:
					ba.history();
					break;
				case 4:
					ba.userInformation();
					break;
				case 5:
					ba.balance();
					break;
				case 6:
					ba.dataBase();
					break;
				        }
			    }while(c!=7);
				 break;
			
		       }
			   
		case 3:
			
			 Scanner sc4=new Scanner(System.in);
			 int choice;
			 do {
			 System.out.println("------------");
		     System.out.println("U P D A T E");
			 System.out.println("------------");
			 System.out.println("1. Change address."+"\n"+"2. Change contact."+"\n"+"3. Change username."+"\n"+"4. Chnage password."+"\n"+"5. Exit.");
			 System.out.println();
			 System.out.print("Enter choice: ");
			 choice=sc.nextInt();
			 switch(choice)
			 {
			 case 1:
				 ba.change_address();
				 break;
				
			 case 2:
				 ba.change_contact();
				 break;
			 case 3:
				 ba.change_username();
				 break;
			 case 4:
				 ba.change_password();
				 break;
				 
			 }
			 }while(choice!=5);
			break;
			
		
			
			
			
			
		}
		

	}while(ch!=4);
	}

}

class Bank {
	ArrayList<Bank> data=new ArrayList<Bank>();
	String name_;
	String add_;
	String contact_;
	String username_;
	String password_;
	double amount_;
	public Bank(String name_, String add_, String contact_, String username_, String password_, double amount_) {
		super();
		this.name_ = name_;
		this.add_ = add_;
		this.contact_ = contact_;
		this.username_ = username_;
		this.password_ = password_;
		this.amount_ = amount_;
	}
	
	@Override
	public String toString() {
		
		return "Name: "+name_+", Address: "+add_+", Contact: "+contact_+", Username: "+username_+", Password: "+password_+", Balance: "+amount_;
	}
}

