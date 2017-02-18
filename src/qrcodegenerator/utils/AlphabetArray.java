/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.utils;

/**
 *
 * @author Rizaldi Habibie
 */
public class AlphabetArray {
  private String[] alphabets = new String[26];
  private String alphabet;

    public AlphabetArray() {
        this.setAlphabets();
    }

    public String[] getAlphabets() {
        return alphabets;
    }

    public void setAlphabets() {
        alphabets[0] = "A";
        alphabets[1] = "B";alphabets[14] = "O";
        alphabets[2] = "C";alphabets[15] = "P";
        alphabets[3] = "D";alphabets[16] = "Q";
        alphabets[4] = "E";alphabets[17] = "R";
        alphabets[5] = "F";alphabets[18] = "S";
        alphabets[6] = "G";alphabets[19] = "T";
        alphabets[7] = "H";alphabets[20] = "U";
        alphabets[8] = "I";alphabets[21] = "V";
        alphabets[9] = "J";alphabets[22] = "W";
        alphabets[10] = "K";alphabets[23] = "X";
        alphabets[11] = "L";alphabets[24] = "Y";
        alphabets[12] = "M";alphabets[25] = "Z";
        alphabets[13] = "N";      
    }

    public String getAlphabet(int index) {
        return alphabets[index];
    }

    
  
}
