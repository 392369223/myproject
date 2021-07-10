<%@ page import="com.project.bean.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/6/30
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="./css/mainSheet.css" rel="stylesheet">
    <title>闲鱼网上书城</title>
    <style type="text/css">
        .cc{
            display: flex;
            flex-wrap: wrap;
        }
        .mycc{
            border: #bd2c00 4px solid;
            overflow: auto;
        }
        .mydefine{
            margin-left: 10px;
            margin-right: 10px;
        }
    </style>
</head>
<body>
<!--头部导航-->
<nav class="nav">
    <div class="header w">
        <div class="location">
            <label>
                <img src="./image/zb.png"/>
            </label>
            <a href="#">湖南</a>
        </div>
        <div class="r_nav">
            <ul>
                <li>
                    <c:choose>
                        <c:when test="${not empty sessionScope.uname}">
                            <label>${sessionScope.uname}</label>
                        </c:when>
                        <c:otherwise>
                            <a href="login.jsp" style="color: red">你好，请登录</a>
                            <a href="Reg.jsp">免费注册</a>
                        </c:otherwise>
                    </c:choose>
                </li>
                <li class="line"></li>
                <li>
                    <a href="sell">我卖出的书</a>
                    <label>
                        <img src="./image/order.png"/>
                    </label>
                </li>
                <li class="line"></li>
                <li>
                    <a href="median">我买的书</a>
                    <label>
                        <img src="./image/hj.png"/>
                    </label>
                </li>
                <li class="line"></li>
                <li>
                    <a href="sale">我的卖书列表</a>
                    <label>
                        <img src="./image/dh.png">
                    </label>
                </li>
                <li>
                    <a href="modify"><label>修改个人信息</label></a>
                    <label>
                        <img src="./image/dh.png">
                    </label>
                </li>
                <li class="line"></li>
                <li>
                    <a href="upload.jsp">提供卖书信息</a>
                    <label>
                        <img src="./image/kefu.png"/>
                    </label>
                </li>
                <li>
                    <a href="money">我的钱包</a>
                    <label>
                        <img src="./image/kefu.png"/>
                    </label>
                </li>
                <li>
                    <a href="login.jsp">退出登录</a>
                </li>
                <li class="line"></li>
            </ul>
        </div>
    </div>
</nav>
<!--导航结束-->
<!--搜索栏开始-->
<div class="m_nav w">
    <div class="logo">
        <a href="#">闲鱼书城
            <label>
                <img src="image/book.jpg" width="180"height="100" >
            </label></a>
    </div>
    <div class="search_box">
        <form method="post" action="search2">
        <input type="text" name="name1" class="search" placeholder="伟大的中国" autofocus>&nbsp;
        <input type="submit" class="btn" value="搜索">
        <label>
            <img src="image/ss.png"/>
        </label>
        </form>
    </div>
    <div class="cart">
        <!--<b class="Hui-iconfont"></b>-->
        <label><img src="./image/gwc.png"/></label>
        <a href="shop">我的购物车</a>
    </div>
    <div class="hot_word">
        <ul>
            <li><a href="#" style="color: red">我们仨</a></li>
            <li><a href="#">新品上市</a></li>
            <li><a href="#">历史书好物</a></li>
        </ul>
    </div>
    <div class="nav_item " align="center">
        <ul>
            <li>
                <a href="#">劲爆低价</a>
            </li>
            <li>
                <a href="#">超高销量</a>
            </li>
            <li>
                <a href="#">超值限量</a>
            </li>
            <li>
                <a href="#">即买即得</a>
            </li>
        </ul>
    </div>
</div>
<!--搜索栏结束-->
<!--主体开始-->
<div class="content">
    <div class="main_body w">
        <div class="banner">
            <!--左侧的轮动框-->
            <div class="left_banner" align="center">
                <ul>
                    <li>
                        <a href="#" id="book_top">书本类型</a>
                    </li>
                    <li>
                        <a href="search?key=人生">人生</a>
                    </li>
                    <li>
                        <a href="search?key=国家">国家</a>
                    </li>
                    <li>
                        <a href="search?key=言情">言情</a>
                    </li>
                    <li>
                        <a href="search?key=历史">历史</a>
                    </li>
                    <li>
                        <a href="search?key=生活">生活</a>
                    </li>
                    <li>
                        <a href="search?key=亲情">亲情</a>
                    </li>
                    <li>
                        <a href="search?key=名著">名著</a>
                    </li>
                    <li>
                        <a href="#book_top">回到顶部</a>
                    </li>
                </ul>
            </div>
            <!--右侧轮动，功能性元素-->
            <div class="middle_banner cc mycc">
                <c:forEach items="${sessionScope.books}" var="v">
                <a class="mydefine" href="purchase?bookid=${v.id}&salename=${v.saler}&bookname=${v.name}&path=${v.path}&num=${v.count}" target="_blank" style="display: flex;align-items: center;flex-direction: column">
                    <img src="${v.path}" width="220px" height="300px">
                    <p>${v.name}&nbsp;&nbsp;${v.prise}</p>
                 </c:forEach>
            </div>
            <div class="right_banner">
                <div class="top_user">
                    <!-- 用户等录信息 -->
                    <div class="login_msg clearfix">
                        <a href="#" class="no_login">
                            <img src="./image/1.JPEG" alt="">
                        </a>
                        <div class="text">
                            <p>咸鱼书城，买一本到一本</p>
                            <p>
                            <div class="buttons">
                                <input type="button" class="button" value="登录" id="edit"
                                       onClick="window.location.href='Reg.jsp'">&nbsp;
                                <input type="button" class="button" value="注册" id="del"
                                       onclick="window.location.href='login.jsp'">
                            </div>
                            </p>
                        </div>
                    </div>
                </div>
                <!--新闻啊，链接啊房子啊这里-->
                <div class="title">
                    <div class="top_title">
                        <span class="hot_title">首页推送</span>
                        <a href="https://www.baidu.com">更多
                            <span class="title_span">></span>
                        </a>
                    </div>
                    <div class="content_title">
                        <div class="public">
                            <a href="#" class="box">公告</a>
                            <a href="https://gkcx.eol.cn/">2022高考</a>
                        </div>
                        <div class="public">
                            <a href="#" class="box">最新</a>
                            <a href="https://baike.baidu.com/item/%E6%9A%91%E5%81%87/6077671">实训逼近尾声</a>
                        </div>
                        <div class="public">
                            <a href="#" class="box">最新</a>
                            <a href="https://baike.baidu.com/item/%E5%9B%9E%E5%AE%B6">马上就要放假</a>
                        </div>
                        <div class="public">
                            <a href="#" class="box">最新</a>
                            <a href="https://www.csust.edu.cn/">长沙理工大学</a>
                        </div>
                    </div>
                </div>
                <div class="bottom_user">
                    <img src="image/2.JPEG" alt="">
                </div>
            </div>
        </div>
    </div>
</div>
<!--主体结束-->
<!--底部开始-->
<div class="footer ">
    <div class="top_footer">
        <div class="w">
            <ul>
                <li>
                    <span>自产自销 消费自由</span>
                </li>
                <li>
                    <span>一件发货 权益保障</span>
                </li>
                <li>
                    <span> 无中间商 直接交易</span>
                </li>
                <li>
                    <span>种类繁多 任君选择</span>
                </li>
            </ul>
        </div>
    </div>
    <div class="middle_footer  w">
        <dl>
            <dt>购物指南</dt>
            <dd>购物流程</dd>
            <dd>会员介绍</dd>
            <dd>品类选择</dd>
            <dd>常见问题</dd>
            <dd>意见反馈</dd>
            <dd>联系客服</dd>
        </dl>
        <dl>
            <dt>配送方式</dt>
            <dd>上门自提</dd>
            <dd>211限时达</dd>
            <dd>配送服务查询</dd>
            <dd>配送费收取标准</dd>
            <dd>海外配送</dd>
        </dl>
        <dl>
            <dt>支付方式</dt>
            <dd>货到付款</dd>
            <dd>在线支付</dd>
            <dd>分期付款</dd>
        </dl>
        <dl>
            <dt>售后服务</dt>
            <dd>售后政策</dd>
            <dd>价格保护</dd>
            <dd>退款说明</dd>
            <dd>返修/退换货</dd>
            <dd>取消订单</dd>
        </dl>
        <dl>
            <dt>特色服务</dt>
            <dd>DIY装机</dd>
            <dd>延保服务</dd>
            <dd>咸鱼VIP</dd>
        </dl>
        <dl class="last-dl">
            <dt>网络书城 全国畅享</dt>
            <dd>
                <p>面向全国众多网民提供购买销售一体化平台，便携贴心</p>
                <a href="#">查看详情</a>
            </dd>
        </dl>
    </div>
    <div class="bottom_footer">
        <p>
            <a href="#">关于我们</a><span>|</span>
            <a href="#">联系我们</a><span>|</span>
            <a href="#">联系客服</a><span>|</span>
            <a href="#">合作招商</a><span>|</span>
            <a href="#">商家帮助</a><span>|</span>
            <a href="#">营销中心</a><span>|</span>
            <a href="#">友情链接</a><span>|</span>
            <a href="#">销售联盟</a><span>|</span>
            <a href="#">风险监测</a><span>|</span>
            <a href="#">隐私政策</a><span>|</span>
            <a href="#">English Site</a><span>|</span>
            <a href="#">Media & IR</a>
        </p>
        <p class="public">
            <a href="#">京公网安备 11000002000088号</a><span>|</span>
            <a href="#">京ICP证070359号</a><span>|</span>
            <a href="#">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a><span>|</span>
            <a href="#">新出发京零 字第大120007号</a>
        </p>
        <p class="public">
            <a href="#">互联网出版许可证编号新出网证(京)字150号</a><span>|</span>
            <a href="#">出版物经营许可证</a><span>|</span>
            <a href="#">网络文化经营许可证京网文[2014]2148-348号</a><span>|</span>
            <a href="#">违法和不良信息举报电话：4006561155</a>
        </p>
        <p class="public">
            <a href="#">Copyright © 2004 - 2020  京东JD.com 版权所有</a><span>|</span>
            <a href="#">消费者维权热线：4006067733经营证照</a><span>|</span>
            <a href="#">(京)网械平台备字(2018)第00003号</a><span>|</span>
            <a href="#">营业执照</a>
        </p>
        <p class="public">
            <a href="#">Global Site|Сайт России</a><span>|</span>
            <a href="#">Situs Indonesia</a><span>|</span>
            <a href="#">Sitio de España</a><span>|</span>
            <a href="#">เว็บไซต์ประเทศไทย</a>
        </p>
        <p class="public">
            <a href="#">支持微信支付</a><span>|</span>
            <a href="#">支付宝支付</a>
        </p>
    </div>
</div>
<!--底部结束-->
</body>
</html>
