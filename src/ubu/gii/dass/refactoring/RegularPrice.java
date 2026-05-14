package ubu.gii.dass.refactoring;

public class RegularPrice extends MoviePrice{

	@Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }
	
}
