package bundle.suggestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bundle.suggestion.bundle.Bundle;
import bundle.suggestion.bundle.CustomBundle;
import bundle.suggestion.customer.Customer;
import bundle.suggestion.service.BundleService;

/**
 * REST services for bundles suggestions
 * 
 * @author MG
 *
 */
@RestController
@RequestMapping("/services")
public class SuggestionRestService {
	
	@Autowired
	private BundleService suggestionService;
	
	
	/**
	 * Method which suggest budle for customer
	 * 
	 * @param age customer age
	 * @param income customer income
	 * @param isStudent is customer student
	 * @return suggested bundle
	 * 
	 * @author MG
	 */
	@RequestMapping(value = "/suggest", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Bundle> getSuggestion(@RequestParam int age, 
			@RequestParam int income, @RequestParam boolean isStudent) {
		Customer customer = createCustomer(age, income, isStudent);
		Bundle bundles = suggestionService.suggest(customer);
		if (bundles == null) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Bundle>(bundles, HttpStatus.CREATED);
	}

	/**
	 * Method which creates customer object from passed parameters
	 * 
	 * @param age customer age
	 * @param income customer income
	 * @param isStudent is customer student
	 * @return new {@link Customer}
	 * 
	 * @author MG
	 */
	private Customer createCustomer(int age, int income, boolean isStudent) {
		Customer customer = new Customer();
		customer.setAge(age);
		customer.setIncome(income);
		customer.setStudent(isStudent);
		return customer;
	}
	
	/**
	 * Checks if custom bundle could be created from passed bundle name and changes to it
	 * 
	 * @param age customer age
	 * @param income customer income
	 * @param isStudent is customer student
	 * @param bundle bundle changes json object
	 * @return HttpStatus.OK if everything is ok,  HttpStatus.BAD_REQUEST otherwise with error list
	 * 
	 * @author MG
	 */
	@RequestMapping(value = "/custom", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<SuggestionStatus> postCustomBundle(@RequestParam int age, 
			@RequestParam int income, @RequestParam boolean isStudent, @RequestBody CustomBundle bundle) {
		Customer customer = createCustomer(age, income, isStudent);
		SuggestionStatus result = suggestionService.validatesCustomBundle(customer, bundle);
		if (result.getErrors().isEmpty()) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity<SuggestionStatus>(result, HttpStatus.BAD_REQUEST);
	}

	public BundleService getSuggestionService() {
		return suggestionService;
	}

	public void setSuggestionService(BundleService suggestionService) {
		this.suggestionService = suggestionService;
	}
}
