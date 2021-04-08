<template>
  <div class="page-login">
    <div class="page-login--layer page-login--layer-area">
      <ul class="circles">
        <li v-for="n in 10" :key="n"></li>
      </ul>
    </div>
    <div
      class="page-login--layer page-login--layer-time"
      flex="main:center cross:center"
    >
      {{ time }}
    </div>
    <div class="page-login--layer">
      <div
        class="page-login--content"
        flex="dir:top main:justify cross:stretch box:justify"
      >
        <div class="page-login--content-header"></div>
        <div
          class="page-login--content-main"
          flex="dir:top main:center cross:center"
        >
          <!-- logo -->
          <img class="page-login--logo" src="./image/logo.png" />
          <!-- form -->
          <div class="page-login--form">
            <el-card shadow="never">
              <el-form
                ref="loginForm"
                label-position="top"
                :rules="rules"
                :model="formLogin"
                size="default"
              >
                <el-form-item prop="username">
                  <el-input
                    type="text"
                    v-model="formLogin.username"
                    placeholder="用户名"
                  >
                    <i slot="prepend" class="fa fa-user-circle-o"></i>
                  </el-input>
                </el-form-item>
                <el-form-item prop="password">
                  <el-input
                    type="password"
                    v-model="formLogin.password"
                    placeholder="密码"
                  >
                    <i slot="prepend" class="fa fa-keyboard-o"></i>
                  </el-input>
                </el-form-item>
                <el-form-item>
                  <el-row>
                    <el-col :span="18">
                      <el-button type="text" @click="sendFogetPassword"
                        >忘记密码</el-button
                      >
                    </el-col>

                    <el-col :span="4">
                      <el-button type="text" @click="dialogVisible = true"
                        >注册账号</el-button
                      >
                    </el-col>
                  </el-row>
                </el-form-item>
                <el-button
                  size="default"
                  @click="loginMySelf"
                  type="primary"
                  class="button-login"
                >
                  登录
                </el-button>
              </el-form>
            </el-card>
          </div>
        </div>
        <div class="page-login--content-footer">
          <p class="page-login--content-footer-copyright">
            Copyright
            <d2-icon name="copyright" />
            爬山虎云脚本平台
            <a href="https://github.com/cytern"> @Cytern </a>
          </p>
          <p class="page-login--content-footer-options">
            <a href="#">帮助</a>
            <a href="#">隐私</a>
            <a href="#">条款</a>
          </p>
        </div>
      </div>
    </div>
    <el-dialog title="注册用户" :visible.sync="dialogVisible" width="400px">
      <el-form ref="form" :model="userVo" label-width="80px">
        <el-form-item label="登录名">
          <el-input v-model="userVo.jsoupUser.username"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input
            type="password"
            v-model="userVo.jsoupUser.password"
          ></el-input>
        </el-form-item>
        <el-form-item label="确认密码">
          <el-input type="password" v-model="tempPassword"></el-input>
        </el-form-item>
        <el-form-item label="昵称">
          <el-input v-model="userVo.jsoupUserDetail.userNickName"></el-input>
        </el-form-item>
        <el-form-item label="简介">
          <el-input v-model="userVo.jsoupUserDetail.userDes"></el-input>
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-model="userVo.jsoupUserDetail.userEmail"></el-input>
        </el-form-item>
        <el-form-item label="电话号码" prop="phone">
          <el-input v-model="userVo.jsoupUserDetail.userPhone"></el-input>
        </el-form-item>
        <el-tag type="danger" v-if="tempMsg">{{ tempMsg }} </el-tag>
        <el-form-item prop="phone">
          <el-row>
            <el-col :span="18">
              <el-button type="primary" @click="sendForRegister"
                >注册</el-button
              >
            </el-col>
            <el-col :span="4">
              <el-button type="warning" @click="closeDio">取消</el-button>
            </el-col>
          </el-row>
        </el-form-item>
      </el-form>
    </el-dialog>

    <!-- 忘记密码对话框 -->
    <el-dialog title="忘记密码" :visible.sync="forgetPass" width="400px">
      <el-form ref="form" :model="userVo" label-width="80px">
        <el-form-item label="登录名">
          <el-input disabled v-model="userVo.jsoupUser.username"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input
            type="password"
            v-model="userVo.jsoupUser.password"
          ></el-input>
        </el-form-item>
        <el-form-item label="确认密码">
          <el-input type="password" v-model="tempPassword"></el-input>
        </el-form-item>
        <el-form-item label="验证码">
          <el-input v-model="userVo.jsoupUser.userToken"></el-input>
        </el-form-item>
        <el-tag type="danger" v-if="tempMsg">{{ tempMsg }} </el-tag>
        <el-form-item prop="phone">
          <el-row>
            <el-col :span="18">
              <el-button type="primary" @click="sendForResetPassword"
                >重设密码</el-button
              >
            </el-col>
            <el-col :span="4">
              <el-button type="warning" @click="closeDio">取消</el-button>
            </el-col>
          </el-row>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import dayjs from "dayjs";
import { mapActions } from "vuex";
import localeMixin from "@/locales/mixin.js";
import {
  everyOneLogin,
  registerUser,
  forgetPassword,
  resetPassword,
  getUserInfo
} from "../../netWork/apiMethod";
import { userPojo, jsoupUser } from "../../model/userPojo";
import { newRules } from "../../model/rules";
import { notEmpty, password } from "../../model/validator";
export default {
  mixins: [localeMixin],
  data() {
    return {
      userVo: new userPojo(),
      forgetPass: false,
      tempPassword: null,
      timeInterval: null,
      tempMsg: null,
      time: dayjs().format("HH:mm:ss"),
      // 快速选择用户
      dialogVisible: false,
      users: [],
      // 表单
      formLogin: {
        username: null,
        password: null,
        code: "v9am",
      },
      formRules: new newRules(),
      // 表单校验
      rules: {
        username: [
          {
            required: true,
            message: "请输入用户名",
            trigger: "blur",
          },
        ],
        password: [
          {
            required: true,
            message: "请输入密码",
            trigger: "blur",
          },
        ],
      },
    };
  },
  mounted() {
    this.timeInterval = setInterval(() => {
      this.refreshTime();
    }, 1000);
  },
  beforeDestroy() {
    clearInterval(this.timeInterval);
  },
  methods: {
    /**
     * 发送重设密码网络请求
     */
    sendForResetPassword() {
      //确定两次密码相同
      if (this.tempPassword != this.userVo.jsoupUser.password) {
        this.tempMsg = "两次密码不相等!请确认后重新输入";
      } else {
        resetPassword(
          this.userVo.jsoupUser.username,
          this.userVo.jsoupUser.password,
          this.userVo.jsoupUser.userToken
        )((res) => {
          if (res.code == "success") {
            this.tempMsg = null;
            this.$message(res.msg);
            this.forgetPass = false;
          } else {
            this.$message({
              message: res.msg,
              type: "warning",
            });
            this.tempMsg = res.msg
          }
        });
      }
    },
    /**
     * 忘记密码发送
     */
    sendFogetPassword() {
      //判断是否输入账号
      if (this.formLogin.username == null || this.formLogin.username == "") {
        this.$message({
          message: "账号为空",
          type: "warning",
        });
      } else {
        //发送网络请求 发送邮箱验证码
        forgetPassword(this.formLogin.username).then((res) => {
          if (res.code == "success") {
            this.userVo = new userPojo();
            this.userVo.jsoupUser.username = this.formLogin.username;
            this.forgetPass = true;
           
          } else {
            this.$message({
              message: res.msg,
              type: "warning",
            });
          }
        });
      }
    },

    //准备注册前服务
    sendForRegister() {
      //判断两次密码是否相等
      if (this.tempPassword != this.userVo.jsoupUser.password) {
        this.tempMsg = "两次密码不相等!请确认后重新输入";
      } else {
        this.tempMsg = null;
        registerUser(this.userVo).then((res) => {
          if (res.code == "error") {
            this.tempMsg = res.msg;
          } else {
            this.tempMsg = null;
            this.dialogVisible = false;
            this.$message("注册成功,邮件已发送至邮箱，请尽快完成验证");
          }
        });
      }
    },
    /**
     * 关闭窗口
     */
    closeDio() {
      this.userVo = new userPojo();
      this.tempMsg = null
      this.dialogVisible = false;
      this.forgetPass = false
    },
    ...mapActions("d2admin/account", ["login"]),
    refreshTime() {
      this.time = dayjs().format("HH:mm:ss");
    },
    /**
     * @description 接收选择一个用户快速登录的事件
     * @param {Object} user 用户信息
     */
    handleUserBtnClick(user) {
      this.formLogin.username = user.username;
      this.formLogin.password = user.password;
      this.submit();
    },
    /**
     * @description 提交表单
     */
    loginMySelf() {
      everyOneLogin(this.formLogin.username, this.formLogin.password).then(
        (res) => {
          if (res.code == "error") {
            this.$message.error(res.msg);
          } else {
            this.$store.state.code = res.token;
            this.$store.state.type = res.role;
            localStorage.setItem("token", this.$store.state.code);
            localStorage.setItem("type", this.$store.state.type);

            this.submit();
          }
          if (res.token) {
            //登录成功 
            this.$store.state.code = res.token;
            this.$store.state.type = res.role;
            localStorage.setItem("token", this.$store.state.code);
            localStorage.setItem("type", this.$store.state.type);
            if(getUserInfo()){
               this.submit();
            }
          } else {
            console.log(res.token);
            this.$message.error(res.error);
          }
        }
      );
    },
    // 提交登录信息
    submit() {
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
          // 登录
          // 注意 这里的演示没有传验证码
          // 具体需要传递的数据请自行修改代码
          this.login({
            username: "admin",
            password: "admin",
          }).then(() => {
            // 重定向对象不存在则返回顶层路径
            this.$router.replace(this.$route.query.redirect || "/");
          });
        } else {
          // 登录表单校验失败
          this.$message.error("表单校验失败，请检查");
        }
      });
    },
  },
};
</script>

<style lang="scss">
.page-login {
  @extend %unable-select;
  $backgroundColor: #f0f2f5;
  // ---
  background-color: $backgroundColor;
  height: 100%;
  position: relative;
  // 层
  .page-login--layer {
    @extend %full;
    overflow: auto;
  }
  .page-login--layer-area {
    overflow: hidden;
  }
  // 时间
  .page-login--layer-time {
    font-size: 24em;
    font-weight: bold;
    color: rgba(0, 0, 0, 0.03);
    overflow: hidden;
  }
  // 登陆页面控件的容器
  .page-login--content {
    height: 100%;
    min-height: 500px;
  }
  // header
  .page-login--content-header {
    padding: 1em 0;
    .page-login--content-header-motto {
      margin: 0px;
      padding: 0px;
      color: $color-text-normal;
      text-align: center;
      font-size: 12px;
    }
  }
  // main
  .page-login--logo {
    width: 240px;
    margin-bottom: 2em;
    margin-top: -2em;
  }
  // 登录表单
  .page-login--form {
    width: 280px;
    // 卡片
    .el-card {
      margin-bottom: 15px;
    }
    // 登录按钮
    .button-login {
      width: 100%;
    }
    // 输入框左边的图表区域缩窄
    .el-input-group__prepend {
      padding: 0px 14px;
    }
    .login-code {
      height: 40px - 2px;
      display: block;
      margin: 0px -20px;
      border-top-right-radius: 2px;
      border-bottom-right-radius: 2px;
    }
    // 登陆选项
    .page-login--options {
      margin: 0px;
      padding: 0px;
      font-size: 14px;
      color: $color-primary;
      margin-bottom: 15px;
      font-weight: bold;
    }
    .page-login--quick {
      width: 100%;
    }
  }
  // 快速选择用户面板
  .page-login--quick-user {
    @extend %flex-center-col;
    padding: 10px 0px;
    border-radius: 4px;
    &:hover {
      background-color: $color-bg;
      i {
        color: $color-text-normal;
      }
      span {
        color: $color-text-normal;
      }
    }
    i {
      font-size: 36px;
      color: $color-text-sub;
    }
    span {
      font-size: 12px;
      margin-top: 10px;
      color: $color-text-sub;
    }
  }
  // footer
  .page-login--content-footer {
    padding: 1em 0;
    .page-login--content-footer-locales {
      padding: 0px;
      margin: 0px;
      margin-bottom: 15px;
      font-size: 12px;
      line-height: 12px;
      text-align: center;
      color: $color-text-normal;
      a {
        color: $color-text-normal;
        margin: 0 0.5em;
        &:hover {
          color: $color-text-main;
        }
      }
    }
    .page-login--content-footer-copyright {
      padding: 0px;
      margin: 0px;
      margin-bottom: 10px;
      font-size: 12px;
      line-height: 12px;
      text-align: center;
      color: $color-text-normal;
      a {
        color: $color-text-normal;
      }
    }
    .page-login--content-footer-options {
      padding: 0px;
      margin: 0px;
      font-size: 12px;
      line-height: 12px;
      text-align: center;
      a {
        color: $color-text-normal;
        margin: 0 1em;
      }
    }
  }
  // 背景
  .circles {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    overflow: hidden;
    margin: 0px;
    padding: 0px;
    li {
      position: absolute;
      display: block;
      list-style: none;
      width: 20px;
      height: 20px;
      background: #fff;
      animation: animate 25s linear infinite;
      bottom: -200px;
      @keyframes animate {
        0% {
          transform: translateY(0) rotate(0deg);
          opacity: 1;
          border-radius: 0;
        }
        100% {
          transform: translateY(-1000px) rotate(720deg);
          opacity: 0;
          border-radius: 50%;
        }
      }
      &:nth-child(1) {
        left: 15%;
        width: 80px;
        height: 80px;
        animation-delay: 0s;
      }
      &:nth-child(2) {
        left: 5%;
        width: 20px;
        height: 20px;
        animation-delay: 2s;
        animation-duration: 12s;
      }
      &:nth-child(3) {
        left: 70%;
        width: 20px;
        height: 20px;
        animation-delay: 4s;
      }
      &:nth-child(4) {
        left: 40%;
        width: 60px;
        height: 60px;
        animation-delay: 0s;
        animation-duration: 18s;
      }
      &:nth-child(5) {
        left: 65%;
        width: 20px;
        height: 20px;
        animation-delay: 0s;
      }
      &:nth-child(6) {
        left: 75%;
        width: 150px;
        height: 150px;
        animation-delay: 3s;
      }
      &:nth-child(7) {
        left: 35%;
        width: 200px;
        height: 200px;
        animation-delay: 7s;
      }
      &:nth-child(8) {
        left: 50%;
        width: 25px;
        height: 25px;
        animation-delay: 15s;
        animation-duration: 45s;
      }
      &:nth-child(9) {
        left: 20%;
        width: 15px;
        height: 15px;
        animation-delay: 2s;
        animation-duration: 35s;
      }
      &:nth-child(10) {
        left: 85%;
        width: 150px;
        height: 150px;
        animation-delay: 0s;
        animation-duration: 11s;
      }
    }
  }
}
</style>
