package practica;

import java.sql.*;

public class viewLibros {
/*diseña una consulta para mostrar todos los libros en consola*/
    public static void main(String[]args) throws SQLException {
        Connection conn=null;
        try {
            Class.forName("c.cj.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            String consulta="select * from libros";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(consulta);
            while(rs.next()){
                System.out.println("Titulo "+rs.getString(2));
                System.out.println("Autor "+rs.getString(3));
                System.out.println("Unidades "+rs.getString(4));
                System.out.println("Precio "+rs.getString(5));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            conn.close();
        }
    }//cierra main


}//cierra clase
