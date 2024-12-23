import java.awt.Point;

public class PrintPositionPGPButton extends PGPButton {
    public PrintPositionPGPButton(String label) {
        super(label);
    }

    @Override
    public void click() {
        String message = "I'm the button at (%d, %d)";
        Point location = this.getLocation();
        System.out.println(String.format(message, location.x, location.y));
    }
}
