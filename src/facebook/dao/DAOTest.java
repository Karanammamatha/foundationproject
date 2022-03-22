package facebook.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import facebook.entity.FacebookTimeline;
import facebook.entity.FacebookUser;

public class DAOTest {
    FacebookDAOInterface fd = null;
	@Before
	public void setUp() throws Exception {
		fd = new FacebookDAO();
	}

	@After
	public void tearDown() throws Exception {
		fd = null;
	}

	@Test
	public void testSignUpDAO() {
 		System.out.println("SIGN-UP DAO TEST");
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name: ");
        String name=sc.next();
        
        System.out.println("Enter password: ");
        String password=sc.next();
        
        System.out.println("Enter email: ");
        String email=sc.next();
        
        System.out.println("Enter dateofbirth : ");
        String dateOfBirth=sc.next();
        System.out.println();
        
        FacebookUser fu=new FacebookUser();
    	fu.setName(name);
    	fu.setPassword(password);
    	fu.setEmail(email);
    	fu.setDateOfBirth(dateOfBirth);
    	
    	int i=fd.signUpDAO(fu);
    	
    	assert(i>0) : "Test failed to sign-up";
	}

	@Test
	public void testSignInDAO() {
		System.out.println("SIGN-IN DAO TEST");
		Scanner sc = new Scanner(System.in);
		
        System.out.println("Enter email: ");
        String email=sc.next();
        
        System.out.println("Enter your password : ");
        String password=sc.next();
        
        FacebookUser fu=new FacebookUser();
    	
    	fu.setEmail(email);
    	fu.setPassword(password);
    	
    	FacebookUser user =fd.signInDAO(fu);
    	
    	assert  user != null : "Test failed to sign-in";
	}

	@Test
	public void testViewProfileDAO() {
		System.out.println("VIEWING PROFILE SERVICE TEST");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter email whose profile you wish to view : ");
        String email=sc.next();
        
        FacebookUser fu=new FacebookUser();
    	fu.setEmail(email);
    	
    	FacebookUser user =fd.viewProfileDAO(fu);
        assert  user != null : "Test failed to view profile";
	}

	@Test
	public void testDeleteProfileDAO() {
		System.out.println("DELETING PROFILE SERVICE TEST");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter email whose profile you wish to delete : ");
        String email=sc.next();
        System.out.println();
        
        FacebookUser fu=new FacebookUser();
        fu.setEmail(email);
        
        int i=fd.deleteProfileDAO(fu);
    	assert(i>0) : "Test failed to delete profile";
	}

	@Test
	public void testViewAllProfileDAO() {


	}

	@Test
	public void testEditProfileDAO() {
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
    	
    	
    	int i=fd.editProfileDAO(fu,fu1);
    	
    	assert(i>0) : "Test failed to edit profile";
	}

	@Test
	public void testSearchProfileDAO() {
		System.out.println("SEARCH PROFILE SERVICE TEST");
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a name whose profile you wish to search: ");
		String name=sc.next();
		System.out.println();
		
		FacebookUser fu=new FacebookUser();
		fu.setName(name);
		
		ArrayList<FacebookUser> lis=fd.searchProfileDAO(fu);
		assert lis != null : "Test failed to search profile";
	}

	@Test
	public void testSortProfileDAO() {
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
    	
    	int i=fd.createTimelineDAO(ft);
    	
    	assert(i>0) : "Test failed to create Timeline";
	}

	
}
