package liwei;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class HttpSocketServer {

	public static void main(String[] args) throws UnknownHostException, IOException {
		ServerSocket serverSocket = new ServerSocket(8080, 1, InetAddress.getByName("127.0.0.1"));
		String shutdown = null;
		while(true){
			try{
				Socket socket = serverSocket.accept();
				Request request = new Request(socket.getInputStream());
				String uri = request.getUri();
				shutdown = uri;
				if(shutdown.equalsIgnoreCase("shutdown")){
					socket.close();
					return;
				}
				Response response = new Response(socket.getOutputStream(), request);
				if(uri.endsWith("Servlet")){
					new ServletProcessor().process(request, response);
				}else{
					new StaticSourceProcessor().process(request, response);
				}
				socket.close();
			}catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			
		}
		
	}
}
