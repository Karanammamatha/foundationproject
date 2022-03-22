package facebook.service;

public class ServiceFactory {

	public static FacebookServiceInterface createObject() {
		return new FacebookService();
	}

}
