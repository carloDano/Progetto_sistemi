import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class CSVClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to server. Available commands:");
            System.out.println("GET_ROW <n>, GET_ALL, GET_SIZE, FILTER <col>=<val>, HEADERS, exit");

            while (true) {
                System.out.print("> ");
                String command = scanner.nextLine();
                if ("exit".equalsIgnoreCase(command)) break;

                out.println(command);
                String response;
                while ((response = in.readLine()) != null && !response.isEmpty()) {
                    System.out.println(response);
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
