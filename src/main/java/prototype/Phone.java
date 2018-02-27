package prototype;

import java.io.Serializable;

public class Phone implements Serializable {

    private String type;

    private String number;

    public Phone(String type, String number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

}
