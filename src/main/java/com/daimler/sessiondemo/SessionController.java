package com.daimler.sessiondemo;

import com.session.springbootstarterdemo.SessionDemoService;
import com.session.springbootstarterdemo.SessionInterface;
import com.session.springbootstarterdemo.SessionInterfaceImpl1;
import com.session.springbootstarterdemo.SessionInterfaceImpl2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SessionController {

    @Autowired
    private SessionDemoService demoService;

    @Autowired
    private SessionInterface sessionInterface;

    @GetMapping("log-test")
    public String logTest() {
        log.info("this is the log info level");
        log.debug("this is the log debug level");
        return "logging testing";
    }

    @GetMapping("staterDemo")
    public String staterDemo() {
        return demoService.getComments();
    }

    @GetMapping("sessionInterface")
    public String sessionInterface() {

        if (sessionInterface instanceof SessionInterfaceImpl1) {
            return "current sessionInterface is implemented by  SessionInterfaceImpl1";
        }

        if (sessionInterface instanceof SessionInterfaceImpl2) {
            return "current sessionInterface is implemented by  SessionInterfaceImpl2";
        }
        return null;
    }

}
