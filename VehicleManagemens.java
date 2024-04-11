import java.util.ArrayList;
import java.util.Scanner;

public class VehicleManagemens {
    public static void main(String[] args) {
        ArrayList<Vehicles> vehicleList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        MenuHandler menuHandler = new MenuHandler(vehicleList, scanner);
        menuHandler.runMenu();

        scanner.close();
    }
}

class MenuHandler {
    private ArrayList<Vehicles> vehicleList;
    private Scanner scanner;

    public MenuHandler(ArrayList<Vehicles> vehicleList, Scanner scanner) {
        this.vehicleList = vehicleList;
        this.scanner = scanner;
    }

    public void runMenu() {
        int choice;
        do {
            System.out.print("\nMenu:");
            System.out.println("\n1. Add a vehicle");
            System.out.println("2. Display a list of vehicle details");
            System.out.println("3. Delete a vehicle");
            System.out.println("4. Sort vehicle list by age");
            System.out.println("5. Quit");
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    new VehicleAdder(vehicleList, scanner).addVehicle();
                    break;
                case 2:
                    new VehicleDisplayer(vehicleList).displayVehicleList();
                    break;
                case 3:
                    new VehicleDeleter(vehicleList, scanner).deleteVehicle();
                    break;
                case 4:
                    new VehicleSorter(vehicleList).sortVehicleListByAge();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}

class VehicleAdder {
    private ArrayList<Vehicles> vehicleList;
    private Scanner scanner;

    public VehicleAdder(ArrayList<Vehicles> vehicleList, Scanner scanner) {
        this.vehicleList = vehicleList;
        this.scanner = scanner;
    }

    public void addVehicle() {
        System.out.print("\nEnter registration number: ");
        String regNo = scanner.nextLine();
        System.out.print("Enter make of vehicle: ");
        String make = scanner.nextLine();
        System.out.print("Enter year of manufacture: ");
        int yearOfManufacture = scanner.nextInt();
        System.out.print("Enter value of vehicle: ");
        double value = scanner.nextDouble();
        vehicleList.add(new Vehicles(regNo, make, yearOfManufacture, value));
        System.out.println("\nVehicle added successfully." + "\n");
    }
}

class VehicleDisplayer {
    private ArrayList<Vehicles> vehicleList;

    public VehicleDisplayer(ArrayList<Vehicles> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public void displayVehicleList() {
        if (vehicleList.isEmpty()) {
            System.out.println("\nNo vehicles in the list." + "\n");
            return;
        }
        System.out.println("\nList of vehicles:" + "\n");
        for (int i = 0; i < vehicleList.size(); i++) {
            System.out.println((i + 1) + ". " + vehicleList.get(i));
        }
    }
}

class VehicleDeleter {
    private ArrayList<Vehicles> vehicleList;
    private Scanner scanner;

    public VehicleDeleter(ArrayList<Vehicles> vehicleList, Scanner scanner) {
        this.vehicleList = vehicleList;
        this.scanner = scanner;
    }

    public void deleteVehicle() {
        new VehicleDisplayer(vehicleList).displayVehicleList();
        if (vehicleList.isEmpty()) {
            return;
        }
        System.out.print("\nEnter the number of the vehicle to delete: ");
        int index = scanner.nextInt();
        if (index < 1 || index > vehicleList.size()) {
            System.out.println("\nInvalid index.");
            return;
        }
        vehicleList.remove(index - 1);
        System.out.println("\nVehicle deleted successfully." + "\n");
    }
}

class VehicleSorter {
    private ArrayList<Vehicles> vehicleList;

    public VehicleSorter(ArrayList<Vehicles> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public void sortVehicleListByAge() {
        if (vehicleList.isEmpty()) {
            System.out.println("\nNo vehicles in the list." + "\n");
            return;
        }
        vehicleList.sort((v1, v2) -> Integer.compare(v1.getYearOfManufacture(), v2.getYearOfManufacture()));
        System.out.println("\nVehicles sorted by age." + "\n");
        new VehicleDisplayer(vehicleList).displayVehicleList();
    }
}
