package facebook.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Logger;

import facebook.entity.FacebookTimeline;
import facebook.entity.FacebookUser;
import facebook.service.FacebookServiceInterface;
import facebook.service.ServiceFactory;
import facebook.utility.SortByName;



public class FacebookController implements FacebookControllerInterface {
    FacebookServiceInterface fs = null;
    Scanner sc = null;
    Logger log = Logger.getLogger("FacebookController");
    
	public FacebookController() {
		sc = new Scanner(System.in);
		fs = ServiceFactory.createObject();
	}
	
	@Override
	public int signUp() {
        System.out.println("profile is signing-up: ");
        
		System.out.println("Enter name: ");
        String name=sc.next();
        
        System.out.println("Enter password: ");
        String password=sc.next();
        
        System.out.println("Enter email: ");
        String email=sc.next();
        
        System.out.println("Enter dateOfBirth: ");
        String dateOfBirth=sc.next();
        
        FacebookUser fu=new FacebookUser();
    	fu.setName(name);
    	fu.setPassword(password);
    	fu.setEmail(email);
    	fu.setDateOfBirth(dateOfBirth);
    	
    	int i=fs.signUpService(fu);
    	
    	if(i>0) {
    		System.out.println("profile created");
    		System.out.println();
    	}
    	else {
    		System.out.println("could not create profile");
    	}
		return i;
		
	}

	@Override
	public FacebookUser signIn() {
		System.out.println("Enter email: ");
		String email = sc.next();
		System.out.println("Enter password: ");
		String password = sc.next();

		FacebookUser fu=new FacebookUser();
		fu.setEmail(email);
		fu.setPassword(password);
		
		FacebookUser user = fs.signInService(fu);
		return user;
	}
	
	@Override
	public FacebookUser viewProfileController() {
		System.out.println("profile is viewing: ");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Email whose profile you wish to view: ");
		String email=sc.next();
		
		FacebookUser fu=new FacebookUser();
		fu.setEmail(email);
		
		FacebookUser user=fs.viewProfileService(fu);
		
		if(user!=null) {
			System.out.println("Name is "+user.getName());
			System.out.println("Password is "+user.getPassword());
			System.out.println("Email is "+user.getEmail());
			System.out.println("DateOfBirth is "+user.getDateOfBirth());
			System.out.println();
		}
		else {
			System.out.println("profile not found");
		}
		return user;
		
	}

	@Override
	public int deleteProfileController() {
		System.out.println("profile is deleting: ");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Email whose profile you wish to delete: ");
		String email=sc.next();
		
		FacebookUser fu=new FacebookUser();
		fu.setEmail(email);
		
		int i=fs.deleteProfileService(fu);
		
		if(i>0) {
			System.out.println("profile deleted");
			System.out.println();
		}
		else {
			System.out.println("could not delete profile");
		}
		return i;
		
	}

	@Override
	public ArrayList<FacebookUser> viewAllProfileController() {
		System.out.println("view all profile");
		Scanner sc=new Scanner(System.in);
		
		FacebookUser fu=new FacebookUser();
		
		ArrayList<FacebookUser> lis=fs.viewAllProfileService(fu);
		
		System.out.println(lis.size() +"records found in database");
		for(FacebookUser i:lis) {
			System.out.println("********************");
			System.out.println("Name is "+i.getName());
			System.out.println("Password is "+i.getPassword());
			System.out.println("Email is "+i.getEmail());
			System.out.println("DateOfBirth is "+i.getDateOfBirth());
			System.out.println();
		}
		
		if(lis.size()==0){
			System.out.println("No records found");
		}
		return lis;
		
		
	}

	@Override
	public int editProfileController() {
		System.out.println("editing the profile: ");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Email whose profile you wish to edit");
		String email=sc.next();
		
		System.out.println("Edit name: ");
		String name=sc.next();
		
		System.out.println("Edit password: ");
		String password=sc.next();
		
		System.out.println("Enter dateOfBirth: ");
		String dateOfBirth=sc.next();
		
		FacebookUser fu=new FacebookUser();
		fu.setEmail(email);
		
		FacebookUser fu1=new FacebookUser();
		fu1.setName(name);
		fu1.setPassword(password);
		fu1.setDateOfBirth(dateOfBirth);
		
		
		int i=fs.editProfileService(fu,fu1);
		
		if(i>0) {
			System.out.println("profile edited");
			System.out.println();
		}
		else {
			System.out.println("could not edit profile");
		}
		return i;
	}

	@Override
	public ArrayList<FacebookUser> searchProfileController() {
		System.out.println("searching the profile");
		
		System.out.println("Enter a name whose profile you wish to search: ");
		String name=sc.next();
		
		FacebookUser fu=new FacebookUser();
		fu.setName(name);
		
		ArrayList<FacebookUser> lis=fs.searchProfileService(fu);
		
		if(lis!=null) {
			for(FacebookUser user : lis) {
			System.out.println("***************");
			System.out.println("Name is "+user.getName());
			System.out.println("Password is "+user.getPassword());
			System.out.println("Email is "+user.getEmail());
			System.out.println("DateOfBirth is "+user.getDateOfBirth());
			System.out.println();
			}
		}
		else {
			System.out.println("No profiles found with the given name");
		}
		return lis;
		
		
		
	}

	@Override
	public ArrayList<FacebookUser> sortProfileController() {
		System.out.println("sorting the profile: ");
		ArrayList<FacebookUser> lis = new ArrayList<FacebookUser>();
	
		lis = fs.sortProfileService();
		Collections.sort(lis, new SortByName());
		
		for (FacebookUser user : lis) {
			System.out.println("____________________");
			System.out.println("Name is " + user.getName());
			System.out.println("Password is "+ user.getPassword());
			System.out.println("Email is " + user.getEmail());
			System.out.println("DateOfBirth is " + user.getDateOfBirth());
			System.out.println();
		}
		return lis;
		
		
	}

	@Override
	public void createTimelineController() {
		System.out.println("Enter message id : ");
		String messageid = sc.next();
		
		System.out.println("Enter sender email id : ");
		String sender = sc.next();
		
		System.out.println("Enter receiver email id : ");
		String receiver = sc.next();
		
		System.out.println("Enter message : ");
		String message = sc.next();
		
		System.out.println("Enter messagedate : ");
		String messagedate = sc.next();
		
		FacebookTimeline ft = new FacebookTimeline();
		ft.setMessageid(messageid);
		ft.setSender(sender);
		ft.setReceiver(receiver);
		ft.setMessage(message);
		ft.setMessageDate(messagedate);
		
		int i = fs.createTimelineService(ft);
		
		if(i>0) {
			System.out.println("Timeline updated");
		}
		else {
			System.out.println("could not update timeline");
		}
		
		
	}

	

	

	
	
}

