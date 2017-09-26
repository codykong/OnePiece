package com.xten.drools.memberof;

import com.xten.drools.duplicate.DuplicateFact;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/8/9
 * Time: 上午10:49
 */
public class MemberOfRule {

    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("MemberOfKS");

        DuplicateFact fact = new DuplicateFact(1,1);
        kieSession.insert(fact);
        kieSession.fireAllRules();
        System.out.println(fact);



    }

}
