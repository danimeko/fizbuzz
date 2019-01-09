package FiizBuzz;

public class Engine {

    private final long id;
    private final String output;
    private final String input;

    public Engine(long id,String input,String output) {
        this.id = id;
        this.input = input;
        this.output = output;

    }

    public long getId() {
        return id;
    }

    public String getOutput() {
        return output;
    }

    public String getInput() {
        return input;
    }
}