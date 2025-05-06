import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket clientSocket;
    private CSVReader reader;

    public ClientHandler(Socket socket, CSVReader reader) {
        this.clientSocket = socket;
        this.reader = reader;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            out.println("comandi disponibili:\n\r" +
                    "1) GET_ALL\n\r" +
                    "2) GET_ROW\n\r" +
                    "3) GET_SIZE\n\r" +
                    "4) FILTER<colonna>=<valore>\n\r" +
                    "5) HEADERS\n\r" +
                    "6) END\n\r");
            String input;
            while ((input = in.readLine()) != null) {
                if(input.equals("END")) break;
                if (input.startsWith("GET_ROW")) {
                    try {
                        int row = Integer.parseInt(input.split(" ")[1]);
                        out.println(reader.getRow(row));
                    } catch (Exception e) {
                        out.println("ERROR: Invalid row index");
                    }
                } else if (input.equals("GET_ALL")) {
                    out.println(reader.getAllRows());
                } else if (input.equals("GET_SIZE")) {
                    out.println(reader.getRowCount());
                } else if (input.startsWith("FILTER")) {
                    try {
                        String[] parts = input.substring(7).split("=", 2);
                        String column = parts[0].trim();
                        String value = parts[1].trim();
                        out.println(reader.filterBy(column, value));
                    } catch (Exception e) {
                        out.println("ERROR: Invalid filter format. Use FILTER column=value");
                    }
                } else if (input.equals("HEADERS")) {
                    out.println(reader.getHeaders());
                } else {
                    out.println("ERROR: Unknown command");
                }
            }
        } catch (IOException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }
}



