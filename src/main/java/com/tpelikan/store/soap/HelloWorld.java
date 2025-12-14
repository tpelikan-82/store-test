package com.tpelikan.store.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

/**
 * Example of client request
 *
 * <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
 *    <soap:Body>
 *       <ns1:getHelloWorldAsString xmlns:ns1="http://ws.example.com/">
 *          <arg0>Alice</arg0>
 *       </ns1:getHelloWorldAsString>
 *    </soap:Body>
 * </soap:Envelope>
 *
 * Example of server response
 *
 * <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
 *    <soap:Body>
 *       <ns1:getHelloWorldAsStringResponse xmlns:ns1="http://ws.example.com/">
 *          <return>Hello World JAX-WS from Alice</return>
 *       </ns1:getHelloWorldAsStringResponse>
 *    </soap:Body>
 * </soap:Envelope>
 *
 *
 */


// Annotation to define the Java class/interface as a web service
@WebService
// Annotation to specify the message style, e.g., document or rpc
@SOAPBinding(style = Style.RPC)
public interface HelloWorld {

    // Annotation to expose a public method as a web service operation
    @WebMethod
    String getHelloWorldAsString(String name);
}