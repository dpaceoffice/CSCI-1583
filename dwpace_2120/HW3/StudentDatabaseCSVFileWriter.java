package HW3;


import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Formatter;


public class StudentDatabaseCSVFileWriter {

    private static Formatter output;

    public static void openFile (String filename) {

        try {
            output = new Formatter(filename);
        }   
        catch (IOException e) {
            System.err.println("Error opening file.  Terminating");
            System.exit(1);
        }        
    }    

    public static void writeData(StudentDatabase db) {
        int numStudents = db.getNumStudents();
        String header = "ID,Sex,Ethnic Grp,Name,Prim Prog,Acad Plan,Sub-Plan,Strt Level,Total,GPA,FAFSA,Take Prgrs,Fin Need%n";
        output.format(header);
        for (int i=0; i<numStudents; i++) {
            Student current = db.getStudent(i);
            String name = "\"" + current.getLastName() + ", " + current.getFirstName() + " " + current.getMiddleInitial() + "\"";
            double gpa = current.getGPA();
            String sex = current.getSex();
            int studentID = current.getStudentID();
            String ethnicGrp = current.getEthnicGroup();
            String fafsa = current.getFAFSA();
            String subPlan = current.getSubPlan();
            int strtLevel = current.getStrtLevel();
            double total = current.getTotal();
            double takePrgrs = current.getTakePrgrs();
            double financialNeed = current.getFinancialNeed();
            output.format("%d,%s,%s,%s,USCI,CSCI,%s,%d,%.3f,%.3f,%s,%.3f,%.2f%n",studentID,sex,ethnicGrp,name,subPlan,strtLevel,total,gpa,fafsa,takePrgrs,financialNeed);
            // YOUR CODE HERE
            /* here, you're going to output the rest of the student information to the file
               see the format of how the "parsing" method works in StudentDatabaseCSVFileReader
               NOTE: THE OUTPUT SHOULD BE IN EXACTLY THE SAME FORMAT AS THE INPUT!!!
            */


            // end the line that represents all the data for one student
            //output.format("%n");
        }
    }

    public static void closeFile() {
        if (output != null)
            output.close();
        output = null;
    }

}
