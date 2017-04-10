package superCsv;


public class Shop {
	
	String id;
	String name;
	String brandImageUrl;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrandImageUrl() {
		return brandImageUrl;
	}
	public void setBrandImageUrl(String brandImageUrl) {
		this.brandImageUrl = brandImageUrl;
	}
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append( "ShopId = " + id + " name = "+ name);
		
		return sb.toString();
	}
}
