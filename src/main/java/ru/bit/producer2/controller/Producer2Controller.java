package ru.bit.producer2.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("convert")
@Log4j2
public class Producer2Controller {
    @GetMapping("from/{firstCurrency}/to/{secondCurrency}")
    public Map<String, String> exchange(@PathVariable String firstCurrency, @PathVariable String secondCurrency,
                                        @RequestParam int value) {
        HashMap<String, String> result = new HashMap<>();
        double returningValue = value * 0.013;
        result.put(secondCurrency, returningValue + "");
        String instanceName = "Producer2";
        result.put("instanceId", instanceName);
        log.info(instanceName + " " + value + " " + firstCurrency + " = " + returningValue + " " + secondCurrency);
        return result;
    }
}
