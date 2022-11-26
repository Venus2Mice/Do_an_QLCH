package Framework;

@FunctionalInterface
public interface ControllerAction<Parameter> {
    void action(Parameter t);
}
