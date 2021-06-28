package by.tms.entity;

public class Operation {

    private double parOne;
    private double parTwo;
    private String operation;
    private double result;
    private User user;

    public Operation(double parOne, double parTwo, String operation, double result, User user) {
        this.parOne = parOne;
        this.parTwo = parTwo;
        this.operation = operation;
        this.result = result;
        this.user = user;
    }

    public double getParOne() {
        return parOne;
    }

    public double getParTwo() {
        return parTwo;
    }

    public String getOperation() {
        return operation;
    }

    public User getUser() {
        return user;
    }

    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "parOne=" + parOne +
                ", parTwo=" + parTwo +
                ", operation='" + operation + '\'' +
                ", result=" + result +
                '}';
    }
}
