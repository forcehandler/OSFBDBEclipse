package superCsv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateMallsWithShops {
	
	static List<Mall> malls;
	static List<Mall_Shop> mall_shops;
	static List<Shop> shops;
	
	
	public static void main(String args[]){
		try{
			malls = ReadMallCsv.getMalls();
			mall_shops = ReadMallShopCsv.getMallShops();
			shops = CreateShopsWithCategories.getShops();
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		createMallWithShops();		// Changes the malls list to malls containing shops
	}

	private static void createMallWithShops() {
		
		List<String> shopIds;
		List<Shop> shops_in_mall;
		HashMap<String, Shop> shops_in_mall_map;
		for(Mall mall : malls){
			shopIds = getMallShopIds(mall);
			shops_in_mall = getMatchingShops(shopIds);
			shops_in_mall_map = getHashMapShops(shops_in_mall);
			mall.setShops(shops_in_mall_map);
			
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
	
	private static List<Shop> getMatchingShops(List<String> shopIds) {
		
		List<Shop> filteredShops = new ArrayList<>();
		
		for(String shopId : shopIds){
			
			for(Shop shop : shops){
				if(shopId.equals(shop.getShopId())){
					filteredShops.add(shop);
				}
			}
		}
		return filteredShops;
	}

	public static List<Mall> getMalls()
	{
		main(null);				// I call getMalls() method from other class and malls is 
								// initialized only after main is run so I am running main()
		return malls;
	}
	
	private static HashMap<String, Shop> getHashMapShops(List<Shop> shopList){
		HashMap<String, Shop> shopMap = new HashMap<>();
		
		for(Shop shop : shopList){		
			shopMap.put(shop.getShopId(), shop);		
		}
		
		return shopMap;
	}
	
}
