package teoria;

import java.sql.*;

public class basicoSelect {
    public static void main(String[] args){
        System.out.println("Conexión JDBC");
        Connection c=null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            //System.out.println(c.toString());
            String consultar="SELECT * FROM clientes";
            Statement st=c.createStatement();
           // st.executeQuery(insertar);
            ResultSet rs=st.executeQuery(consultar);
            while(rs.next()){
                System.out.println("ID de cliente "+rs.getString(1));
                System.out.println("Nombre de cliente "+rs.getString("nombre"));
                System.out.println("Ciudad de cliente "+rs.getString("ciudad"));
                System.out.println("--------");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }//cierra main
}//cierra clase
