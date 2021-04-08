<template>
  <d2-container>
     <template slot="header">
       <el-button type="text" disabled>个人信息</el-button>
     </template>

  </d2-container>
</template>

<script>
  import leidatu from "../../echart-comment/leidatu";
  import leidatu2 from "../../echart-comment/leidatu2";
  import leidatu3 from "../../echart-comment/leidatu3";
  import {} from "../../netWork/apiMethod";
export default {
  name: 'studentConf',
  components:{
    leidatu,
    leidatu2,
    leidatu3
  },
  data(){
    return{ }

  },
  mounted() {
    const vm = this
    vm.$nextTick(()=> {})
    this.getOriginData()
  },
  methods:{ }

}
</script>

<style>
  .divCard{
    margin-top: 10px;
    background-color: rgba(150, 255, 28, 0.26);
  }
  .conf{
    border: 5px solid;
    border-radius: 10%;border-image: linear-gradient(to right,#ff831c, #0ceebb) 20 20;
    background: rgba(255, 255, 255, 0.3) url("../../../../public/userFor/listBack.png");
  }
  .touxiang{
    height: 200px;width: 200px;border-radius: 50%;background: linear-gradient(to right,#ff478e,#2fff2e);


  }
  .confs{
    border: 5px solid;
    border-radius: 10%;border-image: linear-gradient(to left,#ff831c, #0ceebb) 20 20;
    background: rgba(255, 255, 255, 0.3) url("../../../../public/userFor/listBack.png");
  }
  .leidatu{
    border: 5px solid;
    border-radius: 10%;border-image: linear-gradient(to left,#ff831c, #0ceebb) 20 20;
    background: rgba(255, 255, 255, 0.3) url("../../../../public/userFor/leidabeijing1.png");
  }
  .xuexiaobeijing{
    border: 5px solid;
    border-radius: 10%;border-image: linear-gradient(to left,#ff831c, #0ceebb) 20 20;
    background: rgba(255, 255, 255, 0.3) url("../../../../public/userFor/xuexiaobeijing.png");
  }
  .conf-key{
    /*width: 300px;*/
    /*height: 200px;*/
    background-image: -webkit-linear-gradient(left, #1c006f, #d5df13 10%, #bb6a03 20%, #37001e 30%, #1b001d 40%, #1a000a 50%,#191a00 60%,#051600 70%,#1b001d 80%,#1a000a 90%,#191a00 100%);
    -webkit-text-fill-color: transparent;/* 将字体设置成透明色 */
    -webkit-background-clip: text;/* 裁剪背景图，使文字作为裁剪区域向外裁剪 */
    -webkit-background-size: 200% 100%;
    -webkit-animation: masked-animation 60s linear infinite;
    font-size: 20px;
    display: inline-block;
    border-bottom: 1px dotted grey;
    height: 25px;
    font-weight: 800;

  }
  .conf-value{

    background-image: -webkit-linear-gradient(left, #1c006f, #d5df13 10%, #bb6a03 20%, #37001e 30%, #1b001d 40%, #1a000a 50%,#191a00 60%,#051600 70%,#1b001d 80%,#1a000a 90%,#191a00 100%);
    -webkit-text-fill-color: transparent;/* 将字体设置成透明色 */
    -webkit-background-clip: text;/* 裁剪背景图，使文字作为裁剪区域向外裁剪 */
    -webkit-background-size: 200% 100%;
    -webkit-animation: masked-animation1 60s linear infinite;
    font-size: 20px;  height: 25px;
    display: inline-block;
    font-weight: 800;
  }

  @keyframes masked-animation {
    0% {
      background-position: 0  0;
    }
    50% {
      background-position: -100%  0;
    }
    100% {
      background-position: 0%  0;
    }
  }
  @keyframes masked-animation1 {
    0% {
      background-position: -100%  0;
    }
    50% {
      background-position: 0%  0;
    }
    100% {
      background-position: -100%  0;
    }
  }

  .text-reflect-base{
    color: #001a03;
    -webkit-box-reflect:below 10px;
  }
</style>
