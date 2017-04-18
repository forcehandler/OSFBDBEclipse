package superCsv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateMalls {
	
	static List<Mall> malls;
	static List<Mall_Shop> mall_shops;
	static List<Shop> shops;
	
	static List<Mall_Coupon> mall_coupons;
	static List<Coupon> coupons;
	
	static List<Mall_Event> mall_events;
	static List<Event> events;
	
	public static void main(String args[]){
		try{
			malls = ReadMallCsv.getMalls();
			mall_shops = ReadMallShopCsv.getMallShops();
			shops = CreateShops.getShops();
			
			mall_coupons = ReadMallCouponCsv.getMallCoupons();
			coupons = ReadCouponCsv.getCoupons();
			
			mall_events = ReadMallEventCsv.getMallEvents();
			events = ReadEventCsv.getEvents();
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		createMall();		// Changes the malls list to malls containing shops
	}

	private static void createMall() {
		
		List<String> shopIds;
		HashMap<String, Shop> shops_in_mall;
		
		List<String> couponIds;
		HashMap <String, Coupon> coupons_in_mall;
		
		List<String> eventIds;
		HashMap <String, Event> events_in_mall;
		
		for(Mall mall : malls){
			shopIds = getMallShopIds(mall);
			shops_in_mall = getMatchingShops(shopIds);
			mall.setShops(shops_in_mall);
			
			couponIds = getMallCouponIds(mall);
			coupons_in_mall = getMatchingCoupons(couponIds);
			mall.setCoupons(coupons_in_mall);
			
			eventIds = getMallEventIds(mall);
			events_in_mall = getMatchingEvents(eventIds);
			mall.setEvents(events_in_mall);
			System.out.println(mall);
		}
		
	}


	private static List<String> getMallShopIds(Mall mall) {
		
		String mallId = mall.getMallId();
		List<String> filteredShopIds = new ArrayList<>();
		
		for(Mall_Shop mall_shop : mall_shops){
			
			if(mall_shop.getMallId().equals(mallId)){
				filteredShopIds.add(mall_shop.getShopId());
			}
		}
		return filteredShopIds;
	}
	
	private static HashMap<String, Shop> getMatchingShops(List<String> shopIds) {
		
		HashMap<String, Shop> filteredShops = new HashMap<String, Shop>();
		
		for(String shopId : shopIds){
			
			for(Shop shop : shops){
				if(shopId.equals(shop.getShopId())){
					filteredShops.put(shopId, shop);
				}
			}
		}
		return filteredShops;
	}
	
	private static List<String> getMallCouponIds(Mall mall) {
		
		String mallId = mall.getMallId();
		List<String> filteredCouponIds = new ArrayList<>();
		
		for(Mall_Coupon mall_coupon : mall_coupons){
			
			if(mall_coupon.getMallId().equals(mallId)){
				filteredCouponIds.add(mall_coupon.getCouponId());
			}
		}
		return filteredCouponIds;
	}
	
	private static HashMap<String, Coupon> getMatchingCoupons(List<String> couponIds) {
		
		HashMap<String, Coupon> filteredCoupons = new HashMap<>();
		
		for(String couponId : couponIds){
			
			for(Coupon coupon : coupons){
				if(couponId.equals(coupon.getCouponId())){
					filteredCoupons.put(couponId, coupon);
				}
			}
		}
		return filteredCoupons;
	}

	private static List<String> getMallEventIds(Mall mall) {
		
		String mallId = mall.getMallId();
		List<String> filteredEventIds = new ArrayList<>();
		
		for(Mall_Event mall_event : mall_events){
			
			if(mall_event.getMallId().equals(mallId)){
				filteredEventIds.add(mall_event.getEventId());
			}
		}
		return filteredEventIds;
	}
	
	private static HashMap<String, Event> getMatchingEvents(List<String> ids) {
		
		HashMap<String, Event> filteredItems = new HashMap<>();
		
		for(String id : ids){
			
			for(Event item : events){
				if(id.equals(item.getEventId())){
					filteredItems.put(id, item);
				}
			}
		}
		return filteredItems;
	}
	public static List<Mall> getMalls()
	{
		main(null);				// I call getMalls() method from other class and malls is 
								// initialized only after main is run so I am running main()
		return malls;
	}
	
	
	
}
