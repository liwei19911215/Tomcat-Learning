package liwei;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class Response {

	public Response(OutputStream outputStream, Request request){
		this.outputStream = outputStream;
		this.request = request;
	}
	
	public void write() throws FileNotFoundException, IOException{
		File f = new File(request.getUri());
		System.out.println();
		if(f.exists()){
			outputStream.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
			FileInputStream fi = new FileInputStream(f);
			byte[] b = new byte[1024];
			int c;
			while((c = fi.read(b))!=-1){
				outputStream.write(b, 0, c);
			}
			outputStream.flush();
			fi.close();
		}
		
	}
	private OutputStream outputStream = null;
	
	private Request request = null;

	public OutputStream getOutputStream() {
		return outputStream;
	}

	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
}
