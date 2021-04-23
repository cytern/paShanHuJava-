package dam.server.demo.pojo;

import lombok.Data;

/**
 * @author : dam
 * @description :
 * @create :2021-04-23 09:59:00
 */

public class JsoupSetting {
    public Executor getExecutor() {
        return executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    private Executor executor;
    private Pool pool;
}

