const keyboardDiv = document.getElementById("keyboard");
const display = document.getElementById("display");

// Bảng chữ cái và một số nút chức năng
const keys = [
  "Q","W","E","R","T","Y","U","I","O","P",
  "A","S","D","F","G","H","J","K","L",
  "Z","X","C","V","B","N","M",
  "Space","Backspace","Clear"
];

keys.forEach(key => {
  const button = document.createElement("button");
  button.className = "key";

  if(key === "Space") button.classList.add("extra-wide");
  if(key === "Backspace" || key === "Clear") button.classList.add("wide");

  button.innerText = key;
  button.addEventListener("click", () => {
    if(key === "Backspace"){
      display.value = display.value.slice(0,-1);
    } else if(key === "Clear"){
      display.value = "";
    } else if(key === "Space"){
      display.value += " ";
    } else {
      display.value += key;
    }
    display.focus();
  });
  keyboardDiv.appendChild(button);
});
