/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.AfterClass;

public abstract class JettyTest {

    private static Server server;

    protected static void startJetty(String... profiles) throws Exception {
        server = new Server(8080);
        WebAppContext webAppContext = new WebAppContext("src/main/webapp", "/");
        String profilesAsString = profilesAsString(profiles);
        if (!profilesAsString.isEmpty()) {
            webAppContext.setInitParameter("spring.profiles.active", profilesAsString);
        }
        server.setHandler(webAppContext);
        server.start();
    }

    @AfterClass
    public static void stopJetty() throws Exception {
        server.stop();
    }

    private static String profilesAsString(String[] profiles) {
        StringBuilder profilesAsString = new StringBuilder();
        for (String profile : profiles) {
            if (profilesAsString.length() > 0) {
                profilesAsString.append(',');
            }
            profilesAsString.append(profile);
        }
        return profilesAsString.toString();
    }

}