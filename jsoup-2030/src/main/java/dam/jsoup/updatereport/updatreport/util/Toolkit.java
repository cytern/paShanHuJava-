package dam.jsoup.updatereport.updatreport.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author lcd
 * @create 2018-08-22
 * @desc 通用工具类
 */
public class Toolkit {
    public static final String DEFAULT_VALUE_STR = "0";
    public static final double DEFAULT_VALUE = 0.00;

    public static boolean isValid(String s) {
        return s != null && !s.trim().isEmpty();
    }

    public static boolean isInvalid(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static boolean isValid(Object o) {
        if (o instanceof String) {
            return isValid((String) o);
        }
        return false;
    }

    public static boolean isInvalid(Object o) {
        if (o instanceof String) {
            return isInvalid((String) o);
        }
        return true;
    }

    public static boolean isNumber(String s) {
        if (!isValid(s)) {
            return false;
        } else {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
    }

    public static boolean isDoubleNumber(String s) {
        if (!isValid(s)) {
            return false;
        } else {
            try {
                Double.parseDouble(s);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
    }

    public static boolean isDoubleNumber(Object s) {
        if (!isValid(s)) {
            return false;
        } else {
            try {
                Double.parseDouble((String) s);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
    }

    public static void sleep(int seconds) {
        for (int i = 0; i < seconds; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }

    public static void threadSleep(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (Exception e) {
        }
    }

    public static boolean isJson(String s) {
        try {
            Object json = JSON.parse(s);
            if (json instanceof JSONObject) {
                return true;
            } else if (json instanceof JSONArray) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean isJson(Object o) {
        if (isInvalid(o)) return false;
        try {
            Object json = JSON.parse((String) o);
            if (json instanceof JSONObject) {
                return true;
            } else if (json instanceof JSONArray) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static String[] stringToArr(String s) {
        return Toolkit.isValid(s) ? s.replaceAll("\"", "").replace("[", "")
                .replace("]", "").split(",") : new String[]{};
    }

    public static int[] changeIntArr(String[] arr) {
        try {
            int[] result = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                result[i] = Integer.parseInt(arr[i]);
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isNull(Object... objects) {
        if (objects == null) {
            return true;
        }
        for (Object o1 : objects) {
            if (Objects.isNull(o1)) {
                return true;
            }
            if (o1 instanceof String) {
                return isInvalid((String) o1);
            }
        }
        return false;
    }

    public static void close(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException ioex) {
                // ignore.
            }
        }
    }

    public static boolean isWindows() {
        return System.getProperties().getProperty("os.name").toUpperCase().contains("WINDOWS");
    }

    public static boolean noNull(Object... objects) {
        return !isNull(objects);
    }

    /**
     * 使用空格拼接字符串
     *
     * @param sArr
     * @return
     */
    public static String spliceStringBySpace(String... sArr) {
        StringBuffer sb = new StringBuffer();
        for (String s : sArr) {
            sb.append(s).append(" ");
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : sb.toString();
    }

    public static boolean isNotEmptyList(List list) {
        return list != null && list.size() > 0;
    }

    public static boolean isNotEmptyCollection(Collection data) {
        return data != null && !data.isEmpty();
    }

    public static boolean isEmptyList(List list) {
        return !isNotEmptyList(list);
    }

    /**
     * 数组通过指定的分隔符拼接在一块
     *
     * @param src
     * @param separator
     * @return
     */
    public static String arrayTransformBySeparator(List src, String separator) {
        if (src.isEmpty()) return "";
        StringBuffer result = new StringBuffer();
        src.forEach(t -> result.append(t).append(separator));
        return result.deleteCharAt(result.lastIndexOf(separator)).toString();
    }

    /**
     * 格式化数字，
     *
     * @param str   原字符
     * @param scale 小数点后几位
     * @return
     */
    public static String formatNumber(String str, int scale) {
        BigDecimal bigDecimal;
        if (Toolkit.isInvalid(str)) {
            str = DEFAULT_VALUE_STR;
        }

        try {
            bigDecimal = new BigDecimal(str);
        } catch (NumberFormatException e) {
            bigDecimal = new BigDecimal(DEFAULT_VALUE_STR);
        }
        return bigDecimal.setScale(scale, BigDecimal.ROUND_HALF_UP).toPlainString();
    }

    /**
     * 格式化数字，
     * 只保留小数点后两位
     *
     * @param str 原字符
     * @return
     */
    public static String formatNumber(String str) {
        BigDecimal bigDecimal;
        if (Toolkit.isInvalid(str)) {
            str = DEFAULT_VALUE_STR;
        }

        try {
            bigDecimal = new BigDecimal(str);
        } catch (NumberFormatException e) {
            bigDecimal = new BigDecimal(DEFAULT_VALUE_STR);
        }
        final String s = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
        if ("00".equals(s.substring(s.lastIndexOf(".") + 1))) {
            return s.substring(0, s.lastIndexOf("."));
        }
        if ("0".equals(s.substring(s.lastIndexOf(".") + 2))) {
            return s.substring(0, s.lastIndexOf(".") + 2);
        }
        return s;
    }

    /**
     * 格式化数字，
     *
     * @param str   原字符
     * @param scale 小数点后几位
     * @return
     */
    public static String formatNumber(Double str, int scale) {
        return formatNumber(str.toString(), scale);
    }

    public static String toString(Object o) {
        if (Objects.isNull(o)) {
            return "";
        }
        return String.valueOf(o);
    }

}
