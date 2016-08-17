package webshop.domain;

public class Customer {
	private String customerId;
	private String name;
	private String adress;
	private int noOfOrderMade;

	public Customer() {
		super();
	}
	public Customer(String customerId, String adress, String name){
		this.customerId = customerId;
		this.adress = adress;
		this.name = name;
		noOfOrderMade = 0 ;
	}
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getNoOfOrderMade() {
		return noOfOrderMade;
	}

	public void setNoOfOrderMade(int noOfOrderMade) {
		this.noOfOrderMade = noOfOrderMade;
	}

}
