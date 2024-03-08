package com.cep.Listeners;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.StatementAwareUpdateListener;

public class EventListener implements StatementAwareUpdateListener {

    @Override
    public void update(EventBean[] newComplexEvents, EventBean[] oldComplexEvents, EPStatement detectedPattern, EPServiceProvider epService) {
        if (newComplexEvents != null){
            EventBean lastEvent = newComplexEvents[0];
            System.out.println("\n*********************************************************************************************************************************************************");
            System.out.println("[ALERT]: a new " + detectedPattern.getName() + " pattern detected in " + lastEvent.get("station") + " with a " + lastEvent.get("averagePM10") + " level");
            System.out.println("********************************************************************************************************************************************************");
        }
    }
}
