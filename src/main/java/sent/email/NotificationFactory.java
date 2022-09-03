package sent.email;

public class NotificationFactory {

	public Notification createNotification(String channel) {
		
		
		if (channel.equalsIgnoreCase("EMAIL")) {
			return new emailNotification();
		}
		
		return null;
		
	}
	
}
