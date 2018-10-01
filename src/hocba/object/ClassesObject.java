package hocba.object;

public class ClassesObject{
	private int class_id;
	private String class_name;
	
	
	private int class_mainteacher_id;
	private TeacherObject tearcher;
	
	
	private byte class_course;
	private byte class_student_count;
	
	
	public ClassesObject() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getClass_id() {
		return class_id;
	}


	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}


	public String getClass_name() {
		return class_name;
	}


	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}


	public int getClass_mainteacher_id() {
		return class_mainteacher_id;
	}


	public void setClass_mainteacher_id(int class_mainteacher_id) {
		this.class_mainteacher_id = class_mainteacher_id;
	}


	public TeacherObject getTearcher() {
		return tearcher;
	}


	public void setTearcher(TeacherObject tearcher) {
		this.tearcher = tearcher;
	}


	public byte getClass_course() {
		return class_course;
	}


	public void setClass_course(byte class_course) {
		this.class_course = class_course;
	}


	public byte getClass_student_count() {
		return class_student_count;
	}


	public void setClass_student_count(byte class_student_count) {
		this.class_student_count = class_student_count;
	}
	
	
	
}