import java.util.Random;
import java.awt.Color;

public class RecolorPGPButton extends PGPButton {
    public RecolorPGPButton(String label) {
        super(label);
    }

    @Override
    public void click() {
        Random rnd = new Random();
        float red = rnd.nextFloat();
        float green = rnd.nextFloat();
        float blue = rnd.nextFloat();
        Color newColor = new Color(red, green, blue);

        this.setBackground(newColor);
    }
}
