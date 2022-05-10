package HW3;

public class SortStudentDatabase {

	public static void main(String files[]) {
		if (files.length != 2) {
			System.err.println("Provide arguments! 'input.filetype' 'output.filetype'");
			System.exit(1);
		}

		String inputFileName = files[0];
		StudentDatabase database = loadDatabase(inputFileName);
		database.sortByGPA();
		writeDatabase(database, files[1]);
		System.out.print("Database organized");
	}

	private static StudentDatabase loadDatabase(String inputFileName) {
		String extention = inputFileName.split("\\.")[1];
		if (extention.equals("ser")) {
			StudentDatabaseSerializedFileReader.openFile(inputFileName);
			return StudentDatabaseSerializedFileReader.readData();
		} else
			StudentDatabaseCSVFileReader.openFile(inputFileName);
		return StudentDatabaseCSVFileReader.readData();

	}

	private static void writeDatabase(StudentDatabase database, String outputFileName) {
		String extention = outputFileName.split("\\.")[1];
		if (extention.equals("ser")) {
			StudentDatabaseSerializedFileWriter.openFile(outputFileName);
			StudentDatabaseSerializedFileWriter.writeData(database);
			StudentDatabaseSerializedFileWriter.closeFile();
		} else {
			StudentDatabaseCSVFileWriter.openFile(outputFileName);
			StudentDatabaseCSVFileWriter.writeData(database);
			StudentDatabaseCSVFileWriter.closeFile();
		}
	}

}
