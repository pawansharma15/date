package com.futurice.date;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class Controller {
    @Autowired
    Service service;

    @GetMapping(path="/difference", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JSONObject> getDifference(@RequestParam(name = "date1", required=true)
                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                    LocalDate dateOne,
                                                    @RequestParam(name = "date2", required=true)
                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                    LocalDate dateTwo) {
            Integer difference = service.getDifference(dateOne, dateTwo);
            return ResponseEntity.ok().body(new View().createSuccessResponse(difference));
    }
}
