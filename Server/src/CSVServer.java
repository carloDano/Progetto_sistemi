
import java.net.ServerSocket;
import java.net.Socket;

public class CSVServer {
    public static void main(String[] args) {
        int port = 12345;
        String csvPath = "Mappa-agriturismo-BB-locanda-e-simili-in-Italia.csv";

        try {
            CSVReader reader = new CSVReader(csvPath);
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket, reader).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

