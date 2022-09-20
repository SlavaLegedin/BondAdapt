package testcases.SmokeTest;

import _helpers.TestBase;
import _helpers.IoOperations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.annotations.Report;

@Report
public class CreateSystemUser extends TestBase {
	
	
	@Test
	public void createUser() throws IOException, ParseException {
		
		Map <String, String> data = new HashMap<String, String>();
		data.put("streetAddress", "21 2nd Street");
        data.put("city", "New York");
        data.put("state", "NY");
        data.put("postalCode", "10021");
        
        IoOperations io = new IoOperations();
        io.writeMapFile(data);
        
		
        Map <String, String> testdata = io.readMapFromFile();
        System.out.println(testdata.get("city"));
		
	}
	
	
	
}
