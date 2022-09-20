package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfig;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class RPCClient {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        String opcion ="";
        String num1 ="";
        String num2 ="";
        do {
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Exponente");
            System.out.println("6. Raiz");
            System.out.println("7. Historial");
            System.out.println("8. Salir");
        opcion = sc.next();
        if (isNumber(opcion)){
            switch (Integer.parseInt(opcion)){
                case 1:
                    do {
                        System.out.println("Ingresa el primer valor");
                        num1 = sc.next();
                        if (!isNumber(num1)){
                            System.out.println("Error, ingrese un valor numerico");
                        }
                    }while (!isNumber(num1));
                    do {
                        System.out.println("Ingresa el segundo valor");
                        num2 = sc.next();
                        if (!isNumber(num2)){
                            System.out.println("Error, ingrese un valor numerico");
                        }
                    }while (!isNumber(num2));
                    //Se envia la llamada al servidor
                    Object[] suma = {num1,num2};
                    String response = (String) client.execute("Operations.suma",suma);//Se envian los numeros al metodo del servidor
                    System.out.println(response);
                    break;

                case 2:
                    do {
                        System.out.println("Ingresa el primer valor");
                        num1 = sc.next();
                        if (!isNumber(num1)){
                            System.out.println("Error, ingrese un valor numerico");
                        }
                    }while (!isNumber(num1));
                    do {
                        System.out.println("Ingresa el segundo valor");
                        num2 = sc.next();
                        if (!isNumber(num2)){
                            System.out.println("Error, ingrese un valor numerico");
                        }
                    }while (!isNumber(num2));
                    //Se envia la llamada al servidor
                    Object[] resta = {num1,num2};
                    String response2 = (String) client.execute("Operations.resta",resta);//Se envian los numeros al metodo del servidor
                    System.out.println(response2);
                    break;

                case 3:
                    do {
                        System.out.println("Ingresa el primer valor");
                        num1 = sc.next();
                        if (!isNumber(num1)){
                            System.out.println("Error, ingrese un valor numerico");
                        }
                    }while (!isNumber(num1));
                    do {
                        System.out.println("Ingresa el segundo valor");
                        num2 = sc.next();
                        if (!isNumber(num2)){
                            System.out.println("Error, ingrese un valor numerico");
                        }
                    }while (!isNumber(num2));
                    //Se envia la llamada al servidor
                    Object[] multiplicacion = {num1,num2};
                    String response3 = (String) client.execute("Operations.multiplicacion",multiplicacion);//Se envian los numeros al metodo del servidor
                    System.out.println(response3);
                    break;

                case 4:
                    do {
                        System.out.println("Ingresa el primer valor");
                        num1 = sc.next();
                        if (!isNumber(num1)){
                            System.out.println("Error, ingrese un valor numerico");
                        }
                    }while (!isNumber(num1));
                    do {
                        System.out.println("Ingresa el segundo valor");
                        num2 = sc.next();
                        if (indeterminacion(num2)){
                            System.out.println("Hay una indeterminación...Inténtelo de nuevo");
                        }
                    }while (!isNumber(num2));
                    //Se envia la llamada al servidor
                    Object[] division = {num1,num2};
                    String response4 = (String) client.execute("Operations.division",division);//Se envian los numeros al metodo del servidor
                    System.out.println(response4);
                    break;

                case 5:
                    do {
                        System.out.println("Ingresa el primer valor");
                        num1 = sc.next();
                        if (!isNumber(num1)){
                            System.out.println("Error, ingrese un valor numerico");
                        }
                    }while (!isNumber(num1));
                    do {
                        System.out.println("Ingresa el segundo valor");
                        num2 = sc.next();
                        if (!isNumber(num2)){
                            System.out.println("Error, ingrese un valor numerico");
                        }
                    }while (!isNumber(num2));
                    //Se envia la llamada al servidor
                    Object[] exponente = {num1,num2};
                    String response5 = (String) client.execute("Operations.exponente",exponente);//Se envian los numeros al metodo del servidor
                    System.out.println(response5);
                    break;
                case 6:
                    do {
                        System.out.println("Ingresa el primer valor");
                        num1 = sc.next();
                        if (!isNumber(num1)){
                            System.out.println("Error, ingrese un valor numerico");
                        }
                    }while (!isNumber(num1));
                    do {
                        System.out.println("Ingresa el segundo valor");
                        num2 = sc.next();
                        if (!isNumber(num2)){
                            System.out.println("Error, ingrese un valor numerico");
                        }
                    }while (!isNumber(num2));
                    //Se envia la llamada al servidor
                    Object[] raiz = {num1,num2};
                    String response6 = (String) client.execute("Operations.raiz",raiz);//Se envian los numeros al metodo del servidor
                    System.out.println(response6);
                    break;
                case 7:
                    Object param [];
                    param = new Object[1];
                    int count=0;
                    String cadena="";
                    do {
                        param [0]= count;
                        try {
                            cadena = (String) client.execute("Operations.list",param);
                            System.out.println(cadena);
                            count++;
                        }catch (Exception e){
                            System.out.println("Oooops ocurrió un error");
                        }
                    }while (!(cadena.equals("")));

                    break;
                case 8:
                    System.out.println("Gracias por usar el sistema");
                default:
                    System.out.println("Ingresa una opcion valida");
                    break;

            }
        }else{
            System.out.println("Ingresa un valor valido");
        }

        }while (!opcion.equals("7")); //validar objetos con equals, compara lo que tiene entre()

    }

    public static boolean isNumber(String number){
        try {
            int num = Integer.parseInt(number);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    public static boolean indeterminacion (String val){
        int num = Integer.parseInt(val);
        if (num == 0){
            return true;
        }else {
            return false;
        }
    }
}
