package com.cep.repository;

import com.cep.SimpleEvents.Event;
import com.cep.Listeners.EventListener;
import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

public class EsperEngineRepository {
    public Configuration conf;
    public EPServiceProvider epServiceProvider;

    public EsperEngineRepository(){
        this.initEngine();
    }

    private void initEngine(){
        this.conf = new Configuration();
        this.epServiceProvider = EPServiceProviderManager.getDefaultProvider(conf);
        System.out.printf("\n******************************************************");
        System.out.printf("\nCEP Engine is ready for processing the incoming data!");
        System.out.printf("\n******************************************************");
    }

    public void createNewSchema(Class schema){
        this.epServiceProvider.getEPAdministrator().getConfiguration().addEventType(schema);
        System.out.printf("\n******************************************************");
        System.out.printf("\nNew pattern schema added to the engine!");
        System.out.printf("\n******************************************************");
    }

    public void addNewPattern(String pattern){
        EPStatement newPattern = this.epServiceProvider.getEPAdministrator().createEPL(pattern);
        newPattern.addListener(new EventListener());
        System.out.printf("\n******************************************************");
        System.out.printf("\nNew Complex Event Pattern added to the engine!");
        System.out.printf("\n******************************************************");
    }

    public void sendEvent(Event event){
        this.epServiceProvider.getEPRuntime().sendEvent(event);
    }
}
