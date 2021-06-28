package by.tms.service;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.storage.OperationStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalcService {

    private final OperationStorage operationStorage = new OperationStorage();

    public Operation calc(double firstPar, double secondPar, String operation, User user){
        switch (operation){
            case "sum":
                Operation operation1 = new Operation(firstPar, secondPar, operation, firstPar + secondPar, user);
                operationStorage.save(operation1);
                return operation1;
            case "sub":
                Operation operation2 = new Operation(firstPar, secondPar, operation, firstPar - secondPar, user);
                operationStorage.save(operation2);
                return operation2;
            case "multi":
                Operation operation3 = new Operation(firstPar, secondPar, operation, firstPar * secondPar, user);
                operationStorage.save(operation3);
                return operation3;
            case "div":
                Operation operation4 = new Operation(firstPar, secondPar, operation, firstPar / secondPar, user);
                operationStorage.save(operation4);
                return operation4;
        }
        return null;
    }

    public List<Operation> findAll(){
        return operationStorage.getAll();
    }

    public List<Operation> findAllByUser(User user){
        List<Operation> all = operationStorage.getAll();
        return  new ArrayList<>(all.stream().filter(o -> o.getUser().equals(user)).collect(Collectors.toList()));
    }

    public void deleteByUser(User u){
        operationStorage.deleteByUser(u);
    }
}
