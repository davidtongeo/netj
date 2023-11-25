package httpClass;

import java.net.URI;
import java.net.http.HttpClient;

import httpClass.httpVerbs.Verbs;

public class httpClass {
	private HttpClient client;
	private URI url;

	public void makeRequest(Verbs verb, String[] headers, String body, Boolean showBody) {
		try {
			if (verb == Verbs.GET) {
				if (showBody)
					System.out.println(httpVerbs.Get(this.url, this.client).body());
				else
					System.out.println(httpVerbs.Get(this.url, this.client));
			} else {
				if (body != null) {
					if (showBody)
						System.out.println(httpVerbs.Post(this.url, this.client, headers, body).body());
					else
						System.out.println(httpVerbs.Post(this.url, this.client, headers, body));
				}
			}
		} catch (Exception e) {
			System.err.println("[ERROR] Couldn't send the request. Check the url");
		}
	}

	public httpClass(String url) {
		this.client = HttpClient.newHttpClient();
		this.url = URI.create(url);
	}
}
