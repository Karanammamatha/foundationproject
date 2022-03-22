package facebook.controller;

public class ControllerFactory {

	public static FacebookControllerInterface createObject() {
		return new FacebookController();
	}

}
