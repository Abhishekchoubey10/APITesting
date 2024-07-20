package day1;

// This class will be use for data preparation 

public class Pojo_PostRequests {

	String Name;
	String location;
	String Phone;
	String Courses[];

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		this.Phone = phone;
	}

	public String[] getCourses() {
		return Courses;
	}

	public void setCourses(String[] courses) {
		this.Courses = courses;
	}

}
