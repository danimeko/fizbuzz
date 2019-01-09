package FiizBuzz;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final String template = "Output, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/fiizbuzz")
    public Engine engine(@RequestParam(value="name", defaultValue="World") String name) {

        String[] parts = name.split(",");
        String str ="";
        for(int i = 0; i < parts.length ; i++){
            System.out.println(parts[i]);
            int result = Integer.parseInt(parts[i]);

            if(result % 3 == 0 ) {
                str  = str + "Fiiz ";
            }else if(result % 5 == 0 ){
                str  = str + "Buzz ";
            }else if(result % 15 == 0){
                str  = str + "FiizBuzz ";
            }else
                str  = str + parts[i] + " ";
        }



        return new Engine(counter.incrementAndGet(),
                String.format(template, str));
    }
}