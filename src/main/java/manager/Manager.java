package manager;

import entity.Call;
import entity.PhoneNumber;
import builders.CallBuilder;
import builders.PhoneNumberBuilder;
import output.ReportGenerator;
import readers.FilesReader;
import storages.NumberAndCallsStorageImpl;
import storages.NumbersAndTariffTimeStorageImpl;
import storages.Storage;
import utils.CallsPriceSetter;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    private Storage<PhoneNumber, List<Call>> numbersAndCalls;
    private Storage<String, Long> numbersAndTariffTime;
    private final String fileName;

    public Manager(String fileName) {
        this.fileName = fileName;
    }

    public void manage() {
        CallsPriceSetter setter = new CallsPriceSetter();
        getCallsFromFile();
        setter.set(this);
        ReportGenerator generator = new ReportGenerator(numbersAndCalls);
        generator.generateReport();
    }

    public void getCallsFromFile() {
        this.numbersAndCalls = new NumberAndCallsStorageImpl();
        this.numbersAndTariffTime = new NumbersAndTariffTimeStorageImpl();
        List<List<String>> calls;
        CallBuilder callBuilder = new CallBuilder();
        PhoneNumberBuilder phoneNumberBuilder = new PhoneNumberBuilder();
        try {
            FilesReader reader = new FilesReader(fileName);
            calls = reader.read();
            for (List<String> list : calls) {
                PhoneNumber phoneNumber = phoneNumberBuilder.createPhoneNumber(list);
                Call call = callBuilder.createCall(list);
                if (numbersAndCalls.containsNumber(phoneNumber)) {
                    numbersAndCalls.get(phoneNumber).add(call);
                } else {
                    numbersAndCalls.put(phoneNumber, new ArrayList<>());
                    numbersAndTariffTime.put(phoneNumber.getNumber(), phoneNumber.getTariffTime());
                    numbersAndCalls.get(phoneNumber).add(call);
                }
            }
        } catch (IOException e) {
            System.err.println("There's some problems with reading file.");
        } catch (ParseException e) {
            System.err.println("There's some problems with parsing file.");
        }
    }

    public Storage<String, Long> getNumbersAndTariffTime() {
        return this.numbersAndTariffTime;
    }

    public Storage<PhoneNumber, List<Call>> getNumbersAndCalls() {
        return this.numbersAndCalls;
    }

}
