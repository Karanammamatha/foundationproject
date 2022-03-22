package facebook.dao;

import java.util.ArrayList;

import facebook.entity.FacebookTimeline;
import facebook.entity.FacebookUser;

public interface FacebookDAOInterface {


	FacebookUser viewProfileDAO(FacebookUser fu);

	int deleteProfileDAO(FacebookUser fu);

	ArrayList<FacebookUser> viewAllProfileDAO(FacebookUser fu);

	int editProfileDAO(FacebookUser fu, FacebookUser fu1);

	ArrayList<FacebookUser> searchProfileDAO(FacebookUser fu);

	ArrayList<FacebookUser> sortProfileDAO();

	int signUpDAO(FacebookUser fu);

	FacebookUser signInDAO(FacebookUser fu);

	int createTimelineDAO(FacebookTimeline ft);

	
     
	


	


}
