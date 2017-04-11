package superCsv;

public class ShopOffer {

	String shopId;
	String offerId;
	public ShopOffer() {}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getOfferId() {
		return offerId;
	}
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		sb.append(shopId + " " + offerId);
		return sb.toString();
	}
}
