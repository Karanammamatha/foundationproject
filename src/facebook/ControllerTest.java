package facebook;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import facebook.controller.FacebookController;
import facebook.controller.FacebookControllerInterface;
import facebook.entity.FacebookUser;

class ControllerTest {
	FacebookControllerInterface fc=null;
	@BeforeEach
	void setUp() throws Exception {
		fc=new FacebookController();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		fc=null;
	}

	@Test
	void testViewProfileController() {
		FacebookUser user=fc.viewProfileController();
		assert user!=null : "Test failed to view profile";
	}

	@Test
	void testDeleteProfileController() {
		int i=fc.deleteProfileController();
		assert i>0 : "Test failed to delete profile";
	}

	@Test
	void testViewAllProfileController() {
		ArrayList<FacebookUser> lis=fc.viewAllProfileController();
		assert lis!=null : "Test failed to view all profiles";
	}

	@Test
	void testEditProfileController() {
		int i = fc.editProfileController();
		assert i>0 : "Test failed to edit profile";
	}

	@Test
	void testSearchProfileController() {
		ArrayList<FacebookUser> lis=fc.searchProfileController();
		assert lis!=null : "Test failed to search profiles";
	}

	@Test
	void testSortProfileController() {
		ArrayList<FacebookUser> lis=fc.sortProfileController();
		assert lis!=null : "Test failed to sort profiles";
	}

}
