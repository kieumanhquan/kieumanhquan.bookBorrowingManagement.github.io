package model;

import java.text.NumberFormat;
import java.text.ParsePosition;

public class Convert {
    public  static String convertIntToStringFiveNumber(int number){
        String numberTemp = String.valueOf(number);
        String result = "";
        if(numberTemp.length() == 1){
            result = "0000"+number;
        }
        if(numberTemp.length() == 2){
            result = "000"+number;
        }
        if(numberTemp.length() == 3){
            result = "00"+number;
        }
        if(numberTemp.length() == 4){
            result = "0"+number;
        }
        if(numberTemp.length() == 5){
            result = numberTemp;
        }
        return  result;
    }
    static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }
}
