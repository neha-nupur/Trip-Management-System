import { useNavigate } from "react-router-dom";
import React, { useState } from "react";
import "./Signup.css"; 



function Signup() {
    const navigate = useNavigate();

  const [formData, setFormData] = useState({
    name: "",
    email: "",
    password: "",
    mobile: "",
    age: "",
    status: "Working",
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSignup = (e) => {
    e.preventDefault();
    alert(`Signup Successful! Welcome, ${formData.name}`);

    navigate("/Login");
  };

  return (
    <div className="signup-page">
      <div className="signup-card">
        <h2>Signup</h2>
        <form onSubmit={handleSignup}>
          <input type="text" name="name" placeholder="Full Name" value={formData.name} onChange={handleChange} required/>
          <input type="email" name="email" placeholder="Email" value={formData.email} onChange={handleChange} required/>
          <input type="password" name="password" placeholder="Password" value={formData.password} onChange={handleChange} required/>
          <input type="text" name="mobile" placeholder="Mobile Number" value={formData.mobile} onChange={handleChange} required/>
          <input type="number" name="age" placeholder="Age" value={formData.age} onChange={handleChange} required/>
          <select name="status" value={formData.status} onChange={handleChange} required>
            <option value="Working">Working</option>
            <option value="Student">Student</option>
            <option value="Married">Married</option>
            <option value="Unmarried">Unmarried</option>
          </select>
          <button type="submit">Signup</button>
        </form>


<p style={{ textAlign: "center", marginTop: "15px" }}>
  Already registered?{" "}
  <span 
    style={{ color: "#3498db", cursor: "pointer", fontWeight: "bold" }} 
    onClick={() => navigate("/login")}
  >
    Login here
  </span>
</p>
      </div>
    </div>
  );
}

export default Signup;