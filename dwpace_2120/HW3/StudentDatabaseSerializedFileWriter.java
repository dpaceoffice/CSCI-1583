
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class StudentDatabaseSerializedFileWriter {

	static FileOutputStream file;

	public static void openFile(String string) {
		try {
			file = new FileOutputStream(new File(string));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void writeData(StudentDatabase db) {
		try {
			if (file == null) {
				throw new Exception("File was not initilized!");
			}
			ObjectOutputStream output = new ObjectOutputStream(file);
			output.writeObject(db);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void closeFile() {
		if(file != null) {
			try {
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			file = null;
		}
	}

}
