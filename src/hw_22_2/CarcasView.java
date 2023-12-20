package hw_22_2;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarcasView<T> extends JFrame {
    IDocument<T> doc;

    class openDocument extends ActionEvent {
        public openDocument(Object obj) {
            super(obj, 0, "");
        }
    }

    class openStaticDocument extends ActionEvent {
        private String path;

        public String getPath() {
            return path;
        }

        public openStaticDocument(Object source, String path) {
            super(source, 0, "");
            this.path = path;
        }
    }

    JMenuBar menu = new JMenuBar();
    ArrayList<ActionListener> saveListener = new ArrayList<>();
    ArrayList<ActionListener> newListener = new ArrayList<>();
    ArrayList<ActionListener> openListener = new ArrayList<>();

    class saveDocument extends ActionEvent {
        private IDocument<T> doc;

        public saveDocument(Object obj, IDocument<T> doc) {
            super(obj, 0, "");
            this.doc = doc;
        }

        public IDocument<T> getDocument() {
            return doc;
        }
    }

    void addNewListener(ActionListener actionListener) {
        newListener.add(actionListener);
    }

    void addOpenListener(ActionListener actionListener) {
        openListener.add(actionListener);
    }

    void addSaveListener(ActionListener actionListener) {
        saveListener.add(actionListener);
    }

    void setOpenDoc(String path) {
        for (ActionListener actionListener : openListener) {
            actionListener.actionPerformed(new openStaticDocument(this, path));
        }
    }

    void setNewDoc() {
        for (ActionListener actionListener : newListener) {
            actionListener.actionPerformed(new openDocument(this));
        }
    }

    void setSaveDoc() {
        for (ActionListener actionListener : saveListener) {
            actionListener.actionPerformed(new saveDocument(this, doc));
        }
    }

    CarcasView() {
        setTitle("Каркас");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        JMenu fileItem = new JMenu("Файл");

        JMenuItem newPosition = new JMenuItem("Создать");
        newPosition.addActionListener(e -> {
            setNewDoc();
        });

        JMenuItem openPosition = new JMenuItem("Открыть");
        openPosition.addActionListener(e -> {
            JFileChooser file_choose = new JFileChooser();
            if (file_choose.showDialog(getContentPane(), "OK") == JFileChooser.APPROVE_OPTION) {
                setOpenDoc(file_choose.getSelectedFile().getAbsolutePath());
            }
        });

        JMenuItem savePosition = new JMenuItem("Сохранить");
        savePosition.addActionListener(e -> {
            setSaveDoc();
        });

        JMenuItem exitPosition = new JMenuItem("Выход");
        exitPosition.addActionListener(e -> {
            setVisible(false);
        });
        fileItem.add(newPosition);
        fileItem.add(openPosition);
        fileItem.add(savePosition);
        fileItem.add(exitPosition);
        menu.add(fileItem);
        setJMenuBar(menu);
        setBounds(0, 0, 790, 600);
    }

    void showDocText(TextDocument textDocument) {
        this.doc = (IDocument<T>) textDocument;
        setTitle("Текущий документ - " + textDocument.getName());
        getContentPane().removeAll();
        repaint();
        JTextArea textFieldBig = new JTextArea(textDocument.getContent());
        textFieldBig.setFont(new Font("Arial", Font.PLAIN, 14));
        textFieldBig.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                ((TextDocument) doc).setContent(textFieldBig.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                ((TextDocument) doc).setContent(textFieldBig.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                ((TextDocument) doc).setContent(textFieldBig.getText());
            }
        });
        add(textFieldBig);
        setBounds(0, 0, 800, 600);
    }
}
