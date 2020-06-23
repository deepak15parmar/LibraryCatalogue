package librarycatalogue;

public class Book {
	//Properties, fields, Global Variables
	String title;
	int pageCount;
	int ISBN;
	boolean isCheckedOut;//whether or not it is checked out
	int dayCheckedOut = -1 ;
	//Constructor
	public Book(String bookTitle, int bookPageCount, int bookISBN) {
		this.title = bookTitle ;
		this.pageCount = bookPageCount;
		this.ISBN = bookISBN;
		this.isCheckedOut = false ;
		
	}
	
	//Getters  ----> INSTANCE Methods
	
	public String getTitle() {
		return this.title;
	}
	
	public int getPageCOunt() {
		return this.pageCount;
	}

	public int getISBN() {
		return this.ISBN;
	}
	
	public boolean getIsCheckedOut() {
		return this.isCheckedOut;
	}
	public int getDayCheckedOut() {
		return this.dayCheckedOut;
	}
	
	//Setters
	
	public void setIsCheckedOut(boolean newIsCheckedOut, int currentDayCheckedOut) {
		this.isCheckedOut = newIsCheckedOut ;
		setDayCheckedOut(currentDayCheckedOut);
		
	}
	
	private void setDayCheckedOut(int Day) {
		this.dayCheckedOut = Day ;
	}


}
