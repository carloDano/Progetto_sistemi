import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CSVHandler {
    private List<String[]> data;


    public CSVHandler(String filePath) throws IOException {
        data = new ArrayList<>();
        loadCSV(filePath);
    }


    private void loadCSV(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            data.add(row);
        }
        br.close();
    }


    public String[] getRow(int index) {
        if (index >= 0 && index < data.size()) {
            return data.get(index);
        } else {
            return null;
        }
    }


    public int getRowCount() {
        return data.size();
    }
}