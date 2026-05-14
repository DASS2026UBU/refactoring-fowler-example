package ubu.gii.dass.refactoring;

/**
* Tema  Refactorizaciones 
*
* Ejemplo de aplicaci�n de refactorizaciones. Actualizado para colecciones gen�ricas de java 1.5
*
* @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
* @version 1.1
* @see java.io.File
*
*/
import java.util.*;

public class Customer {
	private String _name;
	private List<Rental> _rentals;

	public Customer(String name) {
		_name = name;
		_rentals = new ArrayList<Rental>();

	};

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	};

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental each = rentals.next();
			// determine amounts for each line
			thisAmount = amountFor(thisAmount, each);

			frequentRenterPoints = getFrequentRenterPoints(frequentRenterPoints, each);
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints())
				+ " frequent renter points";
		return result;
	}
	
	public String htmlStatement() {
		Iterator<Rental> rentals = _rentals.iterator();
		String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
		
		while (rentals.hasNext()) {
			Rental each = rentals.next();
			// show figures for each rental
			result += each.getMovie().getTitle() + ": "
					+ String.valueOf(each.getCharge()) + "<BR>\n";
		}
		
		// add footer lines
		result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
		result += "On this rental you earned <EM>"
				+ String.valueOf(getTotalFrequentRenterPoints())
				+ "</EM> frequent renter points<P>";
		return result;
	}
	
	
	private double getTotalCharge() {
		double result = 0;
		for(Rental rental : _rentals) {
			result += rental.getCharge();
		}
		return result;
	}
	
	private int getTotalFrequentRenterPoints() {
		int result = 0;
		for (Rental rental : _rentals) {
			result += rental.getFrequentRenterPoints();
		}
		return result;
	}

	/**
	 * @deprecated Use {@link ubu.gii.dass.refactoring.Rental#getFrequentRenterPoints(int)} instead
	 */
	private int getFrequentRenterPoints(int frequentRenterPoints, Rental each) {
		return each.getFrequentRenterPoints();
	}

	/**
	 * @deprecated Use {@link ubu.gii.dass.refactoring.Rental#amountFor(double)} instead
	 */
	private double amountFor(double thisAmount, Rental each) {
		return each.getCharge();
	}
}
