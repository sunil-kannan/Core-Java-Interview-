package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHttpServer {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10); // Create a thread pool with 10 threads
        try (ServerSocket serverSocket = new ServerSocket(8080)) { // Listening on port 8080
            System.out.println("Server is listening on port 8080");
            while (true) {
                Socket socket = serverSocket.accept(); // Accept a client connection
                System.out.println("Client connected");
                executor.submit(() -> handleClient(socket)); // Handle each client in a separate thread
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            // Read and print the client's request (For HTTP, this will be the HTTP request)
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                if (inputLine.isEmpty()) {
                    break;
                }
            }

            // Respond to the client
            String httpResponse = "HTTP/1.1 200 OK\r\n\r\nHello, World!";
            out.write(httpResponse);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close(); // Close the socket after handling the client
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
