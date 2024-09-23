package practica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class addLibro {
    /*diseña el código para insertar libros en la tabla de libros.
        los datos del libro se piden por consola*/

public static void main(String[] args){
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
        System.out.println(conn.toString());
        String add="INSERT INTO `libros` (`id`, `titulo`, `autor`, `unidades`, `precio`) VALUES (NULL, ?, ?, ?, ?);";
        PreparedStatement ps=conn.prepareStatement(add);
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el título del libro");
        ps.setString(1,sc.next());
        System.out.println("Introduce el autor del libro");
        ps.setString(2,sc.next());
        System.out.println("Introduce las unidades del libro");
        ps.setInt(3,sc.nextInt());
        System.out.println("Introduce el precio del libro");
        ps.setFloat(4,sc.nextFloat());
        ps.executeUpdate();
        System.out.println("El libro se ha añadido correctamente");
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

}//cierra main

}//cierra class
