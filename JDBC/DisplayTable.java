
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class DisplayTable {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306realsoft", "root", "");
        PreparedStatement ps1 = con.prepareStatement("select * from trade");

        int id = 0, cap = 0;
        String nm = "";

        ResultSet rs = ps1.executeQuery();

        while (rs.next()) {
            id = rs.getInt(1);
            nm = rs.getString(2);
            cap = rs.getInt(3);
            String s = "Trade ID: " + id + "\nName: " + nm + "\nIntake: " + cap;
            JOptionPane.showMessageDialog(null, s);
            System.out.println("Successfull");
        }
        con.close();
    }
}
