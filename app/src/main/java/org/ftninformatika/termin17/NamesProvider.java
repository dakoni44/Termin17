package org.ftninformatika.termin17;

import java.util.ArrayList;
import java.util.List;

public class NamesProvider {

    private static List<String> names;

    public static List<String> getName(){
        if(names==null){
            names=new ArrayList<>();
            names.add("Pera");
            names.add("Mika");
            names.add("Djoka");
        }
        return names;
    }

}
