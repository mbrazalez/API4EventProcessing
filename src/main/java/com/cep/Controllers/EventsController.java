package com.cep.Controllers;

import com.espertech.esper.client.util.JSONEventRenderer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cep.Models.PatternRequest;
import com.cep.Services.CEPService;
import com.cep.SimpleEvents.PM10Event;
import com.cep.Models.DynamicClassGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class EventsController {
    private CEPService cepService;

    @Autowired
    public EventsController(CEPService cepService){
        this.cepService = cepService;
    }

   /* @PostMapping("/pm10_crear")
    public void createPM10schema(@RequestBody Object object){
        this.cepService.createSchema(object);
    }*/

    @PostMapping("/create_schema")
    public void createSchema(@RequestBody String newSchema){
        this.cepService.createSchema(newSchema);
    }

    @PostMapping("/add_pattern")
    public void sendEvent(@RequestBody PatternRequest pattern){
        this.cepService.addNewComplexEvent(pattern);
    }

    @PostMapping("/send_pm10event")
    public void sendEvent(@RequestBody PM10Event pm10Event){
        this.cepService.sendEvent(pm10Event);
    }

}
