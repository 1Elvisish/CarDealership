package org.yearup.New;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contract> contracts = readContractsFromCSV("contracts.csv");

        for (Contract contract : contracts) {
            contract.printContract();
            System.out.println();
        }
    }

    private static List<Contract> readContractsFromCSV(String csvFile) {
        List<Contract> contracts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] contractData = line.split("\\|");
                String contractType = contractData[0];

                if (contractType.equalsIgnoreCase("SALE")) {
                    SalesContract salesContract = createSalesContract(contractData);
                    contracts.add(salesContract);
                } else if (contractType.equalsIgnoreCase("LEASE")) {
                    LeaseContract leaseContract = createLeaseContract(contractData);
                    contracts.add(leaseContract);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contracts;
    }

    private static SalesContract createSalesContract(String[] contractData) {
        String contractDate = contractData[1];
        String customerName = contractData[2];
        String customerEmail = contractData[3];
        String vehicleSold = contractData[4];
        double salesTaxAmount = Double.parseDouble(contractData[6]);
        double recordingFee = Double.parseDouble(contractData[7]);
        double processingFee = Double.parseDouble(contractData[8]);
        boolean isFinanced = contractData[10].equalsIgnoreCase("YES");

        return new SalesContract(contractDate, customerName, customerEmail, vehicleSold, salesTaxAmount,
                recordingFee, processingFee, isFinanced);
    }

    private static LeaseContract createLeaseContract(String[] contractData) {
        String contractDate = contractData[1];
        String customerName = contractData[2];
        String customerEmail = contractData[3];
        String vehicleSold = contractData[4];
        double expectingEndingValue = Double.parseDouble(contractData[6]);
        double leaseFee = Double.parseDouble(contractData[7]);

        return new LeaseContract(contractDate, customerName, customerEmail, vehicleSold, expectingEndingValue, leaseFee);
    }
}
