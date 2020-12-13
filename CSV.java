import com.opencsv.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class CSV {
public static ArrayList<String[]> readCSVFile(String file){
    String[] line;
    ArrayList<String[]> list = new ArrayList<>();
    try {
        CSVParser csvBuilder = new CSVParserBuilder().build();
        CSVReader csvReader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(csvBuilder).build();

        while ((line = csvReader.readNext()) != null) {
            list.add(line);
        }
        csvReader.close();
    } catch (Exception e){
        e.printStackTrace();
    }

    return list;
}

public static void writeCSVFile(String file, String[] data){
    try {
        CSVWriter csvWriter = new CSVWriter(new FileWriter(file, true));
        csvWriter.writeNext(data, false);
        csvWriter.close();
    }catch (Exception e){
        e.printStackTrace();
    }
}
}
