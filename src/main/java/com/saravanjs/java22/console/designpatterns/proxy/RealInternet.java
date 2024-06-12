package com.saravanjs.java22.console.designpatterns.proxy;

/**
 * @author Sarav on 20 Sep 2023
 * @project govtech
 * @package com.govtech.viswa.designpatterns.proxy
 * @class RealInternet
 */
public class RealInternet implements Internet
{
    @Override
    public void connectTo(String serverhost)
    {
        System.out.println("Connecting to "+ serverhost);
    }
}