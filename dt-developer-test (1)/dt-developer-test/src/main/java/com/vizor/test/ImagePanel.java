package com.vizor.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ImagePanel extends JPanel {
    private List<ImageIcon> images;
    private int currentPage = 0;
    private static final int IMAGES_PER_PAGE = 16;

    public ImagePanel(List<ImageIcon> images) {
        this.images = images;
        setLayout(new GridLayout(4, 4));
        updateGallery();
    }

    public void updateImages(List<ImageIcon> newImages) {
        this.images = newImages;
        currentPage = 0;
        updateGallery();
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        updateGallery();
    }

    private void updateGallery() {
        removeAll();

        int start = currentPage * IMAGES_PER_PAGE;
        int end = Math.min(start + IMAGES_PER_PAGE, images.size());

        for (int i = start; i < end; i++) {
            JLabel imageLabel = new JLabel(images.get(i));
            int currentI = i;
            imageLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new ImageViewer(images.get(currentI));
                }
            });

            add(imageLabel);
        }
        revalidate();
        repaint();
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) images.size() / IMAGES_PER_PAGE);
    }
}
