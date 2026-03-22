import java.util.List;

public class Main {
    public static void main(String[] args) {

        Repository repo = new Repository.RepoBuilder().build();
        List<Hardware> hardwareList = repo.fetchHardwareMasterlist();

        int laptop16 = 0;
        int laptop32 = 0;
        int phone50 = 0;

        System.out.println("=== Hardware Masterlist ===");

        for (Hardware hw : hardwareList) {
            System.out.println(hw.getBrand() + " - " + hw.interpretSpec());

            if (hw instanceof Laptop) {
                if (hw.getSpec() == 16) laptop16++;
                if (hw.getSpec() == 32) laptop32++;
            }
            else if (hw instanceof Phone) {
                if (hw.getSpec() == 50) phone50++;
            }
        }

        System.out.println("\n=== Inventory Summary ===");
        System.out.println("16GB Laptops: " + laptop16);
        System.out.println("32GB Laptops: " + laptop32);
        System.out.println("50MP Phones: " + phone50);
    }
}