package SeleniumFrameworkProject_26.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class DataReader {

	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		
		//reading json to String
	String jsonContent=	FileUtils.readFileToString(new File(System.getProperty("user.dir")+"src\\test\\java\\SeleniumFrameworkProject_26\\Data\\Purchaseorder.json"),StandardCharsets.UTF_8);
	
	
	//converting string to hashmap using jackson data bind dependency
	
	ObjectMapper mapper =new ObjectMapper();
	
	List<HashMap<String,String>> data =mapper.readValue( jsonContent, new TypeReference< List <HashMap<String, String>>> () 
	{
	} );
	return data;
		
	}
	}
	

