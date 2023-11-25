package httpClass;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;

public class httpVerbs {
	public static enum Verbs {
		GET, POST,
	};

	public static HttpResponse<String> Get(URI url, HttpClient client) throws Exception {
		HttpRequest req = HttpRequest.newBuilder(url).GET().build();

		return client.send(req, HttpResponse.BodyHandlers.ofString());
	}

	public static HttpResponse<String> Post(URI url, HttpClient client, String[] headers, String body)
			throws Exception {
		HttpRequest req = HttpRequest.newBuilder(url).headers(headers[0], headers[1])
				.POST(BodyPublishers.ofString(body)).build();
		return client.send(req, HttpResponse.BodyHandlers.ofString());
	}
}
