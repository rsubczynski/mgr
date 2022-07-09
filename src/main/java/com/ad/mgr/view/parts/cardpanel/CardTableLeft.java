package com.ad.mgr.view.parts.cardpanel;

import com.ad.mgr.data.cards.entity.Card;
import com.ad.mgr.view.parts.cardpanel.parts.config.CardPanelConfig;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.time.LocalDate;

import static com.ad.mgr.view.util.DataPickerHelper.*;

public class CardTableLeft extends JPanel {

    private final String PATH_TO_FILE = "Ścieżka do pliku...";

    private final JLabel cardIdLabel = new JLabel("Id Karty");
    private final JLabel expirationDateLabel = new JLabel("Data ważnosci");
    private final JLabel accessPlacesLabel = new JLabel("Miejsca dostępu");
    private final JLabel photoLabel = new JLabel("Zdjęcie");
    private final JLabel photoPreviewLabel = new JLabel("Podgląd zdjęcia");
    private final JTextField cardIdFiled = new JTextField();
    private final JTextField photoFiled = new JTextField(PATH_TO_FILE);
    private final JButton photoButton = new JButton("Wczytaj");
    private final JButton accessPlacesButton = new JButton("Wyświetl listę");
    private final JLabel photoPreview = new JLabel();
    private JDatePickerImpl expirationDatePicker = getDatePicker(true, LocalDate.now());
    private CardPanelConfig cardPanelConfig;
    private Card card;

    public CardTableLeft(CardLeftPanelConnector cardLeftPanelConnector) {
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        setLayout(null);
        setBounds();
        addControl();

        cardIdFiled.disable();
        photoFiled.setEditable(false);

        accessPlacesButton.addActionListener(e -> {
            boolean hidden = cardLeftPanelConnector.accessPlacesButtonClicked();
            accessPlacesButton.setText(!hidden ? "Wyświetl listę" : "Schowaj Liste");
        });

        photoButton.addActionListener(e -> {
            openFileChooser();
        });

    }

    private void openFileChooser() {
        JFrame frame = new JFrame();
        JFileChooser fileChooser = new JFileChooser(".");
        Action details = fileChooser.getActionMap().get("viewTypeDetails");
        details.actionPerformed(null);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));
        int status = fileChooser.showOpenDialog(frame);

        doActionAfterFileChose(fileChooser, status);
    }

    private void doActionAfterFileChose(JFileChooser fileChooser, int status) {
        if (status == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            var fileSize = selectedFile.length() / 1024;
            if (500 > fileSize) {
                String fileUrl = selectedFile.getParent() + "\\" + selectedFile.getName();
                photoFiled.setText(fileUrl);
                photoPreview.setIcon(getScaledIcon(new ImageIcon(fileUrl)));
            } else {
                JOptionPane.showMessageDialog(this, "Obsługiwany rozmiar do 500 kb");
            }
        }
    }

    private void addControl() {
        add(cardIdLabel);
        add(cardIdFiled);
        add(expirationDateLabel);
        add(expirationDatePicker);
        add(accessPlacesLabel);
        add(accessPlacesButton);
        add(photoLabel);
        add(photoFiled);
        add(photoButton);
        add(photoPreviewLabel);
        add(photoPreview);

    }

    private void setBounds() {
        cardIdLabel.setBounds(10, 10, 200, 25);
        cardIdFiled.setBounds(110, 10, 190, 25);
        expirationDateLabel.setBounds(10, 50, 200, 25);
        expirationDatePicker.setBounds(110, 50, 190, 25);
        accessPlacesLabel.setBounds(10, 90, 200, 25);
        accessPlacesButton.setBounds(130, 90, 150, 25);
        photoLabel.setBounds(10, 130, 200, 25);
        photoFiled.setBounds(110, 130, 110, 25);
        photoButton.setBounds(220, 130, 85, 25);
        photoPreviewLabel.setBounds(10, 170, 200, 25);
        photoPreview.setBounds(150, 170, 90, 90);
    }

    public void cleanData() {
        expirationDatePicker.getModel().setSelected(false);
        photoPreview.setIcon(new ImageIcon());
        photoFiled.setText(PATH_TO_FILE);
    }

    public void setData(Card card, CardPanelConfig cardPanelConfig) {
        this.cardPanelConfig = cardPanelConfig;
        this.card = card;
        cardIdFiled.setText(String.valueOf(card.getId()));

        if (cardPanelConfig.isAddMode()) {
            card.setExpirationDate(LocalDate.now());
        }

        expirationDatePicker.getModel().setSelected(!cardPanelConfig.isAddMode());
        expirationDatePicker.getModel().setDay(card.getExpirationDate().getDayOfMonth());
        expirationDatePicker.getModel().setMonth(card.getExpirationDate().getMonthValue() - 1);
        expirationDatePicker.getModel().setYear(card.getExpirationDate().getYear());
        if (card.getImage() != null) {
            photoPreview.setIcon(getScaledIcon(new ImageIcon(card.getImage())));
        } else {
            photoPreview.setIcon(new ImageIcon());
        }
        photoFiled.setText(PATH_TO_FILE);

    }

    ImageIcon getScaledIcon(ImageIcon imageIcon) {
        var image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }

    public LocalDate getExpirationDate() {
        return convertToLocalDateCard(expirationDatePicker);
    }

    @SneakyThrows
    public byte[] getImage() {

        if (cardPanelConfig.isAddMode() && PATH_TO_FILE.equals(photoFiled.getText())) {
            return null;
        }

        if (!cardPanelConfig.isAddMode() && PATH_TO_FILE.equals(photoFiled.getText())) {
            return card.getImage();
        }

        File photo = new File(photoFiled.getText());
        return FileUtils.readFileToByteArray(photo);
    }
}

