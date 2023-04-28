import java.io.FileInputStream;
import java.util.Properties;

public class Keyreader {

    Properties props;

    public Keyreader(String file){

        props = new Properties();

        String userHome = System.getProperty("user.home");

        try {
            //hämta textfilen kolla så den inte ligger i onedrive
            FileInputStream input = new FileInputStream(userHome + "/Documents/Pass/" + file +".txt");
            props.load(input);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
    public String getAPIkey(){
        //läs nycklen som finns i filen
        return props.getProperty("Pass");

    }

    public String getKey(String key){
        return props.getProperty(key);
    }
}

