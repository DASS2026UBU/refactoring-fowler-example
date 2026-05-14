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
	
}
