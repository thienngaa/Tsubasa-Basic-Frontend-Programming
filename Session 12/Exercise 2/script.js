// Bài 1: Chuyển từ độ C sang độ F
let c = parseFloat(prompt("Bài 1 - Nhập độ C:"));
let f = (c * 9/5) + 32;
alert(c + "°C = " + f.toFixed(2) + "°F");

// Bài 2: Chuyển từ mét sang feet
let m = parseFloat(prompt("Bài 2 - Nhập mét:"));
let feet = m * 3.2808;
alert(m + " mét = " + feet.toFixed(2) + " feet");

// Bài 3: Diện tích hình vuông
let a = parseFloat(prompt("Bài 3 - Nhập cạnh hình vuông a:"));
let sSquare = a * a;
alert("Diện tích hình vuông = " + sSquare);

// Bài 4: Diện tích hình chữ nhật
let a1 = parseFloat(prompt("Bài 4 - Nhập cạnh a:"));
let b1 = parseFloat(prompt("Bài 4 - Nhập cạnh b:"));
let sRectangle = a1 * b1;
alert("Diện tích hình chữ nhật = " + sRectangle);

// Bài 5: Diện tích tam giác vuông
let a2 = parseFloat(prompt("Bài 5 - Nhập cạnh kề a:"));
let b2 = parseFloat(prompt("Bài 5 - Nhập cạnh kề b:"));
let sTriangle = (a2 * b2) / 2;
alert("Diện tích tam giác vuông = " + sTriangle);

// Bài 6: Giải phương trình bậc 1: ax + b = 0
let a3 = parseFloat(prompt("Bài 6 - Nhập hệ số a:"));
let b3 = parseFloat(prompt("Bài 6 - Nhập hệ số b:"));

if (a3 === 0) {
  if (b3 === 0) {
    alert("Phương trình vô số nghiệm");
  } else {
    alert("Phương trình vô nghiệm");
  }
} else {
  let x = -b3 / a3;
  alert("Nghiệm của phương trình là x = " + x);
}

// Bài 7: Giải phương trình bậc 2: ax^2 + bx + c = 0
let a4 = parseFloat(prompt("Bài 7 - Nhập hệ số a:"));
let b4 = parseFloat(prompt("Bài 7 - Nhập hệ số b:"));
let c4 = parseFloat(prompt("Bài 7 - Nhập hệ số c:"));

if (a4 === 0) {
  // Trở thành bậc 1
  if (b4 === 0) {
    if (c4 === 0) {
      alert("Phương trình vô số nghiệm");
    } else {
      alert("Phương trình vô nghiệm");
    }
  } else {
    let x = -c4 / b4;
    alert("Phương trình bậc 1, nghiệm x = " + x);
  }
} else {
  let delta = b4*b4 - 4*a4*c4;
  if (delta < 0) {
    alert("Phương trình vô nghiệm");
  } else if (delta === 0) {
    let x = -b4 / (2*a4);
    alert("Phương trình có nghiệm kép x1 = x2 = " + x);
  } else {
    let x1 = (-b4 + Math.sqrt(delta)) / (2*a4);
    let x2 = (-b4 - Math.sqrt(delta)) / (2*a4);
    alert("Phương trình có 2 nghiệm phân biệt:\n x1 = " + x1 + "\n x2 = " + x2);
  }
}

// Bài 8: Kiểm tra số có phải là tuổi hợp lệ
let age = parseInt(prompt("Bài 8 - Nhập tuổi:"));
if (age > 0 && age < 120) {
  alert(age + " là tuổi hợp lệ của một người");
} else {
  alert(age + " không phải là tuổi hợp lệ");
}
