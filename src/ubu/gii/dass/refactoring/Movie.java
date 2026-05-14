package ubu.gii.dass.refactoring;
/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5.
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.1
 * @see java.io.File
 * 
 */

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
	private MoviePrice _price;

	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return _price.getPriceCode();
	}

	public void setPriceCode(int arg) {
		switch (arg) {
		case REGULAR:
			_price = new RegularPrice();
			break;
		case CHILDRENS:
			_price = new ChildrenPrice();
			break;
		case NEW_RELEASE:
			_price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
	}

	public String getTitle() {
		return _title;
	}

	/**
	 * @deprecated Use {@link #MISSING()} instead
	 */
	double getCharge(Rental rental) {
		return getCharge(0);
	}

	/**
	 * @deprecated Use {@link ubu.gii.dass.refactoring.MoviePrice#getCharge(ubu.gii.dass.refactoring.Movie,int)} instead
	 */
	double getCharge(int daysRented) {
		return _price.getCharge(this, daysRented);
	}

	/**
	 * @deprecated Use {@link #MISSING()} instead
	 */
	int getFrequentRenterPoints(Rental rental) {
		return getFrequentRenterPoints(0);
	}

	/**
	 * @deprecated Use {@link ubu.gii.dass.refactoring.MoviePrice#getFrequentRenterPoints(ubu.gii.dass.refactoring.Movie,int)} instead
	 */
	int getFrequentRenterPoints(int daysRented) {
		return _price.getFrequentRenterPoints(this, daysRented);
	}
}
