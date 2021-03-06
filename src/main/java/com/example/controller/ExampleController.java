package com.example.controller;

import com.example.service.ExampleService;
import com.example.ExampleMessageResource;
import com.example.domain.ExampleRequest;
import com.example.domain.ExampleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExampleController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ExampleService exampleService;

    @Autowired
    private ExampleMessageResource exampleMessageResource;

    @RequestMapping("/")
    public String index() {
        return exampleMessageResource.getMessage("application.welcome");
    }

    @RequestMapping(value = "/exampleParam", method = RequestMethod.GET)
    public ExampleResponse exampleParam(@RequestParam(value="name", defaultValue="World") String name) {
        ExampleResponse response = null;
        try {
            response = exampleService.index(name);
        } catch (Exception e) {
            logger.error("Unable to process Example Request", e);
        }
        return response;
    }

    @RequestMapping(value = "/exampleGetRecord", method = RequestMethod.POST)
    public ExampleResponse exampleGetRecord(@RequestBody ExampleRequest request) {
        ExampleResponse response = null;
        try {
            response = exampleService.getRecord(request);
        } catch (Exception e) {
            logger.error("Unable to process Example Request", e);
        }
        return response;
    }
    
}
