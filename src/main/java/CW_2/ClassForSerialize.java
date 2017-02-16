package CW_2;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
