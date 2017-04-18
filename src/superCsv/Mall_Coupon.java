package superCsv;

public class Mall_Coupon {

	String mallId;
	String couponId;
	
	public Mall_Coupon() {
		super();
	}

	public String getMallId() {
		return mallId;
	}

	public void setMallId(String mallId) {
		this.mallId = mallId;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(mallId);
		sb.append(',');
		sb.append(couponId);
		return sb.toString();
	}
}
