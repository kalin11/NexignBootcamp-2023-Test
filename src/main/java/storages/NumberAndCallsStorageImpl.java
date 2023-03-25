package storages;

import entity.Call;
import entity.PhoneNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumberAndCallsStorageImpl implements Storage<PhoneNumber, List<Call>> {
    private Map<PhoneNumber, List<Call>> storage;

    public NumberAndCallsStorageImpl() {
        this.storage = new HashMap<>();
    }

    public Map<PhoneNumber, List<Call>> getStorage() {
        return this.storage;
    }

    public void setStorage(Map<PhoneNumber, List<Call>> storage) {
        this.storage = storage;
    }

    public boolean containsNumber(PhoneNumber number) {
        return this.storage.containsKey(number);
    }


    public List<Call> get(PhoneNumber number) {
        return this.storage.get(number);
    }

    public void put(PhoneNumber number, List<Call> list) {
        this.storage.put(number, list);
    }

    @Override
    public Set<PhoneNumber> keySet() {
        return storage.keySet();
    }

    @Override
    public String toString() {
        StringBuilder mapAsString = new StringBuilder("{");
        for (PhoneNumber key : storage.keySet()) {
            mapAsString.append(key + "=" + storage.get(key).toString() + ", ");
        }
        mapAsString.delete(mapAsString.length() - 2, mapAsString.length()).append("}");
        return mapAsString.toString();
    }
}
