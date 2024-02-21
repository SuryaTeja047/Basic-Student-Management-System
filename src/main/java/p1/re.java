package p1;

public class re {
	public static char grade(int marks) {
		char a=' ';
			if(marks<35) {
				a='F';
			}
			else if(marks>=35 && marks<50) {
				a='E';
			}
			else if(marks>=50 && marks<60) {
				a='D';
			}
			else if(marks>=60 && marks<70) {
				a='C';
			}
			else if(marks>=70 && marks<80) {
				a='B';
			}
			else if(marks>=80 && marks<90) {
				a='A';
			}
			else if(marks>=90 && marks<=100) {
				a='O';
			}
		return a;
	}
}
