package superCsv;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

public class GetJson {

	private static List<Mall> malls;
	public static void main(String args[]){
		
		malls = CreateMallsWithShops.getMalls();
		Malls fmalls = new Malls();
		
		fmalls.setMalls(getHashMapMall(malls));  						// send a list of malls and get a hashmap of malls
		
		ObjectMapper mapper = new ObjectMapper();
		String json;
		try{
			json = mapper.writeValueAsString(fmalls);
			System.out.println(json);
			mapper.writeValue(new File("d:\\malls.json"), fmalls);
		}
		catch(Exception e)
		{
			System.out.println(e + "from catch");
			json = "ghanta";
		}
		
		
	}
	
	// Gets a list of malls and converts them to a HashMap
	
	private static HashMap<String, Mall> getHashMapMall(List<Mall> mallList){
		
		HashMap<String, Mall> mallHashMap = new HashMap<String, Mall>();
		for(Mall m : mallList){
			mallHashMap.put(m.getId(), m);
		}
		return mallHashMap;
	}
	
}
