package dam.jsoup.updatereport.updatreport.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodDetailVo {
  private Integer  id;
   private String name;
   private String  des;
   private String time;
   private BigDecimal price;
   private String rate;
   private String[] tips;
   private String userName;
   private String isAuto;
   private String url;
   private String saleNum;
   private Integer type;    //是脚本 1还是数据 2
   private Integer  userId;
}


