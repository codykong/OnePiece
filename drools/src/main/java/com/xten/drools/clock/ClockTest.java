package com.xten.drools.clock;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/12
 * Time: 上午11:40
 */
public class ClockTest {

    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession kSession = kieContainer.newKieSession("session-clock");

        kSession.insert(new Clock());
        kSession.fireAllRules();
        kSession.dispose();
    }
}
