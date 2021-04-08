import Vue from 'vue'
import Vuex from 'vuex'
import { userPojo } from "../views/model/userPojo";
import {goodDetail,maToDetail,mhToDetail} from "../views/model/detailPojo"
import d2admin from './modules/d2admin'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    d2admin
  },
  state: {
    code: null,
    name: '',
    type: '',
    typeId: null,
    userId: null,
    missionDatas: [],
    maId: null,
    userVo: null,
    goodDetail: new goodDetail()
  },
  getters: {
    getCode (state) {
      return state
    }
  },
  mutations: {
    setCode(state, code = null) {
      state.code = code
      return state.code
    },
    setName(state, name = null) {
      state.name = name
      return state.name
    }
  }
})
