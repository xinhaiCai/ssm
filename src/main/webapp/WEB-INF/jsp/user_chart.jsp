<%@ page import="com.jackie.util.DateUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    #userStatistic span {
        margin-left: 20px;
        margin-right: 20px;
    }
</style>
<head>
    <title>用户数概况</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="userStatistic">
    <table width=100% border="1">
        <caption style="font-size: large">用户统计概况</caption>
        <tr style="background-color:#EEEEEE;">
            <td colspan="3">
                关键指标概况 &nbsp <span id="today"></span> 对比
                <input type="date" id="selectDate" value=${anotherDay}>
                <button id="oneDay" onclick=compareSelectDay()>对比</button>
                &nbsp&nbsp&nbsp&nbsp
                <button id="yesterday" onclick=compareYesterday()>对比昨天</button>
                <button id="lastWeek" onclick=compareLastWeek()>对比上周</button>
            </td>
        </tr>

        <tr>
            <td style="background-color:#F5FFFA;text-align:center;">
                <a href="#" class="tooltip-test" data-toggle="tooltip"
                   title="指截止到当前日期，注册的用户数量">?</a>累计用户数<span id="userCount"></span>
                <br>对比<span id="userCountVariation"></span> | <span id="userCountVariationPercent"></span>
            </td>
            <td style="background-color:#F5FFFA;text-align:center;">
                <a href="#" class="tooltip-test" data-toggle="tooltip"
                   title="指截止到当前日期，登录过的所有独立用户">?</a>活跃用户数<span id="activeUserCount"></span>
                <br>对比<span id="activeUserCountVariation"></span> | <span id="activeUserCountVariationPercent"></span>
            </td>
            <td style="background-color:#F5FFFA;text-align:center;">
                <a href="#" class="tooltip-test" data-toggle="tooltip"
                   title="指新增加的注册用户">?</a>新增用户数<span id="growUserCount"></span>
                <br>对比<span id="growUserCountVariation"></span> | <span id="growUserCountVariationPercent"></span>
            </td>
        </tr>


    </table>
</div>
<script>
    $(function () {
        var _today = getDateBefore(0);
        $("#today").html(_today);
        compareLastWeek();
    });


    function getDateBefore(before)  //获取before天前的日期，获取今天则before为0
    {
        var _myDate, _myDateStr;
        _myDate = new Date(new Date() - 1000 * 60 * 60 * 24 * before);
        var yyyy = _myDate.getFullYear();//取四位年份
        var MM = _myDate.getMonth() + 1;//取月份
        if (MM < 10) {
            MM = "0" + MM;
        }
        var dd = _myDate.getDate();//取日
        if (dd < 10) {
            dd = "0" + dd;
        }
        _myDateStr = yyyy + "-" + MM + "-" + dd;
        return _myDateStr;
    }

    /**
     * 获取当天对比某一天的用户统计数据
     * @param date
     */
    function compare(date) {
        $("#selectDate").val(date);
        $.get("/ssm/user/chart/query", {
                    date: date
                },
                function (result) {
                    alert(JSON.stringify(result));
                    var _today = result.today;
                    var _anotherDay = result.anotherDay;
                    if (_anotherDay == null) {
                        alert("没有" + date + "的数据，无法对比,请选择其它日期");
                        return;
                    }
                    //累计用户增长数及增长百分比计算
                    var _userCountVariation = _today.userCount - _anotherDay.userCount;
                    var _userCountVariationPercent = _userCountVariation / _anotherDay.userCount * 100;
                    //活跃用户增长数及增长百分比计算
                    var _activeUserCountVariation = _today.activeUserCount - _anotherDay.activeUserCount;
                    var _activeUserCountVariationPercent = _activeUserCountVariation / _anotherDay.activeUserCount * 100;
                    //新增用户增长数及增长百分比计算
                    var _growUserCountVariation = _today.growUserCount - _anotherDay.growUserCount;
                    var _growUserCountVariationPercent = _growUserCountVariation / _anotherDay.growUserCount * 100;
                    //累计用户增长数及增长百分比显示
                    $("#userCount").html(_today.userCount);
                    $("#userCountVariation").html(_userCountVariation >= 0 ?
                    '&uArr;' + _userCountVariation : '&dArr;' + (-_userCountVariation));
                    $("#userCountVariationPercent").html(_userCountVariationPercent + "%");
                    //活跃用户增长数及增长百分比显示
                    $("#activeUserCount").html(_today.activeUserCount);
                    $("#activeUserCountVariation").html(_activeUserCountVariation >= 0 ?
                    '&uArr;' + _activeUserCountVariation : '&dArr;' + (-_activeUserCountVariation));
                    $("#activeUserCountVariationPercent").html(_activeUserCountVariationPercent + "%");
                    //新增用户增长数及增长百分比显示
                    $("#growUserCount").html(_today.growUserCount);
                    $("#growUserCountVariation").html(_growUserCountVariation >= 0 ?
                    '&uArr;' + _growUserCountVariation : '&dArr;' + (-_growUserCountVariation));
                    $("#growUserCountVariationPercent").html(_growUserCountVariationPercent + "%");
                });
    }

    function compareSelectDay() {
        var _selectDay = $("#selectDate").val();
        compare(_selectDay);
    }

    function compareYesterday() {
        var _yesterday = getDateBefore(1);
        compare(_yesterday);
    }

    function compareLastWeek() {
        var _lastWeek = getDateBefore(7);
        compare(_lastWeek);
    }


</script>
</body>
</html>
