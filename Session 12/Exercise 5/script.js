let output = document.getElementById("output");

// Bài 1: In dãy Fibonacci
let nFib = parseInt(prompt("Bài 1 - Nhập số lượng số Fibonacci cần in:"));
let fib = [0,1];
while(fib.length < nFib){
  fib.push(fib[fib.length-1] + fib[fib.length-2]);
}
output.innerText += "Dãy Fibonacci " + nFib + " số:\n" + fib.slice(0,nFib).join(", ") + "\n\n";

// Bài 2: Tính giai thừa
let numFact = parseInt(prompt("Bài 2 - Nhập số nguyên dương để tính giai thừa:"));
let fact = 1;
if(numFact < 0){
  output.innerText += "Số không hợp lệ.\n\n";
} else {
  for(let i=1;i<=numFact;i++){
    fact *= i;
  }
  output.innerText += numFact + "! = " + fact + "\n\n";
}

// Bài 3: In tam giác vuông
let size = parseInt(prompt("Bài 3 - Nhập kích thước tam giác:"));
let position = prompt("Chọn góc vuông: top-left, top-right, bottom-left, bottom-right");

output.innerText += "Tam giác vuông " + position + ":\n";

for(let i=1;i<=size;i++){
  let line = "";
  switch(position){
    case "top-left":
      line = "*".repeat(size-i+1);
      break;
    case "top-right":
      line = " ".repeat(i-1) + "*".repeat(size-i+1);
      break;
    case "bottom-left":
      line = "*".repeat(i);
      break;
    case "bottom-right":
      line = " ".repeat(size-i) + "*".repeat(i);
      break;
    default:
      line = "Chọn vị trí hợp lệ!";
  }
  output.innerText += line + "\n";
}
