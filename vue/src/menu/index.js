import { uniqueId } from 'lodash'

/**
 * @description 给菜单数据补充上 path 字段
 * @description https://github.com/d2-projects/d2-admin/issues/209
 * @param {Array} menu 原始的菜单数据
 */
function supplementPath (menu) {
  return menu.map(e => ({
    ...e,
    path: e.path || uniqueId('d2-menu-empty-'),
    ...e.children ? {
      children: supplementPath(e.children)
    } : {}
  }))
}

export const menuHeader = supplementPath([
  { path: '/index', title: '首页', icon: 'home' },

])

export const menuAside = supplementPath([
  { path: '/index', title: '首页', icon: 'home' },
      {
        title: '商城',
        icon: 'window-restore',
        children: [
          { path: '/scriptShop', title: '脚本市场',icon: 'user-o' },
          { path: '/resShop', title: '数据市场',icon: 'podcast' },
        ]
      },
      {
        title: '我的',
        icon: 'window-restore',
        children: [
          { path: '/studentConf', title: '我的信息',icon: 'user-o' },
          { path: '/myScript', title: '我的脚本',icon: 'podcast' },
          { path: '/myReason', title: '我的结果',icon: 'ravelry' },
        ]
      },
      {
        title: '开发',
        icon: 'window-restore',
        children: [
          { path: '/myEditScript', title: '开发脚本',icon: 'user-o' },
      { path: '/studentCharts', title: '编写教程',icon: 'podcast' },
      { path: '/goodDetail', title: '商品详情',icon: 'podcast' },
        ]
      },
     
     
    
      // { path: '/notice', title: '开发帮助',icon: 'ravelry' },

  
  
])
