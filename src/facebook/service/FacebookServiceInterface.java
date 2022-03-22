package facebook.service;

import java.util.ArrayList;

import facebook.entity.FacebookTimeline;
import facebook.entity.FacebookUser;


public interface FacebookServiceInterface {

	FacebookUser viewProfileService(FacebookUser fu);

	int deleteProfileService(FacebookUser fu);

	ArrayList<FacebookUser> viewAllProfileService(FacebookUser fu);

	int editProfileService(FacebookUser fu, FacebookUser fu1);

	ArrayList<FacebookUser> searchProfileService(FacebookUser fu);

	ArrayList<FacebookUser> sortProfileService();

	FacebookUser signInService(FacebookUser fu);

	int signUpService(FacebookUser fu);

	int createTimelineService(FacebookTimeline ft);

	int signUpService(FacebookUser fu, FacebookUser fu1);




}
