export default {
    missionAllHistoryId: null,
    missionAllId: null,
    missionState: null,
    missionResultUrl: null,
    userId: null,
    missionFailReason: null,
    sentTime: null,
    finishTime: null,
    missionAllName: null,
    missionAllDis: null
  };
  export function newMah() {
    let mah = {
      missionAllHistoryId: null,
      missionAllId: null,
      missionState: null,
      missionResultUrl: null,
      userId: null, 
      missionFailReason: null,
      sentTime: null,
      finishTime: null,
      missionAllName: null,
      missionAllDis: null,
      onSale: null,
      salePrice: null,
      saleRate: null,
      saleNum: null,
      tips: null,
      userName: null,
      isAoto: null,
      hsUrl: null
    }
    return mah;
  }

  export function formateMhData(mh) {
    let tips = mh.tips
    let arry = new Array()
    arry = tips.split(";");
    mh.tips = arry
    return mh;
  }