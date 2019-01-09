package FiizBuzz;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/fiizbuzz")
    public Engine engine(@RequestParam(value="inputNumber") String inputNumber) {

        //split the input string separator comma and put them in the string of array
        String[] parts = inputNumber.split(",");

        String str ="";
        //loop the string of array and determine if it is fiiz or booz or fiizbozz and concatinate it to outout srting
        for(int i = 0; i < parts.length ; i++){
           //
            int result = Integer.parseInt(parts[i]);

            if(result % 3 == 0 && result % 5 == 0) {
                str  = str + "FiizBuzz ";
            }else if(result % 5 == 0 ){
                str  = str + "Buzz ";
            }else if(result % 3 == 0){
                str  = str + "Fiiz ";
            }else
                str  = str + parts[i] + " ";
        }



        return new Engine(counter.incrementAndGet(),
                            inputNumber,
                            str
        );
    }
}