package storages;


import entity.PhoneNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NumbersAndTariffTimeStorageImpl implements Storage<String, Long> {
    private Map<String, Long> storage;

    public NumbersAndTariffTimeStorageImpl() {
        this.storage = new HashMap<>();
    }

    public Map<String, Long> getStorage() {
        return this.storage;
    }

    public void setStorage(Map<String, Long> storage) {
        this.storage = storage;
    }

    public boolean containsNumber(String number) {
        return this.storage.containsKey(number);
    }


    public Long get(String number) {
        return this.storage.get(number);
    }

    public void put(String number, Long list) {
        this.storage.put(number, list);
    }

    @Override
    public Set<String> keySet() {
        return storage.keySet();
    }
}
