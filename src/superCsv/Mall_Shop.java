package superCsv;

public class Mall_Shop {
	
	String mallId;
	String shopId;
	
	
	public String getMallId() {
		return mallId;
	}
	public void setMallId(String mallId) {
		this.mallId = mallId;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(mallId);
		sb.append(',');
		sb.append(shopId);
		return sb.toString();
	}
	
}
