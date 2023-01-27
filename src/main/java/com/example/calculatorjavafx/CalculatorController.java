package com.example.calculatorjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController{

    @FXML
    TextField textResult;

    String output="";
    long number1;
    long number2;

    //Functionality to click number
    public void Number(ActionEvent event){

        String number= ((Button)event.getSource()).getText();
        textResult.setText(textResult.getText()+number);
    }

    //Functionality to click operator
    public void Operation(ActionEvent event){

        String operation= ((Button)event.getSource()).getText();
        if(!operation.equals("=")){

            if (!output.equals("")) {
                return;
            }
            output=operation;
            number1=Long.parseLong(textResult.getText());
            textResult.setText("");
        }
        else {

            if (output.equals("")) {
                return;
            }
            number2 = Long.parseLong(textResult.getText());
            float result =calculate(number1,number2,output);
            textResult.setText(String.valueOf(result));
            output="";
        }
    }

    //Function to perform calculation
    public float calculate(long n1, long n2, String op){

        switch (op){

            case "+" : return n1+n2;
            case "-" : return n1-n2;
            case "*" : return n1*n2;
            case "/" :
                if(n2==0){
                    return 0;
                }
                return n1/(float)n2;
            default : return 0;
        }
    }

    //Clear button
    public void setClearButton(ActionEvent event){

        textResult.clear();
    }
}