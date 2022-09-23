package server;
import java.util.ArrayList;
import java.util.List;
import  java.util.Random;
import java.util.random.RandomGenerator;

public class metodos {
    public String save (String name, String apellido1, String apellido2, String curp, int dia, String mes, String año) {
        char letraname = name.charAt(0);
        char letra1 = apellido1.charAt(0);
        char letra2 = apellido1.charAt(1);
        char letra3 = apellido2.charAt(0);
        String fecha = año + mes + dia;
        String caracteres = "QWERTYUIOPASDFGHJKLÑZXCVBNM1234567890";
        String rfc = "Su RFC es: " + letra1 + letra2 + letra3 + letraname + fecha;
        DaoRpc daoRpc = new DaoRpc();
        boolean result = daoRpc.save(name,apellido1,apellido2,curp,dia,año,mes,rfc);
        Random random = new Random();
            int randomInt = random.nextInt(caracteres.length());
            char randomChar = caracteres.charAt(randomInt);
            String rfcT= rfc.toUpperCase();
        return rfcT + randomChar;

    }
    public String list (int count){
        DaoRpc daoRpc = new DaoRpc();
        ArrayList<BeanDatos> list = daoRpc.list();
        if (count == list.size()){
            return "";
        }else {
            String cadena= list.get(count).getName()+" "+list.get(count).getApellido1()+" "+list.get(count).getApellido2()+" "+list.get(count).getCurp()+" "+list.get(count).getFecha();
            return cadena;
        }
    }
    public String listcurp (int count1){
        DaoRpc daoRpc = new DaoRpc();
        ArrayList<BeanDatos> list = daoRpc.listcurp(listcurp(count1));
        if (count1 == list.size()){
            return "";
        }else {
            String cadena1= list.get(count1).getName()+" "+list.get(count1).getApellido1()+" "+list.get(count1).getApellido2()+" "+list.get(count1).getCurp()+" "+list.get(count1).getFecha();
            return cadena1;
        }
    }
}
