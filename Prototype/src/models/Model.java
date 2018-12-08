package models;

import java.io.Serializable;

public abstract class Model implements Serializable {
    public abstract String getInfo();
}


/*
YYYY      YYYY  EEEEEEEEEEEEEEEEEE  EEEEEEEEEEEEEEEEEE
 YYYY    YYYY   EEEEEEEEEEEEEEEEEE  EEEEEEEEEEEEEEEEEE
  YYYY  YYYY    EEEE                EEEE
   YYYYYYYY     EEEE                EEEE
    YYYYYY      EEEEEEEEE           EEEEEEEEE
     YYYY       EEEEEEEEE           EEEEEEEEE
     YYYY       EEEE                EEEE
     YYYY       EEEE                EEEE
     YYYY       EEEEEEEEEEEEEEEEEE  EEEEEEEEEEEEEEEEEE
     YYYY       EEEEEEEEEEEEEEEEEE  EEEEEEEEEEEEEEEEEE
 */