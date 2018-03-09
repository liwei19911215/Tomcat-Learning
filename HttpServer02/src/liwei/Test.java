package liwei;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLStreamHandler;

public class Test {
	public static void main(String[] args) throws URISyntaxException, IOException {
		File f = new File("WebRoot");

		
		URLStreamHandler handler = null;
		URL url = new URL("file", null, f.getCanonicalPath());
		URL url2 = new URL(null, url.toString(), handler);
		System.out.println(url);
		System.out.println(url.getPath());
		System.out.println(url2);
		
		
		URI uri =url2.toURI();
		
		System.out.println(uri.toString());

		System.out.println(uri.getPath());

		
	}
}
