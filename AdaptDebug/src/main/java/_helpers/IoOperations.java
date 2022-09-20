package _helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;


public class IoOperations {
	
	@SuppressWarnings("unchecked")
	public void writeMapFile(Map testdata) throws FileNotFoundException {
		/**Function converts received Map object to json and then writes this json to the file with named determined in function**/
		JSONObject json = new JSONObject();
		String filename = "testdata.json";
		
		
		//put hashmap to hsin under testdata tag
		json.put("testdata",testdata);	
		
		String json_line = json.toString();
		//write json to file
	
		PrintWriter pw = new PrintWriter(filename);		
		pw.write(json_line);
		pw.close();
	}
	
	
	public Map<String, String> readMapFromFile() throws FileNotFoundException, IOException, ParseException {
		/**Function read file with test data and then converts data to hashmap**/
		//ObjectMapper mapper = new ObjectMapper();
		String filename = "testdata.json";
		
		Object obj = new JSONParser().parse(new FileReader(filename));
		JSONObject jo = (JSONObject) obj;
		
		Map <String, String> testData = (Map)jo.get("testdata");
				
		return testData;
		
	}	
	
}
