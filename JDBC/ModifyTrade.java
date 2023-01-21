import java.sql.*;
import javax.swing.*;
import java.util.*;

class ModifyTrade

{
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
        // pre compiled statements
        PreparedStatement ps = con.prepareStatement("update trade set tnm=?, tcap=? where tid=?");
        PreparedStatement ps1 = con.prepareStatement("select * from trade where tid=?");

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

            if (!rs.next()) {
                System.out.println("Record does not exists");
                continue;
            }

            System.out.println("Trade Name:");
            nm = s.next();

            System.out.println("Trade Intake:");
            cap = s.nextInt();

            ps.setString(1, nm); // 2 represents value in 2nd ?
            ps.setInt(2, cap);
            ps.setInt(3, id);

            ps.executeUpdate();
            System.out.println("Successful");

        }
        con.close();
    }
}