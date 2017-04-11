package superCsv;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseBool;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class ReadShopCsv {
	
	static final String CSV_FILENAME = "csv/Shops.csv";
	public static void main(String args[])
	{
		try{
		getShops();
		System.out.println("Hello World");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	private static CellProcessor[] getProcessors()
	{
		final CellProcessor[] processors = new CellProcessor[]{
						
				new UniqueHashCode(),		// shopId
				new NotNull(),		//shop name
				new Optional(),		// brandImageUrl
				new Optional(),
				new Optional(),		// location
				new Optional(),		// phone
				new Optional(),		// email
				new NotNull(new ParseBool()),	// hasMenu
				new NotNull()		// gender
		};
		return processors;
	}
	
	public static List<Shop> getShops() throws Exception{
		
		ICsvBeanReader reader = null;
		
		try	{
			reader = new CsvBeanReader(new FileReader(CSV_FILENAME), 
					CsvPreference.STANDARD_PREFERENCE);
			 // the header elements are used to map the values 
			// to the bean (names must match)
			
			final String[] header = reader.getHeader(true);
            final CellProcessor[] processors = getProcessors();
            
            List<Shop> shops = new ArrayList<>();
            Shop shop;
            while((shop = reader.read(Shop.class, header, processors)) != null)
            {
            	shops.add(shop);
            }
            
           return shops;
		}
		finally{
			if(reader != null)
			{
				reader.close();
			}
		}
		
	}

}
