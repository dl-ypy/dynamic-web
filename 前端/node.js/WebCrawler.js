//网络爬虫，读取到网页源码，然后可以进行其他操作
var http = require('http')
var url = 'http://www.imooc.com/learn/348'

function filterChapters(html) {
	
}

http.get(url, function(res){
	var html = ''
	res.on('data', function(data){
		html += data
	})
	
	res.on('end', function(){
		filterChapters(html)
	})
}).on('error', function(){
	console.log('获取数据出错！')
})