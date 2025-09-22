const nameInput = document.getElementById("name");
const ageInput = document.getElementById("age");
const classInput = document.getElementById("class");
const addBtn = document.getElementById("add-btn");
const studentTable = document.getElementById("student-table").getElementsByTagName("tbody")[0];
const searchInput = document.getElementById("search");

let students = [];

// Thêm sinh viên
addBtn.addEventListener("click", () => {
  const name = nameInput.value.trim();
  const age = ageInput.value.trim();
  const className = classInput.value.trim();

  if(!name || !age || !className) {
    alert("Vui lòng nhập đầy đủ thông tin sinh viên!");
    return;
  }

  students.push({name, age, className});
  renderTable();
  nameInput.value = "";
  ageInput.value = "";
  classInput.value = "";
});

// Render bảng
function renderTable(filteredStudents = null) {
  const data = filteredStudents || students;
  studentTable.innerHTML = "";

  data.forEach((stu, index) => {
    const row = studentTable.insertRow();
    row.insertCell(0).innerText = index + 1;
    row.insertCell(1).innerText = stu.name;
    row.insertCell(2).innerText = stu.age;
    row.insertCell(3).innerText = stu.className;

    const actionsCell = row.insertCell(4);

    const editBtn = document.createElement("button");
    editBtn.innerText = "Sửa";
    editBtn.className = "edit-btn";
    editBtn.addEventListener("click", () => editStudent(index));

    const deleteBtn = document.createElement("button");
    deleteBtn.innerText = "Xóa";
    deleteBtn.className = "delete-btn";
    deleteBtn.addEventListener("click", () => deleteStudent(index));

    actionsCell.appendChild(editBtn);
    actionsCell.appendChild(deleteBtn);
  });
}

// Xóa sinh viên
function deleteStudent(index) {
  if(confirm("Bạn có chắc muốn xóa sinh viên này?")) {
    students.splice(index,1);
    renderTable();
  }
}

// Sửa sinh viên
function editStudent(index) {
  const stu = students[index];
  const newName = prompt("Tên mới:", stu.name);
  const newAge = prompt("Tuổi mới:", stu.age);
  const newClass = prompt("Lớp mới:", stu.className);

  if(newName && newAge && newClass) {
    students[index] = {name: newName, age: newAge, className: newClass};
    renderTable();
  }
}

// Tìm kiếm sinh viên
searchInput.addEventListener("input", () => {
  const keyword = searchInput.value.trim().toLowerCase();
  if(keyword === "") {
    renderTable();
  } else {
    const filtered = students.filter(stu => stu.name.toLowerCase().includes(keyword));
    renderTable(filtered);
  }
});

// Render lần đầu
renderTable();
