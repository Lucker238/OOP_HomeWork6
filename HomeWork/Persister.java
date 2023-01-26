package OOP_Lesson6_Solid.HomeWork;

public class Persister{
	private User user;
	
	public Persister(User user){
		this.user = user;
	}
	
	public void save(){
		System.out.println("Save user: " + user.getName());
	}
}