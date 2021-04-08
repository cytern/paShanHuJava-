export default {
    jsoupUser:jsoupUser(),
    jsoupUserDetail: {
        userDetailId: null,
        userRealName: null,
        userNickName: null,
        userImageUrl: null,
        userDes: null,
        userId: null,
        userEmail: null,
        userPhone: null,
        serialVersionUID: null
    },
    jsoupUserAssets: {
        userAssetsId: null,
        userId: null,
        cornNum: null,
        goldNum: null,
        serialVersionUID: null
    },
    orders: [{
        orderId: null,
        userId: null,
        missionAllId: null,
        createTime: null,
        serialVersionUID: null
    }],
    list: [{
        orders: [{
            missionOrderId: null,
            moMissionId: null,
            moMissionAllId: null,
            moAddTime: null,
            moRank: null,
            serialVersionUID: null
        }],
        missionDataList: [
            {
                jsoupMission: {
                    missionId: null,
                    missionName: null,
                    startActionId: null,
                    noticeEmail: null,
                    endTagContains: null,
                    missionStartUrl: null,
                    missionSuccessExcelName: null,
                    serialVersionUID: null
                },
                actionList: [{
                    action: {
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
                        actionElePragramId: null,
                        serialVersionUID: null
                    }
                }], 
                jsoupMissionOrder: {
                    missionOrderId: null,
                    moMissionId: null,
                    moMissionAllId: null,
                    moAddTime: null,
                    moRank: null,
                    serialVersionUID: null
                },
                jsoupPragrams: [
                    {
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
                        programContent: null,
                        serialVersionUID: null
                    }
                ],
             
            }


        ],
        jsoupMissionAll: {
            maId: null,
            maName: null,
            maTip: null,
            malStartUrl: null,
            maSuccessFileName: null,
            maUserId: null,
            maNoticeEmail: null,
            userId: null,
            serialVersionUID: null
        }

    }]
}
/**
 * 构造方法
 */
export function userPojo(){
 let userPojo = {
    jsoupUser:jsoupUser(),
    jsoupUserDetail: {
        userDetailId: null,
        userRealName: null,
        userNickName: null,
        userImageUrl: null,
        userDes: null,
        userId: null,
        userEmail: null,
        userPhone: null,
        serialVersionUID: null
    },
    jsoupUserAssets: {
        userAssetsId: null,
        userId: null,
        cornNum: null,
        goldNum: null,
        serialVersionUID: null
    },
    orders: [{
        orderId: null,
        userId: null,
        missionAllId: null,
        createTime: null,
        serialVersionUID: null
    }],
    list: [{
        orders: [{
            missionOrderId: null,
            moMissionId: null,
            moMissionAllId: null,
            moAddTime: null,
            moRank: null,
            serialVersionUID: null
        }],
        missionDataList: [
            {
                jsoupMission: {
                    missionId: null,
                    missionName: null,
                    startActionId: null,
                    noticeEmail: null,
                    endTagContains: null,
                    missionStartUrl: null,
                    missionSuccessExcelName: null,
                    serialVersionUID: null
                },
                actionList: [{
                    action: {
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
                        actionElePragramId: null,
                        serialVersionUID: null
                    }
                }], 
                jsoupMissionOrder: {
                    missionOrderId: null,
                    moMissionId: null,
                    moMissionAllId: null,
                    moAddTime: null,
                    moRank: null,
                    serialVersionUID: null
                },
                jsoupPragrams: [
                    {
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
                        programContent: null,
                        serialVersionUID: null
                    }
                ],
             
            }


        ],
        jsoupMissionAll: {
            maId: null,
            maName: null,
            maTip: null,
            malStartUrl: null,
            maSuccessFileName: null,
            maUserId: null,
            maNoticeEmail: null,
            userId: null,
            serialVersionUID: null
        }

    }]
}
return userPojo;
}


export function jsoupUser () {
    let user = {
        userId: null,
        username: null,
        password: null,
        createTime: null,
        userToken: null,
        serialVersionUID: null
    }
    return user;
}