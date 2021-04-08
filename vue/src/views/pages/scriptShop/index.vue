<template>
  <d2-container>
    <template slot="header">
      <el-button type="text" disabled>脚本市场</el-button>
    </template>
     <!-- 卡片式改写 -->
       <template v-for="(item, index) in missionDatas">
      <el-card
        class="box-card cardBackgroud"
        :key="index"
        style="
          width: 45%;
          display: inline-block;
          margin-right: 3%;
          margin-bottom: 3%;
        "
      >
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
                  item.maName
                }}</span>
              </el-col>
              <el-col :span="12"></el-col>
            </el-row>
            <!-- 第二行是第一对字段 -->
            <el-row :getter="60" style="margin-bottom: 16px">
              <el-col :span="12">
                <span >用途:&nbsp;&nbsp;</span
                ><span  class="idlike" style="color: rgba(34, 28, 28, 0.555)">{{
                  item.maTip
                }}</span>
              </el-col>
              <el-col :span="12">
                <span>类型:&nbsp;&nbsp;</span
                ><span style="color: rgba(34, 28, 28, 0.555)">{{
                  item.isAuto == "1" ? "官方" : "自制"
                }}</span>
              </el-col>
            </el-row>
            <!-- 下一个字段 -->
            <el-row :getter="60" style="margin-bottom: 16px">
              <el-col :span="12">
                <span>评分:&nbsp;&nbsp;</span
                ><el-rate
                  :value="item.saleRate == null ? 0 : item.maRate"
                  disabled
                  text-color="#ff9900"
                  style="display: inline-block"
                >
                </el-rate>
              </el-col>
              <el-col :span="12">
                <span>创建者:&nbsp;&nbsp;</span
                ><span style="color: rgba(34, 28, 28, 0.555)">{{
                  item.userName
                }}</span>
              </el-col>
            </el-row>
            <!-- 下一个字段 -->
            <el-row :getter="60" style="margin-bottom: 16px">
              <el-col :span="12">
                <span>销量:&nbsp;&nbsp;</span
                ><span style="color: rgba(34, 28, 28, 0.555)">{{
                  item.maSaleNum
                }}</span>
              </el-col>
              <el-col :span="12">
                <span>上架时间:&nbsp;&nbsp;</span
                ><span style="color: rgba(34, 28, 28, 0.555)">{{
                  item.createTime
                }}</span>
              </el-col>
            </el-row>
            <!-- 下一段 -->
            <el-row :getter="60" style="margin-bottom: 16px">
              <el-col :span="24">
                <span>标签:&nbsp;&nbsp;</span
                ><span style="color: rgba(34, 28, 28, 0.555)"
                  ><el-tag v-for="(tp, adex) in item.tips" :key="adex">{{
                    tp
                  }}</el-tag></span
                >
              </el-col>
            </el-row>
            <el-row :getter="60" style="margin-bottom: 16px">
              <el-col :span="24">
                <el-button v-if="item.userId==0"
                  type="success"
                  style="width: 100%"
                  @click="sendBuy(item)"
                  >购买 ( {{item.maPrice}}代币 )</el-button
                >
                <el-button style="width: 100%" v-else-if="item.userId==2" disabled type="warning">已在库中</el-button>
                <el-button style="width: 100%" v-else-if="item.userId==1" disabled type="warning">我提供的</el-button>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
      </el-card>
    </template>
  
  
    <!-- 分页组件 目前是简单分页 -->
    <el-pagination
      background
      layout="prev, pager, next"
      :total="pageNum"
      :current-page="index"
    >
    </el-pagination>
  </d2-container>
</template>

<script>
import leidatu from "../../echart-comment/leidatu";
import leidatu2 from "../../echart-comment/leidatu2";
import leidatu3 from "../../echart-comment/leidatu3";
import { getSalesMa, buyMa } from "../../netWork/apiMethod";
import { newJsoupMissionAll } from "../../model/missionAllPojo";
export default {
  name: "scriptShop",
  components: {
    leidatu,
    leidatu2,
    leidatu3,
  },
  data() {
    return {
      missionDatas: [new newJsoupMissionAll()],
      pageSize: 10,
      index: 1,
      pageNum: 0,
      userId: this.$store.state.userVo.jsoupUser.userId,
    };
  },
  mounted() {
    this.getOriginData();
  },
  methods: {
    /**
     * 购买脚本
     */
    sendBuy(jsMa) {
      this.$confirm("是否购买?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
            buyMa(jsMa.maId).then((res) => {
              if (res.code == "success") {
                this.$message({
                  type: "success",
                  message: res.msg,
                });
              }
            });
          
        })
        .catch(() => {});
    },

    /**
     * 获取我的脚本
     */
    getMyScript() {
      getSalesMa(this.pageSize, this.index).then((res) => {
        this.missionDatas = res.maList;
        this.pageNum = res.pageNum;
      });
    },
    getOriginData() {
      this.getMyScript();
    },
  },
};
</script>
<style>
.idlike {

    width:100%;  /*根据个人需要自定义宽度*/
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
}
.divCard1 {
  margin-top: 10px;
  background-color: rgba(0, 255, 250, 0.26);
}
.conf {
  border: 5px solid;
  border-radius: 10%;
  border-image: linear-gradient(to right, #ff831c, #0ceebb) 20 20;
  background: rgba(255, 255, 255, 0.3)
    url("../../../../public/userFor/listBack.png") no-repeat;
  background-size: cover;
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
