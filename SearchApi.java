package com.java.first;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sun.org.apache.xerces.internal.util.URI;

public class SearchApi {

	public static void main(String[] args) throws URISyntaxException, ClientProtocolException, IOException {
		HttpGet httpget = new HttpGet("https://itunes.apple.com/search?parameterkeyvalue");
		URIBuilder builder = new URIBuilder();
		builder.setScheme("https").setHost("itunes.apple.com").setPath("/search").setParameter("term", "jack+johnson")
				.setParameter("country", "US").setParameter("media", "movie").setParameter("limit", "25");
		java.net.URI uri = builder.build();
		httpget = new HttpGet(uri);
		System.out.println(httpget.getURI());
		HttpClient client = new DefaultHttpClient();
		HttpGet response = new HttpGet(httpget.getURI());
		ResponseHandler<String> handler = new BasicResponseHandler();
		String body = client.execute(response, handler);
		HttpResponse httpResp = client.execute(response);
		int code = httpResp.getStatusLine().getStatusCode();
		System.out.println(code);
		int expectedresponsecode = HttpStatus.SC_OK;

	}

}
