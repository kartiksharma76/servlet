package jdbcUtil;

/*
 * ps.setString(1, username);
			ps.setString(2, phone);
			ps.setString(3,email);
			ps.setString(4,gender);
			ps.setString(5 ,course);
			ps.setString(6,timing);
 */
public class Student {
	private String username;
	private String phone;
	private String gender;
	private String course;
	private String timing;
	private String email;
//student.phone
//System.out.println(student.phone);
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
