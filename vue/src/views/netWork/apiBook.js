
const linuxUrl = "http://62.234.29.109:2060/"
const windowsUrl = "http://localhost:2060/"
const baseUrl = linuxUrl
export default {
  everyOne:{
    login:  baseUrl + "server/everyone/login",
    register: baseUrl + "server/everyone/register",
    forgetPassword: baseUrl + "server/everyone/forgetPassword",
    resetPassword: baseUrl + "server/everyone/resetPassword"
    

  },
  customer: {
    getMyScript : baseUrl + "server/customer/getMyOrders",
    getMyMissionHistorys : baseUrl + "server/customer/getMyMissionHistory" ,
    getOneScript: baseUrl + "server/customer/getScript",
    saveOneScript: baseUrl + "server/customer/saveMyScript",
    sendExcutor: baseUrl + "server/customer/runJavaSoup",
    getUserInfo: baseUrl + "server/customer/getUserInfo",
    setMaState: baseUrl + "server/customer/setMissionAllState",
    getSalesMa: baseUrl + "server/customer/getSalesMa",
    getSalesMh: baseUrl + "server/customer/getSalesMh",
    setMhState: baseUrl + "server/customer/setMhState",
    buyMa: baseUrl + "server/customer/buyMa",
    buyMh: baseUrl + "server/customer/buyMh",
    getDetailComment:baseUrl + "server/customer/getGoodDetailComment",
    getDetailUser: baseUrl + "server/customer/getGoodDetailUsaer",
    


  },
  other: {
    downloadExcel: baseUrl + "server/other/downloadFile"    
  }
}
