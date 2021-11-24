package stepdefinitions;

import io.cucumber.java.ParameterType;
import model.Type;

public class ParameterTypes {

    @ParameterType("(SELL|BUY)")
    public Type type(String type) {
        return Type.fromString(type);
    }
}
