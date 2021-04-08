<template>
  <el-dropdown size="small" class="d2-mr">
    <span class="btn-text">{{userVo != null? `你好 ${userVo.jsoupUserDetail.userNickName}` : '未登录'}}</span>
    <el-dropdown-menu slot="dropdown">
      <el-dropdown-item @click.native="logOff">
        <d2-icon name="power-off" class="d2-mr-5"/>
        注销
      </el-dropdown-item>
    </el-dropdown-menu>
  </el-dropdown>
</template>

<script>
import { mapState, mapActions } from 'vuex'
export default {
  computed: {
    ...mapState('d2admin/user', [
      'info'
    ])
  },

  data (){
    return{
      userVo: this.$store.state.userVo,
    }
  },
  afterMounted() {
   this.userVo = this.$store.state.userVo
  },
  methods: {
    ...mapActions('d2admin/account', [
      'logout'
    ]),
    /**
     * @description 登出
     */
    logOff () {
      this.$store.state.userVo = null
      this.logout({
        confirm: true
      })
    }
  }
}
</script>
