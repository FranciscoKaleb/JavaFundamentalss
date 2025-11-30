
public class Student extends Person {
	
	//fields
	private String school_name;
	private String grade_level;
	
	
	// properties
	public void setSchoolName(String s_name) {
		this.school_name = s_name;
	}
	public String getSchoolName() {
		return this.school_name;
	}
	public void setGradeLevel(String gl) {
		this.grade_level = gl;
	}
	public String getGradeLevel() {
		return this.grade_level;
	}
	
	
	
	public Student(String n, int a, String sn, String gl) {
		setName(n);
		setAge(a);
		setSchoolName(sn);
		setGradeLevel(gl);
	}
	
	
}
