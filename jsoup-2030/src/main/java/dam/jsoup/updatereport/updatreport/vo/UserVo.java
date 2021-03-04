package dam.jsoup.updatereport.updatreport.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import dam.jsoup.updatereport.updatreport.pojo.JsoupUser;
import dam.jsoup.updatereport.updatreport.pojo.JsoupUserAssets;
import dam.jsoup.updatereport.updatreport.pojo.JsoupUserDetail;
import dam.jsoup.updatereport.updatreport.pojo.JsoupUserOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserVo {
    /**
     * 用户实体类
     */
    @JsonProperty
    private JsoupUser jsoupUser;
    /**
     * 用户详细信息实体类
     */
    private JsoupUserDetail jsoupUserDetail;
    /**
     * 用户资产信息实体类
     */
    private JsoupUserAssets jsoupUserAssets;
    /**
     * 用户相关order 实体类
     */
    private List<JsoupUserOrder> jsoupUserOrderList;
    /**
     * 根据order 获得的信息
     */
    private List<MissionAllData> missionAllDataList;
}
