package webstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="There is no products under this category")
public class NoProductFoundUnderCategoryException extends RuntimeException{
	private static final long serialVersionUID = 2132143256314643216L;
}
