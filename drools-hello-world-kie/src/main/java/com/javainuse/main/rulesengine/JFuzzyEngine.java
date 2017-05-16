package com.javainuse.main.rulesengine;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Created by ASUS on 16/05/2017.
 */
public class JFuzzyEngine {


    public static double calculate(int experience, double patrimonio) {
        String fileName = "C:\\Users\\ASUS\\Downloads\\drools-hello-world-kie\\src\\main\\resources\\rules\\FuzzyRules.fcl";
        FIS fis = FIS.load(fileName,true);

        // Error while loading?
        if( fis == null ) {
            System.err.println("Can't load file: '" + fileName + "'");
            return 0;
        }

        // Set inputs, aqui habria q mandar el patrimonio y la experiencia
        fis.setVariable("experience", experience);
        fis.setVariable("patrimonio", patrimonio);

        // Evaluate
        fis.evaluate();

        return fis.getVariable("rating").getValue();
    }
}
