package superCsv;

import java.io.FileReader;
import java.io.IOException;
 
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;
 
public class ReadCSVFileExample {
 
    static final String CSV_FILENAME = "mall.csv";
 
    public static void main(String[] args) throws IOException 
    {
        try(ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(CSV_FILENAME), CsvPreference.STANDARD_PREFERENCE))
        {
            // the header elements are used to map the values to the bean
            final String[] headers = beanReader.getHeader(true);
            //final String[] headers = new String[]{"CustomerId","CustomerName","Country","PinCode","Email"};
            final CellProcessor[] processors = getProcessors();
 
            Mall customer;
            while ((customer = beanReader.read(Mall.class, headers, processors)) != null) {
                System.out.println(customer);
            }
        } 
    }
 
    /**
     * Sets up the processors used for the examples.
     */
    private static CellProcessor[] getProcessors() {
        final String emailRegex = "[a-z0-9\\._]+@[a-z0-9\\.]+";
        StrRegEx.registerMessage(emailRegex, "must be a valid email address");
 
        final CellProcessor[] processors = new CellProcessor[] {
        		new UniqueHashCode(),	// MallId should be unique
				new NotNull(),		// name of mall
				new Optional(),		// phone no
				new Optional()		//email
        };
        return processors;
    }
}
