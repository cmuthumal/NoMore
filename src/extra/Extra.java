/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package extra;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class Extra {

    private String firstID = "", id, nextID = "";

    public String getFirstID(String type) {
        if (type.equals("employee")) {
            firstID = "EM0000";
        }
        if (type.equals("item")) {
            firstID = "IT0000";
        }
        if (type.equals("customer")) {
            firstID = "CS0000";
        }
        if (type.equals("customerOrder")) {
            firstID = "R0000";
        }
        if (type.equals("customerOrderDetail")) {
            firstID = "CO0000";
        }
        return firstID;
    }

    public String getNextID(String id) {
        String oldID, nextID = "";
        oldID = (id.charAt(2) + "") + (id.charAt(3) + "") + (id.charAt(4) + "") + (id.charAt(5) + "");
        int val = Integer.parseInt(oldID);
        String number = String.format("%04d", (val + 1));
        nextID = (id.charAt(0) + "") + (id.charAt(1) + "") + number;
        return nextID;
    }

    public boolean limitedTo(int number, int limit) {
        int count = 0;
        boolean b = false;
        while (number > 0) {
            number = (number / 10);
            count++;
        }
        if (count == limit) {
            b = true;
        }
        return b;
    }

    public boolean validateMobileNumber(JTextField textField) {
        String text = textField.getText();

        Pattern pattern = Pattern.compile("[0][7][1,2,5,7,8]([0-9]){7}");
        Matcher matcher = pattern.matcher(text);

        boolean b = false;

        if (matcher.find()) {
            b = true;
        } else {
            b = false;
        }
        return b;
    }

    public boolean validatePhoneNumber(JTextField textField) {
        String text = textField.getText();

        Pattern pattern = Pattern.compile("[0]([0-9]){9}");
        Matcher matcher = pattern.matcher(text);

        boolean b = false;

        if (matcher.find()) {
            b = true;
        } else {
            b = false;
        }
        return b;
    }

    public boolean validateNICNumber(JTextField textField) {
        String text = textField.getText();

        Pattern pattern = Pattern.compile("[0-9]{2}[0,1,2,3,5,6,7,8]([0-9]){6}");
        Matcher matcher = pattern.matcher(text);

        boolean b = false;

        if (matcher.find()) {
            b = true;
        } else {
            b = false;
        }
        return b;
    }

    public boolean validateDate(String date) {
        Pattern pattern = Pattern.compile("[1,2][0,1,2,9][0-9]{2}[-][0,1][0-9][-][0,1,2,3][0-9]");
        Matcher matcher = pattern.matcher(date);

        boolean b = false;

        if (matcher.find()) {
            b = true;
        } else {
            b = false;
        }
        return b;
    }
}
