package server;

import utils.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
