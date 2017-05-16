package com.javainuse.test;

import com.javainuse.model.Emprendedor;
import com.javainuse.model.Pareja;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsTest {

	public static final void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rule");

            Pareja p = new Pareja();
			Emprendedor a = new Emprendedor();
			a.setEmprendedor(true);
			a.setInversionista(false);

			Emprendedor b = new Emprendedor();
			b.setEmprendedor(false);
			b.setInversionista(true);

			p.setEmpA(a);
			p.setEmpB(b);

            kSession.insert(p);
			kSession.fireAllRules();

			System.out.println("afinidad a-b: " + p.getAfinidad());

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
