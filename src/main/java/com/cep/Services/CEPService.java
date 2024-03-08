package com.cep.Services;

import com.cep.Models.DynamicClassGenerator;
import com.cep.Models.PatternRequest;
import com.cep.SimpleEvents.Event;
import com.cep.repository.EsperEngineRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CEPService {
    private EsperEngineRepository esperEngine;

    public CEPService(){
        this.esperEngine = new EsperEngineRepository();
    }

    public void createSchema(String schema){
       
    }

    public void addNewComplexEvent(PatternRequest pattern){
        String newComplexEvent = "@Name(\"" + pattern.patternName + "\") " +
                "insert into " + pattern.patternName + " " +
                pattern.patternContent;
        this.esperEngine.addNewPattern(newComplexEvent);
    }

    public void sendEvent(Event event){
        this.esperEngine.sendEvent(event);
    }

}
