<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2016/4/6
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>活跃用户统计</title>
    <script type='text/javascript' src='/ssm/js/highcharts.js'></script>
    <script type='text/javascript' src='/ssm/js/exporting.js'></script>
    <script type='text/javascript' src='/ssm/js/export-csv.js'></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<button id="getcsv">获取Csv数据</button>
<button id="download">导出数据到Excel</button>

<div id="container">

</div>

<!--
<%//${request.contextPath};%>
<link rel='stylesheet' href='webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
<script type='text/javascript' src='webjars/jquery/1.9.0/jquery.min.js'></script>
<script type='text/javascript' src='webjars/bootstrap/3.1.0/js/bootstrap.min.js'></script>
-->
<script type='text/javascript'>
    a = '${dates}';
    b = '${counts}';
    console.log(a.split(' '));
    console.log(b.split(' '));
    var arr_data = b.split(' ');
    for (var i = 0; i < arr_data.length; ++i) {
        arr_data[i] = arr_data[i].length > 0 ? arr_data[i] * 1 : 0;
    }
    console.log(arr_data);

    $(function () {
        //alert(${dates});
        var chart = new Highcharts.Chart({
            chart: {
                renderTo: 'container'
            },

            title: {
                text: '活跃用户趋势',
                x: -20 //center
            },
            xAxis: {
                categories: a.split(' ')
//                        ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
//                    'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
            },
            yAxis: {
                title: {
                    text: '活跃用户人数'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                valueSuffix: '人'
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            series: [{
                name: '活跃用户',
                data: arr_data
//                        [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
            }]
        });

        $('#getcsv').click(function () {
            alert(chart.getCSV());
        });

        $("#download").click(function () {
            Highcharts.post('http://export.hcharts.cn/cvs.php', {
                csv: chart.getCSV()
            });
        })
    });
</script>
</body>
</html>
