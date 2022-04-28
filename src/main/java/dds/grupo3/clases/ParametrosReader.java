package dds.grupo3.clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ParametrosReader {
	public Map<String, Float> leerParametros(String path) {
		Map<String, Float> parametros = new HashMap<>();
		try {
			String line;
			BufferedReader reader = new BufferedReader(new FileReader(path));
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("=", 2);
				if (parts.length >= 2) {
					String key = parts[0];
					Float value = Float.valueOf(parts[1]);
					parametros.put(key, value);
				} else {
					System.out.println("ignoring line: " + line);
				}
				reader.close();
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return parametros;
	}
}
