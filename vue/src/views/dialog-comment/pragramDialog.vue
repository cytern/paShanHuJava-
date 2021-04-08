<template>

<el-dialog
  title="编辑参数"
  :visible.sync="dialogVisible"
  width="30%"
  :before-close="handleClose">
  <el-form ref="form" :model="actionVo" label-width="80px">
    <!-- 修改数值类型 -->
    <el-form-item label="数据类型">
      <el-select v-model="actionVo.jsoupPragram.pragramType" placeholder="请选择类型">
        <el-option
          v-for="(item, index) in pragramTypes"
          :key="index"
          :label="item.name"
          :value="item.value"
        ></el-option>
      </el-select>
    </el-form-item>
    <!-- 如果是随机数属性 则进入随机数判定 -->
    <template
      v-if="
        actionVo.jsoupPragram.pragramType == 'decimal' ||
        actionVo.jsoupPragram.pragramType == 'int' ||
        actionVo.jsoupPragram.pragramType == 'date'
      "
    >
      <el-form-item label="是否随机">
        <el-select v-model="actionVo.jsoupPragram.isRamdom" placeholder="请选择">
          <el-option label="是" value="1"></el-option>
          <el-option label="否" value="0"></el-option>
        </el-select>
      </el-form-item>
      <!-- 如果不是日期属性 则使用两个框 -->
      <el-form-item
        v-if="actionVo.jsoupPragram.isRamdom == 1 && actionVo.jsoupPragram.pragramType != 'date'"
        lable="上下数值区间"
      >
      <el-col :span="11">
      <el-form-item >
          <el-input
            placeholder="请输入下区间"
            @change="makeSureData"
            v-model="actionVo.jsoupPragram.downNum"
            clearable
          >
          </el-input>
      </el-form-item>
    </el-col>
    <el-col class="line" :span="2">-</el-col>
    <el-col :span="11">
      <el-form-item prop="date2">
          <el-input
            placeholder="请输入上区间"
            @change="makeSureData"
            v-model="actionVo.jsoupPragram.upNum"
            clearable
          >
          </el-input>
      </el-form-item>
    </el-col>
      </el-form-item>
      <!-- 如果是日期属性 则使用日期选择器 -->
      <el-form-item
        v-if="actionVo.jsoupPragram.isRamdom == 1 && actionVo.jsoupPragram.pragramType == 'date'"
        label="上下数值区间"
      >
        <el-col :span="11">
          <el-date-picker
            v-model="actionVo.jsoupPragram.downNum"
            @change="makeSureData"
            type="datetime"
            placeholder="选择起始日期时间"
          >
          </el-date-picker>
        </el-col>
        <el-col class="line" :span="2">-</el-col>
        <el-col>
          <el-date-picker
            v-model="actionVo.jsoupPragram.upNum"
            @change="makeSureData"
            type="datetime"
            placeholder="选择结束日期时间"
          >
          </el-date-picker>
        </el-col>
      </el-form-item>
    </template>
     <el-form-item label="小数长度" v-if="actionVo.jsoupPragram.pragramType == 'decimal'">
     <el-input v-model="actionVo.jsoupPragram.pragramAccuracy" placeholder="请输入小数位数"></el-input>
    </el-form-item>
  <el-form-item label="数据别名">
     <el-input v-model="actionVo.jsoupPragram.programContent" placeholder="请输入数据别名"></el-input>
    </el-form-item>
      <el-form-item label="值">
     <el-input v-model="actionVo.jsoupPragram.pragramValue" placeholder="请输入值"></el-input>
    </el-form-item>
  </el-form>
   <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="outPutData">确 定</el-button>
  </span>
  </el-dialog>
</template>

<script>
import accRule from "../model/rules";
import praType from "../model/pragramTypes";
export default {
  name: "dialogComment",
  mounted() {},
  props: {},
  data() {
    return {
      rules: accRule,
      actionVo: {
        jsoupAction: {
              actionId: null,
              actionEleType: null,
              actionDoType: null,
              actionUrl: null,
              missionId: null,
              actionEleValue: null,
              actionPreId: null,
              actionAfterId: null,
              actionName: null,
              actionPragramId: null,
              actionElePragramId: null
            },
            actionOrder: {
              actionOrderId: null,
              actionId: null,
              missionId: null,
              missionAllId: null,
              rank: null
            },
            jsoupPragram: {
              pragramId: null,
              missionId: null,
              actionId: null,
              pragramType: null,
              pragramAccuracy: null,
              isRamdom: null,
              upNum: null,
              downNum: null,
              pragramValue: null,
              missionAllId: null,
              programContent: null
            }
      },
      actionList: [],
      pragramTypes: praType,
      dialogVisible: false,
    };
  },
  computed: {},
  methods: {
      /**
       * 父组件初始化数据给子组件
       */
      initData (actionVo) {
          //赋值
              this.actionVo = actionVo
             this.dialogVisible = true
      },
      /**
       * 将数据传递给父组件
       */
     outPutData() {
         this.$emit('func',this.actionVo.jsoupPragram)
         this.dialogVisible = false
     },     
      /**
       * 坚定数据是否符合大小依赖
       */
    makeSureData() {
      let tempData = 0;
      if (this.actionVo.jsoupPragram.upNum < this.actionVo.jsoupPragram.downNum) {
        tempData = this.actionVo.jsoupPragram.upNum;
        this.actionVo.jsoupPragram.upNum = this.actionVo.jsoupPragram.downNum;
        this.actionVo.jsoupPragram.downNum = tempData;
        this.$message({
          message: "上下区间数值对照相反，已自动重新调整",
          type: "warning",
        });
      }
    },

      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      }
  },
};
</script>

<style scoped>
</style>
