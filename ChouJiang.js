// each 循环遍历的意思
// $(".user .name") 选择器选择节点，它是一个节点集合。
// each(这里的函数被称为回调函数)
// jQuery 库在调用这个回调函数的时候，会自动给这个回调函数传两个参数
// 第一个参数 index（只是一个变量名）：index 是元素的下标，下表从 0 开始，以 1 递增。
// 第二个参数 item（只是一个变量名）：item 代表的就是集合中的当前遍历到的元素。
// console.log(index)
// item 是 dom 节点（原生的 JavaScript 对象）。不是 jquery 对象。不能使用 jQuery 对象的方法/函数。
// 怎么把 dom 对象转换成 jQuery 对象？
// item 是一个 <a> 标签对象，属于 dom 对象。dom 对象有 innerHTML/innerText 属性，可以获取元素中文本内容。
// 大致的思路：将取到的用户名放到一个数组当中，然后生成随机数，随机数是数组的下标。
var arr = new Array();
$(".user .name").each(function (index, item) {
    // console.log(item.innerText)
    // 怎么把 dom 对象转换成 jQuery 对象呢？
    // $(dom 对象) 就是一个 jQuery 对象
    // jQuery 对象可以使用 jQuery 的方法/函数
    // console.log(index + "=" + $(item).text())
    arr.push($(item).text());
});

console.log(arr.join(", "));

// 生成随机数，以随机数作为数组的下标
var myIndex = Math.round(Math.random() * arr.length);
console.log("中奖的老铁对应的数组下标：" + myIndex);
console.log("中奖的老铁是：" + arr[myIndex]);
