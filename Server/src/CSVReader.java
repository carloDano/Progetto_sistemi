
import java.io.*;
import java.util.*;

public class CSVReader {
    private List<Map<String, String>> data = new ArrayList<>();
    private List<String> headers;

    public CSVReader(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            headers = Arrays.asList(br.readLine().split(";"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                Map<String, String> row = new LinkedHashMap<>();
                for (int i = 0; i < headers.size() && i < values.length; i++) {
                    row.put(headers.get(i), values[i]);
                }
                data.add(row);
            }
        }
    }

    public String getRow(int index) {
        if (index < 0 || index >= data.size()) {
            return "ERROR: Invalid row";
        }
        return data.get(index).toString();
    }

    public String getAllRows() {
        return data.toString() + "\n\r";
    }

    public int getRowCount() {
        return data.size();
    }

    public List<String> getHeaders() {
        return headers;
    }

    public String filterBy(String column, String value) {
        List<Map<String, String>> filtered = new ArrayList<>();
        for (Map<String, String> row : data) {
            if (value.equalsIgnoreCase(row.get(column))) {
                filtered.add(row);
            }
        }
        return filtered.isEmpty() ? "No results found" : filtered.toString();
    }
}
