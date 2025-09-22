// Bài 1: Kiểm tra a có chia hết cho b không
let a = parseInt(prompt("Nhập số a:"));
let b = parseInt(prompt("Nhập số b:"));

if (b === 0) {
  alert("Không thể chia cho 0!");
} else if (a % b === 0) {
  alert(a + " chia hết cho " + b);
} else {
  alert(a + " không chia hết cho " + b);
}

// Bài 2: Kiểm tra tuổi vào lớp 10
let age = parseInt(prompt("Nhập tuổi học sinh:"));
if (age >= 15) {
  alert("Đủ điều kiện vào lớp 10");
} else {
  alert("Không đủ điều kiện vào lớp 10");
}

// Bài 3: Kiểm tra số nguyên lớn hơn, nhỏ hơn hay bằng 0
let number = parseInt(prompt("Nhập một số nguyên bất kỳ:"));
if (number > 0) {
  alert("Số " + number + " lớn hơn 0");
} else if (number < 0) {
  alert("Số " + number + " nhỏ hơn 0");
} else {
  alert("Số bạn nhập bằng 0");
}

// Bài 4: Tìm số lớn nhất trong 3 số
let x = parseInt(prompt("Nhập số thứ nhất:"));
let y = parseInt(prompt("Nhập số thứ hai:"));
let z = parseInt(prompt("Nhập số thứ ba:"));

let max = x;
if (y > max) max = y;
if (z > max) max = z;

alert("Số lớn nhất trong 3 số là: " + max);

// Bài 5: Xếp hạng học lực
let test = parseFloat(prompt("Nhập điểm bài kiểm tra:"));
let mid = parseFloat(prompt("Nhập điểm thi giữa kỳ:"));
let final = parseFloat(prompt("Nhập điểm thi cuối kỳ:"));

let average = (test + mid * 2 + final * 3) / 6;

let grade;
if (average >= 9) {
  grade = "Xuất Sắc";
} else if (average >= 8) {
  grade = "Giỏi";
} else if (average >= 6.5) {
  grade = "Khá";
} else if (average >= 5) {
  grade = "Trung Bình";
} else {
  grade = "Yếu";
}

alert("Điểm trung bình: " + average.toFixed(2) + " → Học lực: " + grade);
