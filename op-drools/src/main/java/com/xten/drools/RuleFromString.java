package com.xten.drools;

import com.xten.drools.fact.BaseFact;
import org.drools.core.marshalling.impl.ProtobufMessages;
import org.drools.core.util.Drools;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/4/11
 * Time: 下午3:32
 */
public class RuleFromString {


    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieFileSystem kfs = ks.newKieFileSystem();
        // 生成新的kieModule ,存放生成的kieSession
        ReleaseId releaseId = ks.newReleaseId("com.xten", "drools", Drools.getFullVersion());
        kfs.generateAndWritePomXML(releaseId);
        KieModuleModel kieModule = ks.newKieModuleModel();

        // 如果存在多个规则，releaseId和SessionModel 必须不一致，否则会相互覆盖
        kieModule.newKieBaseModel("baseModule")
                .newKieSessionModel("session-module");

        kfs.writeKModuleXML(kieModule.toXML());
        String path = "src/main/resources/rules/template.drl";
        kfs.write(path, rule());

        KieBuilder kb = ks.newKieBuilder(kfs);
        // kieModule is automatically deployed to KieRepository if successfully built.
        kb.buildAll();

        // 检查传入的规则是否存在错误
        if (kb.getResults().hasMessages(Message.Level.ERROR)){
            throw new RuntimeException("Build Errors:\n" + kb.getResults().toString());
        }

//        KieContainer kContainer = ks.newKieClasspathContainer(UUID.randomUUID().toString());
        KieContainer kContainer = ks.newKieContainer(releaseId);
        // 对于stateful kieSession 使用完成后必须释放资源，否则会产生内存泄露
        KieSession kieSession =kContainer.newKieSession("session-module");

        BaseFact fact = new BaseFact();
        fact.setStatus(1);
        fact.addValue("text","abcd");
        fact.setText("abcd");


        FactHandle factHandle = kieSession.insert(fact);
        kieSession.fireAllRules();

        System.out.println(fact.isRes());
//        fact.setStatus(2);
//        fact.setRes(false);
//        fact.setText("abf");
//        // 如果规则相同需要重复利用kieSession ,则可以使用更新之前的factHandle即可
//        // 当需要生成新的factHandle时，则必须调用 kieSession.delete(factHandle);
//        // 删除之前的handler，否则之前的handler会持续生效，并占据内存，导致内存泄露
//        kieSession.update(factHandle,fact);
//        kieSession.fireAllRules();
//        System.out.println(fact.isRes());

        // 如果需要重新生成kieSession ，则需要调用kieSession.dispose()，否则会产生内存泄露
        kieSession.dispose();
    }

    private static String rule(){
        String s ="package com.xten.drools.fact\n" +
                "\n" +
                "rule \"run\"\n" +
                "    when\n" +
                "        c: BaseFact(c.getValue(\"+text+\") matches \".*(abc|abd|abe)+.*\")\n" +
                "    then\n" +
                "        c.setRes(true);\n" +
                "end\n";
        return s;
    }
}
