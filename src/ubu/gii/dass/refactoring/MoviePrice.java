package ubu.gii.dass.refactoring;

public abstract class MoviePrice {
	
	public abstract int getPriceCode();
	
	public abstract double getCharge(int daysRented);


	int getFrequentRenterPoints(Movie movie, int daysRented) {
		// add bonus for a two day new release rental
		if ((movie.getPriceCode() == Movie.NEW_RELEASE)
				&& daysRented > 1)
			return 2;
		return 1;
	}
	
}
