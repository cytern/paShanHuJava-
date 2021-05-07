package dam.server.demo.pojo;

import lombok.Data;

/**
 * @author : dam
 * @description :
 * @create :2021-04-23 10:16:00
 */
@Data
 public  class Executor {
    private String token;
    private String userName;
    private String executorUrl;
    private Boolean testModel;
}
