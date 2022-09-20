package server;

import utils.MySqlConnection;

import java.sql.*;
import java.util.ArrayList;

public class DaoOperations {

        public boolean save (double num, double nume, double resultado, String operacion ){
                boolean result = false;
                try (
                        Connection con = MySqlConnection.getConnection();
                        PreparedStatement pstm = con.prepareStatement("insert into operaciones (tipo,primer_numero,segundo_numero,resultado) values (?,?,?,?);");
                ){
                        pstm.setString(1,operacion);
                        pstm.setDouble(2,num);
                        pstm.setDouble(3,nume);
                        pstm.setDouble(4,resultado);
                        result = pstm.executeUpdate() == 1;
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }

                return result;
        }
        public ArrayList<BeanOperaciones> listOperations (){
                ArrayList<BeanOperaciones> list = new ArrayList<>();
                try {
                        Connection connection = MySqlConnection.getConnection();
                        Statement statement = connection.createStatement();
                        ResultSet rs = statement.executeQuery("select * from operaciones");
                        while (rs.next()){
                                BeanOperaciones operation = new BeanOperaciones();
                                operation.setOperacion(rs.getString("tipo"));
                                operation.setNum1(rs.getInt("primer_numero"));
                                operation.setNum2(rs.getInt("segundo_numero"));
                                operation.setResult(rs.getDouble("resultado"));
                                operation.setFecha(rs.getDate("created_at"));

                                list.add(operation);
                        };

                        rs.close();
                        connection.close();
                        statement.close();

                } catch(Exception e) {
                        e.printStackTrace();
                }
                return list;
        }
}
