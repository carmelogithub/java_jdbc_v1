package teoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class basico {
    public static void main(String[] args) throws SQLException {
        System.out.println("Conexión JDBC");
        Connection c=null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            //System.out.println(c.toString());
            String insertar="insert into clientes(id,nombre,ciudad,telefono) values(null,'maria','valencia','600102030')";
            Statement st=c.createStatement();

           // st.executeQuery(insertar);
            int insertado=st.executeUpdate(insertar);
            System.out.println("Has añadido "+insertado+" cliente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
           if(c!=null){
               c.close();
           }

        }
    }//cierra main
}//cierra clase
