package dam.jsoup.updatereport.updatreport.robot.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class QqRoleImg {
        /**
         *
         */
        private Integer id;

        /**
         * 角色名称/code
         */
        private String roleName;

        /**
         * 角色名称
         */
        private String roleNick;

        /**
         * 情绪状态
         */
        private Integer emotion;

        /**
         * 图片路径
         */
        private String picUrl;

        /**
         *
         */
        private Integer delFlag;

        /**
         * 单个头像大小
         */
        private Integer imgSize;

        /**
         * 多少个头像
         */
        private Integer imgNum;

        /**
         * 从左到右从上到下第几个
         */
        private Integer imgClass;

        /**
         * 是否解压
         */
        private Integer isDecode;

        /**
         * 解压之后的路径
         */
        private String decodeUrl;

        private static final long serialVersionUID = 1L;

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
            QqRoleImg other = (QqRoleImg) that;
            return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                    && (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
                    && (this.getRoleNick() == null ? other.getRoleNick() == null : this.getRoleNick().equals(other.getRoleNick()))
                    && (this.getEmotion() == null ? other.getEmotion() == null : this.getEmotion().equals(other.getEmotion()))
                    && (this.getPicUrl() == null ? other.getPicUrl() == null : this.getPicUrl().equals(other.getPicUrl()))
                    && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
                    && (this.getImgSize() == null ? other.getImgSize() == null : this.getImgSize().equals(other.getImgSize()))
                    && (this.getImgNum() == null ? other.getImgNum() == null : this.getImgNum().equals(other.getImgNum()))
                    && (this.getImgClass() == null ? other.getImgClass() == null : this.getImgClass().equals(other.getImgClass()))
                    && (this.getIsDecode() == null ? other.getIsDecode() == null : this.getIsDecode().equals(other.getIsDecode()))
                    && (this.getDecodeUrl() == null ? other.getDecodeUrl() == null : this.getDecodeUrl().equals(other.getDecodeUrl()));
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
            result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
            result = prime * result + ((getRoleNick() == null) ? 0 : getRoleNick().hashCode());
            result = prime * result + ((getEmotion() == null) ? 0 : getEmotion().hashCode());
            result = prime * result + ((getPicUrl() == null) ? 0 : getPicUrl().hashCode());
            result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
            result = prime * result + ((getImgSize() == null) ? 0 : getImgSize().hashCode());
            result = prime * result + ((getImgNum() == null) ? 0 : getImgNum().hashCode());
            result = prime * result + ((getImgClass() == null) ? 0 : getImgClass().hashCode());
            result = prime * result + ((getIsDecode() == null) ? 0 : getIsDecode().hashCode());
            result = prime * result + ((getDecodeUrl() == null) ? 0 : getDecodeUrl().hashCode());
            return result;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(" [");
            sb.append("Hash = ").append(hashCode());
            sb.append(", id=").append(id);
            sb.append(", roleName=").append(roleName);
            sb.append(", roleNick=").append(roleNick);
            sb.append(", emotion=").append(emotion);
            sb.append(", picUrl=").append(picUrl);
            sb.append(", delFlag=").append(delFlag);
            sb.append(", imgSize=").append(imgSize);
            sb.append(", imgNum=").append(imgNum);
            sb.append(", imgClass=").append(imgClass);
            sb.append(", isDecode=").append(isDecode);
            sb.append(", decodeUrl=").append(decodeUrl);
            sb.append(", serialVersionUID=").append(serialVersionUID);
            sb.append("]");
            return sb.toString();
        }

}
