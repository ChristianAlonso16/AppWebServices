package server;

import utils.MySQLConection;

import java.sql.*;
import java.util.ArrayList;

public class DaoRpc {
public boolean save (String name, String apellido1, String apellido2, String curp, int dia, String mes, String año,String rfc){
    boolean result = false;
    String curpT = curp.toUpperCase();
    String rfcT = curp.toUpperCase();
    try
            (Connection con = MySQLConection.getConnection();
             PreparedStatement pstm = con.prepareStatement("insert into rfc (name,apellido1,apellido2,curp,fecha,rfc) values (?,?,?,?,?,?);");
            ){
        pstm.setString(1,name);
        pstm.setString(2,apellido1);
        pstm.setString(3,apellido2);
        pstm.setString(4,curpT);
        pstm.setString(5, dia+" - "+ mes+ " - "+año);
        pstm.setString(6,rfcT);
        result = pstm.executeUpdate() == 1;
    }catch (Exception e){
        e.printStackTrace();
    }
    System.out.println("Registrado");

    return result;
}

public ArrayList<BeanDatos> list () {
    ArrayList<BeanDatos> list = new ArrayList<>();

    try {
        Connection connection =  MySQLConection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from rfc");
        while (rs.next()){
            BeanDatos datos = new BeanDatos();
            datos.setName(rs.getString("name"));
            datos.setApellido1(rs.getString("apellido1"));
            datos.setApellido2(rs.getString("apellido2"));
            datos.setCurp(rs.getString("curp"));
            datos.setFecha(rs.getString("fecha"));
            datos.setRfc(rs.getString("rfc"));
            list.add(datos);
        };
        rs.close();
        connection.close();
        statement.close();

    } catch(Exception e) {
        e.printStackTrace();
    }
    return list;
}
    public ArrayList<BeanDatos> listcurp(String curp){
        ArrayList<BeanDatos> listcurp= new ArrayList<>();

        try (
                Connection con = MySQLConection.getConnection();
                PreparedStatement pstm = con.prepareStatement("SELECT * FROM rfc where curp=?");
        ){

            pstm.setString(5,curp);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                BeanDatos datos = new BeanDatos();
                datos.setName(rs.getString("name"));
                datos.setApellido1(rs.getString("apellido1"));
                datos.setApellido2(rs.getString("apellido2"));
                datos.setCurp(rs.getString("curp"));
                datos.setFecha(rs.getString("fecha"));
                datos.setRfc(rs.getString("rfc"));
                listcurp.add(datos);
}

            } catch (Exception e) {
            e.printStackTrace();
        }

        return listcurp;
    }
}
