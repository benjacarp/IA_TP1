package com.javainuse.main.rulesengine;

import com.javainuse.model.Emprendedor;
import com.javainuse.model.Pareja;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsEngine {


    public static int calculate(Pareja pareja) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-rule");

        kSession.insert(pareja);
        kSession.fireAllRules();

        return pareja.getAfinidad();
    }
}
