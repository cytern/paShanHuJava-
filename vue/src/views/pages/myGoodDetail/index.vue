<template>
  <d2-container>
    <template slot="header">
      <el-button type="text" disabled>商品详情</el-button>
    </template>
      <el-card >
        <el-row :gutter="20">
          <!-- 这一格为图标 -->
          <el-col :span="7">
            <i class="el-icon-s-ticket"></i>
          </el-col>
          <el-col :span="17">
            <!-- 第一行是标题  用两块的第一块表示名称-->
            <el-row :getter="60" style="margin-bottom: 26px">
              <el-col :span="12">
                <span style="font-size: 16px; font-weight: 600">{{
                  tempGoodDetail.name
                }}</span>
              </el-col>
              <el-col :span="12"></el-col>
            </el-row>
            <!-- 第二行是第一对字段 -->
            <el-row :getter="60" style="margin-bottom: 16px">
              <el-col :span="12">
                <span>类别:&nbsp;&nbsp;</span
                ><span class="idlike" style="color: rgba(34, 28, 28, 0.555)">{{
                  tempGoodDetail.type == 1 ? "脚本" : "数据"
                }}</span>
              </el-col>
              <el-col :span="12">
                <span>类型:&nbsp;&nbsp;</span
                ><span style="color: rgba(34, 28, 28, 0.555)">{{
                  tempGoodDetail.isAuto == "1" ? "官方" : "自制"
                }}</span>
              </el-col>
            </el-row>
            <!-- 下一个字段 -->
            <el-row :getter="60" style="margin-bottom: 16px">
              <el-col :span="12">
                <span>评分:&nbsp;&nbsp;</span
                ><el-rate
                  :value="tempGoodDetail.rate == null ? 0 : item.saleRate"
                  disabled
                  text-color="#ff9900"
                  style="display: inline-block"
                >
                </el-rate>
              </el-col>
              <el-col :span="12">
                <span>创建者:&nbsp;&nbsp;</span
                ><span style="color: rgba(34, 28, 28, 0.555)">{{
                  tempGoodDetail.userName
                }}</span>
              </el-col>
            </el-row>
            <!-- 下一个字段 -->
            <el-row :getter="60" style="margin-bottom: 16px">
              <el-col :span="12">
                <span>销量:&nbsp;&nbsp;</span
                ><span style="color: rgba(34, 28, 28, 0.555)">{{
                  tempGoodDetail.saleNum
                }}</span>
              </el-col>
              <el-col :span="12">
                <span>上架时间:&nbsp;&nbsp;</span
                ><span style="color: rgba(34, 28, 28, 0.555)">{{
                  tempGoodDetail.time
                }}</span>
              </el-col>
            </el-row>
            <!-- 下一段 -->
            <el-row :getter="60" style="margin-bottom: 16px">
              <el-col :span="24">
                <span>标签:&nbsp;&nbsp;</span
                ><span style="color: rgba(34, 28, 28, 0.555)"
                  ><el-tag v-for="(tp, adex) in tempGoodDetail.tips" :key="adex">{{
                    tp
                  }}</el-tag></span
                >
              </el-col>
            </el-row>
            <el-row :getter="60" style="margin-bottom: 16px">
              <el-col :span="24">
                <el-button
                  v-if="tempGoodDetail.userId == 0"
                  type="success"
                  style="width: 50%"
                  @click="sendBuy(tempGoodDetail)"
                  >购买 ( {{ tempGoodDetail.salePrice }}代币 )</el-button
                >
                <el-button
                  style="width: 50%"
                  v-else-if="tempGoodDetail.userId == 2"
                  disabled
                  type="warning"
                  >已在库中</el-button
                >
                <el-button
                  style="width: 50%"
                  v-else-if="tempGoodDetail.userId == 1"
                  disabled
                  type="warning"
                  >我提供的</el-button
                >
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <!-- 一个模块应该由这个组成 一个按钮表示内容 一个分割线 下方为 描述性内容 -->

        <!-- 功能详细 -->
        <el-divider><i class="el-icon-loading"></i></el-divider>
        <el-row style="margin-bottom: 10px">
          <el-col :span="4"
            ><el-button style="width: 100%" type="primary"
              >功能详细</el-button
            ></el-col
          >
        </el-row>
        <!-- 这一行为描述性内容 -->
        <el-row>
          <el-col
            ><p class="color: rgba(34, 28, 28, 0.555)">&nbsp;&nbsp;{{ tempGoodDetail.des }}</p></el-col
          >
        </el-row>

 <!-- 作者信息 -->
        <el-divider><i class="el-icon-loading"></i></el-divider>
        <el-row style="margin-bottom: 10px">
          <el-col :span="4"
            ><el-button style="width: 100%" type="primary"
              >作者信息</el-button
            ></el-col
          >
        </el-row>
        <!-- 这一行为描述性内容 -->
        <el-row>
          <el-col
            ><p class="color: rgba(34, 28, 28, 0.555)">&nbsp;&nbsp;{{ tempGoodDetail.des }}</p></el-col
          >
        </el-row>
       
      </el-card>
      <el-card>
        <span>详细</span>
      </el-card>
  
  </d2-container>
</template>

<script>
import { buyMh, buyMa } from "../../netWork/apiMethod";
import { goodDetail } from "../../model/detailPojo";
import { newMission, newMissionAll } from "../../model/missionAllPojo";
export default {
  name: "myGoodDetail",
  components: {},
  data() {
    return {
      tempGoodDetail: new goodDetail(),
      screenHeight: document.body.clientHeight
    };
  },
  watch:{
screenHeight (val) {
this.screenHeight = val
document.getElementById('layout').style.height=this.screenHeight-60+"px";//检测窗口的大小，并赋值
}
},
  mounted() {
    document.getElementById('layout').style.height=this.screenHeight+"px";//页面初始化
window.onresize = () => {
return (() => {
this.screenHeight = document.body.clientHeight
})()
}
  },
  methods: {
    sendBuy(detail) {
      this.$confirm("是否购买?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        // 脚本
        if (detail.type == 1) {
          buyMa(detail.id).then((res) => {
            if (res.code == "success") {
              this.$message({
                type: "success",
                message: res.msg,
              });
            }
          });
        } else {
          buyMh(detail.id).then((res) => {
            if (res.code == "success") {
              this.$message({
                type: "success",
                message: res.msg,
              });
            }
          });
        }
      });
    },
  },
};
</script>

<style>
.missionTag {
  margin-bottom: 10px;
}
.actionTag {
  margin-bottom: 4px;
}
.divCard {
  margin-top: 10px;
  background-color: rgba(150, 255, 28, 0.26);
}
.conf {
  border: 5px solid;
  border-radius: 10%;
  border-image: linear-gradient(to right, #ff831c, #0ceebb) 20 20;
  background: rgba(255, 255, 255, 0.3)
    url("../../../../public/userFor/listBack.png");
}
.touxiang {
  height: 200px;
  width: 200px;
  border-radius: 50%;
  background: linear-gradient(to right, #ff478e, #2fff2e);
}
.confs {
  border: 5px solid;
  border-radius: 10%;
  border-image: linear-gradient(to left, #ff831c, #0ceebb) 20 20;
  background: rgba(255, 255, 255, 0.3)
    url("../../../../public/userFor/listBack.png");
}
.leidatu {
  border: 5px solid;
  border-radius: 10%;
  border-image: linear-gradient(to left, #ff831c, #0ceebb) 20 20;
  background: rgba(255, 255, 255, 0.3)
    url("../../../../public/userFor/leidabeijing1.png");
}
.xuexiaobeijing {
  border: 5px solid;
  border-radius: 10%;
  border-image: linear-gradient(to left, #ff831c, #0ceebb) 20 20;
  background: rgba(255, 255, 255, 0.3)
    url("../../../../public/userFor/xuexiaobeijing.png");
}
.conf-key {
  /*width: 300px;*/
  /*height: 200px;*/
  background-image: -webkit-linear-gradient(
    left,
    #1c006f,
    #d5df13 10%,
    #bb6a03 20%,
    #37001e 30%,
    #1b001d 40%,
    #1a000a 50%,
    #191a00 60%,
    #051600 70%,
    #1b001d 80%,
    #1a000a 90%,
    #191a00 100%
  );
  -webkit-text-fill-color: transparent; /* 将字体设置成透明色 */
  -webkit-background-clip: text; /* 裁剪背景图，使文字作为裁剪区域向外裁剪 */
  -webkit-background-size: 200% 100%;
  -webkit-animation: masked-animation 60s linear infinite;
  font-size: 20px;
  display: inline-block;
  border-bottom: 1px dotted grey;
  height: 25px;
  font-weight: 800;
}
.conf-value {
  background-image: -webkit-linear-gradient(
    left,
    #1c006f,
    #d5df13 10%,
    #bb6a03 20%,
    #37001e 30%,
    #1b001d 40%,
    #1a000a 50%,
    #191a00 60%,
    #051600 70%,
    #1b001d 80%,
    #1a000a 90%,
    #191a00 100%
  );
  -webkit-text-fill-color: transparent; /* 将字体设置成透明色 */
  -webkit-background-clip: text; /* 裁剪背景图，使文字作为裁剪区域向外裁剪 */
  -webkit-background-size: 200% 100%;
  -webkit-animation: masked-animation1 60s linear infinite;
  font-size: 20px;
  height: 25px;
  display: inline-block;
  font-weight: 800;
}

@keyframes masked-animation {
  0% {
    background-position: 0 0;
  }
  50% {
    background-position: -100% 0;
  }
  100% {
    background-position: 0% 0;
  }
}
@keyframes masked-animation1 {
  0% {
    background-position: -100% 0;
  }
  50% {
    background-position: 0% 0;
  }
  100% {
    background-position: -100% 0;
  }
}

.text-reflect-base {
  color: #001a03;
  -webkit-box-reflect: below 10px;
}
</style>
