package superCsv;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class ReadCategoryCsv {

static final String CSV_FILENAME = "csv/Categories.csv";
	
	public static void main(String args[])
	{
		try{
		getCategories();
		System.out.println("Hello World");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	private static CellProcessor[] getProcessors()
	{
		final CellProcessor[] processors = new CellProcessor[]{
				new UniqueHashCode(),	// CategoryId should be unique
				new NotNull()		// Category name
				
				
		};
		return processors;
	}
	
	public static List<Category> getCategories() throws Exception{
		
		ICsvBeanReader reader = null;
		
		try	{
			reader = new CsvBeanReader(new FileReader(CSV_FILENAME), 
					CsvPreference.STANDARD_PREFERENCE);
			 // the header elements are used to map the values 
			// to the bean (names must match)
			
			final String[] header = reader.getHeader(true);
            final CellProcessor[] processors = getProcessors();
            
            List<Category> categories = new ArrayList<>();
            Category category;
            while((category = reader.read(Category.class, header, processors)) != null)
            {
            	categories.add(category);
            }
            
           
            return categories;
		}
		finally{
			if(reader != null)
			{
				reader.close();
			}
		}
		
	}
}
