
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StudentDatabaseSerializedFileReader {

	static FileInputStream file;

	public static void openFile(String string) {
		try {
			file = new FileInputStream(string);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static StudentDatabase readData() {
		try {
			if (file == null) {
				throw new Exception("File was not initilized!");
			}
			ObjectInputStream input = new ObjectInputStream(file);
			return (StudentDatabase) input.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void closeFile() {
		if (file != null) {
			try {
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			file = null;
		}
	}

}
