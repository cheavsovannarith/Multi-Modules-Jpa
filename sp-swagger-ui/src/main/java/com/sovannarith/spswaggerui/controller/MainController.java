package com.sovannarith.spswaggerui.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@Api(tags = "Application Status")
@RestController
@RequestMapping("/v1/api")
public class MainController {

    @ApiOperation(value = "Get Massage :) ", hidden = false,tags = "", nickname = "nickname for this method!", notes = "notes for this method!")
    @GetMapping("")
    public Map<String, Object> greeting(){
        return Collections.singletonMap("Message","I Love You :)");
    }

}
