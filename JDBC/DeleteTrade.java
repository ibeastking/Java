import java.sql.*;
import javax.swing.*;
import java.util.*;

class DeleteTrade {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
        // pre compiled statement
        PreparedStatement ps = con.prepareStatement("delete from trade where tid=?");
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

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Successful");
        }
        con.close();
    }
}