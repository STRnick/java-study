package prob02;

public class Book {
	private int bookNo;
	private String title, author;
	private int stateCode = 1; // 0: 대여중, 1: 재고 있음

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Book(int bookNo, String title, String author) {
		
	}

	public void print() {
		// TODO Auto-generated method stub
		
	}

}
