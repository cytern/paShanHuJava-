package dam.jsoup.updatereport.updatreport.util;

import lombok.Data;

@Data
public  class BusyUtil {
    private static final Integer SO_EASY = 1;
    private static final Integer EASY = 2;
    private static final Integer MEDIUM = 3;
    private static final Integer BUSY = 4;
    private static final Integer SO_BUSY =5;
    private static final Integer GAP = 10;
    private static final Integer NO_WORK = 0;
    public  static Integer backStatus(Integer waitNum) {
          if (waitNum<GAP && 0<waitNum) {
              return SO_EASY;
          }else if (waitNum<GAP*10) {
              return EASY;
          }else if (waitNum<GAP*100) {
              return MEDIUM;
          }else if (waitNum<GAP*1000) {
              return BUSY;
          }else if (waitNum<GAP*10000) {
              return SO_BUSY;
          }else {
              return NO_WORK;
          }
    }
}
