let output = document.getElementById("output");

// ==========================
// Bài 1: Mảng products
// ==========================
let products = [
  {id: 1, name: "Butter", price: 20, count: 5},
  {id: 2, name: "Milk", price: 15, count: 10},
  {id: 3, name: "Bread", price: 10, count: 7}
];

// 1. Thêm đối tượng mới
let newProduct = {
  id: 4,
  name: "Cheese",
  price: 25,
  count: 3
};
products.push(newProduct);

// 2. Xóa đối tượng có id = 2
products = products.filter(p => p.id !== 2);

// 3. Cập nhật đối tượng id = 3, count = 0
let p3 = products.find(p => p.id === 3);
if(p3) p3.count = 0;

// 4. Tìm từ khóa "Butter"
let keyword = "Butter";
let found = products.filter(p => p.name.includes(keyword));

output.innerText += "Bài 1 - Danh sách products sau thao tác:\n";
products.forEach(p => {
  output.innerText += `ID: ${p.id}, Name: ${p.name}, Price: ${p.price}, Count: ${p.count}\n`;
});

if(found.length > 0){
  output.innerText += "\nTìm thấy sản phẩm từ khóa 'Butter':\n";
  found.forEach(p => {
    output.innerText += `ID: ${p.id}, Name: ${p.name}, Price: ${p.price}, Count: ${p.count}\n`;
  });
}else{
  output.innerText += "\nKhông có dữ liệu bạn tìm kiếm.\n";
}

output.innerText += "\n==============================\n\n";

// ==========================
// Bài 2: CRUD khóa học
// ==========================
let courses = [
  {name: "HTML", status: "Completed"},
  {name: "CSS", status: "Completed"},
  {name: "JS", status: "Pending"}
];

function printCourses(){
  output.innerText += "Danh sách khóa học:\n";
  courses.forEach((c,i) => {
    output.innerText += `${i+1}. Name: ${c.name}, Status: ${c.status}\n`;
  });
  output.innerText += "\n";
}

while(true){
  let action = prompt("Nhập C/R/U/D/E để thao tác khóa học:").toUpperCase();

  if(action === "E"){
    alert("Cảm ơn bạn đã đến với Rikkei Academy");
    break;
  }

  switch(action){
    case "C":
      let newName = prompt("Nhập tên khóa học mới:");
      let newStatus = prompt("Nhập trạng thái hoàn thành:");
      courses.push({name: newName, status: newStatus});
      printCourses();
      break;
    case "R":
      printCourses();
      break;
    case "U":
      let uIndex = parseInt(prompt("Nhập vị trí khóa học muốn update:")) -1;
      if(uIndex >=0 && uIndex < courses.length){
        let upName = prompt("Nhập tên mới:");
        let upStatus = prompt("Nhập trạng thái mới:");
        courses[uIndex] = {name: upName, status: upStatus};
        printCourses();
      } else {
        alert("Vị trí không hợp lệ!");
      }
      break;
    case "D":
      let dIndex = parseInt(prompt("Nhập vị trí khóa học muốn xóa:")) -1;
      if(dIndex >=0 && dIndex < courses.length){
        courses.splice(dIndex,1);
        printCourses();
      } else {
        alert("Vị trí không hợp lệ!");
      }
      break;
    default:
      alert("Chức năng không hợp lệ!");
  }
}
