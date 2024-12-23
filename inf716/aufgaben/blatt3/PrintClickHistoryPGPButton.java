import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Timestamp;

public class PrintClickHistoryPGPButton extends PGPButton {
    private ArrayList<Timestamp> history;

    public PrintClickHistoryPGPButton(String label) {
        super(label);
        this.history = new ArrayList();
    }

    @Override
    public void click() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        this.history.add(currentTimestamp);

        for (int i = 0; i < history.size(); ++i) {
            System.out.println("I was clicked at " + history.get(i).toString());
        }
    }
}
