package teoria;

import java.sql.*;
import java.util.Scanner;

public class basicoParametrico {
    public static void main(String[] args) throws SQLException {
        System.out.println("Conexión JDBC");
        Connection c=null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            //System.out.println(c.toString());
            //String insertar="insert into clientes values(null,?,?,?)";
            String insertar2="INSERT INTO `clientes` (`id`, `nombre`, `ciudad`, `telefono`) VALUES (NULL, ?, ?, ?)";
            PreparedStatement ps=c.prepareStatement(insertar2);
            System.out.println("dime el nombre del usuario");
            Scanner sc=new Scanner(System.in);
            String nombre=sc.next();
           ps.setString(1,nombre);
            System.out.println("dime la ciudad del usuario");
            String ciudad=sc.next();
           ps.setString(2,ciudad);
            System.out.println("dime el teléfono del usuario");
            String telefono=sc.next();
            ps.setString(3,telefono);

           // st.executeQuery(insertar);
            int insertado=ps.executeUpdate();//no pasar como argumento de nuevo la query
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
