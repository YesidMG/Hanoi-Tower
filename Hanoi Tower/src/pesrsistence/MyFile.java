package pesrsistence;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Vector;

public class MyFile {
	Properties value;

	public MyFile() {
		value = new Properties();
	}

	public int readLevel(String key) {
		try (FileInputStream reader = new FileInputStream("data/Levels")) {
			value.load(reader);
			reader.close();
			return Integer.parseInt(value.getProperty(key));   
		} catch (IOException e) {
			return 0;
		}
	}

	public Vector<String> obtainLevels() {
		try (BufferedReader br = new BufferedReader(new FileReader("data/Levels"))) {
			Vector<String> levelsName = new Vector<>();
			String linea;
			while ((linea = br.readLine()) != null) {
				int indiceIgual = linea.indexOf('=');
				String clave = linea.substring(0, indiceIgual).trim();
				levelsName.add(clave);
			}
			return levelsName;
		} catch (IOException e) {
			return null;
		}
	}
}
