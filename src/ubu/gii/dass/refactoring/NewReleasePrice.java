package ubu.gii.dass.refactoring;

public class NewReleasePrice extends MoviePrice{

	@Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

	@Override
	public double getCharge(int daysRented) {
		return daysRented * 3;
	}
	
	@Override
	public int getFrequentRenterPoints(int daysRented) {
		// add bonus for a two day new release rental
		if (daysRented > 1)
			return 2;
		return 1;
	}
	
}
