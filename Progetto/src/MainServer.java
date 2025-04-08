import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {
        int port = 12345;
        String filePath = "\\C:\\Users\\carlo.dano\\Documents\\Progetto_sistemi\\Progetto\\Mappa-agriturismo-BB-locanda-e-simili-in-Italia.csv";

        try {
            CSVHandler csvHandler = new CSVHandler(filePath);
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server avviato sulla porta " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nuovo client connesso.");
                ClientHandler clientHandler = new ClientHandler(clientSocket, csvHandler);
                clientHandler.start();
            }

        } catch (IOException e) {
            System.err.println("Errore nell'avvio del server: " + e.getMessage());
        }
    }
}
