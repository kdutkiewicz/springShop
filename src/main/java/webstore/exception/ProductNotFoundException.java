package webstore.exception;

public class ProductNotFoundException extends RuntimeException {
	private static final long serialVersioUID = -12321421521521512L;
	private String productId;
	public ProductNotFoundException(String productId){
		this.productId = productId;
	}
	public String getProductId(){
		return productId;
	}
}
