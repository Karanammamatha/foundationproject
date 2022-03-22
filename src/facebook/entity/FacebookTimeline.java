package facebook.entity;

public class FacebookTimeline {
   private String messageid;
   private String sender;
   private String receiver;
   private String message;
   private String messagedate;
   
   
    public String getMessageid() {
		return messageid;
	}
	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageDate() {
		return messagedate;
	}
	public void setMessageDate(String messagedate) {
		this.messagedate = messagedate;
	}
	
	   
	   
}
