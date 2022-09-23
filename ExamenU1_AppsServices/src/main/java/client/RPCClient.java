package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RPCClient {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        Scanner sc = new Scanner(System.in);
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        System.out.println("Bienvenido al sistema para generar tu RFC");
        String opcion;
        do {

            System.out.println("Ingresa la opcion que deseas utilizar");
            System.out.println("1.Registrar una persona 2.Modificar una persona 3.Consultar persona por medio del curp 4.Consultar personas 5.Eliminar a una persona");
            opcion = sc.next();
            String name;
            String apellido1;
            String apellido2;
            String curp;
            int dia;
            String mes;
            String año;
            if (isNumber(opcion)) {

                switch (Integer.parseInt(opcion)) {
                    case 1:
                        System.out.println("Ingresa el nombre");
                        name = sc.next();
                        System.out.println("Ingresa el primer apellido");
                        apellido1 = sc.next();
                        System.out.println("Ingresa el segundo apellido");
                        apellido2 = sc.next();
                        System.out.println("Ingresa el CURP");
                        curp = sc.next();
                        System.out.println("Ingresa el dia de nacimiento");
                        dia = sc.nextInt();
                        System.out.println("Ingresa el mes de nacimiento en numero");
                        mes = sc.next();
                        System.out.println("Ingresa el año de nacimiento");
                        año = sc.next();
                        Object[] save = {name, apellido1, apellido2, curp, dia, mes, año};
                        String response = (String) client.execute("metodos.save", save);
                        System.out.println(response);
                        break;
                    case 2:
                        System.out.println("Ingresa el curp de la persona que quieres modificar");
                        int id = sc.nextInt();
                        System.out.println("Ingresa el nombre");
                        name = sc.next();
                        System.out.println("Ingresa el primer apellido");
                        apellido1 = sc.next();
                        System.out.println("Ingresa el segundo apellido");
                        apellido2 = sc.next();
                        System.out.println("Ingresa el CURP");
                        curp = sc.next();
                        System.out.println("Ingresa el dia de nacimiento");
                        dia = sc.nextInt();
                        System.out.println("Ingresa el mes de nacimiento en numero");
                        mes = sc.next();
                        System.out.println("Ingresa el año de nacimiento");
                        año = sc.next();
                        Object[] update = {name, apellido1, apellido2, curp, dia, mes, año};
                        String response2 = (String) client.execute("metodos.update", update);
                        System.out.println(response2);
                        break;
                    case 3:
                        Object param1[];
                        param1 = new Object[1];
                        int count1 = 0;
                        String cadena1 = "";
                        do {
                            param1[0] = count1;
                            try {
                                cadena1 = (String) client.execute("metodos.listcurp", param1);
                                System.out.println(cadena1);
                                count1++;
                            } catch (Exception e) {
                                System.out.println("Oooops ocurrió un error");
                            }
                        } while (!(cadena1.equals("")));
                        break;
                    case 4:
                        Object param[];
                        param = new Object[1];
                        int count = 0;
                        String cadena = "";
                        do {
                            param[0] = count1;
                            try {
                                cadena = (String) client.execute("metodos.list", param);
                                System.out.println(cadena1);
                                count++;
                            } catch (Exception e) {
                                System.out.println("Oooops ocurrió un error");
                            }
                        } while (!(cadena.equals("")));
                }else{
                    System.out.println("Ingresa un valor valido");
                }
            } while (!opcion.equals("6")) ;
        }
    }

    public static boolean isNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}