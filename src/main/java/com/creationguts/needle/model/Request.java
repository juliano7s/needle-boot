package com.creationguts.needle.model;

import java.util.Date;

/**
 * Class to represent an request made by a customer
 * Created by Juliano on 10/1/16.
 */
public class Request {

    private Customer customer;
    private Worker worker;
    private RequestStatus status;
    private Date addedDate;
    private Date scheduledDeliveryDate;
    private Date deliveryDate;
    private Date readyDate;
}
