import java.util.Comparator;
import java.util.logging.Logger;

public class Enrollee {
    private static final Logger logger = Logger.getLogger(Enrollee.class.getName());
    private String userid;
    private String firstName;
    private String lastName;
    private Integer version;
    private String insuranceCompany;

    public Enrollee(String userid, String firstName, String lastName, Integer version, String insuranceCompany) {
        this.userid = userid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.version = version;
        this.insuranceCompany = insuranceCompany;
        logger.info(this.toString());
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    @Override
    public String toString(){
        String string = "UserId: " + userid + " First Name: " + firstName + " Last Name: " + lastName + " Version: " + version.toString() + " Insurance Company: " + insuranceCompany;
        return string;
    }
}
