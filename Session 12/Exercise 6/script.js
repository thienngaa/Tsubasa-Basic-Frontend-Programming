let name = "";
let age = 0;

function isPrime(num) {
  if(num < 2) return false;
  for(let i=2;i<=Math.sqrt(num);i++){
    if(num % i === 0) return false;
  }
  return true;
}

while(true){
  let choice = prompt(
`Chọn chức năng:
1: Nhập tên người dùng
2: Nhập tuổi người dùng
3: In tên và tuổi
4: In bảng cửu chương
5: Kiểm tra số chẵn/lẻ
6: Tính tổng từ 1 đến N
7: In các số trong dãy
8: Kiểm tra số nguyên tố
9: Đảo ngược chuỗi
10: Thoát`
  );

  if(choice === null) break; // nhấn Cancel
  choice = parseInt(choice);

  switch(choice){
    case 1:
      name = prompt("Nhập tên của bạn:");
      break;
    case 2:
      age = parseInt(prompt("Nhập tuổi của bạn:"));
      break;
    case 3:
      alert("Tên: " + name + "\nTuổi: " + age);
      break;
    case 4:
      let n = parseInt(prompt("Nhập số để in bảng cửu chương:"));
      let table = "";
      for(let i=1;i<=10;i++){
        table += `${n} x ${i} = ${n*i}\n`;
      }
      alert(table);
      break;
    case 5:
      let num = parseInt(prompt("Nhập số để kiểm tra chẵn/lẻ:"));
      alert(num % 2 === 0 ? num + " là số chẵn" : num + " là số lẻ");
      break;
    case 6:
      let N = parseInt(prompt("Nhập N để tính tổng từ 1 đến N:"));
      let sum = (N*(N+1))/2;
      alert("Tổng từ 1 đến " + N + " = " + sum);
      break;
    case 7:
      let seq = prompt("Nhập dãy số, cách nhau bởi dấu phẩy:");
      let arr = seq.split(",").map(x=>x.trim());
      alert("Dãy bạn nhập: " + arr.join(", "));
      break;
    case 8:
      let p = parseInt(prompt("Nhập số để kiểm tra nguyên tố:"));
      alert(isPrime(p) ? p + " là số nguyên tố" : p + " không phải số nguyên tố");
      break;
    case 9:
      let str = prompt("Nhập chuỗi để đảo ngược:");
      let reversed = str.split("").reverse().join("");
      alert("Chuỗi đảo ngược: " + reversed);
      break;
    case 10:
      alert("Thoát chương trình. Hẹn gặp lại!");
      break;
    default:
      alert("Lựa chọn không hợp lệ");
  }

  if(choice === 10) break;
}
