package frame;

import java.awt.Component;

public class Book {

	String BookName;
	String BookCop;
	String BookPub;
	String BookInt;
	String question1;
	String question2;
	String question3;
	String answer1;
	String answer2;
	String answer3;
	Member m;

	public Book(String BookName, String BookCop, String BookPub, String BookInt, String question1, String question2, String question3, 
			String answer1, String answer2, String answer3) {
		this.BookName = BookName; // 책이름
		this.BookCop = BookCop; // 출판사
		this.BookPub = BookPub; // 저자
		this.BookInt = BookInt; // 책 소개
		this.BookName = BookName;
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;

	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getBookName() {
		return BookName;
	}

	public String getBookCop() {
		return BookCop;
	}

	public String getBookPub() {
		return BookPub;
	}

	public String getBookInt() {
		return BookInt;
	}


	public void setM(Member m) {
		this.m = m;
	}

	public Member getM() {
		return m;
	}
	
	
}