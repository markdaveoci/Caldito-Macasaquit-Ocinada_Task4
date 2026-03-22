import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    private static final String DB_URL = "jdbc:sqlite:Hardware.db";

    private Repository(RepoBuilder builder) {

    }

    public static class RepoBuilder {
        public Repository build() {
            return new Repository(this);
        }
    }

    public List<Hardware> fetchHardwareMasterlist() {

        List<Hardware> list = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL)) {

            String sql = "SELECT * FROM hardware_masterlist";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String brand = rs.getString("brand");
                int spec = rs.getInt("spec");
                String type = rs.getString("type");

                if (type.equalsIgnoreCase("Laptop")) {
                    Laptop laptop = new Laptop.LaptopBuilder()
                            .setId(id)
                            .setBrand(brand)
                            .setSpec(spec)
                            .build();
                    list.add(laptop);
                } else if (type.equalsIgnoreCase("Phone")) {
                    Phone phone = new Phone.PhoneBuilder()
                            .setId(id)
                            .setBrand(brand)
                            .setSpec(spec)
                            .build();
                    list.add(phone);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}