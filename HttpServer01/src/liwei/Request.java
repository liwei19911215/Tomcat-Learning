package liwei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Request {
	public Request(InputStream in) {
		inputStream = in;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getUri() throws IOException {
		if(uri!=null)
		{
			return uri;
		}
		parseUri();
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public void parseUri() throws IOException {
		InputStream in = getInputStream();
		String firstLine = new BufferedReader(new InputStreamReader(in))
				.readLine();
		uri = firstLine.split(" ")[1].substring(1);
	}

	private InputStream inputStream;

	private String uri = null;

}
