package org.aluismarte.test.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Aluis on 10/21/2021.
 */
@RestController
@RequestMapping("/wh")
public class WebHookController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> notifyWEvent() {
        // TODO get data from webhook
        return ResponseEntity.ok("OK");
    }
}
