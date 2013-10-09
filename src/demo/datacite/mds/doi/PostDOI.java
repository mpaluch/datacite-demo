package demo.datacite.mds.doi;

import demo.http.client.HTTPClient;
import demo.http.client.HTTPRequest;
import demo.http.client.HTTPResponse;

/**
 * Demonstration of DataCite Metadata Store API /doi resource. 
 * @see <a href="http://mds.datacite.org">http://mds.datacite.org</a>
 * @author mpaluch
 */
public class PostDOI {

	public static final String SERVICE_ADDRESS = "https://mds.datacite.org/doi/";
	public static final String USERNAME = "[username]";
	public static final String PASSWORD = "[password]";
	
	public void execute(){
		try{						
			//Note: To successfully POST a DOI, its metadata must be POSTed first (/metadata resource)			
			String contentType = "text/plain;charset=UTF-8";
			
			String url = "http://url.test.doi";
			String doi = "10.5072/testing.doi.post.1";
			
			String requestBody = "";
			requestBody += "doi=" + doi;
			requestBody += "\n";
			requestBody += "url=" + url;
						
			HTTPRequest request = new HTTPRequest();
			request.setMethod(HTTPRequest.Method.POST);
			request.setURL(SERVICE_ADDRESS);
			request.setUsername(USERNAME);
			request.setPassword(PASSWORD);
			
			request.setContentType(contentType);
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
		PostDOI exec = new PostDOI();
		exec.execute();
		exec = null;
	}

	private void print(String str){
		System.out.println(str);
	}
}
