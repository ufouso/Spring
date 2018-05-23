
var vm = avalon.define({
	$id: "test",
	aaa: "aaa",
	toggle: false,
	bbb: "bbbb",
	ccc: 'ccc'
});

var vm1 = avalon.define({
	$id: "faker",
	name: "大魔王",
	obj: [{ name:"faker1"},{name: "faker2"},{name: "faker3"}],
	One: {title:"晚会", name:"张三", age: "17"},
	path: "image/mei.jpg",
	color1: "blue",
	color: {color:"red"},
	toggle: false,
	obj1: {backgroundColor: "blue",textAlign:"center"},
	aaa: "aaaas",
	bbb: "bbb"
});

var vm2 = avalon.define({
	$id: "TT",
	name: "汽车",
	array: [1,2,3,4,5],
	html: "<div>什么</div>",
	show: function(a, b, c){
//		此处需要注意的是获取对象的内容不能用点之后跟属性名,要使用中括号。
		var obj= a[b];
		if(obj){
			return obj[c];
		}
		return "";
	},
	one: {bbb: {ccc:"ccc"}}
});

var root = avalon.define({
    $id: 'root',
    getRootFun: function () {
        avalon.log('Root|'+new Date());
    },
    headerPage: '<p>this is headerPage</p>',//头部页面
    footerPage: '<p>this is footerPage</p>',//尾部页面
    currPath: '',//当前路径k
    currPage: ''//当前页面
});

var vm3 = avalon.define({
	$id: "testClick",
	name: "洪门",
	status: "",
	count1 : "",
	count2 : "",
	count3 : "",
	testOne: function(e, a, b){
		alert(JSON.stringify(this.name));
		//获取方法的参数，e,a,b,参数的具体数值。
		alert([].slice.call(arguments).join(" "));
	},
	testTwo: function(e){
		vm3.status = e.type;
	},
	testThree: function(e){
		//e.target.value获取的是你输入的值
		vm3.field = e.target.value+ " "+e.type; 
	},
	testFour: function(){
		//获取到的是vm3下面的所有数据，不包括方法。
		var data = vm3.$model;
		if(window.JSON){
			setTimeout(function(){
				alert(JSON.stringify(data));
			});
			
		}
	},
	testFive1: function(){
		vm3.count1++;
	},
	testFive2: function(){
		vm3.count2++;
	},
	testFive3: function(){
		vm3.count3++;
	}
});

var vm4 = avalon.define({
	$id: "testduplex",
	username:"",
	password:"",
	textArea:"",
	div: "",
	aaa: "33",
	bbb: "22"
});

