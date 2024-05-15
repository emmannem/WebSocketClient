package org.uv.websocketclient;
import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import java.net.URI;
import javax.websocket.ContainerProvider;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author Codigy
 */
@ClientEndpoint
public class WebSocketCliente{

//    @OnOpen
//    public void onOpen(Session session) {
//        System.out.println("Connected to server");
//        // Send a message to the server
//        try {
//            session.getBasicRemote().sendText("Hello, Server!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    @OnMessage
//    public void onMessage(String message, Session session) {
//        System.out.println("Message from " + session.getId() + ": " + message);
//    }
//    public static void main(String[] args) {
//    try {
//        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
//        Session session = container.connectToServer(WebSocketCliente.class, URI.create("ws://localhost:8080/websocket"));
//        // Mantén al cliente vivo (puedes implementar tu propia manera)
//        Thread.sleep(Long.MAX_VALUE);
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//  }
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Conectado al servidor");
        // Enviar los dos números al servidor para restar
        try {
            session.getBasicRemote().sendText("10,5"); // Envía dos números separados por coma
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Resultado del servidor: " + message);
    }

    public static void main(String[] args) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            Session session = container.connectToServer(WebSocketCliente.class, URI.create("ws://localhost:8080/websocket"));
            // Mantener al cliente vivo (puedes implementar tu propia lógica)
            Thread.sleep(Long.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}