package dam.jsoup.updatereport.updatreport.robot.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName qq_auto_reply
 */
public class QqAutoReply implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 目标的id
     */
    private String targetKey;

    /**
     * 询问关键词
     */
    private String askKey;

    /**
     * 询问类型 1 包含关键词 2等于关键词
     */
    private Integer askType;

    /**
     * 回复关键词
     */
    private String replyKey;

    /**
     * 回复类型 
1文件语音回复
 2 文件图片回复
 3 机器人语音回复 
4 机器人文字图片回复
0 文字回复
     */
    private Integer replyType;

    /**
     * 创建人
     */
    private String ctreateBy;

    /**
     * 目标类型
0 所有人所有群组
1 指定群组
2 指定人
     */
    private Integer targetType;

    /**
     * 
     */
    private Integer delFlag;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTargetKey() {
        return targetKey;
    }

    public void setTargetKey(String targetKey) {
        this.targetKey = targetKey;
    }

    public String getAskKey() {
        return askKey;
    }

    public void setAskKey(String askKey) {
        this.askKey = askKey;
    }

    public Integer getAskType() {
        return askType;
    }

    public void setAskType(Integer askType) {
        this.askType = askType;
    }

    public String getReplyKey() {
        return replyKey;
    }

    public void setReplyKey(String replyKey) {
        this.replyKey = replyKey;
    }

    public Integer getReplyType() {
        return replyType;
    }

    public void setReplyType(Integer replyType) {
        this.replyType = replyType;
    }

    public String getCtreateBy() {
        return ctreateBy;
    }

    public void setCtreateBy(String ctreateBy) {
        this.ctreateBy = ctreateBy;
    }

    public Integer getTargetType() {
        return targetType;
    }

    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        QqAutoReply other = (QqAutoReply) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTargetKey() == null ? other.getTargetKey() == null : this.getTargetKey().equals(other.getTargetKey()))
            && (this.getAskKey() == null ? other.getAskKey() == null : this.getAskKey().equals(other.getAskKey()))
            && (this.getAskType() == null ? other.getAskType() == null : this.getAskType().equals(other.getAskType()))
            && (this.getReplyKey() == null ? other.getReplyKey() == null : this.getReplyKey().equals(other.getReplyKey()))
            && (this.getReplyType() == null ? other.getReplyType() == null : this.getReplyType().equals(other.getReplyType()))
            && (this.getCtreateBy() == null ? other.getCtreateBy() == null : this.getCtreateBy().equals(other.getCtreateBy()))
            && (this.getTargetType() == null ? other.getTargetType() == null : this.getTargetType().equals(other.getTargetType()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTargetKey() == null) ? 0 : getTargetKey().hashCode());
        result = prime * result + ((getAskKey() == null) ? 0 : getAskKey().hashCode());
        result = prime * result + ((getAskType() == null) ? 0 : getAskType().hashCode());
        result = prime * result + ((getReplyKey() == null) ? 0 : getReplyKey().hashCode());
        result = prime * result + ((getReplyType() == null) ? 0 : getReplyType().hashCode());
        result = prime * result + ((getCtreateBy() == null) ? 0 : getCtreateBy().hashCode());
        result = prime * result + ((getTargetType() == null) ? 0 : getTargetType().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", targetKey=").append(targetKey);
        sb.append(", askKey=").append(askKey);
        sb.append(", askType=").append(askType);
        sb.append(", replyKey=").append(replyKey);
        sb.append(", replyType=").append(replyType);
        sb.append(", ctreateBy=").append(ctreateBy);
        sb.append(", targetType=").append(targetType);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}