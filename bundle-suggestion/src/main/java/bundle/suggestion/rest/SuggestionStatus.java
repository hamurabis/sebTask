package bundle.suggestion.rest;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds suggestion status used for custom budle processing
 * 
 * @author MG
 *
 */
public class SuggestionStatus {
	
	/**
	 * Holds error message if any rule failed during validation
	 */
	private List<String> errors = new ArrayList<String>();

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
