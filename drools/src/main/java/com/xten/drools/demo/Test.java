package com.xten.drools.demo;


import org.kie.api.io.ResourceType;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderErrors;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: cody
 * Date: 2016/11/12
 * Time: 下午10:52
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static void main(String[] args) {

        KnowledgeBuilder  kBuilder =
                KnowledgeBuilderFactory.newKnowledgeBuilder();
        kBuilder.add(ResourceFactory.newClassPathResource("test.drl",Test.class), ResourceType.DRL);

        if (kBuilder.hasErrors()){
            System.out.println("规则中存在错误,错误信息如下:");
            KnowledgeBuilderErrors knowledgeBuilderErrors =kBuilder.getErrors();
            for (Iterator iterator = knowledgeBuilderErrors.iterator();iterator.hasNext();){
                System.out.println(iterator.next());
            }
        }

        Collection<KnowledgePackage> kPackage = kBuilder.getKnowledgePackages();
    }
}
