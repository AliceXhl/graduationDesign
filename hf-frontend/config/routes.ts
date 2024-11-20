export default [
  {
    path: '/user',
    layout: false ,
    routes: [{ name: '登录', path: '/user/login', component: './User/Login' }],
  },
  { path: '/welcome', name: '欢迎', icon: 'smile', component: './Welcome' },
  {
    path: '/admin',
    name: '预测中心',
    icon: 'crown',
    access: 'canAdmin',
    routes: [
      { path: '/admin', redirect: '/admin/single-page' },
      { path: '/admin/single-page', name: '单用户预测', component: './Check/SingleCheck' },
      { path: '/admin/multi-page', name: '多用户预测', component: './Check/MultiCheck' },
    ],
  },
  { name: '信息管理', icon: 'table', path: '/list', component: './TableList' },
  { name: '个人中心', icon: 'table', path: '/center', component: './Personal' },
  { path: '/', redirect: '/welcome' },
  { path: '*', layout: false, component: './404' },
];
