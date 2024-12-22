package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            // Start the RMI registry on port 1099 (default)
            LocateRegistry.createRegistry(1099);

            // Create an instance of the remote object
            CalculatorImp calculator = new CalculatorImp();

            // Bind the remote object to a name in the registry
            Naming.rebind("CalculatorService", calculator);

            System.out.println("Calculator Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

