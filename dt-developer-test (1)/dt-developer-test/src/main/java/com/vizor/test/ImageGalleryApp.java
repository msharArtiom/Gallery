package com.vizor.test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ImageGalleryApp {

    private static final int WIDTH = 1024;
    private static final int HEIGHT = 768;
    private PaginationPanel paginationPanel;
    private final ImageLoaderService service;
    private final String path = "D:\\Testwork\\dt-developer-test (1)\\dt-developer-test\\assets";

    public ImageGalleryApp() {

        service = new ImageLoaderService();

        JFrame frame = new JFrame("DT Developer Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setLocationRelativeTo(null);

        paginationPanel = new PaginationPanel(new ArrayList<>());
        frame.add(paginationPanel, BorderLayout.CENTER);

        JButton loadButton = new JButton("Load image");
        loadButton.addActionListener(e -> loadImagesFromAssets());
        frame.add(loadButton, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    private void loadImagesFromAssets() {
        ArrayList<ImageIcon> images = service.loadImages(path);
        paginationPanel.updateImages(images);
    }
}
