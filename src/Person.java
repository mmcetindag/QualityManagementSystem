
public class Person {
	
	private int id;
	private String name;
	private String password;
	private String userType;
	
	
	public Person(int id, String name, String password, String userType) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.password=password;
		this.userType=userType;
	}
	public Person(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
}
