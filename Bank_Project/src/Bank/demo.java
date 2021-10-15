package Bank;

import java.util.Scanner;

public class demo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=1;
		String[] gmail2=new String[n];
		System.out.println("Enter gmail:");
		boolean a2=false;
		while(a2==false) {
		for(int i=0;i<n;i++)
		{
			String exp2="\\w{1,}\\@\\w{1,}\\.\\w{1,3}";
			gmail2[i]=sc.nextLine();
			a2=gmail2[i].matches(exp2);
			if(a2==false)
				System.out.println("Enter gmail again:");
		}
		}

	}

}
