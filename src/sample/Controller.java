package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {

    ObservableList<String> options = FXCollections.observableArrayList("Encrypt", "Decript");

    @FXML
    private ComboBox userComboBox = new ComboBox(options);

    @FXML
    private TextField userInputText;

    @FXML
    private TextArea userOutputText;


    @FXML
    public void initialize() {

    }

    @FXML
    public void onButtonClicked(){

        String frase = userInputText.getText();
        userOutputText.setText(cipher(frase, 1));

    }



    public char cipher(char c, int k) {
        final int alphaLength = 26;
        final char asciiShift = Character.isUpperCase(c) ? 'A' : 'a';
        final int cipherShift = k % alphaLength;

        // shift down to 0..25 for a..z
        char shifted = (char) (c - asciiShift);
        // rotate the letter and handle "wrap-around" for negatives and value >= 26
        shifted = (char) ((shifted + cipherShift + alphaLength) % alphaLength);
        // shift back up to english characters
        return (char) (shifted + asciiShift);
    }

    public String cipher(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(cipher(s.charAt(i), k));
        }
        return sb.toString();
    }



}
