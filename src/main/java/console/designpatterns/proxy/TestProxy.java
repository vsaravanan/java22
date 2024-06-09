package console.designpatterns.proxy;

/**
 * @author Sarav on 20 Sep 2023
 * @project govtech
 * @package com.govtech.viswa.designpatterns.proxy
 * @class TestProxy
 */
public class TestProxy {
    public static void main (String[] args)
    {
        Internet internet = new ProxyInternet();
        try
        {
            internet.connectTo("geeksforgeeks.org");
            internet.connectTo("abc.com");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
