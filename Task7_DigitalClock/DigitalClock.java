import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock {

    public static void main(String[] args) throws Exception {

        SimpleDateFormat formatter =
                new SimpleDateFormat("HH:mm:ss");

        while(true) {

            Date date = new Date();

            System.out.print("\rCurrent Time: "
                    + formatter.format(date));

            Thread.sleep(1000);
        }
    }
}