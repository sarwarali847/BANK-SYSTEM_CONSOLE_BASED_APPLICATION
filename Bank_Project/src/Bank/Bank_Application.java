package Bank;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Bank_Application {
	Scanner sc=new Scanner(System.in);
	private String username;
	private String password;
	private String contact;
	private double deposit,deposit2,amnt_transfer;
	private double deposite_temp;
	LocalDate date1,date2,date3;
	LocalTime time1,time2,time3;
    private double credit;
    private  String name;
    private String add;
    private String payee_user1,payee_user2;
    
    
	
	//Register
	
	 void register(){
		 
		//String name;
		//String contact;
		String uname;
		String pname;
		//String add;
		System.out.println();
		System.out.print("Enter name:");
		name=sc.nextLine();
		System.out.print("Enter address:");
		add=sc.nextLine();
		boolean d=false;
		
		while(d==false) {
		System.out.print("Enter contact:");
		contact=sc.nextLine();
		String exp4="\\d{10}";
		d=contact.matches(exp4);
		if(d==false)
		{
			System.err.println("Enter contact again!");
		}
	    }
		
		boolean b2=false,b1=false;
		while(b2==false) {
			
		System.out.print("Set username : ");
		uname=sc.nextLine();
		String exp1="\\w{1,}";
		b2=uname.matches(exp1);
		if(b2==false)
			System.err.println("Enter username again!");
		username=uname;
		
		}
		while(b1==false)
		{
		
		System.out.print("Set a password (minimum 8 chars; minimum 1 digit, 1 lowercase, 1 \r\n"
				           + "uppercase, 1 special character[!@#$%^&*_]) :");
		pname=sc.nextLine();
		String ex2="\\w{1,8}\\W{1}\\d{1,4}";
	    b1=pname.matches(ex2);
	    if(b1==false)
	    	System.err.println("Enter password again!");
	    password=pname;
	    
		}

	 System.out.print("Enter initial deposit:");
	 deposit=sc.nextDouble();
	 LocalDate d1 = LocalDate.now(); 
	 date1=d1;
	 LocalTime t1 = LocalTime.now();
	 time1=t1;
	 deposite_temp=deposit;
	 deposit2=deposit;
	 System.out.println();
	 System.out.println((name)+" , Registration Successful....... ");
	}
	 
	 //Deposit
	 void deposit_() {
		 double depo;
		 Scanner sc3=new Scanner(System.in);
		 System.out.print("Enter amount:");
		 depo=sc.nextDouble();
		 System.out.println("Rs. "+depo+" deposited successfully..");
		 //credit=depo;
		 credit=deposit2+depo; 
		 deposit=deposit2+depo;
		 LocalDate d2 = LocalDate.now(); 
		 date2=d2;
		 LocalTime t2 = LocalTime.now();
		 time2=t2;
	 }
	 
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
			 deposit=deposit-amnt_transfer;
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
	 
	 void history() {
		 
		 System.out.println("Rs. "+amnt_transfer+" Transferred to "+payee_user1+". Balance -Rs. "+deposit+" as on "+date3+" at "+time3);
		 System.out.println("Rs. "+credit+" credited to your account. Balance -Rs. "+credit+" as on "+date2+" at "+time2);
		 System.out.println("Initial Deposit - Rs. "+deposite_temp+" as on "+date1+" at "+time1);
		 
	 }
	 
	 void userInformation() {
		 System.out.println();
		 System.out.println("Name : "+name+"\n"+"Contact number : "+contact+"\n"+"Address : "+add);
	 }
	 
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
			ba.register();
			break;
		case 2:
		     Scanner sc2=new Scanner(System.in);
			 String uname2 = "",pname2="";
			 boolean check1=false,check2=false;;
			 while(check1==false)
			 {
			 System.out.print("Enter user name:");
			 uname2=sc2.nextLine();
			 check1=uname2.equals(ba.username);
				  
				  if((uname2.equals(ba.username))==false)
				  { 
					  System.err.println("Wrong Username!");
				  }
			 }
				 while(check2==false)
				 {
			      System.out.print("Enter Password:");
			       pname2=sc2.nextLine();
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
				System.out.println("1. Deposit."+"\n"+"2. Transfer."+"\n"+"3. Last 5 Transactions."+"\n"+"4. User information."+"\n"+"5. Log out");
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
					
					
				        }
			    }while(c!=5);
				 
			
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
			
			
			
			
			
		}
		

	}while(ch!=4);
	}

}


