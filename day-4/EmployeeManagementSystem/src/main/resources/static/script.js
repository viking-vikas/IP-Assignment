const API_URL = "http://localhost:8080/api/employees";

document.addEventListener("DOMContentLoaded", () => {
    if (document.getElementById("totalEmployees")) loadDashboard();
    if (document.getElementById("employeeTable")) loadEmployees();
});

function loadDashboard() {
    fetch(API_URL)
        .then(res => res.json())
        .then(data => {
            document.getElementById("totalEmployees").innerText = data.length;
            document.getElementById("activeEmployees").innerText = data.length;

            let payroll = 0;
            data.forEach(e => payroll += parseFloat(e.salary));

			document.getElementById("monthlyPayroll").innerHTML =
			    "&#8377; " + payroll.toLocaleString("en-IN");
        });
}

function loadEmployees() {
    fetch(API_URL)
        .then(res => res.json())
        .then(data => {
            let rows = "";
            data.forEach(e => {
                rows += `
                <tr>
                    <td>${e.id}</td>
                    <td>${e.name}</td>
                    <td>${e.email}</td>
                    <td>${e.salary}</td>
                    <td>
                        <button class="action-btn edit" onclick="editEmployee(${e.id})">Edit</button>
                        <button class="action-btn delete" onclick="deleteEmployee(${e.id})">Delete</button>
                    </td>
                </tr>`;
            });
            document.getElementById("employeeTable").innerHTML = rows;
        });
}

function addEmployee() {
    const id = empId.value;
    const emp = {
        name: name.value,
        email: email.value,
        salary: salary.value
    };

    const req = id
        ? fetch(`${API_URL}/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(emp)
        })
        : fetch(API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(emp)
        });

    req.then(() => window.location.href = "employees.html");
}

function editEmployee(id) {
    fetch(`${API_URL}/${id}`)
        .then(res => res.json())
        .then(e => {
            localStorage.setItem("editEmp", JSON.stringify(e));
            window.location.href = "add-employee.html";
        });
}

function deleteEmployee(id) {
    fetch(`${API_URL}/${id}`, { method: "DELETE" })
        .then(loadEmployees);
}

const edit = localStorage.getItem("editEmp");
if (edit && document.getElementById("name")) {
    const e = JSON.parse(edit);
    empId.value = e.id;
    name.value = e.name;
    email.value = e.email;
    salary.value = e.salary;
    localStorage.removeItem("editEmp");
}
