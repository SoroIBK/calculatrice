package soro.aka.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


public class HelloController {
    @FXML
    private TextArea ecran;
    @FXML
    private Pane message;
    @FXML
    private Text resultat;
    @FXML
    protected void operation(ActionEvent actionEvent) {
        String nb1 = "";
        String nb2 = "";
        Integer nb11 = 0;
        Integer nb22 = 0;
        String valeur = ecran.getText();
        if (valeur.contains("Impossible")){
            ecran.setText("0");
        }
        if (valeur.contains("+") && !(valeur.contains("-"))){
            ecran.setText(String.valueOf((normal(valeur, "+"))+((Button)actionEvent.getSource()).getText()));
        }
        else if (valeur.contains("-") && (valeur.contains("+")) && valeur.indexOf("-")==0){
            ecran.setText(String.valueOf((ng(valeur, "+")) + ((Button) actionEvent.getSource()).getText()));
        }
        else if (valeur.contains("-") && !(valeur.contains("+")) && valeur.indexOf("-")!=0){
                ecran.setText(String.valueOf((normal(valeur, "-"))+((Button)actionEvent.getSource()).getText()));
        }
        else  if (valeur.contains("-") && valeur.indexOf("-")==0 && !(valeur.contains("/")) && !(valeur.contains("*")) && !(valeur.contains("+")) && !(valeur.contains("%"))){
            String v = valeur.substring(1, valeur.length());
            if (v.contains("-") && v.indexOf("-") >0){
                int val = normal(v, "--");
                int valFinale= -1*val;
                ecran.setText(String.valueOf(valFinale));
            }
            else {
                ecran.setText(ecran.getText()+((Button)actionEvent.getSource()).getText());
            }
        }
        else if (valeur.contains("*") && !(valeur.contains("-"))){
            ecran.setText(String.valueOf((normal(valeur, "*"))+((Button)actionEvent.getSource()).getText()));
        }
        else if (valeur.contains("*") && (valeur.contains("-")) && valeur.indexOf("-")==0){
            ecran.setText(String.valueOf((ng(valeur, "*")) + ((Button) actionEvent.getSource()).getText()));
        }
        else if (valeur.contains("/") && !(valeur.contains("-"))){
            int veri = normal(valeur, "/");
            if (veri == -333){
                ecran.setText("Impossible");
            }else {
                ecran.setText(String.valueOf(veri)+((Button)actionEvent.getSource()).getText());
            }
        }
        else if (valeur.contains("/") && (valeur.contains("-")) && valeur.indexOf("-")==0){
            int veri = ng(valeur, "/");
            if (veri == -333){
                ecran.setText("Impossible");
            }else {
                if (veri == 0){
                    ecran.setText(String.valueOf(veri)+((Button)actionEvent.getSource()).getText());
                }else {
                    ecran.setText("-"+String.valueOf(veri)+((Button)actionEvent.getSource()).getText());
                }
            }
        }
        else if (valeur.contains("%") && !(valeur.contains("-"))){
            ecran.setText(String.valueOf((normal(valeur, "%"))+((Button)actionEvent.getSource()).getText()));
        }
        else if (valeur.contains("%") && (valeur.contains("-")) && valeur.indexOf("-")==0){
            ecran.setText(String.valueOf((ng(valeur, "%")) + ((Button) actionEvent.getSource()).getText()));
        }

        else{
            ecran.setText(ecran.getText()+((Button)actionEvent.getSource()).getText());
        }
    }
    @FXML
    protected void calcul(ActionEvent  actionEvent) {
        String ecr = ecran.getText();
        if(ecr.contains("+") && !(ecr.contains("-"))){
            ecran.setText(String.valueOf(normal(ecr, "+")));
        }
        else if (ecr.contains("-") && (ecr.contains("+")) && ecr.indexOf("-")==0){
            ecran.setText(String.valueOf(ng(ecr, "+")));
        }
        else if(ecr.contains("-") && !(ecr.contains("+")) && ecr.indexOf("-")>0){
            ecran.setText(String.valueOf(normal(ecr, "-")));
        }
        else if(ecr.contains("-") && ecr.indexOf("-")==0 && !(ecr.contains("/")) && !(ecr.contains("*")) && !(ecr.contains("%")) && !(ecr.contains("+"))){
            String v = ecr.substring(1, ecr.length());
            if (v.contains("-") && v.indexOf("-") >0){
                int val = normal(v, "--");
                int valFinale= -1*val;
                ecran.setText(String.valueOf(valFinale));
            }
        }
        else if(ecr.contains("*") && !(ecr.contains("-"))){
            ecran.setText(String.valueOf(normal(ecr, "*")));
        }
        else if(ecr.contains("*") && (ecr.contains("-")) && ecr.indexOf("-")==0){
            ecran.setText(String.valueOf(ng(ecr, "*")));
        }
        else if(ecr.contains("/") && !(ecr.contains("-"))){
            int veri = normal(ecr, "/");
            if (veri == -333){
                ecran.setText("Impossible");
            }else {
                ecran.setText(String.valueOf(veri));
            }
        }
        else if(ecr.contains("/") && ecr.contains("-") && ecr.indexOf("-")==0 && ecr.indexOf("/")>0){
            int veri = ng(ecr, "/");
            if (veri == -333){
                ecran.setText("Impossible");
            }else {
                if (veri == 0){
                    ecran.setText(String.valueOf(veri));
                }else {
                    ecran.setText("-"+String.valueOf(veri));
                }
            }
        }
        else if(ecr.contains("%") && !(ecr.contains("-"))){
            ecran.setText(String.valueOf(normal(ecr, "%")));
        }
        else if(ecr.contains("%") && (ecr.contains("-")) && ecr.indexOf("-")==0){
            ecran.setText(String.valueOf(ng(ecr, "%")));
        }

    }

    public void reset(ActionEvent actionEvent) {
        ecran.setText("");
    }

    public void delete(ActionEvent actionEvent) {
        ecran.setText((ecran.getText()).substring(0, ecran.getText().length()-1));
    }

    public void chiffre(ActionEvent actionEvent) {
        if (ecran.getText().contains("Division par zero !!!")){
            ecran.setText(((Button)actionEvent.getSource()).getText());
        }
        else {
            ecran.setText(ecran.getText()+((Button)actionEvent.getSource()).getText());
        }

    }

    public void negation(ActionEvent actionEvent) {
        String e = ecran.getText();
        Integer ee = Integer.parseInt(e);
        int eee = -1*ee;
        ecran.setText(String.valueOf(eee));
    }

    public static int ng(String e, String o){
        String va = e.substring(1, e.length());
        int p = va.indexOf(o);
        String nb1 = "";
        String nb2 = "";
        int nb11 = 0;
        int nb22 = 0;
        for (int i = 0; i < p; i++) {
            nb1 = nb1 + va.charAt(i);
            nb11 = Integer.parseInt(nb1);
        }
        for (int i = p + 1; i <= va.length() - 1; i++) {
            nb2 = nb2 + va.charAt(i);
            nb22 = Integer.parseInt(nb2);
        }
        int nb111 = -1 * nb11;
        switch (o){
            case "+":
                int res = nb111 + nb22;
                return res;
            case "-":
                 res = nb111 - nb22;
                return res;
            case "*":
                res = nb111 * nb22;
                return res;
            case "/":
                if (nb22 == 0){
                    return -333;
                }
                else {

                    res = nb11 / nb22;
                    return res;
                }
            case "%":
                res = nb111 % nb22;
                return res;
            default:
                return 000;
        }
    }

    public static int normal(String e, String o) {
        String nb1 = "";
        String nb2 = "";
        Integer nb11 = 0;
        Integer nb22 = 0;
        int op;
        if(o == "--"){
            e = e.replace(e.charAt(e.indexOf("-")), '+');
            op = e.indexOf("+");
            o = "+";
        }
        else {
            op = e.indexOf(o);
        }

        for (int i = 0; i < op; i++) {
            nb1 = nb1 + e.charAt(i);
            nb11 = Integer.parseInt(nb1);
        }
        for (int i = op + 1; i <= e.length() - 1; i++) {
            nb2 = nb2 + e.charAt(i);
            nb22 = Integer.parseInt(nb2);
        }
        int res;
        switch (o){
            case "+":
                res = nb11 + nb22;
                return res;
            case "-":
                 res = nb11 - nb22;
                return res;
            case "*":
                res = nb11 * nb22;
                return res;
            case "/":
                if (nb22 == 0){
                    return -333;
                }
                else {
                    res = nb11 / nb22;
                    return res;
                }
            case "%":
                res = nb11 % nb22;
                return res;
            default:
                return 000;
        }
    }
}
