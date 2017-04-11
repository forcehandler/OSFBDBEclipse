package superCsv;

public class Offer {

	String offerId;
	String description;
	String validity;
	String tnc;
	String couponImageURL;
	public Offer() {}
	public String getOfferId() {
		return offerId;
	}
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public String getTnc() {
		return tnc;
	}
	public void setTnc(String tnc) {
		this.tnc = tnc;
	}
	public String getCouponImageURL() {
		return couponImageURL;
	}
	public void setCouponImageURL(String couponImageURL) {
		this.couponImageURL = couponImageURL;
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		sb.append(offerId + "  " + description);
		return sb.toString();
	}
}
