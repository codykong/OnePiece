package com.xten.drools.dtables;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/12
 * Time: 下午2:13
 */
public class Test {

    public static void main(String[] args) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("ksession-rules");

        Message message = new Message();
        message.setMessage("Hello World");
        kieSession.insert(message);
        kieSession.fireAllRules();
    }
}


