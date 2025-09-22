// Bài 1: Đếm từ 1 đến 100
for (let i = 1; i <= 100; i++) {
  console.log(i);
  if (i === 99) {
    alert("Đã hoàn thành đếm đến 99!");
  }
}

// Bài 2: Nhập nhiệt độ
let temp = parseFloat(prompt("Nhập nhiệt độ hiện tại:"));
if (temp > 100) {
  alert("Nhiệt độ quá cao! Hãy giảm nhiệt độ.");
} else if (temp < 20) {
  alert("Nhiệt độ quá thấp! Hãy tăng nhiệt độ.");
} else {
  alert("Nhiệt độ bình thường.");
}

// Bài 3: Hiển thị 20 số Fibonacci đầu tiên
let fib = [0,1];
while(fib.length < 20){
  fib.push(fib[fib.length-1] + fib[fib.length-2]);
}
alert("20 số Fibonacci đầu tiên: " + fib.join(","));

// Bài 4: Tìm số đầu tiên trong Fibonacci chia hết cho 5
let firstDiv5 = fib.find(n => n % 5 === 0);
alert("Số Fibonacci đầu tiên chia hết cho 5: " + firstDiv5);

// Bài 5: Tổng 20 số Fibonacci đầu tiên
let sumFib20 = fib.reduce((a,b)=>a+b,0);
alert("Tổng 20 số Fibonacci đầu tiên: " + sumFib20);

// Bài 6: Tổng 30 số chia hết cho 7 đầu tiên
let count = 0;
let sum7 = 0;
let num = 1;
while(count < 30){
  if(num % 7 === 0){
    sum7 += num;
    count++;
  }
  num++;
}
alert("Tổng 30 số chia hết cho 7 đầu tiên: " + sum7);

// Bài 7: FizzBuzz
let fizzBuzzOutput = [];
for(let i=1;i<=100;i++){
  if(i%3===0 && i%5===0){
    fizzBuzzOutput.push("FizzBuzz");
  } else if(i%3===0){
    fizzBuzzOutput.push("Fizz");
  } else if(i%5===0){
    fizzBuzzOutput.push("Buzz");
  } else {
    fizzBuzzOutput.push(i);
  }
}
console.log("FizzBuzz từ 1-100:", fizzBuzzOutput);

// Bài 8: Game đoán số
document.getElementById("play-game").addEventListener("click", function(){
  alert("Chào mừng bạn đến với game đoán số!");
  
  let min = parseInt(prompt("Nhập giới hạn nhỏ nhất:"));
  let max = parseInt(prompt("Nhập giới hạn lớn nhất:"));
  
  if(isNaN(min) || isNaN(max) || min >= max){
    alert("Giới hạn không hợp lệ!");
    return;
  }
  
  let randomNumber = Math.floor(Math.random() * (max - min +1)) + min;
  let guess;
  let attempts = 0;
  
  do{
    guess = parseInt(prompt("Nhập số bạn đoán từ " + min + " đến " + max + ":"));
    attempts++;
    
    if(guess === randomNumber){
      alert("Chúc mừng! Bạn đoán đúng số " + randomNumber + " sau " + attempts + " lần.");
      break;
    } else if(guess > randomNumber){
      alert("Số bạn đoán lớn hơn số bí mật. Thử lại!");
    } else {
      alert("Số bạn đoán nhỏ hơn số bí mật. Thử lại!");
    }
  } while(true);
});
