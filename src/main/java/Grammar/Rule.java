package Grammar;

import java.util.List;

public class Rule {

    public List<String> generate;
    public String name;


    public Rule(List<String> generate, String name) {
        this.generate = generate;
        this.name = name;
    }

    public List<String> getGenerate() {
        return generate;
    }

    public void setGenerate(List<String> generate) {
        this.generate = generate;
    }
}
