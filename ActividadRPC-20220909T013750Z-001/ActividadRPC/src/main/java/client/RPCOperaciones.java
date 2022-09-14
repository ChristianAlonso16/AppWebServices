package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RPCOperaciones {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        Scanner scanner = new Scanner(System.in);
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        System.out.println("Ingresa las 4 variables a operar");
        Double num1 = scanner.nextDouble();
        Double num2 = scanner.nextDouble();
        Double num3 = scanner.nextDouble();
        Double num4 = scanner.nextDouble();
        Object[] numbers = {num1,num2,num3,num4};
        String result = (String) client.execute("Methods.operation",numbers);
        System.out.println(result);
    }
}
