import java.util.*;
import java.util.logging.Logger;

public class CreateEnrollee {
    private static final Logger logger = Logger.getLogger(CreateEnrollee.class.getName());
    List<Enrollee> enrolleeList = new ArrayList<>();
    public  List<Enrollee> parseCSV(String csv)throws Exception{

        String cleancsv =csv.replaceAll("\\r","");
        String[] parsedCSV = cleancsv.split(",|\\n");

        if(!(parsedCSV.length % 5==0)){
            throw new Exception();
        }
        for (int i = 5; i <parsedCSV.length ; i+=5) {
            //Map fields from parsedCSV
            String currentUserId = parsedCSV[i].strip();
            String currentFirstName = parsedCSV[i+1].strip();
            String currentLastName = parsedCSV[i+2].strip();
            Integer currentVersionNum = Integer.valueOf(parsedCSV[i+3]);
            String currentinsuranceCompany = parsedCSV[i+4].strip();

            //check to see if user id exists if it does updates version number to highest
            //this should be split to its own method for easier testing

            if(!(enrolleeList.isEmpty()) && enrolleeList.stream().anyMatch(x -> x.getUserid().equals(currentUserId))) {
                enrolleeList.stream().forEach(x -> {
                            if (x.getUserid().equals(currentUserId)) {
                                logger.info("UserId Exists");
                                if (x.getVersion() < currentVersionNum) {
                                    logger.info("UserId Exists and updating version number");
                                    x.setVersion(currentVersionNum);
                                }
                            }
                        }
                );
            }else {
                enrolleeList.add(new Enrollee(currentUserId, currentFirstName, currentLastName, currentVersionNum, currentinsuranceCompany));
            }
        }
        //this should be split to its own method for easier testing
        //Sorts list using custom comparators new ones can be added as needed
         Collections.sort(enrolleeList,new LastNameSorter().thenComparing(new FirstNameSorter()));

        return enrolleeList;
    }


    public class LastNameSorter implements Comparator<Enrollee>
    {
        public int compare(Enrollee o1, Enrollee o2)
        {
            return o1.getLastName().compareTo(o2.getLastName());
        }
    }
    public class FirstNameSorter implements Comparator<Enrollee>
    {
        public int compare(Enrollee o1, Enrollee o2)
        {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    }


}
