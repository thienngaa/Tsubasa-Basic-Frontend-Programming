let output = document.getElementById("output");

// Bài 1: Đảo ngược mảng ký tự
let arr1 = prompt("Bài 1 - Nhập dãy ký tự cách nhau bởi dấu phẩy, ví dụ: c,s,c,2,6,1").split(",").map(x=>x.trim());
let reversed1 = [...arr1].reverse().join("");
output.innerText += "Bài 1 - Dãy đảo ngược: " + reversed1 + "\n\n";

// Bài 2: Đếm ký tự số trong mảng
let arr2 = prompt("Bài 2 - Nhập mảng ký tự cách nhau bởi dấu phẩy").split(",").map(x=>x.trim());
let digitCount = arr2.filter(ch => !isNaN(parseInt(ch))).length;
output.innerText += "Bài 2 - Số ký tự số: " + digitCount + "\n\n";

// Bài 3: Đếm số ký tự trong chuỗi
let str3 = prompt("Bài 3 - Nhập chuỗi:");
output.innerText += "Bài 3 - Số ký tự trong chuỗi: " + str3.length + "\n\n";

// Bài 4: So sánh hai chuỗi
let strA = prompt("Bài 4 - Nhập chuỗi thứ nhất:");
let strB = prompt("Bài 4 - Nhập chuỗi thứ hai:");
let equal = strA === strB ? "giống nhau" : "khác nhau";
output.innerText += `Bài 4 - Hai chuỗi ${equal}\n\n`;

// Bài 5: Thay ký tự '-' bằng '_'
let arr5 = prompt("Bài 5 - Nhập mảng ký tự cách nhau bởi dấu phẩy").split(",").map(x=>x.trim());
let replaced5 = arr5.map(ch => ch === "-" ? "_" : ch);
output.innerText += "Bài 5 - Mảng sau khi thay '-' bằng '_': " + replaced5.join(", ") + "\n\n";
