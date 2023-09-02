import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class stringFilter extends DocumentFilter {

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (Character.isDigit(ch)) {
                sb.append(ch);
            }
        }
        super.insertString(fb, offset, sb.toString(), attr);

    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text == null) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isDigit(ch)) {
                sb.append(ch);
            }
        }
        super.replace(fb, offset, length, sb.toString(), attrs);
    }
}
