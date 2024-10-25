package com.vizor.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ImageGalleryApp {

    private static final int WIDTH = 1024;
    private static final int HEIGHT = 768;
    private static final int IMAGE_WIDTH = 150;
    private static final int IMAGE_HEIGHT = 140;
    private final ImagePanel imagePanel;
    private final ImageLoaderService service;
    private final String path = "D:\\Testwork\\dt-developer-test (1)\\dt-developer-test\\assets";

    public ImageGalleryApp() {

        service = new ImageLoaderService();

        JFrame frame = new JFrame("DT Developer Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        imagePanel = new ImagePanel(IMAGE_WIDTH, IMAGE_HEIGHT);
        imagePanel.setBounds(5, 5, 5, 5);
        frame.add(imagePanel, BorderLayout.CENTER);

        JButton loadButton = new JButton("Load image");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadImagesFromAssets();
            }
        });
        frame.add(loadButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void loadImagesFromAssets() {
        ArrayList<ImageIcon> images = service.loadImages(path);
        imagePanel.updateImages(images);
    }

}
