import java.sql.*;
import javax.swing.*;
import java.util.*;

class day96_P1_NewInsertTrade {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
        // pre compiled statements
        PreparedStatement ps = con.prepareStatement("insert into trade values(? ? ?)");
        PreparedStatement ps1 = con.prepareStatement("select * from trade where id=?");

        int id = 0, cap = 0;
        String nm = "";
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("ID:");
            id = s.nextInt();
            if (id == 0) {
                break;
            }

            ps1.setInt(1, id);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                System.out.println("Record exists");
                continue;
            }

            System.out.println("Trade Name:");
            nm = s.next();

            System.out.println("Trade Intake:");
            cap = s.nextInt();
            ps.setInt(1, id);
            ps.setString(2, nm); // 2 represents value in 2nd ?
            ps.setInt(3, cap);
            ps.executeUpdate();
            System.out.println("Successful");

        }
        con.close();
    }
}