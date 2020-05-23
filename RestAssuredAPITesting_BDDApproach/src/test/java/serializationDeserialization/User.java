package serializationDeserialization;

public class User {
	
	public int userId;
	public String title;
	public String body;
	
	public int getUID() {
		return userId;
	}
	
	public void setUID(int userId) {
		this.userId=userId;
		
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title=title;
		
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body=body;
	}
}
