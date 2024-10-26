package com.vizor.test;

import javax.swing.*;
import java.awt.*;

public class ImageViewer extends JFrame {

    public ImageViewer(ImageIcon image){
        setTitle("Image Viewer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);

        JLabel imageLabel = new JLabel(image);

        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(new JScrollPane(imageLabel), BorderLayout.CENTER);
        setVisible(true);

    }
}
