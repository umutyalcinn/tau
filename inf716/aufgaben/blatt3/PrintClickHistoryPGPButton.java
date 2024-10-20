public class PrintClickHistoryPGPButton extends PGPButton {
    private ArrayList<DateTime> history;

    public PrintClickHistoryPGPButton(String label) {
        super(label);
        this.history = new ArrayList();
    }

    @Override
    public void click() {
        this.history.pus
    }
}
