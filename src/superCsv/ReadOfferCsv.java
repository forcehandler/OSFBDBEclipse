package superCsv;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class ReadOfferCsv {

static final String CSV_FILENAME = "csv/Offers.csv";
	
	public static void main(String args[])
	{
		try{
		getOffers();
		System.out.println("Hello World");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	private static CellProcessor[] getProcessors()
	{
		final CellProcessor[] processors = new CellProcessor[]{
				new UniqueHashCode(),	// OfferId should be unique
				new NotNull(),		// description
				new Optional(),		// validity
				new NotNull(),		// tnc
				new Optional()		// couponImageURL
				
				
		};
		return processors;
	}
	
	public static List<Offer> getOffers() throws Exception{
		
		ICsvBeanReader reader = null;
		
		try	{
			reader = new CsvBeanReader(new FileReader(CSV_FILENAME), 
					CsvPreference.STANDARD_PREFERENCE);
			 // the header elements are used to map the values 
			// to the bean (names must match)
			
			final String[] header = reader.getHeader(true);
            final CellProcessor[] processors = getProcessors();
            
            List<Offer> offers = new ArrayList<>();
            Offer offer;
            while((offer = reader.read(Offer.class, header, processors)) != null)
            {
            	offers.add(offer);
            }
            
           
            return offers;
		}
		finally{
			if(reader != null)
			{
				reader.close();
			}
		}
		
	}
}
