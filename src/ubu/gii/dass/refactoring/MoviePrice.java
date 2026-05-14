package ubu.gii.dass.refactoring;

public abstract class MoviePrice {
	
	public abstract int getPriceCode();
	
	public abstract double getCharge(int daysRented);


	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}
	
}
