let output = document.getElementById("output");

// Bài 1: Tạo đối tượng người
let person = {
  name: prompt("Bài 1 - Nhập tên:"),
  age: parseInt(prompt("Bài 1 - Nhập tuổi:")),
  address: prompt("Bài 1 - Nhập địa chỉ:"),
  phone: prompt("Bài 1 - Nhập số điện thoại:")
};

output.innerText += "Bài 1 - Thông tin người:\n";
for(let key in person){
  output.innerText += key + ": " + person[key] + "\n";
}
output.innerText += "\n";

// Bài 2: Tạo đối tượng student và mảng students
let studentKeys = ["name", "age", "score", "class"];
let newStudent = {};
studentKeys.forEach(key => {
  newStudent[key] = prompt(`Bài 2 - Nhập ${key} của học sinh:`);
});

let students = [];
students.push(newStudent);

output.innerText += "Bài 2 - Thông tin newStudent:\n";
for(let key in newStudent){
  output.innerText += key + ": " + newStudent[key] + "\n";
}
output.innerText += "\n";

// Bài 3: Tìm học sinh có điểm cao nhất
// Giả sử điểm lưu trong key 'score', cần chuyển sang number
students.forEach(s => s.score = Number(s.score));

// Nếu muốn nhập thêm vài học sinh để demo
let addMore = prompt("Bạn có muốn nhập thêm học sinh để bài 3? (yes/no)").toLowerCase();
while(addMore === "yes"){
  let tempStudent = {};
  studentKeys.forEach(key => {
    tempStudent[key] = prompt(`Nhập ${key} của học sinh:`)
  });
  tempStudent.score = Number(tempStudent.score);
  students.push(tempStudent);
  addMore = prompt("Bạn có muốn nhập thêm học sinh? (yes/no)").toLowerCase();
}

let maxScore = Math.max(...students.map(s=>s.score));
let topStudent = students.find(s=>s.score === maxScore);

output.innerText += "Bài 3 - Học sinh có điểm cao nhất:\n";
for(let key in topStudent){
  output.innerText += key + ": " + topStudent[key] + "\n";
}
