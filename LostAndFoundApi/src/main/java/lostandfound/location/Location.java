package lostandfound.location;

import javax.persistence.Embeddable;

@Embeddable
public class Location {
	private String place;
	private String street;
	private String city;
	private String state;

	public Location(String place, String street, String city, String state) {
		super();
		this.place = place;
		this.street = street;
		this.city = city;
		this.state = state;
	}

	public Location() {

	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
