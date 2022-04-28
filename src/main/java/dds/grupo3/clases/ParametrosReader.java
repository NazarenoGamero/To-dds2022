package dds.grupo3.clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map;

public class ParametrosReader {
	public Map<String, Float> leerParametros(String path) {
		Map<String, Float> parametros= new HashMap<>();
		try {
			File file = new File("path");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			Enumeration enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				Float value = Float.parseFloat(properties.getProperty(key));
				parametros.put(key, value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return parametros;
	}
}
