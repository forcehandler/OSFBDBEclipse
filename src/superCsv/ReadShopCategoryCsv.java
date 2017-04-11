package superCsv;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class ReadShopCategoryCsv {

static final String CSV_FILENAME = "csv/Shop_Category.csv";
	
	public static void main(String args[])
	{
		try{
		getShopCategories();
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
				new NotNull(new ParseInt())		// categoryId
				
		};
		return processors;
	}
	
	public static List<ShopCategory> getShopCategories() throws Exception{
		
		ICsvBeanReader reader = null;
		
		try	{
			reader = new CsvBeanReader(new FileReader(CSV_FILENAME), 
					CsvPreference.STANDARD_PREFERENCE);
			 // the header elements are used to map the values 
			// to the bean (names must match)
			
			final String[] header = reader.getHeader(true);
            final CellProcessor[] processors = getProcessors();
            
            List<ShopCategory> shop_categories = new ArrayList<>();
            ShopCategory shop_category;
            while((shop_category = reader.read(ShopCategory.class, header, processors)) != null)
            {
            	shop_categories.add(shop_category);
            	
            }
            
            
            return shop_categories;
		}
		finally{
			if(reader != null)
			{
				reader.close();
			}
		}
		
	}
}
