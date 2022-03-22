package facebook.service;

import java.util.ArrayList;

import facebook.dao.DAOFactory;
import facebook.dao.FacebookDAOInterface;
import facebook.entity.FacebookTimeline;
import facebook.entity.FacebookUser;

public class FacebookService implements FacebookServiceInterface {
	FacebookDAOInterface fd = null;
	public FacebookService() {
		fd = DAOFactory.createObject();
	}
	@Override
	public int signUpService(FacebookUser fu) {
		int i=fd.signUpDAO(fu);
		return i;
	}
	@Override
	public FacebookUser signInService(FacebookUser fu) {
		FacebookUser user = fd.signInDAO(fu);
		return user;
	}


	@Override
	public FacebookUser viewProfileService(FacebookUser fu) {
		FacebookUser user=fd.viewProfileDAO(fu);
		return user;
	}


	@Override
	public int deleteProfileService(FacebookUser fu) {
		int i=fd.deleteProfileDAO(fu);
		return i;
	}


	@Override
	public ArrayList<FacebookUser> viewAllProfileService(FacebookUser fu) {
		ArrayList<FacebookUser> lis=fd.viewAllProfileDAO(fu);
		return lis;
	}


	@Override
	public int editProfileService(FacebookUser fu, FacebookUser fu1) {
		int i=fd.editProfileDAO(fu,fu1);
		return i;
	}


	@Override
	public ArrayList<FacebookUser> searchProfileService(FacebookUser fu) {
		ArrayList<FacebookUser> lis=fd.searchProfileDAO(fu);
		return lis;
		
		
	}


	@Override
	public ArrayList<FacebookUser> sortProfileService() {
		ArrayList<FacebookUser> lis=fd.sortProfileDAO();
		return lis; 
	}
	
	@Override
	public int createTimelineService(FacebookTimeline ft) {
		int i = fd.createTimelineDAO(ft);
		return i;
	}
	@Override
	public int signUpService(FacebookUser fu, FacebookUser fu1) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

	
	

}
