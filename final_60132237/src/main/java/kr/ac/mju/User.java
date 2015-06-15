package kr.ac.mju;

public class User {
	private String ID;
	private String name;
	private String password;
	private String pos;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
	}
	public String getPassword() {
		return this.password;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	
	
}
