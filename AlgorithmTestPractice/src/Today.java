import java.text.SimpleDateFormat;
import java.util.Date;

public class Today {
    public static void main(String[] args) {
        Date now = new Date();

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = sd.format(now);

        System.out.println(nowDate);
    }
}
