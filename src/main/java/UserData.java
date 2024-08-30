import java.util.ArrayList;

public class UserData {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public ArrayList<Datum>data;
    public String url;
    public String text;
    public class Datum{
        public int id;
        public String email;
        public String first_name;
        public String last_name;
        public String avatar;
    }



}
