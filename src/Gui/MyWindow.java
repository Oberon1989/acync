package Gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MyWindow extends Frame {
    Label output;
    public MyWindow()
    {
        this.setTitle("Async operation");
        this.setSize(300,300);
        this.setVisible(true);
        this.setLayout(null);
        output=new Label();
        output.setPreferredSize(new Dimension(300,100));
        output.setSize(this.getWidth(),100);
        output.setVisible(true);
        output.setBackground(Color.darkGray);
        output.setForeground(Color.GREEN);
        output.setAlignment(Label.CENTER);
        this.add(output);


    }

    public File selectSourceFile()
    {
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.FILES_ONLY);
        f.showOpenDialog(this);
        return f.getSelectedFile();
    }

    public String selectDestinationPath()
    {
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.showSaveDialog(null);
        return f.getSelectedFile().getAbsolutePath();
    }

    public Label getOutput()
    {
        return output;
    }
}
