package CW_1;

import java.io.Serializable;

/**
 *
 * @author Vitaliy
 */
public class ClassForSerialize implements Serializable {

    public byte field = 10;
    public String str = "Some string";

    @Override
    public String toString() {
        return "ClassForSerialize{" + "field=" + field + ", str=" + str + '}';
    }

}
