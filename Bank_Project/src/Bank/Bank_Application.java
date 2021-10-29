package Bank;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


public class Bank_Application{
	
	
	ArrayList<Bank_> data=new ArrayList<Bank_>();
	Scanner sc=new Scanner(System.in);
	private String username;
	private String password;
	private String contact;
	@SuppressWarnings("unused")
	private double deposit,deposit2,amnt_transfer,depo;
	@SuppressWarnings("unused")
	private double deposite_temp,Initial_deposit=0,deposit3;
	private LocalDate date1,date2,date3;
	private LocalTime time1,time2,time3;
    private double credit;
    private  String name;
    private String add;
    private String payee_user1,payee_user2;
    private int f2=0,f3=0;
    int count=0;
    
	 
	 
	//Register
    public void register() throws IOException{
		 
		String cont="";
		String uname="";
		String pname="";
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
		String ex2="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
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
	 
	
	 
	 data.add(new Bank_(name,add,contact,username,password, deposit));
	  
	 System.out.println((name)+" , Registration Successful....... ");
	 storeintofile1();
	}  
	 
	 
	
	
	
	//Storing into file
	public void storeintofile1() throws IOException
	{
	File file=new File("Files/data.db");
    BufferedWriter br1=new BufferedWriter(new FileWriter(file));
    for(Bank_ v: data)
    {
   	 br1.write("Name: "+v.getName_()+", Address: "+v.getAdd_()+", Contact: "+v.getContact_()+", Username: "+v.getUsername_()+", Password: "+v.getPassword_());
   	 br1.newLine();  
	}  
    br1.close();
    
	}
	
	 //Serialization
	void serialization() {
		 try {
			  FileOutputStream fos=new FileOutputStream("Files/data2.db");  
		      ObjectOutputStream oos=new ObjectOutputStream(fos);  
		      oos.writeObject(data);  
		      fos.close();  
		      oos.close();  
			 }
			 catch (Exception e) {
				 System.out.println(e.getMessage());
			}
		 finally {
		 System.out.println("Serialization Done!");
		 }
	}
	 
	
	 //Deposit
	 public void deposit_() {
		 double depo;
		 System.out.print("Enter amount:");
		 depo=sc.nextDouble();
		 System.out.println("Rs. "+depo+" deposited successfully..");
		 credit=depo; 
		 f3=1;
		 deposit3=deposit2+credit;
		 LocalDate d2 = LocalDate.now(); 
		 date2=d2;
		 LocalTime t2 = LocalTime.now();
		 time2=t2;
	 }
	 
	 //Transfer
	 public void transfer() {
		
		 double amnt_transfer;
		 //String payee_user1, payee_user2;
		 System.out.print("Add payee:");
		 payee_user1=sc.next();
		 System.out.println(payee_user1+", Added successfully!");
		 System.out.print("Enter payee user name:");
		 payee_user2=sc.next();
		 if(payee_user1.equals(payee_user2))
		 {
			 System.out.print("Enter amount to transfer:");
			 amnt_transfer=sc.nextDouble();
			 if(amnt_transfer>deposit)
				 System.err.println("Insufficent amount!");
			 else
			 {
			 System.out.println(amnt_transfer+", Transferred to "+payee_user1+" successfully.");
			 depo=amnt_transfer;
			 deposit2=deposit2-amnt_transfer;
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
	 public void history() {
		
		 if(f3==1)
		 {
		 System.out.println("Rs. "+credit+" credited to your account. Balance -Rs. "+deposit3+" as on "+date2+" at "+time2);
		 }
		 if(f2==1)
		 {
		 System.out.println("Rs. -"+depo+" Transferred to "+payee_user1+". Balance -Rs. "+deposit2+" as on "+date3+" at "+time3);
		 }
		 
		 System.out.println("Initial Deposit - Rs. "+deposit+" as on "+date1+" at "+time1);
		 
	 }
	 
	 //Show Balance
	 
	 public void balance() {
		 System.out.println("Available amount Rs "+deposit3+".");
	 }
	 
	 
	 
	 
	 //Deserialization 
	 public void deserialization() {

		 try {
		 FileInputStream fis=new FileInputStream("Files/data2.db");  
         @SuppressWarnings("resource")
		ObjectInputStream ois=new ObjectInputStream(fis);  
         @SuppressWarnings("unchecked")
		 ArrayList<Bank_>  list=(ArrayList<Bank_>)ois.readObject();  
         
         for(Object val:list)
         { 
         System.out.println(val); 
         }
       
     }
		 catch(Exception e)  
     {  
         System.out.println(e);  
     }  
}
	 
	 
    //Username and password
	 
    public String us(){
		 String uname= "";
		 boolean check1=false;
       while(check1==false)
	      {
		 Iterator<Bank_> itr1=data.iterator();
		 System.out.print("Enter user name:");
		 uname=sc.next();
		 
		 while(itr1.hasNext())
		 {
			 Bank_ b1=itr1.next();
		     if(uname.equals(b1.getUsername_()))
		     {
		    	 check1=true;
		     }
		 }
			  
		if(check1==false)
		{ 
		  System.err.println("Wrong Username!");
	    }
     }
	return uname;
   }
    
    public String ps(){
	
    	  String pname="";
    	  boolean check2=false;
          while(check2==false)
		     {
			 
			  Iterator<Bank_> itr2=data.iterator();
		      System.out.print("Enter Password:");
		      pname=sc.next();
		      while(itr2.hasNext())
		      {
		    	 Bank_ b2=itr2.next();
			  if(pname.equals(b2.getPassword_()))
			   {
				  check2=true;
			   }
		     }
			  if(check2==false)
			  { 
				  System.err.println("Wrong Password!");
			  }
	     }
		return pname;
		
	 }
	 
	 //Update
	 
	 public void change_name() throws IOException
	 {   
		 String u="",p="";
		 u=us();
		 p=ps();
		 System.out.println("Enter new name:");
		 String name2;
		 name2=sc.next();	 
		 Iterator<Bank_> i1=data.iterator();
		 while(i1.hasNext())
		 {
			Bank_ b1=i1.next();
			if(b1.getUsername_().equals(u) && b1.getPassword_().equals(p))
			{
			b1.setName_(name2);
			storeintofile1();
			}
		 }	 
		 
	 }
	 
	public void change_address() throws IOException {
		
		
		String u="",p="";
		u=us();
		p=ps();
		String add2;
		System.out.println("Enter new address:");
		add2=sc.next();
		Iterator<Bank_> i1=data.iterator();
		 while(i1.hasNext())
		 {
			Bank_ b1=i1.next();
			if(b1.getUsername_().equals(u) && b1.getPassword_().equals(p))
			{
			b1.setAdd_(add2);
			storeintofile1();
			}
		 }
		
	}
	
	public void change_contact() throws IOException  {
		String u="",p="";
		u=us();
		p=ps();
		String contact2 = "";
        boolean d=false;
		while(d==false) 
		{
		System.out.print("Enter new contact:");
		contact2=sc.next();
		String exp4="\\d{10}";
		d=contact.matches(exp4);
		if(d==false)
		{
			System.err.println("Enter contact again!");
		}
			
	    }
		 Iterator<Bank_> i1=data.iterator();
		 while(i1.hasNext())
		 {
			Bank_ b1=i1.next();
			if(b1.getUsername_().equals(u) && b1.getPassword_().equals(p))
			{
			b1.setContact_(contact2);
			storeintofile1();
			}
		 }
		
	}
	
	public void change_username() throws IOException  {
		String u="",p="";
		u=us();
		p=ps();
		boolean b2=false;
		String uname="";
		while(b2==false) {
			
		System.out.print("Set new username : ");
		uname = sc.nextLine();
		String exp1="\\w{1,}";
		b2=uname.matches(exp1);
		if(b2==false)
		{
			System.err.println("Enter username again!");
		}
	  }
		 Iterator<Bank_> i1=data.iterator();
		 while(i1.hasNext())
		 {
			Bank_ b1=i1.next();
			if(b1.getUsername_().equals(u) && b1.getPassword_().equals(p))
			{
			b1.setUsername_(uname);
			storeintofile1();
			}
		 }
		
	}
	
	public void change_password() throws IOException  {
		String u="",p="";
		u=us();
		p=ps();
	    boolean b1=false;
	    String pname="";
	    while(b1==false)
	    {
		
		System.out.print("Set new password (minimum 8 chars; minimum 1 digit, 1 lowercase, 1 \r\n"
				           + "uppercase, 1 special character[!@#$%^&*_]) :");
		pname = sc.nextLine();
		String ex2="\\w{1,8}\\W{1}\\d{1,4}";
	    b1=pname.matches(ex2) ;
	    if(b1==false)
	    {
	    	System.err.println("Enter password again!");
	    }
	    
	 }
	    Iterator<Bank_> i1=data.iterator();
		 while(i1.hasNext())
		 {
			Bank_ b11=i1.next();
		  if(b11.getUsername_().equals(u) && b11.getPassword_().equals(p))
			{
			b11.setPassword_(pname);
			storeintofile1();
			}
			
		 }
	    
	}

	
	//Login
	
	public void login() {
		 String uname2 = "",pname2="";
		 boolean check1=false,check2=false;;
		 while(check1==false)
		 {
		 Iterator<Bank_> itr1=data.iterator();
		 System.out.print("Enter user name:");
		 uname2=sc.next();
		 
		 while(itr1.hasNext())
		 {
			 Bank_ b1=itr1.next();
		     if(uname2.equals(b1.getUsername_()))
		     {
		    	 check1=true;
		     }
		 }
			  
		if(check1==false)
		{ 
		  System.err.println("Wrong Username!");
	    }
	  }
	
		 while(check2==false)
			{
			 
			  Iterator<Bank_> itr2=data.iterator();
		      System.out.print("Enter Password:");
		      pname2=sc.next();
		      while(itr2.hasNext())
		      {
		    	 Bank_ b2=itr2.next();
			  if(pname2.equals(b2.getPassword_()))
			   {
				  check2=true;
			   }
		     }
			  if(check2==false)
			  { 
				  System.err.println("Wrong Password!");
			  }
			 }
		
		if(check1 && check2)
		{
			int c;
			String encodeusername="abc",encodepassword="def";
			do {
			System.out.println();
			System.out.println("--------------");
			System.out.println("W E L C O M E ");
			System.out.println("--------------");
			System.out.println();
			System.out.println("1. Transfer."+"\n"+"2. Deposit."+"\n"+"3. Last 5 Transactions."+"\n"+"4. User information."+"\n"+"5. Show balance."+"\n"+"6. Serialization."+"\n"+"7. Deserialization."+"\n"+"8. Sorted Data.\n"+"9. Show Encrypted Username & Password."+"\n"+"10. Show Decrpted Username & Password."+"\n"+"11. Log out.");
			System.out.println();
			System.out.print("Enter choice:");
	
			c=sc.nextInt();
			switch(c)
			{
			
			case 1:
				transfer();
				break;
			case 2:
				deposit_();
				break;
			case 3:
				history();
				break;
			case 4:
				userInformation();
				break;
			case 5:
				balance();
				break;
			case 6:
				serialization();
				break;
			case 7:
				deserialization();
				break;
			case 8:
				sort();
				break;
			case 9:
				Base64.Encoder encoder=Base64.getEncoder();
				encodeusername=encoder.encodeToString(uname2.getBytes());
				System.out.println("Encrypted Username: "+encodeusername);
				encodepassword=encoder.encodeToString(pname2.getBytes());
				System.out.println("Encrypted Password: "+encodepassword);
				break;
				
			case 10:
				Base64.Decoder decoder=Base64.getDecoder();
				String decodusername=new String(decoder.decode(encodeusername));
				System.out.println("Decrypted Username: "+decodusername);
				
				String decodepassword= new String(decoder.decode(encodepassword));
				System.out.println("Decrypted Password: "+decodepassword);
			
			
			     }
		    }while(c!=11);
		
	       }
		
	}
	


	//Sorting Data 
	public void sort() {
		int choice;
		//Iterator<Bank> show=data.iterator();
		do {
		System.out.println("1. Sort by name\n2. Sort by address\n3. Sort by contact\n4. Sort by username\n5. Sort by balance\n6. Exit");
		System.out.println("Enter choice:");
		choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:
			System.out.println("        ==================Sorting list by name===========");
			System.out.println();
			Collections.sort(data, (n1,n2) -> (n1.getName_().compareTo(n2.getName_())));
			data.forEach((value1)-> System.out.println(value1.toString()));
			System.out.println();
			break;
			
		case 2:
			System.out.println("        ================Sorting list by address===========");
			System.out.println();
			Collections.sort(data, (n3,n4)-> (n3.getAdd_().compareTo(n4.getAdd_())));
			data.forEach((value2)-> System.out.println(value2.toString()));
			System.out.println();
			break;
			
		case 3:
			System.out.println("=============Sorting list by contact===========");
			System.out.println();
			Collections.sort(data, (n5,n6)-> (n5.getContact_().compareTo(n6.getContact_())));
			data.forEach((value3)-> System.out.println(value3.toString()));
			System.out.println();
			break;
		case 4:
			System.out.println("        =============Sorting list by username===========");
			System.out.println();
			Collections.sort(data, (n7,n8)-> (n7.getUsername_().compareTo(n8.getUsername_())));
			data.forEach((value4)-> System.out.println(value4.toString()));
			System.out.println();
			break;
		
		case 5:
			System.out.println("        =============Sorting list by balance===========");
			System.out.println();
			Collections.sort(data, (n9,n10)-> (int)(n9.getAmount_()-n10.getAmount_()));
			data.forEach((value5)-> System.out.println(value5.toString()));
			System.out.println();
			System.out.println();
			break;
		
		}
		
		}while(choice!=6);
		
		
		
	}
	
	
	
	
	//User information
		 public void userInformation() {
			 String uname21 = "",pname21="";
			 boolean check1=false,check2=false;;
			 while(check1==false)
			 {
			 Iterator<Bank_> itr1=data.iterator();
			 System.out.print("Enter user name:");
			 uname21=sc.next();
			 
			 while(itr1.hasNext())
			 {
				 Bank_ b1=itr1.next();
			     if(uname21.equals(b1.getUsername_()))
			     {
			    	 check1=true;
			     }
			 }
				  
			if(check1==false)
			{ 
			  System.err.println("Wrong Username!");
		    }
		  }
		
			 while(check2==false)
				{
				 
				  Iterator<Bank_> itr2=data.iterator();
			      System.out.print("Enter Password:");
			      pname21=sc.next();
			      while(itr2.hasNext())
			      {
			    	 Bank_ b2=itr2.next();
				  if(pname21.equals(b2.getPassword_()))
				   {
					  check2=true;
				   }
			     }
				  if(check2==false)
				  { 
					  System.err.println("Wrong Password!");
				  }
				 }
			
			 if(check1 && check2)
			 {
			 Iterator<Bank_> itr5=data.iterator();
			 while(itr5.hasNext())
			 { 	
				Bank_ c1=itr5.next();
		    	if(pname21.equals(c1.getPassword_()) && uname21.equals(c1.getUsername_()))
		    	{
		    		
		    		System.out.println(c1);
		    		//break;
		    	}
		    		
		    }
			
		}
   }
		 
		
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		Bank_Application ba=new Bank_Application();
		@SuppressWarnings("unused")
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
			 ba.login();
			 break;
		     
			   
		case 3:
			
			 @SuppressWarnings("unused") 
			 Scanner sc4=new Scanner(System.in);
			 int choice;
			 do {
			 System.out.println("------------");
		     System.out.println("U P D A T E");
			 System.out.println("------------");
			 System.out.println("1. Change name."+"\n"+"2. Change address."+"\n"+"3. Change contact."+"\n"+"4. Change username."+"\n"+"5. Chnage password."+"\n"+"6. Exit.");
			 System.out.println();
			 System.out.print("Enter choice: ");
			 choice=sc.nextInt();
			 
			 switch(choice)
			 {
			 case 1:
				 
				 ba.change_name();
				
				 break;
			 case 2:
				 ba.change_address();
				 break;
				
			 case 3:
				 ba.change_contact();
				 break;
			 case 4:
				 ba.change_username();
				 break;
			 case 5:
				 ba.change_password();
				 break;
				 
			 }
			 }while(choice!=6);
			break;	
			
		}
		

	}while(ch!=4);
 }
	
	
}


