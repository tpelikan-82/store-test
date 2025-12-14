package com.tpelikan.store.soap;

import jakarta.jws.WebService;

// The @WebService annotation is also placed on the implementation class
@WebService(endpointInterface = "com.example.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello World JAX-WS from " + name;
    }
}

/**
 *
 * Some publisher which show services to client
 *
 * package com.example.ws;
 *
 * import jakarta.xml.ws.Endpoint;
 *
 * public class HelloWorldPublisher {
 *
 *     public static void main(String[] args) {
 *         String url = "http://localhost:8080/ws/hello";
 *
 *         // Use the Endpoint class to publish the service implementation
 *         Endpoint.publish(url, new HelloWorldImpl());
 *
 *         System.out.println("Web Service published at: " + url + "?wsdl");
 *     }
 * }
 */