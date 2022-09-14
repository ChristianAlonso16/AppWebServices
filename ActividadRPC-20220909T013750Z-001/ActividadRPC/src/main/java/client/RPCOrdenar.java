package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RPCOrdenar {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        Scanner scanner = new Scanner(System.in);
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        System.out.println("Ingrese 5 numeros par ordenarlos de forma ascendente");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d= scanner.nextInt();
        int e= scanner.nextInt();
        Object[] ordenar = {a,b,c,d,e};
        String response = (String) client.execute("Methods.ordenar",ordenar);
        System.out.println(response);
    }
}
