package com.vizor.test;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PaginationPanel extends JPanel {
    private List<ImageIcon> images;
    private int currentPage = 0;
    private JPanel navigationPanel;
    private ImagePanel imagePanel;

    public PaginationPanel(List<ImageIcon> images) {
        this.images = images;
        setLayout(new BorderLayout());

        imagePanel = new ImagePanel(images);
        add(imagePanel, BorderLayout.CENTER);
        navigationPanel = createNavigationPanel();
    }

    private JPanel createNavigationPanel() {
        JPanel panel = new JPanel();
        JButton prevButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");

        prevButton.addActionListener(e -> {
            if (currentPage > 0) {
                currentPage--;
                updateGallery();
            }
        });

        nextButton.addActionListener(e -> {
            if ((currentPage + 1) < imagePanel.getTotalPages()) {
                currentPage++;
                updateGallery();
            }
        });

        panel.add(prevButton);
        panel.add(nextButton);
        return panel;
    }

    public void updateImages(List<ImageIcon> newImages) {
        this.images = newImages;
        imagePanel.updateImages(newImages);
        currentPage = 0;
        updateGallery();
    }

    private void updateGallery() {
        imagePanel.setCurrentPage(currentPage);
        updateNavigationButtons();
    }

    private void updateNavigationButtons() {
        JButton prevButton = (JButton) navigationPanel.getComponent(0);
        JButton nextButton = (JButton) navigationPanel.getComponent(1);
        if (images.size() > currentPage) {
            add(navigationPanel, BorderLayout.SOUTH);
            navigationPanel.setVisible(true);
            prevButton.setEnabled(currentPage > 0);
            nextButton.setEnabled((currentPage + 1) < imagePanel.getTotalPages());
        } else {
            navigationPanel.setVisible(false);
        }
    }
}

