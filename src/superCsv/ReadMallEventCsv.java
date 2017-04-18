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

public class ReadMallEventCsv {
static final String CSV_FILENAME = "csv/Mall_Event.csv";
	
	public static void main(String args[])
	{
		try{
		getMallEvents();
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
				new UniqueHashCode()		// EventId
				
		};
		return processors;
	}
	
	public static List<Mall_Event> getMallEvents() throws Exception{
		
		ICsvBeanReader reader = null;
		
		try	{
			reader = new CsvBeanReader(new FileReader(CSV_FILENAME), 
					CsvPreference.STANDARD_PREFERENCE);
			 // the header elements are used to map the values 
			// to the bean (names must match)
			
			final String[] header = reader.getHeader(true);
            final CellProcessor[] processors = getProcessors();
            
            List<Mall_Event> items = new ArrayList<>();
            Mall_Event item;
            while((item = reader.read(Mall_Event.class, header, processors)) != null)
            {
            	items.add(item);
            	
            }
            
            System.out.println(items);
            
            return items;
		}
		finally{
			if(reader != null)
			{
				reader.close();
			}
		}
		
	}
}
