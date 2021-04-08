export default    {
    orders: [
      {
        missionOrderId: null,
        moMissionId: null,
        moMissionAllId: null,
        moAddTime: null,
        moRank: -1
      }
    ],
    missionDataList: [
      {
        jsoupMission: {
          missionId: -1,
          missionName: null,
          startActionId: null,
          noticeEmail: null,
          endTagContains: null,
          missionStartUrl: null,
          missionSuccessExcelName: null
        },
        actionList: [
          {
            actionId: -1,
            actionEleType: null,
            actionDoType: null,
            actionUrl: null,
            missionId: -1,
            actionEleValue: null,
            actionPreId: null,
            actionAfterId: null,
            actionName: null,
            actionPragramId: null,
            actionElePragramId: null
          },
        ],
        actionVos: [
          {
            jsoupAction: {
              actionId: -1,
              actionEleType: null,
              actionDoType: null,
              actionUrl: null,
              missionId: -1,
              actionEleValue: null,
              actionPreId: null,
              actionAfterId: null,
              actionName: null,
              actionPragramId: null,
              actionElePragramId: null
            },
            actionOrder: {
              actionOrderId: null,
              actionId: -1,
              missionId: -1,
              missionAllId: null,
              rank:  1
            },
            jsoupPragram: {
              pragramId: null,
              missionId: -1,
              actionId: -1,
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
        ],
        jsoupMissionOrder: {
          missionOrderId: null,
          moMissionId: null,
          moMissionAllId: null,
          moAddTime: null,
          moRank: -1
        },
        jsoupPragrams: [
          {
            pragramId: null,
            missionId: -1,
            actionId: -1,
            pragramType: null,
            pragramAccuracy: null,
            isRamdom: null,
            upNum: null,
            downNum: null,
            pragramValue: null,
            missionAllId: null,
            programContent: null
          }
        ],
        actionOrders: [
          {
            actionOrderId: null,
            actionId: -1,
            missionId: -1,
            missionAllId: null,
            rank:  1
          },
        ]
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
      maState: null
    },
    isOwner: null
  }

/**
 * 返回一个mission 对象
 */
  export function newMission () {
    return     {
      jsoupMission: {
        missionId: -1,
        missionName: null,
        startActionId: null,
        noticeEmail: null,
        endTagContains: null,
        missionStartUrl: null,
        missionSuccessExcelName: null
      },
      actionList: [
        {
          actionId: -1,
          actionEleType: null,
          actionDoType: null,
          actionUrl: null,
          missionId: -1,
          actionEleValue: null,
          actionPreId: null,
          actionAfterId: null,
          actionName: null,
          actionPragramId: null,
          actionElePragramId: null
        },
      ],
      actionVos: [
        {
          jsoupAction: {
            actionId: -1,
            actionEleType: null,
            actionDoType: null,
            actionUrl: null,
            missionId: -1,
            actionEleValue: null,
            actionPreId: null,
            actionAfterId: null,
            actionName: null,
            actionPragramId: null,
            actionElePragramId: null
          },
          actionOrder: {
            actionOrderId: null,
            actionId: -1,
            missionId: -1,
            missionAllId: null,
            rank:  1
          },
          jsoupPragram: {
            pragramId: null,
            missionId: -1,
            actionId: -1,
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
      ],
      jsoupMissionOrder: {
        missionOrderId: null,
        moMissionId: null,
        moMissionAllId: null,
        moAddTime: null,
        moRank: -1
      },
      jsoupPragrams: [
        {
          pragramId: null,
          missionId: -1,
          actionId: -1,
          pragramType: null,
          pragramAccuracy: null,
          isRamdom: null,
          upNum: null,
          downNum: null,
          pragramValue: null,
          missionAllId: null,
          programContent: null
        }
      ],
      actionOrders: [
        {
          actionOrderId: null,
          actionId: -1,
          missionId: -1,
          missionAllId: null,
          rank:  1
        },
      ]
    }
  }


  export function newMissionAll (){
    return  {
      orders: [
        {
          missionOrderId: null,
          moMissionId: null,
          moMissionAllId: null,
          moAddTime: null,
          moRank: 1
        }
      ],
      missionDataList: [
        {
          jsoupMission: {
            missionId: -1,
            missionName: null,
            startActionId: null,
            noticeEmail: null,
            endTagContains: null,
            missionStartUrl: null,
            missionSuccessExcelName: null
          },
          actionList: [
            {
              actionId: -1,
              actionEleType: null,
              actionDoType: null,
              actionUrl: null,
              missionId: -1,
              actionEleValue: null,
              actionPreId: null,
              actionAfterId: null,
              actionName: null,
              actionPragramId: null,
              actionElePragramId: null
            },
          ],
          actionVos: [
            {
              jsoupAction: {
                actionId: -1,
                actionEleType: null,
                actionDoType: null,
                actionUrl: null,
                missionId: -1,
                actionEleValue: null,
                actionPreId: null,
                actionAfterId: null,
                actionName: null,
                actionPragramId: null,
                actionElePragramId: null
              },
              actionOrder: {
                actionOrderId: null,
                actionId: -1,
                missionId: -1,
                missionAllId: null,
                rank: 1
              },
              jsoupPragram: {
                pragramId: null,
                missionId: -1,
                actionId: -1,
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
          ],
          jsoupMissionOrder: {
            missionOrderId: null,
            moMissionId: null,
            moMissionAllId: null,
            moAddTime: null,
            moRank: -1
          },
          jsoupPragrams: [
            {
              pragramId: null,
              missionId: -1,
              actionId: -1,
              pragramType: null,
              pragramAccuracy: null,
              isRamdom: null,
              upNum: null,
              downNum: null,
              pragramValue: null,
              missionAllId: null,
              programContent: null
            }
          ],
          actionOrders: [
            {
              actionOrderId: null,
              actionId: -1,
              missionId: -1,
              missionAllId: null,
              rank:  1
            },
          ]
        }
      ],
      jsoupMissionAll: new newJsoupMissionAll(),
      isOwner: null,
      isSuccess: null
    }
  }
  
 export function newJsoupMissionAll  () {
    let ma = {
      maId: -1,
      maName: '未命名脚本',
      maTip: null,
      malStartUrl: null,
      maSuccessFileName: null,
      maUserId: null,
      maNoticeEmail: null,
      userId: null,
      maState: null,
      maPrice: null,
      createTime: null ,
      maRate: null,
      maSaleNum: null,
      tips: null,
      userName: null,
      isAuto: null,
      maUrl: null
    }
    return ma
  }

  export function formateMaData(ma) {
    let tips = ma.tips
    let arry = new Array()
    arry = tips.split(";");
    ma.tips = arry
    return ma;
  }
  
