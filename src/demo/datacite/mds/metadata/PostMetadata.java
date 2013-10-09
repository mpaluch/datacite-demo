package demo.datacite.mds.metadata;

import demo.datacite.metadata.Metadata;
import demo.http.client.HTTPClient;
import demo.http.client.HTTPRequest;
import demo.http.client.HTTPResponse;

/**
 * Demo of DataCite Metadata Store API /metadata resource. 
 * @see <a href="http://mds.datacite.org">http://mds.datacite.org</a>
 * @author mpaluch
 */
public class PostMetadata {

	public static final String SERVICE_ADDRESS = "https://mds.datacite.org/metadata/";
	public static final String USERNAME = "[username]";
	public static final String PASSWORD = "[password]";
	
	public void execute(){
		try{			
			String requestBody = Metadata.getMetadataFromFile();
			
			HTTPRequest request = new HTTPRequest();
			request.setMethod(HTTPRequest.Method.POST);
			request.setURL(SERVICE_ADDRESS);
			
			request.setUsername(USERNAME);
			request.setPassword(PASSWORD);
			
			request.setContentType("text/plain;charset=UTF-8");
			request.setBody(requestBody);
			
			print(request.toString());
			
			HTTPResponse response = HTTPClient.doHTTPRequest(request);
			print(response.toString());
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		PostMetadata exec = new PostMetadata();
		exec.execute();
		exec = null;
	}

	private void print(String str){
		System.out.println(str);
	}
}
