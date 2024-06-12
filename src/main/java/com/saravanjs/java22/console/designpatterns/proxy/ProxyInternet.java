package com.saravanjs.java22.console.designpatterns.proxy;

/**
 * @author Sarav on 20 Sep 2023
 * @project govtech
 * @package com.govtech.viswa.designpatterns.proxy
 * @class ProxyInternet
 */

import java.util.ArrayList;
import java.util.List;


public class ProxyInternet implements Internet
{
    private Internet internet = new RealInternet();
    private static List<String> bannedSites;

    static
    {
        bannedSites = new ArrayList<String>();
        bannedSites.add("abc.com");
        bannedSites.add("def.com");
        bannedSites.add("ijk.com");
        bannedSites.add("lnm.com");
    }

    @Override
    public void connectTo(String serverhost) throws Exception
    {
        if(bannedSites.contains(serverhost.toLowerCase()))
        {
            throw new Exception(serverhost + " : Access Denied");
        }

        internet.connectTo(serverhost);
    }

}

