package demo.datacite.mds.doi;

import demo.http.client.HTTPClient;
import demo.http.client.HTTPRequest;
import demo.http.client.HTTPResponse;

/**
 * Demonstration of DataCite Metadata Store API /doi resource. 
 * @see <a href="http://mds.datacite.org">http://mds.datacite.org</a>
 * @author mpaluch
 */
public class GetDOI {

	public static final String SERVICE_ADDRESS = "https://mds.datacite.org/doi/";
	public static final String USERNAME = "[username]";
	public static final String PASSWORD = "[password]";
	
	public void execute(){
		try{			
			
			String doi = "10.4224/21268323";
			
			HTTPRequest request = new HTTPRequest();
			request.setMethod(HTTPRequest.Method.GET);
			request.setURL(SERVICE_ADDRESS + doi);
			request.setUsername(USERNAME);
			request.setPassword(PASSWORD);
			
			print(request.toString());
			
			HTTPResponse response = HTTPClient.doHTTPRequest(request);
			print(response.toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		GetDOI exec = new GetDOI();
		exec.execute();
		exec = null;
	}

	private void print(String str){
		System.out.println(str);
	}
}
