import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class HintTextField extends JTextField implements FocusListener {
    private String hint;

    public HintTextField(String hint) {
        this.hint = hint;
        addFocusListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getText().isEmpty() && !hasFocus()) {
            g.setColor(Color.GRAY);
            g.drawString(hint, getInsets().left, getHeight() / 2 + getFont().getSize() / 2);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (getText().equals(hint)) {
            setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (getText().isEmpty()) {
            setText(hint);
        }
    }
}