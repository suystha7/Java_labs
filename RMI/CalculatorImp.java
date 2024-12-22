package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Implementation of the Remote Interface
public class CalculatorImp extends UnicastRemoteObject implements Calculator {

    // Constructor
    protected CalculatorImp() throws RemoteException {
        super();
    }

    @Override
    public double add(double a, double b) throws RemoteException {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) throws RemoteException {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) throws RemoteException {
        return a * b;
    }

    @Override
    public double divide(double a, double b) throws RemoteException {
        if (b == 0) throw new ArithmeticException("Division by zero is not allowed.");
        return a / b;
    }
}

