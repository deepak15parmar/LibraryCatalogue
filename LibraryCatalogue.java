package librarycatalogue;

import java.util.HashMap;
import java.util.Map;

public class LibraryCatalogue {
	
	// Properties
	Map<String,Book> bookCollection = new HashMap<String,Book>();
	double initialLateFee = 0.50;
	double lateFeePerDay = 1.50;
	int currentDay = 0;
	int lengthOfCheckoutPeriod = 7 ;
	
	//Constructors
	
	public LibraryCatalogue(Map<String,Book> collection) {
		this.bookCollection = collection ;
	}
	
	public LibraryCatalogue(Map<String,Book> collection, int lengthOfCheckoutPeriod, double initialFee, double lateFee) {
		this.bookCollection = collection ;
		this.lengthOfCheckoutPeriod = lengthOfCheckoutPeriod;
		this.initialLateFee = initialFee;
		this.lateFeePerDay = lateFee ;
	}
	
	//Getters
	
	public int getCurrentDay() {
		return this.currentDay;
		
	}
	public int getLengthOfCheckoutPeriod() {
		return this.lengthOfCheckoutPeriod;
	}
	public double getInitialLateFee() {
		return this.initialLateFee;
	}
	public double getLateFeePerDay() {
		return this.lateFeePerDay;
	}
	public Map<String,Book> getBookCollection() {
		return this.bookCollection;
	}
	
	public Book getBook(String bookTitle) {
		return getBookCollection().get(bookTitle);
		
	}
	
	//Setters
	
	public void nextDay() {
		currentDay++ ;
	}
	
	public void setDay(int day) {
		currentDay = day ;
	}
	
	
	public void checkOutBook(String title) {
		Book book = getBook(title);
		if(book.getIsCheckedOut()) {
			sorryBookAlreadyCheckedOut(book);
		}else {
			book.setIsCheckedOut(true,currentDay);
			System.out.println("You just checked out "+ title + ". It is due on day "+ (getCurrentDay() + getLengthOfCheckoutPeriod())+".");
		}
	}
	
	public void returnBook(String title) {
		Book book = getBook(title);
		int daysLate = currentDay - (book.getDayCheckedOut()+ getLengthOfCheckoutPeriod());
		
		if(daysLate>0) {
			System.out.println("You owe the library $"+ (getInitialLateFee() + daysLate*getLateFeePerDay() ) +" because your book is "+
					daysLate + " days overdue.");
		}else {
			System.out.println("Book returned.");
			
		}
		
		book.setIsCheckedOut(false,-1);
	}
	
	public void sorryBookAlreadyCheckedOut(Book book) {
		System.out.println("Sorry, "+ book.getTitle()+" is already checked out."
				+" It should be back on the day " + (book.getDayCheckedOut() + getLengthOfCheckoutPeriod()+ "."));
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Map<String,Book> collection = new HashMap<String,Book>();
			Book Harry = new Book("Harry Potter",2738,9999);
			collection.put("Harry Potter",Harry);
			LibraryCatalogue lib = new LibraryCatalogue(collection);
			lib.checkOutBook("Harry Potter");
			lib.nextDay();
			lib.nextDay();
			lib.checkOutBook("Harry Potter");
			lib.setDay(30);
			lib.returnBook("Harry Potter");
			lib.checkOutBook("Harry Potter");
	}

}
