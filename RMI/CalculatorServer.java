package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            CalculatorImp calculator = new CalculatorImp();
            Naming.rebind("CalculatorService", calculator);

            System.out.println("Calculator Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

