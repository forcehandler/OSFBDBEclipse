package superCsv;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

public class GetJson {

	private static List<Mall> malls;
	private static HashMap<String, Mall> mallsMap;
	public static void main(String args[]){
		
		malls = CreateMalls.getMalls();
		
		
		mallsMap = getHashMapMall(malls);// send a list of malls and get a hashmap of malls
		
		ObjectMapper mapper = new ObjectMapper();
		String json;
		try{
			json = mapper.writeValueAsString(mallsMap);
			System.out.println(json);
			mapper.writeValue(new File("d:\\malls.json"), mallsMap);
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
			mallHashMap.put(m.getMallId(), m);
		}
		return mallHashMap;
	}
	
}
