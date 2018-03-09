package liwei;

import java.io.FileNotFoundException;
import java.io.IOException;

public class StaticSourceProcessor {
	public void process(Request request, Response response) throws FileNotFoundException, IOException{
		response.writeStaticSource();
	}
}
