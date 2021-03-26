package com.ClientConnectivity.tradeSystem.utils;

import com.example.consumingwebservice.wsdl.PostOrderRequest;
import com.example.consumingwebservice.wsdl.PostOrderResponse;
import com.example.consumingwebservice.wsdl.ProductOrder;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;



public class OrderValidationClient extends WebServiceGatewaySupport {

    public PostOrderResponse validateOrder(ProductOrder productOrder){

        PostOrderRequest request = new PostOrderRequest();
        request.setPrice(productOrder.getPrice());
        request.setFunds(productOrder.getFunds());
        request.setQuantityOwned(productOrder.getQuantityOwned());
        request.setQuantity(productOrder.getQuantity());
        request.setSide(productOrder.getSide());
        request.setProductName(productOrder.getProductName());


        return (PostOrderResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://order-val.herokuapp.com/ws/productOrder", request ,
                        new SoapActionCallback("http://www.order.com/validate/postOrderRequest"));

    }

}
