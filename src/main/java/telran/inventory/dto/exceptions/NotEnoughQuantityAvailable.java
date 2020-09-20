package telran.inventory.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class NotEnoughQuantityAvailable extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotEnoughQuantityAvailable(int quantity) {
		super("The quantity of items " + quantity + " is not available");
	}

}
