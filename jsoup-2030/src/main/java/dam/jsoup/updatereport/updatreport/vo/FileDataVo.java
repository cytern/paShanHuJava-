package dam.jsoup.updatereport.updatreport.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDataVo {
  private List<Map<String,String>> result ;
  private   String dir;
  private   String fileName;

}
