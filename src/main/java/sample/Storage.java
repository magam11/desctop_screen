package sample;

import java.util.prefs.Preferences;

public class Storage {

    static final String Is_First_run="Is_First_run";

    Preferences preferences = Preferences.userRoot().node("screen_window");
    private static Storage storage;
    private Storage(){
        preferences.remove(Is_First_run);
//        preferences.putBoolean(Is_First_run,false);
    }
    public static Storage getInstance(){
        if(storage==null){
            storage = new Storage();
        }
        return storage;
    }

    public boolean Is_First_run(){
        return preferences.getBoolean(Is_First_run,false);
    }

    public void setIs_First_run_False(){
        preferences.putBoolean(Is_First_run,false);
    }



}
