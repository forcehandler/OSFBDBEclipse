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

public class ReadEventCsv {

static final String CSV_FILENAME = "csv/Events.csv";
	
	public static void main(String args[])
	{
		try{
		getEvents();
		System.out.println("Hello World");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	private static CellProcessor[] getProcessors()
	{
		final CellProcessor[] processors = new CellProcessor[]{
				new UniqueHashCode(),	// CouponId should be unique
				new NotNull(),		// event name
				new NotNull(),		// date
				new NotNull(),		// time
				new NotNull(), 		// location
				new NotNull(),		// description
				
				
		};
		return processors;
	}
	
	public static List<Event> getEvents() throws Exception{
		
		ICsvBeanReader reader = null;
		
		try	{
			reader = new CsvBeanReader(new FileReader(CSV_FILENAME), 
					CsvPreference.STANDARD_PREFERENCE);
			 // the header elements are used to map the values 
			// to the bean (names must match)
			
			final String[] header = reader.getHeader(true);
            final CellProcessor[] processors = getProcessors();
            
            List<Event> events = new ArrayList<>();
            Event event;
            while((event = reader.read(Event.class, header, processors)) != null)
            {
            	events.add(event);
            }
            
           System.out.println(events);
            return events;
		}
		finally{
			if(reader != null)
			{
				reader.close();
			}
		}
		
	}
}
