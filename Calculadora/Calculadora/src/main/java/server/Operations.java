package server;


import java.util.ArrayList;

public class Operations {
    private int num1,num2;

    public String suma (String num1,String num2){
        double num = Double.parseDouble(num1);
        double nume = Double.parseDouble(num2);
        double suma = num +nume;
        DaoOperations daoOperations = new DaoOperations();
        boolean result = daoOperations.save(num,nume, suma, "Suma");
        return "La suma de "+num1+" + " + num2 + " es: " +(suma);
    }
    public String resta (String num1, String num2){
        double num = Double.parseDouble(num1);
        double nume = Double.parseDouble(num2);
        double resta = num -nume;
        DaoOperations daoOperations = new DaoOperations();
        boolean result = daoOperations.save(num,nume, resta, "Resta");
        return "La resta de "+num1+" - "+num2+" es: " +(resta);
    }
    public String multiplicacion (String num1, String num2){
        double num = Double.parseDouble(num1);
        double nume = Double.parseDouble(num2);
        double multi = num *nume;
        DaoOperations daoOperations = new DaoOperations();
        boolean result = daoOperations.save(num,nume, multi, "Multiplicacion");
        return "La multiplicacion de "+num1+" * "+num2+" es: " +(multi);
    }
    public String division (String num1, String num2){
        double num = Double.parseDouble(num1);
        double nume = Double.parseDouble(num2);
        double division = num /nume;
        DaoOperations daoOperations = new DaoOperations();
        boolean result = daoOperations.save(num,nume, division, "Division");
        return "La division de "+num1+" / "+num2+" es: " +(division);
    }
    public String exponente (String num1, String num2){
        double num = Double.parseDouble(num1);
        double nume = Double.parseDouble(num2);
        double exponente = Math.pow(num,nume);
        DaoOperations daoOperations = new DaoOperations();
        boolean result = daoOperations.save(num,nume, exponente, "Potencia");
        return "El exponente de "+num1+" elevado a la "+num2+" es: " +(exponente);
    }
    public String raiz (String num1, String num2){
        double num = Double.parseDouble(num1);
        double nume = Double.parseDouble(num2);
        double raiz = Math.pow(num,1/nume);
        DaoOperations daoOperations = new DaoOperations();
        boolean result = daoOperations.save(num,nume, raiz, "Raiz");
        return "La raiz de " +num + " es: " +(raiz);
    }
    public String list (int count){
        DaoOperations daoOperations= new DaoOperations();
        ArrayList<BeanOperaciones> list = daoOperations.listOperations();
        if (count == list.size()){
            return "";
        }else {
            String cadena= list.get(count).getOperacion()+" "+list.get(count).getNum1()+" "+list.get(count).getNum2()+" "+list.get(count).getResult()+" "+list.get(count).getFecha();
            return cadena;
        }
    }
}
