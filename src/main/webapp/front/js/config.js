
var projectName = '教学管理平台';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.jsp'
}, 
{
	name: '我的发布',
	url: '../forum/list-my.jsp'
},

{
	name: '我的收藏',
	url: '../storeup/list.jsp'
}
]


var indexNav = [

{
	name: '教学资源',
	url: './pages/jiaoxueziyuan/list.jsp'
}, 
{
	name: '作业发布',
	url: './pages/zuoyefabu/list.jsp'
}, 

{
	name: '论坛信息',
	url: './pages/forum/list.jsp'
}, 
{
	name: '新闻资讯',
	url: './pages/news/list.jsp'
},
{
	name: '留言反馈',
	url: './pages/messages/list.jsp'
}
]

var adminurl =  "http://localhost:8080/teachingManage/index.jsp";

var cartFlag = false

var chatFlag = false




var menu = [{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"学生信息","menuJump":"列表","tableName":"xueshengxinxi"}],"menu":"学生信息管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"教师信息","menuJump":"列表","tableName":"jiaoshixinxi"}],"menu":"教师信息管理"},{"child":[{"buttons":["新增","查看","修改","删除","查看评论"],"menu":"教学资源","menuJump":"列表","tableName":"jiaoxueziyuan"}],"menu":"教学资源管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"教学反馈","menuJump":"列表","tableName":"jiaoxuefankui"}],"menu":"教学反馈管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"教学答疑","menuJump":"列表","tableName":"jiaoxuedayi"}],"menu":"教学答疑管理"},{"child":[{"buttons":["新增","查看","修改","删除","查看评论"],"menu":"作业发布","menuJump":"列表","tableName":"zuoyefabu"}],"menu":"作业发布管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"作业","menuJump":"列表","tableName":"zuoye"}],"menu":"作业管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"我的收藏管理","tableName":"storeup"}],"menu":"我的收藏管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"管理员","tableName":"users"}],"menu":"管理员管理"},{"child":[{"buttons":["查看","修改","回复","删除"],"menu":"留言板管理","tableName":"messages"}],"menu":"留言板管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"论坛管理","tableName":"forum"}],"menu":"论坛管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"新闻资讯","tableName":"news"},{"buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"buttons":["查看","反馈信息","查看评论"],"menu":"教学资源列表","menuJump":"列表","tableName":"jiaoxueziyuan"}],"menu":"教学资源模块"},{"child":[{"buttons":["查看","做作业"],"menu":"作业发布列表","menuJump":"列表","tableName":"zuoyefabu"}],"menu":"作业发布模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"buttons":["查看评论","查看"],"menu":"教学资源","menuJump":"列表","tableName":"jiaoxueziyuan"}],"menu":"教学资源管理"},{"child":[{"buttons":["查看"],"menu":"教学反馈","menuJump":"列表","tableName":"jiaoxuefankui"}],"menu":"教学反馈管理"},{"child":[{"buttons":["查看"],"menu":"教学答疑","menuJump":"列表","tableName":"jiaoxuedayi"}],"menu":"教学答疑管理"},{"child":[{"buttons":["查看","查看评论"],"menu":"作业发布","menuJump":"列表","tableName":"zuoyefabu"}],"menu":"作业发布管理"},{"child":[{"buttons":["查看"],"menu":"作业","menuJump":"列表","tableName":"zuoye"}],"menu":"作业管理"}],"frontMenu":[{"child":[{"buttons":["查看","反馈信息","查看评论"],"menu":"教学资源列表","menuJump":"列表","tableName":"jiaoxueziyuan"}],"menu":"教学资源模块"},{"child":[{"buttons":["查看","做作业"],"menu":"作业发布列表","menuJump":"列表","tableName":"zuoyefabu"}],"menu":"作业发布模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"学生信息","tableName":"xueshengxinxi"},{"backMenu":[{"child":[{"buttons":["查看","新增","删除","修改","查看评论"],"menu":"教学资源","menuJump":"列表","tableName":"jiaoxueziyuan"}],"menu":"教学资源管理"},{"child":[{"buttons":["查看","答疑"],"menu":"教学反馈","menuJump":"列表","tableName":"jiaoxuefankui"}],"menu":"教学反馈管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"教学答疑","menuJump":"列表","tableName":"jiaoxuedayi"}],"menu":"教学答疑管理"},{"child":[{"buttons":["新增","查看","修改","删除","查看评论"],"menu":"作业发布","menuJump":"列表","tableName":"zuoyefabu"}],"menu":"作业发布管理"},{"child":[{"buttons":["查看"],"menu":"作业","menuJump":"列表","tableName":"zuoye"}],"menu":"作业管理"}],"frontMenu":[{"child":[{"buttons":["查看","反馈信息","查看评论"],"menu":"教学资源列表","menuJump":"列表","tableName":"jiaoxueziyuan"}],"menu":"教学资源模块"},{"child":[{"buttons":["查看","做作业"],"menu":"作业发布列表","menuJump":"列表","tableName":"zuoyefabu"}],"menu":"作业发布模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"教师信息","tableName":"jiaoshixinxi"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
