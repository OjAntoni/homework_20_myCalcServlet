package by.tms.storage;

import by.tms.entity.Operation;
import by.tms.entity.User;

import java.util.ArrayList;
import java.util.List;

public class OperationStorage {

    private static List<Operation> operations = new ArrayList<>();

    public void save(Operation o){
        operations.add(o);
    }

    public List<Operation> getAll(){
        return new ArrayList<>(operations);
    }

    public void deleteByUser(User u){
        operations.removeIf(op -> op.getUser().equals(u));
    }
}
