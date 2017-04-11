package superCsv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateShops {
	
	static List<Shop> shops;
	static List<ShopCategory> shop_categories;
	static List<Category> categories;

	static List<ShopOffer> shop_offers;
	static List<Offer> offers;
	
	
	public static void main(String args[]){
		try{
			shops = ReadShopCsv.getShops();
			shop_categories = ReadShopCategoryCsv.getShopCategories();
			categories = ReadCategoryCsv.getCategories();
			shop_offers = ReadShopOfferCsv.getShopOffers();
			offers = ReadOfferCsv.getOffers();
			System.out.println(offers);
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		createShopWithCategories();		
	}

	private static void createShopWithCategories() {
		
		List<Integer> categoryIds;
		HashMap<Integer, String> categories_in_shop;
		
		List<String>	offerIds;
		HashMap<String, Offer> offers_in_shop; 
		for(Shop shop : shops){
			categoryIds = getShopCategoryIds(shop);
			categories_in_shop = getMatchingCategories(categoryIds);
			shop.setCategories(categories_in_shop);
			
			offerIds = getShopOfferIds(shop);
			System.out.println(offerIds);
			offers_in_shop = getMatchingOffers(offerIds);
			System.out.println(offers_in_shop);
			
			shop.setOffers(offers_in_shop);
			System.out.println(shop);
		}
		
	}


	private static List<Integer> getShopCategoryIds(Shop shop) {
		
		String shopId = shop.getShopId();
		List<Integer> filteredCategoryIds = new ArrayList<>();
		
		for(ShopCategory shop_category : shop_categories){
			
			if(shop_category.getShopId().equals(shopId)){
				filteredCategoryIds.add(shop_category.getCategoryId());
			}
		}
		return filteredCategoryIds;
	}
	
	private static HashMap<Integer, String> getMatchingCategories(List<Integer> categoryIds) {
		
		HashMap<Integer, String> filteredCategories = new HashMap<>();
		
		for(int category_id : categoryIds){
			
			for(Category category : categories){
				if(category_id == category.getCategoryId()){
					filteredCategories.put(category_id, category.getName());
				}
			}
		}
		return filteredCategories;
	}
	
	//==============================================================
	
	private static List<String> getShopOfferIds(Shop shop) {
		
		String shopId = shop.getShopId();
		List<String> filteredOfferIds = new ArrayList<>();
		
		for(ShopOffer shop_offer : shop_offers){
			
			if(shop_offer.getShopId().equals(shopId)){
				filteredOfferIds.add(shop_offer.getOfferId());
			}
		}
		return filteredOfferIds;
	}
	
	private static HashMap<String, Offer> getMatchingOffers(List<String> offerIds) {
		
		HashMap<String, Offer> filteredOffers = new HashMap<>();
		
		for(String offer_id : offerIds){
			
			for(Offer offer : offers){
				if(offer_id.equals(offer.getOfferId())){
					filteredOffers.put(offer_id, offer);
				}
			}
		}
		return filteredOffers;
	}

	public static List<Shop> getShops()
	{
		main(null);				// I call getShops() method from other class coz shops is 
								// initialized only after main is run so I am running main()
		return shops;
	}
	

}
