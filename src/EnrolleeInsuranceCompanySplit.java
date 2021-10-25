import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class EnrolleeInsuranceCompanySplit {


    public static Map<String, List<Enrollee>> splitEnrollebyCompany(List<Enrollee> enrollees) throws Exception {
        Map<String, List<Enrollee>> enrolleSorted = new HashMap<>();


        for (Enrollee e: enrollees) {
            if(enrolleSorted.containsKey(e.getInsuranceCompany())){


                enrolleSorted.get(e.getInsuranceCompany()).add(e);
            }else{

                List<Enrollee> enrolleeList = new ArrayList<>();
                enrolleeList.add(e);
                enrolleSorted.put(e.getInsuranceCompany(),enrolleeList);
            }

        }
        createFile(enrolleSorted);

        return enrolleSorted;


    }

    public static void createFile(Map<String,List<Enrollee>> enrolleeMap) throws Exception{
        StringBuilder output = new StringBuilder();

        for (Map.Entry<String,List<Enrollee>> entry :enrolleeMap.entrySet()) {
            output.append("\n");
            output.append(entry.getKey().toUpperCase()+",");
            output.append("\n");

            for (Enrollee e: entry.getValue()) {
                output.append(e.toString()+",");



            }

        }
        File file = new File("sorted.csv");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(output.toString());
        fileWriter.flush();
        fileWriter.close();
        output.toString();

    }
}
