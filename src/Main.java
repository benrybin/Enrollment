import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        CreateEnrollee createEnrollee = new CreateEnrollee();
        List<Enrollee> enrolleeList = createEnrollee.parseCSV(ReadInFile.readCSVIn("test.csv"));
        EnrolleeInsuranceCompanySplit.splitEnrollebyCompany(enrolleeList);

    }
}
