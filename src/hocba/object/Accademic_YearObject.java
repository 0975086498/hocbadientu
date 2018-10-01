package hocba.object;

public class Accademic_YearObject{
	private int accademic_year_id;
	
	private int accademic_year_student_id;
	private StudentObject student;
	

	private byte accademic_year_status;
	private String accademic_year_notes;
	private byte accademic_year_score_final;
	private byte accademic_year_score_term_1;
	private byte accademic_year_score_term_2;
	
	
	public Accademic_YearObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Accademic_YearObject(int accademic_year_id, int accademic_year_student_id, StudentObject student,
			byte accademic_year_status, String accademic_year_notes, byte accademic_year_score_final,
			byte accademic_year_score_term_1, byte accademic_year_score_term_2) {
		super();
		this.accademic_year_id = accademic_year_id;
		this.accademic_year_student_id = accademic_year_student_id;
		this.student = student;
		this.accademic_year_status = accademic_year_status;
		this.accademic_year_notes = accademic_year_notes;
		this.accademic_year_score_final = accademic_year_score_final;
		this.accademic_year_score_term_1 = accademic_year_score_term_1;
		this.accademic_year_score_term_2 = accademic_year_score_term_2;
	}
	public int getAccademic_year_id() {
		return accademic_year_id;
	}
	public void setAccademic_year_id(int accademic_year_id) {
		this.accademic_year_id = accademic_year_id;
	}
	public int getAccademic_year_student_id() {
		return accademic_year_student_id;
	}
	public void setAccademic_year_student_id(int accademic_year_student_id) {
		this.accademic_year_student_id = accademic_year_student_id;
	}
	public StudentObject getStudent() {
		return student;
	}
	public void setStudent(StudentObject student) {
		this.student = student;
	}
	public byte getAccademic_year_status() {
		return accademic_year_status;
	}
	public void setAccademic_year_status(byte accademic_year_status) {
		this.accademic_year_status = accademic_year_status;
	}
	public String getAccademic_year_notes() {
		return accademic_year_notes;
	}
	public void setAccademic_year_notes(String accademic_year_notes) {
		this.accademic_year_notes = accademic_year_notes;
	}
	public byte getAccademic_year_score_final() {
		return accademic_year_score_final;
	}
	public void setAccademic_year_score_final(byte accademic_year_score_final) {
		this.accademic_year_score_final = accademic_year_score_final;
	}
	public byte getAccademic_year_score_term_1() {
		return accademic_year_score_term_1;
	}
	public void setAccademic_year_score_term_1(byte accademic_year_score_term_1) {
		this.accademic_year_score_term_1 = accademic_year_score_term_1;
	}
	public byte getAccademic_year_score_term_2() {
		return accademic_year_score_term_2;
	}
	public void setAccademic_year_score_term_2(byte accademic_year_score_term_2) {
		this.accademic_year_score_term_2 = accademic_year_score_term_2;
	}
	
	
}