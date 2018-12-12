package models;

import java.io.Serializable;

public abstract class Model implements Serializable {
    //Method: getInfo
    //functionality: returns a string with useful info on any class extending model
    //args: none
    //returns: String containing info
    //all classes extending model override this method
    public abstract String getInfo();
}


