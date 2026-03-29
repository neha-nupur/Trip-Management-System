import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav style={{
      display: "flex",
      justifyContent: "space-between",
      padding: "15px",
      backgroundColor: "#2c3e50",
      color: "white"
    }}>
      <h2>TripEase</h2>

      <div>
        <Link to="/login" style={{ color: "white", marginRight: "15px" }}>
          Login
        </Link>
        <Link to="/signup" style={{ color: "white" }}>
          Signup
        </Link>
      </div>
    </nav>
  );
}

export default Navbar;