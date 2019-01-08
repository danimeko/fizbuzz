package FiizBuzz;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/fiizbuzz")
    public Engine engine(@RequestParam(value="name", defaultValue="World") String name) {
        return new Engine(counter.incrementAndGet(),
                String.format(template, name));
    }
}