
import java.io.IOException;
import java.util.Map;

public interface Storage {
    public String getPassword(String username) throws IOException;
    public Map<String, String> getUsernameToPasswordMapping() 
        throws IOException;
}