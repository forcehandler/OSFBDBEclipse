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

public class ReadMallShopCsv {
	
	static final String CSV_FILENAME = "mall_shop.csv";
	
	public static void main(String args[])
	{
		try{
		getMallShops();
		System.out.println("Hello World");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	private static CellProcessor[] getProcessors()
	{
		final CellProcessor[] processors = new CellProcessor[]{
				new NotNull(),		// mallId Need not be unique(one to many)
				new UniqueHashCode()
				
		};
		return processors;
	}
	
	public static List<Mall_Shop> getMallShops() throws Exception{
		
		ICsvBeanReader reader = null;
		
		try	{
			reader = new CsvBeanReader(new FileReader(CSV_FILENAME), 
					CsvPreference.STANDARD_PREFERENCE);
			 // the header elements are used to map the values 
			// to the bean (names must match)
			
			final String[] header = reader.getHeader(true);
            final CellProcessor[] processors = getProcessors();
            
            List<Mall_Shop> mall_shops = new ArrayList<>();
            Mall_Shop mall_shop;
            while((mall_shop = reader.read(Mall_Shop.class, header, processors)) != null)
            {
            	mall_shops.add(mall_shop);
            	
            }
            
            
            return mall_shops;
		}
		finally{
			if(reader != null)
			{
				reader.close();
			}
		}
		
	}

}
