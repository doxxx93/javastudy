package exercise;

public class Student {

	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		super();
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public Student() {}

	int getTotal() {
		return this.kor + this.eng + this.math;
	}

	float getAverage() {
		return Math.round(((float) getTotal() / 3) * 10) / (float) 10.0;
	}

	String info() {
		return this.name + "," + this.ban + "," + this.no + "," + this.kor + "," + this.eng + "," + this.math + ","
				+ getTotal() + "," + getAverage();
	}

}
