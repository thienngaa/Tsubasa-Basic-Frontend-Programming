let output = document.getElementById("output");

// Bài 1: Mảng 10 số nguyên, đếm số >= 10
let arr1 = [];
for(let i=0;i<10;i++){
  arr1.push(parseInt(prompt(`Bài 1 - Nhập số nguyên thứ ${i+1}:`)));
}
let count10 = arr1.filter(x => x >= 10).length;
output.innerText += "Bài 1: Có " + count10 + " số >=10\n\n";

// Bài 2: Mảng 10 số nguyên khác nhau, tìm max và vị trí
let arr2 = [];
while(arr2.length < 10){
  let num = parseInt(prompt(`Bài 2 - Nhập số nguyên thứ ${arr2.length+1} (khác nhau):`));
  if(!arr2.includes(num)) arr2.push(num);
  else alert("Số này đã tồn tại, nhập số khác");
}
let max2 = Math.max(...arr2);
let index2 = arr2.indexOf(max2);
output.innerText += "Bài 2: Giá trị lớn nhất: " + max2 + ", vị trí: " + index2 + "\n\n";

// Bài 3: Mảng số nguyên, tìm max và trung bình
let n3 = parseInt(prompt("Bài 3 - Nhập số lượng phần tử mảng:"));
let arr3 = [];
for(let i=0;i<n3;i++){
  arr3.push(parseInt(prompt(`Nhập phần tử thứ ${i+1}:`)));
}
let max3 = Math.max(...arr3);
let avg3 = arr3.reduce((a,b)=>a+b,0)/arr3.length;
output.innerText += "Bài 3: Max = " + max3 + ", Trung bình = " + avg3.toFixed(2) + "\n\n";

// Bài 4: Đảo ngược mảng
let n4 = parseInt(prompt("Bài 4 - Nhập số lượng phần tử mảng:"));
let arr4 = [];
for(let i=0;i<n4;i++){
  arr4.push(parseInt(prompt(`Nhập phần tử thứ ${i+1}:`)));
}
let arr4Reversed = [...arr4].reverse();
output.innerText += "Bài 4: Mảng đảo ngược: " + arr4Reversed.join(", ") + "\n\n";

// Bài 5: Đếm số âm trong chuỗi
let str5 = prompt("Bài 5 - Nhập chuỗi số, cách nhau bởi dấu phẩy:");
let arr5 = str5.split(",").map(x=>parseInt(x.trim()));
let negCount = arr5.filter(x => x < 0).length;
output.innerText += "Bài 5: Số lượng số âm = " + negCount + "\n\n";

// Bài 6: Tìm số nhập vào trong mảng 10 phần tử
let arr6 = [];
for(let i=0;i<10;i++){
  arr6.push(parseInt(prompt(`Bài 6 - Nhập số nguyên thứ ${i+1}:`)));
}
let num6 = parseInt(prompt("Nhập số để kiểm tra có trong mảng không:"));
if(arr6.includes(num6)){
  output.innerText += "Bài 6: Number " + num6 + " is in the array\n\n";
} else {
  output.innerText += "Bài 6: Number " + num6 + " is not in the array\n\n";
}

// Bài 7: Sắp xếp mảng 10 phần tử giảm dần
let arr7 = [];
for(let i=0;i<10;i++){
  arr7.push(parseInt(prompt(`Bài 7 - Nhập số nguyên thứ ${i+1}:`)));
}
arr7.sort((a,b)=>b-a);
output.innerText += "Bài 7: Mảng giảm dần: " + arr7.join(", ") + "\n\n";

// Bài 8: Nối 2 mảng a và b
let arrA = [];
let arrB = [];
for(let i=0;i<10;i++){
  arrA.push(parseInt(prompt(`Bài 8 - Nhập phần tử thứ ${i+1} của mảng a:`)));
}
for(let i=0;i<10;i++){
  arrB.push(parseInt(prompt(`Bài 8 - Nhập phần tử thứ ${i+1} của mảng b:`)));
}
let arrC = arrB.concat(arrA);
output.innerText += "Bài 8: Mảng c (b nối a) = " + arrC.join(", ") + "\n\n";
