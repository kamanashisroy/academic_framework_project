package framework.account.info;

public class DefaultAddress implements IAddress {
	String street = null;
	String city = null;
	String state = null;
	String zipCode = null;
	String email = null;
	String country = null;
	public DefaultAddress(
			String street
			, String city
			, String state
			, String zipCode
			, String country, String email) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.email = email;
	}
	
	@Override
	public String getStreetAddress() {
		return street;
	}

	@Override
	public String getCity() {
		return city;
	}

	@Override
	public String getState() {
		return state;
	}
	
	@Override
	public String getCountry() {
		return country;
	}

	@Override
	public String getZipCode() {
		return zipCode;
	}

	@Override
	public String getEmail() {
		return email;
	}

}
