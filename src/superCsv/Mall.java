package superCsv;

import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;


public class Mall {
	
	String mallId;
	String name;
	String phone;
	String email;
	String address;
	double latitude;
	double longitude;
	float radius;
	int m1;
	int m2;
	int m3;
	int m4;
	int m5;
	
	HashMap<String, Shop> shops;
	
	public String getId() {
		return mallId;
	}
	public void setId(String id) {
		this.mallId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public HashMap<String, Shop> getShops() {
		return shops;
	}
	public void setShops(HashMap<String, Shop> shops) {
		this.shops = shops;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append( "MallId = " + id + " name = "+ name + 
				" shops = \n");
		for(Shop shop : shops.values())
		{
			
			sb.append("shopid = " + shop.getId());
			sb.append(" shop name = " + shop.getName());
			sb.append("\n");
			
		}
		return sb.toString();
	}
	
}
