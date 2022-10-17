import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ProduceReports {

    public String duration;

    public static void main(String[] args) throws InterruptedException {
        var startTime = System.nanoTime();
        try {
            resultstbl();
        } catch (Exception e) {

        }
        resultstbl();
//        Thread.sleep(5000);

        var elapsedTime = (System.nanoTime() - startTime)/1000000;
        String hm = String.format("%02dm %02ds", TimeUnit.MILLISECONDS.toMinutes(elapsedTime),TimeUnit.MILLISECONDS.toSeconds(elapsedTime));
        System.out.println(hm);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
    }

    public static void resultstbl() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trescriptingtask", "root", "Glados");
            Statement statement = connection.createStatement();
            String query1 = "insert into resultstbl(TestCase ,FailureMessage ,ExecutionDateTime, TestDuration, Result) "
                    + "values (7654, 'Time out: 5 seconds', '2022-10-17','15.214s','Failed';)";
            statement.executeUpdate(query1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

