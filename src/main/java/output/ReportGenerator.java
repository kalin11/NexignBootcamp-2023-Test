package output;

import entity.Call;
import entity.PhoneNumber;
import storages.Storage;
import utils.CallTime;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReportGenerator {
    private String report = "";
    private final Storage<PhoneNumber, List<Call>> numbersAndCalls;

    public ReportGenerator(Storage<PhoneNumber, List<Call>> numbersAndCalls) {
        this.numbersAndCalls = numbersAndCalls;
    }

    private void generateHeader(PhoneNumber number) {
        report += "Tariff index: " + number.getTariff() + "\n" +
                "----------------------------------------------------------------------------\n" +
                "Report for phone number " + number.getNumber() + ":\n" +
                "----------------------------------------------------------------------------\n" +
                "| Call Type |   Start Time        |     End Time        | Duration | Cost  |\n" +
                "----------------------------------------------------------------------------\n";
    }

    public void generateReport() {
        CallTime callTime = new CallTime();
        for (PhoneNumber number : numbersAndCalls.keySet()) {
            generateHeader(number);
            sort(numbersAndCalls, number);
            for (Call call : numbersAndCalls.get(number)) {
                report += "|     " + call.getCallType();
                report += "    | " + callTime.formatDate(call.getCallStartTime());
                report += " | " + callTime.formatDate(call.getCallEndTime());
                report += " | " + callTime.formatCallTime(call.getCallStartTime(), call.getCallEndTime());
                report += " | " + String.format("%5s", String.format("%.2f", call.getPrice())) + " |\n";
            }
            generateFooter(number);
            saveReport(report, number.getNumber());
            report = "";
        }
    }

    private void generateFooter(PhoneNumber number) {
        report += "----------------------------------------------------------------------------\n";
        report += "|                                           Total Cost: |" + String.format("%10s", String.format("%.2f", number.getTotalSum())) + " rubles |\n";
        report += "----------------------------------------------------------------------------";
    }


    private void sort(Storage<PhoneNumber, List<Call>> storage, PhoneNumber phoneNumber) {
        storage.get(phoneNumber).sort((o1, o2) -> {
            if (o1.getCallStartTime().getTime() < o2.getCallStartTime().getTime()) {
                return -1;
            } else if (o1.getCallStartTime().getTime() > o2.getCallStartTime().getTime()) {
                return 1;
            }
            return 0;
        });
    }

    private void saveReport(String report, String number) {
        try {
            Files.write(Paths.get("reports/report_" + number + ".txt"), report.getBytes());
        } catch (IOException e) {
            System.err.println("There was some problems with saving report. Report number " + number);
        }
    }
}
