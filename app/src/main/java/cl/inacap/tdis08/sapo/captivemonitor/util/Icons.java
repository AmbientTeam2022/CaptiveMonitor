package cl.inacap.tdis08.sapo.captivemonitor.util;

import cl.inacap.tdis08.sapo.captivemonitor.R;

public class Icons {

    private static final int[] ICON_LIST = {
            R.drawable.icon00,
            R.drawable.icon01,
            R.drawable.icon02,
            R.drawable.icon03,
            R.drawable.icon04,
            R.drawable.icon05,
            R.drawable.icon06,
            R.drawable.icon07,
            R.drawable.icon08
    };

    public static int getIcon(int id) {
        if (id < 0 || id >= ICON_LIST.length) {
            throw new IllegalArgumentException("Icon ID debe estar entre 0 y " + (ICON_LIST.length - 1));
        } else {
            return ICON_LIST[id];
        }
    }

}
