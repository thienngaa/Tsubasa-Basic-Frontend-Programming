body {
  font-family: Arial, sans-serif;
  background: #f2f2f2;
  display: flex;
  justify-content: center;
  align-items: flex-start;
  padding: 50px 0;
}

.todo-container {
  background: #fff;
  padding: 20px 30px;
  border-radius: 8px;
  width: 400px;
  box-shadow: 0 4px 10px rgba(0,0,0,0.1);
}

h1 {
  text-align: center;
  color: #333;
}

.input-section {
  display: flex;
  margin-bottom: 20px;
}

#todo-input {
  flex: 1;
  padding: 10px;
  font-size: 16px;
  border-radius: 5px 0 0 5px;
  border: 1px solid #ccc;
  outline: none;
}

#add-btn {
  padding: 10px 20px;
  font-size: 16px;
  border: none;
  background: #28a745;
  color: #fff;
  border-radius: 0 5px 5px 0;
  cursor: pointer;
  transition: 0.3s;
}

#add-btn:hover {
  background: #218838;
}

#todo-list {
  list-style: none;
  padding: 0;
  margin: 0;
}

.todo-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background: #f9f9f9;
  margin-bottom: 10px;
  padding: 10px 15px;
  border-radius: 5px;
  transition: 0.3s;
}

.todo-item:hover {
  background: #e9ecef;
}

.todo-text {
  flex: 1;
  cursor: pointer;
}

.todo-actions button {
  margin-left: 5px;
  border: none;
  padding: 5px 10px;
  border-radius: 5px;
  cursor: pointer;
}

.todo-actions .edit-btn {
  background: #ffc107;
  color: #fff;
}

.todo-actions .edit-btn:hover {
  background: #e0a800;
}

.todo-actions .delete-btn {
  background: #dc3545;
  color: #fff;
}

.todo-actions .delete-btn:hover {
  background: #c82333;
}
