import java.io.*;
import java.net.Socket;


public class ClientHandler extends Thread {
    private Socket clientSocket;
    private CSVHandler csvHandler;


    public ClientHandler(Socket socket, CSVHandler handler) {
        this.clientSocket = socket;
        this.csvHandler = handler;
    }


    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.startsWith("GET_ROW")) {
                    try {
                        int rowIndex = Integer.parseInt(inputLine.split(" ")[1]);
                        String[] row = csvHandler.getRow(rowIndex);
                        if (row != null) {
                            out.println(String.join(", ", row));
                        } else {
                            out.println("ERROR: Invalid row");
                        }
                    } catch (Exception e) {
                        out.println("ERROR: Malformed request");
                    }
                } else {
                    out.println("ERROR: Unknown command");
                }
            }
        } catch (IOException e) {
            System.out.println("Errore con il client: " + e.getMessage());
        }
    }
}
