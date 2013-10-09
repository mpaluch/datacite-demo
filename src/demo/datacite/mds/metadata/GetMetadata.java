package demo.datacite.mds.metadata;

import demo.http.client.HTTPClient;
import demo.http.client.HTTPRequest;
import demo.http.client.HTTPResponse;

/**
 * Demo of DataCite Metadata Store API /metadata resource. 
 * @see <a href="http://mds.datacite.org">http://mds.datacite.org</a>
 * @author mpaluch
 */
public class GetMetadata {

	public static final String SERVICE_ADDRESS = "https://mds.datacite.org/metadata/";
	public static final String USERNAME = "[username]";
	public static final String PASSWORD = "[password]";
	
	public void execute(){
		try{			
			
			String doi = "10.5072/testing.doi.post.1";
			
			HTTPRequest request = new HTTPRequest();
			request.setMethod(HTTPRequest.Method.GET);
			request.setURL(SERVICE_ADDRESS + doi);
			request.setUsername(USERNAME);
			request.setPassword(PASSWORD);			
			request.setAccept("application/xml");
			
			print(request.toString());
			
			HTTPResponse response = HTTPClient.doHTTPRequest(request);
			print(response.toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		GetMetadata exec = new GetMetadata();
		exec.execute();
		exec = null;
	}

	private void print(String str){
		System.out.println(str);
	}
}
