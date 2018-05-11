package model;

public class StudentAddress {
	
	private int addId;
	private String street;
	private String area;
	private String city;
	private String state;
	private String zip;
	
	public StudentAddress(){
		
	}
	public StudentAddress(int addId, String street, String area, String city,
			String state, String zip) {
		super();
		this.addId = addId;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
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
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
}
