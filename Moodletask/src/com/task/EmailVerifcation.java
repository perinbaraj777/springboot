package com.task;
import java.util.Scanner;
public class EmailVerifcation {
	public static void main (String [] args) {
		Scanner mailinp=new Scanner(System.in);
		System.out.print("Enter the mail:");
		String mail =mailinp.nextLine();
		if (mail.contains("@gmail.com")) {
			
			System.out.println("valid mail");
			
		}else {
			
			System.out.println("invalid mail");
		}
		
		
		
		
	}
	

}
