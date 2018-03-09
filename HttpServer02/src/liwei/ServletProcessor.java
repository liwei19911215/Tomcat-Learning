package liwei;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

public class ServletProcessor {
	public void process(Request request, Response response) throws IOException, ClassNotFoundException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, ServletException, URISyntaxException{
		String uri = request.getUri();
		String servletName = uri;
		URL[] urls = new URL[1];
		urls[0] = new URL("file",null,new File("WebRoot").getCanonicalPath());
		URLClassLoader URLClassLoader = new URLClassLoader(urls);
		Class<javax.servlet.Servlet> servletClass = (Class<Servlet>) URLClassLoader.loadClass("liwei."+servletName);
		Servlet servlet = servletClass.newInstance();
		servlet.service(request, response);
	}
}
