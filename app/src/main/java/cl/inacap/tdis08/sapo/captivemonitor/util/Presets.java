package cl.inacap.tdis08.sapo.captivemonitor.util;

import java.util.HashMap;
import java.util.Map;

import cl.inacap.tdis08.sapo.captivemonitor.model.TankPreset;

public class Presets {

    public static enum Species {
        FISH, FROG, TURTLE, LIZARD, CUSTOM
    };

    public static Map<Species, TankPreset> presets;
    static {
        presets.put(Species.FISH,
                new TankPreset(new int[][]
                        {{0,0},{0,0},{0,0},{0,0},{70,95},{20,23}}
                        ));
        presets.put(Species.FROG,
                new TankPreset(new int[][]
                        {{0,0},{0,0},{60,90},{24,30},{0,0},{0,0}}
                ));
        presets.put(Species.TURTLE,
                new TankPreset(new int[][]
                        {{0,0},{29,32},{60,80},{24,29},{70,95},{22,25}}
                ));
        presets.put(Species.LIZARD,
                new TankPreset(new int[][]
                        {{10,40},{28,32},{30,40},{22,26},{0,0},{0,0}}
                ));
    }

}

//soilHumidity, soilTemperature, roomHumidity, roomTemperature, waterLevel, waterTemperature,