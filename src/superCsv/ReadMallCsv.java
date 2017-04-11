package superCsv;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class ReadMallCsv {
	
	static final String CSV_FILENAME = "csv/Malls.csv";
	
	public static void main(String args[])
	{
		try{
		getMalls();
		System.out.println("Hello World");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	private static CellProcessor[] getProcessors()
	{
		final CellProcessor[] processors = new CellProcessor[]{
				new UniqueHashCode(),	// MallId should be unique
				new NotNull(),		// name of mall
				new Optional(),		// address of mall
				new Optional(),		// phone
				new Optional(),		// email
				new NotNull(new ParseDouble()),		// latitude
				new NotNull(new ParseDouble()),		// longitude
				new NotNull(new ParseDouble()),		// radius
				new Optional(new ParseInt()),		// milestones m1,m2,...
				new Optional(new ParseInt()),
				new Optional(new ParseInt()),
				new Optional(new ParseInt()),
				new Optional(new ParseInt()),
				
		};
		return processors;
	}
	
	public static List<Mall> getMalls() throws Exception{
		
		ICsvBeanReader mallReader = null;
		
		try	{
			mallReader = new CsvBeanReader(new FileReader(CSV_FILENAME), 
					CsvPreference.STANDARD_PREFERENCE);
			 // the header elements are used to map the values 
			// to the bean (names must match)
			
			final String[] header = mallReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();
            
            List<Mall> malls = new ArrayList<>();
            Mall mall;
            while((mall = mallReader.read(Mall.class, header, processors)) != null)
            {
            	malls.add(mall);
            }
            
           
            return malls;
		}
		finally{
			if(mallReader != null)
			{
				mallReader.close();
			}
		}
		
	}
}
