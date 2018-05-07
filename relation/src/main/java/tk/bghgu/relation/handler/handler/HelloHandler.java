package tk.bghgu.relation.handler.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import tk.bghgu.relation.model.model.Greeting;
import tk.bghgu.relation.model.model.HelloMessage;

/**
 * Created by ds on 2018-04-06.
 */

@Controller
public class HelloHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /*@MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greetig(HelloMessage messages) throws Exception {
        logger.info(messages.getName());
        Thread.sleep(1000);
        return new Greeting("Hello, " + messages.getName() + "!");
    }*/
}
