package server;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

public class RPCServer {
    public static void main (String []args) throws XmlRpcException, IOException {
        System.out.println("Iniciando servidor...");
        PropertyHandlerMapping mapping = new PropertyHandlerMapping(); //las propiedades del servidor tendran una clase metodos que apuntan a esa clase
        mapping.addHandler("Operations", Operations.class);
        WebServer server = new WebServer(1200); //Se añade el servidor que pasa por el puerto 1200
        server.getXmlRpcServer().setHandlerMapping(mapping);
        server.start();
        System.out.println("Esperando peticiones...");
    }
}