package com.ClientConnectivity.tradeSystem.services;

import com.example.consumingwebservice.wsdl.PostOrderRequest;
import com.example.consumingwebservice.wsdl.PostOrderResponse;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class OrderValidationClient extends WebServiceGatewaySupport {

    public PostOrderResponse validateOrder(String orderID){

        PostOrderRequest request = new PostOrderRequest();
        request.setID(orderID);

        PostOrderResponse response = (PostOrderResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8081/ws/productOrder", request ,
                        new SoapActionCallback("http://www.order.com/validate/postOrderRequest"));

        return response;

    }

}
