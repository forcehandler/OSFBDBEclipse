package superCsv;

import java.util.HashMap;

public class Shop {
	
	String shopId;
	String name;
	String brandImageURL;
	String shopImageURL;
	String location;
	String phone;
	String email;
	boolean hasMenu;
	String gender;
	HashMap<Integer, String> categories;
	
	
	public Shop() {}
	
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrandImageURL() {
		return brandImageURL;
	}
	public void setBrandImageURL(String brandImageURL) {
		this.brandImageURL = brandImageURL;
	}
	public String getShopImageURL() {
		return shopImageURL;
	}
	public void setShopImageURL(String shopImageURL) {
		this.shopImageURL = shopImageURL;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isHasMenu() {
		return hasMenu;
	}
	public void setHasMenu(boolean hasMenu) {
		this.hasMenu = hasMenu;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public HashMap<Integer, String> getCategories() {
		return categories;
	}

	public void setCategories(HashMap<Integer, String> categories) {
		this.categories = categories;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append( "ShopId = " + shopId + " name = "+ name);
		
		return sb.toString();
	}
}
