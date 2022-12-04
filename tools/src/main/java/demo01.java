import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo01 {

    public static void outPutCsv(String filePath, String[] headers, List<List<String>> data) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(headers);
        CSVPrinter csvPrinter = new CSVPrinter(outputStreamWriter, csvFormat);

        System.out.println("start..");
        data.forEach(l -> {
            try {
                csvPrinter.printRecord(l);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        csvPrinter.flush();
        csvPrinter.close();
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    public static void main(String[] args) throws IOException {

        String path = "src/main/resources/file.csv";

        String[] headers = new String[]{"employeeId", "name"};

        List<List<String>> data = new ArrayList<>();

        for (int i = 2000; i < 3000; i++){
            data.add(Arrays.asList(String.valueOf(i), "\"user".concat(String.valueOf(i).concat("\""))));
        }

        demo01.outPutCsv(path, headers, data);
    }
}
