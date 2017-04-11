package superCsv;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class ReadShopOfferCsv {

static final String CSV_FILENAME = "csv/Shop_Offer.csv";
	
	public static void main(String args[])
	{
		try{
		getShopOffers();
		System.out.println("Hello World");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	private static CellProcessor[] getProcessors()
	{
		final CellProcessor[] processors = new CellProcessor[]{
				new NotNull(),		// shopId Need not be unique(one to many)
				new UniqueHashCode()		// offerId has to be unique
				
		};
		return processors;
	}
	
	public static List<ShopOffer> getShopOffers() throws Exception{
		
		ICsvBeanReader reader = null;
		
		try	{
			reader = new CsvBeanReader(new FileReader(CSV_FILENAME), 
					CsvPreference.STANDARD_PREFERENCE);
			 // the header elements are used to map the values 
			// to the bean (names must match)
			
			final String[] header = reader.getHeader(true);
            final CellProcessor[] processors = getProcessors();
            
            List<ShopOffer> shop_offers = new ArrayList<>();
            ShopOffer shop_offer;
            while((shop_offer = reader.read(ShopOffer.class, header, processors)) != null)
            {
            	shop_offers.add(shop_offer);
            	
            }
            
            
            return shop_offers;
		}
		finally{
			if(reader != null)
			{
				reader.close();
			}
		}
		
	}
}
