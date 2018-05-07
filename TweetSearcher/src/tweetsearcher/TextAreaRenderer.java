package tweetsearcher;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

public class TextAreaRenderer extends JTextArea
    implements TableCellRenderer {

  public TextAreaRenderer() {
    setLineWrap(true);
    setWrapStyleWord(true);
  }

  public Component getTableCellRendererComponent(JTable jTable,
      Object obj, boolean isSelected, boolean hasFocus, int row,
      int column) {
      setText((String)obj);
      setFont(new java.awt.Font("Tahoma", 0, 11));
      setBackground(new java.awt.Color(39, 57, 78));
      setForeground(new java.awt.Color(255, 255, 255));
      setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(39, 57, 78), new java.awt.Color(39, 57, 78)));
      setEditable(false);
    return this;
  }
}