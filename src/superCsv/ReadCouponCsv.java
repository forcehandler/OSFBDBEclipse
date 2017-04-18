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

public class ReadCouponCsv {


static final String CSV_FILENAME = "csv/Coupons.csv";
	
	public static void main(String args[])
	{
		try{
		getCoupons();
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
				new NotNull(),		// brand name
				new NotNull(),		// logoURL
				new NotNull(),		// description
				new NotNull(), 		// code
				new NotNull(new ParseInt()),	// validity
				new NotNull(),		// tnc
				new NotNull(new ParseInt()), 	// price
				new NotNull()		// couponImageURL
				
				
		};
		return processors;
	}
	
	public static List<Coupon> getCoupons() throws Exception{
		
		ICsvBeanReader reader = null;
		
		try	{
			reader = new CsvBeanReader(new FileReader(CSV_FILENAME), 
					CsvPreference.STANDARD_PREFERENCE);
			 // the header elements are used to map the values 
			// to the bean (names must match)
			
			final String[] header = reader.getHeader(true);
            final CellProcessor[] processors = getProcessors();
            
            List<Coupon> coupons = new ArrayList<>();
            Coupon coupon;
            while((coupon = reader.read(Coupon.class, header, processors)) != null)
            {
            	coupons.add(coupon);
            }
            
           System.out.println(coupons);
            return coupons;
		}
		finally{
			if(reader != null)
			{
				reader.close();
			}
		}
		
	}
	
}
