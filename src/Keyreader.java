import java.io.FileInputStream;
import java.util.Properties;
// Keyreader to get the password from a local textfile
public class Keyreader {

    //initiate properties
    Properties props;

    public Keyreader(String file){

        props = new Properties();

        String userHome = System.getProperty("user.home");

        try {
            FileInputStream input = new FileInputStream(userHome + "/Documents/Pass/" + file +".txt");
            props.load(input);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public String getPasscode(){
        //Return the password that under parameter key
        return props.getProperty("Pass");

    }


}

