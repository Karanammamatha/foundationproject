package facebook.view;

import java.util.Scanner;

import facebook.controller.ControllerFactory;
import facebook.controller.FacebookController;
import facebook.controller.FacebookControllerInterface;
import facebook.entity.FacebookUser;

public class FacebookView {
   public static void main(String[]args) {
	   Scanner sc=new Scanner(System.in);
	   
	   String s="y";
	   while(s.contentEquals("y")) {
	   FacebookControllerInterface ff=ControllerFactory.createObject();   
		   
	   System.out.println("*****************MAIN MENU*************************");
	   System.out.println("press 1 to sign-up");
	   System.out.println("press 2 to sign-in"); 
	   System.out.println("Enter your choice: ");
	   int mainAns=sc.nextInt();
	   System.out.println();
	   String ans1 = "y";
	   
	   while (ans1.contentEquals("y")) {
		   switch(mainAns) {
		   		case 1 : 
		   			System.out.println("******************sign-up*****************");
		   			ff.signUp();
		   			break;
		   		case 2 :
		   			FacebookUser user = ff.signIn();
		   			if (user != null) {
		   				String ans2 = "y";
	                    while(ans2.contentEquals("y")) {
	                       System.out.println("*****************Sign-in Menu************************");
	                  	   System.out.println("press 1 to view profile");
	                  	   System.out.println("press 2 to delete profile");
	                  	   System.out.println("press 3 to viewAll profile");
	                  	   System.out.println("press 4 to edit profile");
	                  	   System.out.println("press 5 to search profile");
	                  	   System.out.println("press 6 to sort profile");
	                  	   System.out.println("press 7 to create timeline profile");
	                       System.out.println("Enter your choice: ");
	                       int ch = sc.nextInt();
	                       System.out.println();
	   
	                       switch(ch) {
							   case 1:ff.viewProfileController();
								   break;
							   case 2:ff.deleteProfileController();
								   break;
							   case 3:ff.viewAllProfileController();
								   break;
							   case 4:ff.editProfileController();
								   break;
							   case 5:ff.searchProfileController();
								   break;
							   case 6:ff.sortProfileController();
								   break;
							   case 7:ff.createTimelineController();
							       break;
							   default:System.out.println("wrong choice");
	                          }
	                       System.out.println("Do you want to continue to sign-in menu press y/n");
						   s=sc.next();
						   System.out.println();
						   }
	                    }
		   			else {
		   				System.out.println("oops! You are not registered.press 1 to sign-up" + "\n");
		   			}
		   			break;
		   		}
	        System.out.print("Do you want to come back to Main menu press y/n");
	        ans1 = sc.next();
	        System.out.println();
	     }
	   }
   }
}
