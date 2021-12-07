package src.service;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JScrollPaneService {
    public JScrollPane instanciarJScrollPaneParaExpandirMensaje(JTextArea newJTextArea, String mensaje) {

        newJTextArea.setText(mensaje);
        JScrollPane scrollPane = new JScrollPane(newJTextArea);

        newJTextArea.setLineWrap(true);
        newJTextArea.setWrapStyleWord(true);
        newJTextArea.setEditable(false);

        scrollPane.setPreferredSize(new Dimension(500, 250));

        return scrollPane;
    }
}
