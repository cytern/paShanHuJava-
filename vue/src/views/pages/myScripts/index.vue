<template>
  <d2-container>
    <template slot="header">
      <el-button type="text" disabled>我的脚本</el-button>
    </template>
    <el-table :data="missionDatas" border style="width: 100%">
      <el-table-column label="脚本名称" width="180">
        <template slot-scope="scope">
          <i class="el-icon-cpu"></i>
          <span style="margin-left: 10px">{{
            scope.row.jsoupMissionAll.maName
          }}</span>
        </template>
      </el-table-column>
      <el-table-column label="脚本详细" width="180">
        <template slot-scope="scope">
          <el-popover trigger="hover" placement="top">
            <p>用途: {{ scope.row.jsoupMissionAll.maTip }}</p>
            <div slot="reference" class="name-wrapper">
              <el-tag size="medium">{{
                scope.row.jsoupMissionAll.maTip
              }}</el-tag>
            </div>
          </el-popover>
        </template>
      </el-table-column>
      <el-table-column label="起始地址" width="360">
        <template slot-scope="scope">
          <i class="el-icon-position"></i>
          <span style="margin-left: 10px">{{
            scope.row.jsoupMissionAll.malStartUrl
          }}</span>
        </template>
      </el-table-column>
      <el-table-column label="结果集名称" width="250">
        <template slot-scope="scope">
          <i class="el-icon-chat-line-square"></i>
          <span style="margin-left: 10px">{{
            scope.row.jsoupMissionAll.maSuccessFileName
          }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="success"
            @click="sendRun(scope.$index, scope.row)"
            >执行</el-button
          >
          <template v-if="scope.row.isOwner == 1">
            <!-- 上架中的脚本不允许编辑 -->
            <el-button
              v-if="scope.row.jsoupMissionAll.maState != 2"
              size="mini"
              type="warning"
              @click="sendEdit(scope.$index, scope.row)"
              >编辑</el-button
            >
            <!-- 市场化操作 -->
            <el-button
              size="mini"
              type="primary"
              @click="sendShop(scope.row.jsoupMissionAll)"
              >市场化</el-button
            >
            <!-- <el-select v-model="scope.row.jsoupMissionAll.maState" placeholder="状态" style="width:40%;margin-left:5px" @change="changeMaState(scope.row.jsoupMissionAll)" :disabled="scope.row.jsoupMissionAll.maState == 2">
              <el-option label="编辑中" :value='0'></el-option>
                       <el-option label="上架中" :value='2'></el-option>
            </el-select> -->
          </template>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 目前是简单分页 -->
    <el-pagination
      background
      layout="prev, pager, next"
      :total="pageNum"
      :current-page="index"
      @current-change="reflashPage"
    >
    </el-pagination>

    <el-dialog
      title="市场化设置"
      :visible.sync="shopDia"
      :before-close="handleClose"
    >
      <el-form :model="tempMa">
        <el-form-item label="价格" label-width="120px">
          <el-input v-model="tempMa.maPrice"></el-input>
        </el-form-item>
        <el-form-item label="上架情况" label-width="120px">
          <el-select
            v-model="tempMa.maState"
            placeholder="状态"
            :disabled="tempMa.maState == 2"
          >
            <el-option label="编辑中" :value="0"></el-option>
            <el-option label="上架中" :value="2"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="closeDia">取 消</el-button>
        <el-button type="primary" @click="sendChange">确 定</el-button>
      </div>
    </el-dialog>
  </d2-container>
</template>

<script>
import leidatu from "../../echart-comment/leidatu";
import leidatu2 from "../../echart-comment/leidatu2";
import leidatu3 from "../../echart-comment/leidatu3";
import {
  getAllScript,
  sendJsoupMission,
  setMissionAllState,
} from "../../netWork/apiMethod";
import { newMissionAll, newJsoupMissionAll } from "../../model/missionAllPojo";
export default {
  name: "studentCharts",
  components: {
    leidatu,
    leidatu2,
    leidatu3,
  },
  data() {
    return {
      missionDatas: [new newMissionAll()],
      pageSize: 10,
      index: 1,
      pageNum: 0,
      shopDia: false,
      tempMa: new newJsoupMissionAll(),
    };
  },
  mounted() {
    this.getOriginData();
  },
  methods: {
    reflashPage(currentPage) {
      this.index = currentPage;
      this.getMyScript();
    },
    handleClose(done) {
      this.$confirm("确认关闭？")
        .then((_) => {
          done();
        })
        .catch((_) => {});
    },
    closeDia() {
      this.tempMa = newJsoupMissionAll();
      this.shopDia = false;
    },
    /**
     * 修改脚本
     */
    sendEdit(index, item) {
      let id = item.jsoupMissionAll.maId;
      this.$store.state.maId = id;
      this.$router.push({
        path: `/myEditScript`,
      });
    },
    /**
     * 发送脚本
     */
    sendRun(index, item) {
      let maId = item.jsoupMissionAll.maId;
      this.$notify({
        title: "提示",
        message: "发送执行成功，请耐心等待",
        duration: 0,
      });
      sendJsoupMission(maId).then((res) => {
        if (res.code == "success") {
          this.$message("执行完毕");
        }
      });
    },

    sendShop(ma) {
      this.tempMa = ma;
      this.shopDia = true;
    },
    //将脚本的变化状态 设置出去
    sendChange() {
      if (this.tempMa.maState == 2 && this.tempMa.maPrice == null) {
        this.$message({
          type: "warning",
          message: "上架时价格不能为0",
        });
      } else {
        this.changeMaState(this.tempMa);
      }
    },
    /**
     * 变化脚本状态
     */
    changeMaState(jsoupMissionAll) {
      if (jsoupMissionAll.maState == 2) {
        this.$confirm("上架后将无法再编辑修改脚本，是否继续?", "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        })
          .then(() => {
            setMissionAllState(jsoupMissionAll).then((res) => {
              if (res.code == "success") {
                this.tempMa = newJsoupMissionAll();
                this.shopDia = false;
                this.getMyScript();
              }
            });
          })
          .catch(() => {
            this.$message({
              type: "info",
              message: "已取消上架",
            });
            jsoupMissionAll.maState = 0;
          });
      }
    },
    /**
     * 获取我的脚本
     */
    getMyScript() {
      getAllScript(this.pageSize, this.index).then((res) => {
        this.missionDatas = res.missionData;
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
