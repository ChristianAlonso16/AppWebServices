package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RPCRango {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        Scanner scanner = new Scanner(System.in);
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        System.out.println("Ingresa dos valores para sumar los valores entre ellos");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        Object[] rango = {a,b};
        int response = (int) client.execute("Methods.rango",rango);
        System.out.println("La suma de los numeros entre esos valores es: "+response);
    }
}
