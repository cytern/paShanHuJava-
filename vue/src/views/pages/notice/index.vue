<template>
  <d2-container>
    <template slot="header">信息栏
    <el-button type="primary" style="margin-left: 30px" @click="showAdd"> 发布帖子 </el-button>
    </template>
   
  </d2-container>
</template>

<script>
  import {} from "../../netWork/apiMethod";

  export default {
  name: 'notice',
  data () {
    return{}
  },
  mounted() {
   this.getAllTitles()
  },
  methods: {}
}
</script>
<style>
  .isUse{
    background-color: rgba(91, 198, 255, 0.77);
    margin-top: 20px;
  }
  .isNotUse{
    background-color: rgba(255, 95, 0, 0.88);
    opacity: 0.6;
    margin-top: 20px;
  }
  .isFinished{
    background-color: rgba(0, 0, 0, 0.26);
    opacity: 0.3;
    margin-top: 20px;
  }
</style>
