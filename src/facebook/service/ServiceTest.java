package facebook.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import facebook.entity.FacebookTimeline;
import facebook.entity.FacebookUser;

class ServiceTest {
	FacebookServiceInterface fs = null;
	@BeforeEach
	void setUp() throws Exception {
		fs = new FacebookService();
	}

	@AfterEach
	void tearDown() throws Exception {
		 fs = null;
	}

	@Test
	void testSignUpServiceFacebookUser() {
		System.out.println("SIGN-UP SERVICE TEST");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name: ");
        String name=sc.next();
        
        System.out.println("Enter password: ");
        String password=sc.next();
        
        System.out.println("Enter email: ");
        String email=sc.next();
        
        System.out.println("Enter dateofbirth : ");
        String dateOfBirth=sc.next();
        
        FacebookUser fu=new FacebookUser();
    	fu.setName(name);
    	fu.setPassword(password);
    	fu.setEmail(email);
    	fu.setDateOfBirth(dateOfBirth);
    	
    	int i=fs.signUpService(fu);
    	
    	assert(i>0) : "Test failed to sign-up";
	}

	@Test
	void testSignInService() {
		System.out.println("SIGN-IN SERVICE TEST");
		Scanner sc = new Scanner(System.in);
		
        System.out.println("Enter email: ");
        String email=sc.next();
        
        System.out.println("Enter your password : ");
        String password=sc.next();
        
        FacebookUser fu=new FacebookUser();
    	
    	fu.setEmail(email);
    	fu.setPassword(password);
    	
    	FacebookUser user =fs.signInService(fu);
    	
    	assert  user != null : "Test failed to sign-in";
	}

	@Test
	void testViewProfileService() {
		System.out.println("VIEWING PROFILE SERVICE TEST");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter email whose profile you wish to view : ");
        String email=sc.next();
        
        FacebookUser fu=new FacebookUser();
    	fu.setEmail(email);
    	
    	FacebookUser user =fs.signInService(fu);
        assert  user != null : "Test failed to view profile";
	}

	@Test
	void testDeleteProfileService() {
		System.out.println("DELETING PROFILE SERVICE TEST");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter email whose profile you wish to delete : ");
        String email=sc.next();
        System.out.println();
        
        FacebookUser fu=new FacebookUser();
        fu.setEmail(email);
        
        int i=fs.deleteProfileService(fu);
    	assert(i>0) : "Test failed to delete profile";
	}

	@Test
	void testEditProfileService() {
		System.out.println("EDITING PROFILE SERVICE TEST");
		Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter email whose profile you wish to edit : ");
        String email=sc.next();
        
        System.out.println("Edit name: ");
        String name=sc.next();
        
        System.out.println("Edit password: ");
        String password=sc.next();
        
        System.out.println("Enter date of birth: ");
        String dateOfBirth=sc.next();
        
        FacebookUser fu=new FacebookUser();
        fu.setEmail(email);
        
        FacebookUser fu1=new FacebookUser();
        fu1.setName(name);
        fu1.setPassword(password);
    	fu1.setDateOfBirth(dateOfBirth);
    	
    	
    	int i=fs.signUpService(fu,fu1);
    	
    	assert(i>0) : "Test failed to edit profile";
	}

	@Test
	void testSearchProfileService() {
		System.out.println("SEARCH PROFILE SERVICE TEST");
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a name whose profile you wish to search: ");
		String name=sc.next();
		System.out.println();
		
		FacebookUser fu=new FacebookUser();
		fu.setName(name);
		
		ArrayList<FacebookUser> lis=fs.searchProfileService(fu);
		assert lis != null : "Test failed to search profile";
	}

	

	@Test
	void testCreateTimelineService() {
		System.out.println("SORTING PROFILE DAO TEST");
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter message id : ");
        String message_id=sc.next();
        
        System.out.println("Enter email id : ");
        String sender=sc.next();
        
        System.out.println("Enter email id : ");
        String receiver=sc.next();
        
        System.out.println("Enter message : ");
        String message=sc.next();
        
        System.out.println("Enter messagedate : ");
        String message_date=sc.next();
        System.out.println();
        
        FacebookTimeline ft=new FacebookTimeline();
    	ft.setMessageid(message_id);
    	ft.setSender(sender);
    	ft.setReceiver(receiver);
    	ft.setMessage(message);
    	ft.setMessageDate(message_date);
    	
    	int i=fs.createTimelineService(ft);
    	
    	assert(i>0) : "Test failed to create Timeline";
	}


}
