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

public class ReadMallCouponCsv {

	
	static final String CSV_FILENAME = "csv/Mall_Coupon.csv";
	
	public static void main(String args[])
	{
		try{
		getMallCoupons();
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
				new NotNull()		// couponId
				
		};
		return processors;
	}
	
	public static List<Mall_Coupon> getMallCoupons() throws Exception{
		
		ICsvBeanReader reader = null;
		
		try	{
			reader = new CsvBeanReader(new FileReader(CSV_FILENAME), 
					CsvPreference.STANDARD_PREFERENCE);
			 // the header elements are used to map the values 
			// to the bean (names must match)
			
			final String[] header = reader.getHeader(true);
            final CellProcessor[] processors = getProcessors();
            
            List<Mall_Coupon> mall_coupons = new ArrayList<>();
            Mall_Coupon mall_coupon;
            while((mall_coupon = reader.read(Mall_Coupon.class, header, processors)) != null)
            {
            	mall_coupons.add(mall_coupon);
            	
            }
            
            System.out.println(mall_coupons);
            return mall_coupons;
		}
		finally{
			if(reader != null)
			{
				reader.close();
			}
		}
		
	}
}
