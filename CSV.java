import com.opencsv.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class CSV {
public static ArrayList<String[]> readCSVFile(String file) throws Exception{
    String[] line;
    ArrayList<String[]> list = new ArrayList<>();
        CSVReader csvReader = new CSVReaderBuilder(new FileReader(file)).build();
        CSVParser csvBuilder = new CSVParserBuilder().build();

        while ((line = csvReader.readNext()) != null){
            list.add(line);
        }
        csvReader.close();
    return list;
}

public static void writeCSVFile(String file, String[] data) throws Exception {
        CSVWriter csvWriter = new CSVWriter(new FileWriter(file, true));
        csvWriter.writeNext(data, false);
        csvWriter.close();
}
}
