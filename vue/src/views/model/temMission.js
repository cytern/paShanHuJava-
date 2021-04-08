export default  {
      orders: [
        {
          missionOrderId: 1,
          moMissionId: 1,
          moMissionAllId: 1,
          moAddTime: '2021-01-06T07:44:28.000+00:00',
          moRank: 1
        }
      ],
      missionDataList: [
        {
          jsoupMission: {
            missionId: 1,
            missionName: '自动填写每日一报',
            startActionId: 1,
            noticeEmail: 'cytern@foxmail.com',
            endTagContains: '成功',
            missionStartUrl: 'https://hsm.sspu.edu.cn/selfreport/Default.aspx',
            missionSuccessExcelName: null
          },
          actionList: [
            {
              actionId: 1,
              actionEleType: 'id',
              actionDoType: 'input',
              actionUrl: null,
              missionId: 1,
              actionEleValue: 'username',
              actionPreId: 0,
              actionAfterId: 2,
              actionName: '输入用户名',
              actionPragramId: 1,
              actionElePragramId: 1
            },
            {
              actionId: 2,
              actionEleType: 'id',
              actionDoType: 'input',
              actionUrl: null,
              missionId: 1,
              actionEleValue: 'password',
              actionPreId: 1,
              actionAfterId: 3,
              actionName: '输入密码',
              actionPragramId: 2,
              actionElePragramId: 1
            },
            {
              actionId: 3,
              actionEleType: 'className',
              actionDoType: 'click',
              actionUrl: null,
              missionId: 1,
              actionEleValue: 'submit_button',
              actionPreId: 2,
              actionAfterId: 4,
              actionName: '登陆',
              actionPragramId: null,
              actionElePragramId: 0
            },
            {
              actionId: 4,
              actionEleType: 'xpath',
              actionDoType: 'click',
              actionUrl: null,
              missionId: 1,
              actionEleValue: '//*[@id="form1"]/div[6]/ul/li[1]/a/div',
              actionPreId: 3,
              actionAfterId: 5,
              actionName: '打开每日一报',
              actionPragramId: null,
              actionElePragramId: 0
            },
            {
              actionId: 5,
              actionEleType: 'xpath',
              actionDoType: 'click',
              actionUrl: null,
              missionId: 1,
              actionEleValue: '/html/body/form/div[5]/div/div[2]/div[1]/div[2]/div[2]/div/span/i',
              actionPreId: 4,
              actionAfterId: 6,
              actionName: '点',
              actionPragramId: null,
              actionElePragramId: 0
            },
            {
              actionId: 6,
              actionEleType: 'xpath',
              actionDoType: 'click',
              actionUrl: null,
              missionId: 1,
              actionEleValue: '//*[@id="fineui_2"]/div[2]/div/label',
              actionPreId: 5,
              actionAfterId: 7,
              actionName: '点',
              actionPragramId: null,
              actionElePragramId: 0
            },
            {
              actionId: 7,
              actionEleType: 'id',
              actionDoType: 'input',
              actionUrl: null,
              missionId: 1,
              actionEleValue: 'p1_TiWen-inputEl',
              actionPreId: 6,
              actionAfterId: 8,
              actionName: null,
              actionPragramId: 3,
              actionElePragramId: 1
            },
            {
              actionId: 8,
              actionEleType: 'xpath',
              actionDoType: 'click',
              actionUrl: null,
              missionId: 1,
              actionEleValue: '/html/body/form/div[5]/div/div[2]/div[2]/div/div/a[1]',
              actionPreId: 7,
              actionAfterId: 9,
              actionName: null,
              actionPragramId: null,
              actionElePragramId: null
            },
            {
              actionId: 9,
              actionEleType: 'xpath',
              actionDoType: 'click',
              actionUrl: null,
              missionId: 1,
              actionEleValue: '/html/body/div[3]/div[2]/div[2]/div/div/a[1]',
              actionPreId: 8,
              actionAfterId: 10,
              actionName: null,
              actionPragramId: null,
              actionElePragramId: null
            },
            {
              actionId: 10,
              actionEleType: 'xpath',
              actionDoType: 'click',
              actionUrl: null,
              missionId: 1,
              actionEleValue: '/html/body/div[3]/div[2]/div[1]/table/tr/td[2]/div',
              actionPreId: 9,
              actionAfterId: null,
              actionName: null,
              actionPragramId: null,
              actionElePragramId: null
            }
          ],
          actionVos: [
            {
              jsoupAction: {
                actionId: 1,
                actionEleType: 'id',
                actionDoType: 'input',
                actionUrl: null,
                missionId: 1,
                actionEleValue: 'username',
                actionPreId: 0,
                actionAfterId: 2,
                actionName: '输入用户名',
                actionPragramId: 1,
                actionElePragramId: 1
              },
              actionOrder: {
                actionOrderId: 1,
                actionId: 1,
                missionId: 1,
                missionAllId: null,
                rank: 1
              },
              jsoupPragram: {
                pragramId: 1,
                missionId: 1,
                actionId: 1,
                pragramType: null,
                pragramAccuracy: null,
                isRamdom: null,
                upNum: null,
                downNum: null,
                pragramValue: '20171130316',
                missionAllId: null,
                programContent: null
              }
            },
            {
              jsoupAction: {
                actionId: 2,
                actionEleType: 'id',
                actionDoType: 'input',
                actionUrl: null,
                missionId: 1,
                actionEleValue: 'password',
                actionPreId: 1,
                actionAfterId: 3,
                actionName: '输入密码',
                actionPragramId: 2,
                actionElePragramId: 1
              },
              actionOrder: {
                actionOrderId: 2,
                actionId: 2,
                missionId: 1,
                missionAllId: null,
                rank: 2
              },
              jsoupPragram: {
                pragramId: 2,
                missionId: 1,
                actionId: 2,
                pragramType: null,
                pragramAccuracy: null,
                isRamdom: null,
                upNum: null,
                downNum: null,
                pragramValue: 'zhenlong112066',
                missionAllId: null,
                programContent: null
              }
            },
            {
              jsoupAction: {
                actionId: 3,
                actionEleType: 'className',
                actionDoType: 'click',
                actionUrl: null,
                missionId: 1,
                actionEleValue: 'submit_button',
                actionPreId: 2,
                actionAfterId: 4,
                actionName: '登陆',
                actionPragramId: null,
                actionElePragramId: 0
              },
              actionOrder: {
                actionOrderId: 3,
                actionId: 3,
                missionId: 1,
                missionAllId: null,
                rank: 3
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
            {
              jsoupAction: {
                actionId: 4,
                actionEleType: 'xpath',
                actionDoType: 'click',
                actionUrl: null,
                missionId: 1,
                actionEleValue: '//*[@id="form1"]/div[6]/ul/li[1]/a/div',
                actionPreId: 3,
                actionAfterId: 5,
                actionName: '打开每日一报',
                actionPragramId: null,
                actionElePragramId: 0
              },
              actionOrder: {
                actionOrderId: 4,
                actionId: 4,
                missionId: 1,
                missionAllId: null,
                rank: 4
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
            {
              jsoupAction: {
                actionId: 5,
                actionEleType: 'xpath',
                actionDoType: 'click',
                actionUrl: null,
                missionId: 1,
                actionEleValue: '/html/body/form/div[5]/div/div[2]/div[1]/div[2]/div[2]/div/span/i',
                actionPreId: 4,
                actionAfterId: 6,
                actionName: '点',
                actionPragramId: null,
                actionElePragramId: 0
              },
              actionOrder: {
                actionOrderId: 5,
                actionId: 5,
                missionId: 1,
                missionAllId: null,
                rank: 5
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
            {
              jsoupAction: {
                actionId: 6,
                actionEleType: 'xpath',
                actionDoType: 'click',
                actionUrl: null,
                missionId: 1,
                actionEleValue: '//*[@id="fineui_2"]/div[2]/div/label',
                actionPreId: 5,
                actionAfterId: 7,
                actionName: '点',
                actionPragramId: null,
                actionElePragramId: 0
              },
              actionOrder: {
                actionOrderId: 6,
                actionId: 6,
                missionId: 1,
                missionAllId: null,
                rank: 6
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
            {
              jsoupAction: {
                actionId: 7,
                actionEleType: 'id',
                actionDoType: 'input',
                actionUrl: null,
                missionId: 1,
                actionEleValue: 'p1_TiWen-inputEl',
                actionPreId: 6,
                actionAfterId: 8,
                actionName: null,
                actionPragramId: 3,
                actionElePragramId: 1
              },
              actionOrder: {
                actionOrderId: 7,
                actionId: 7,
                missionId: 1,
                missionAllId: null,
                rank: 7
              },
              jsoupPragram: {
                pragramId: 3,
                missionId: 1,
                actionId: 7,
                pragramType: null,
                pragramAccuracy: 1,
                isRamdom: 1,
                upNum: 36.8,
                downNum: 36.2,
                pragramValue: '',
                missionAllId: null,
                programContent: null
              }
            },
            {
              jsoupAction: {
                actionId: 8,
                actionEleType: 'xpath',
                actionDoType: 'click',
                actionUrl: null,
                missionId: 1,
                actionEleValue: '/html/body/form/div[5]/div/div[2]/div[2]/div/div/a[1]',
                actionPreId: 7,
                actionAfterId: 9,
                actionName: null,
                actionPragramId: null,
                actionElePragramId: null
              },
              actionOrder: {
                actionOrderId: 8,
                actionId: 8,
                missionId: 1,
                missionAllId: null,
                rank: 8
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
            {
              jsoupAction: {
                actionId: 9,
                actionEleType: 'xpath',
                actionDoType: 'click',
                actionUrl: null,
                missionId: 1,
                actionEleValue: '/html/body/div[3]/div[2]/div[2]/div/div/a[1]',
                actionPreId: 8,
                actionAfterId: 10,
                actionName: null,
                actionPragramId: null,
                actionElePragramId: null
              },
              actionOrder: {
                actionOrderId: 9,
                actionId: 9,
                missionId: 1,
                missionAllId: null,
                rank: 9
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
            {
              jsoupAction: {
                actionId: 10,
                actionEleType: 'xpath',
                actionDoType: 'click',
                actionUrl: null,
                missionId: 1,
                actionEleValue: '/html/body/div[3]/div[2]/div[1]/table/tr/td[2]/div',
                actionPreId: 9,
                actionAfterId: null,
                actionName: null,
                actionPragramId: null,
                actionElePragramId: null
              },
              actionOrder: {
                actionOrderId: 10,
                actionId: 10,
                missionId: 1,
                missionAllId: null,
                rank: 10
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
            }
          ],
          jsoupMissionOrder: {
            missionOrderId: 1,
            moMissionId: 1,
            moMissionAllId: 1,
            moAddTime: '2021-01-06T07:44:28.000+00:00',
            moRank: 1
          },
          jsoupPragrams: [
            {
              pragramId: 1,
              missionId: 1,
              actionId: 1,
              pragramType: null,
              pragramAccuracy: null,
              isRamdom: null,
              upNum: null,
              downNum: null,
              pragramValue: '20171130316',
              missionAllId: null,
              programContent: null
            }
          ],
          actionOrders: [
            {
              actionOrderId: 1,
              actionId: 1,
              missionId: 1,
              missionAllId: null,
              rank: 1
            },
            {
              actionOrderId: 2,
              actionId: 2,
              missionId: 1,
              missionAllId: null,
              rank: 2
            },
            {
              actionOrderId: 3,
              actionId: 3,
              missionId: 1,
              missionAllId: null,
              rank: 3
            },
            {
              actionOrderId: 4,
              actionId: 4,
              missionId: 1,
              missionAllId: null,
              rank: 4
            },
            {
              actionOrderId: 5,
              actionId: 5,
              missionId: 1,
              missionAllId: null,
              rank: 5
            },
            {
              actionOrderId: 6,
              actionId: 6,
              missionId: 1,
              missionAllId: null,
              rank: 6
            },
            {
              actionOrderId: 7,
              actionId: 7,
              missionId: 1,
              missionAllId: null,
              rank: 7
            },
            {
              actionOrderId: 8,
              actionId: 8,
              missionId: 1,
              missionAllId: null,
              rank: 8
            },
            {
              actionOrderId: 9,
              actionId: 9,
              missionId: 1,
              missionAllId: null,
              rank: 9
            },
            {
              actionOrderId: 10,
              actionId: 10,
              missionId: 1,
              missionAllId: null,
              rank: 10
            }
          ]
        }
      ],
      jsoupMissionAll: {
        maId: 1,
        maName: '每日一报填报脚本',
        maTip: '填报脚本启动器',
        malStartUrl: 'https://hsm.sspu.edu.cn/selfreport/Default.aspx',
        maSuccessFileName: 'dam_tianbao',
        maUserId: 1,
        maNoticeEmail: 'cytern@foxmail.com',
        userId: 1
      },
      isOwner: 1
    }