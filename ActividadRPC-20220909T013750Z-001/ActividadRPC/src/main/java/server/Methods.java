package server;

import java.util.Arrays;

public class Methods {
    public double addition(double num1, double num2) {
        return (num1 + num2);
    }

    public String imc(String name, double peso, double altura) {
        double IMC = peso / (altura * altura);
        return "Hola " + name + ", tu IMC es de: " + IMC;
    }

    public String operation(double num1, double num2, double num3, double num4) {
        double suma = num1 + num2 + num3 + num4;
        double prom = (num1 + num2 + num3 + num4) / 4;
        double product = (num1 * num2 * num3 * num4);
        return "Hola el producto de los numeros es: " + product + ", la suma es: " + suma + ", y el promedio es: " + prom;
    }

    public int rango(int a, int b) {
        int mayor;
        int menor;
        int suma = 0;
        if (a > b) {
            mayor = a;
            menor = b;
        } else {
            mayor = b;
            menor = a;
        }
        //Calculo el rango.
        for (int i = menor + 1; i < mayor; i++) {
            suma += i;
        }
        return suma;
    }

    public String ordenar (int a, int b, int c, int d, int e) {
        int numeros[] = {a, b, c, d, e};
        Arrays.sort(numeros);
        String orden="El orden de los numeros es: ";
        for (int i = 0; i < numeros.length; i++) {
        orden=orden+" "+ numeros[i]+" " ;
        }
        return orden;

        /*String orden="El orden de los numeros es: "+Arrays.toString(numeros);
        return orden;*/
    }
}
