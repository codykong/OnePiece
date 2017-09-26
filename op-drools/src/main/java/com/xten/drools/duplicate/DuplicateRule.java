package com.xten.drools.duplicate;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/4/5
 * Time: 下午7:51
 */
public class DuplicateRule {

    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("session_duplicate_rule");
        DuplicateFact fact = new DuplicateFact(1,1);
        kieSession.insert(fact);
        kieSession.fireAllRules();
        System.out.println(fact);



    }
}
