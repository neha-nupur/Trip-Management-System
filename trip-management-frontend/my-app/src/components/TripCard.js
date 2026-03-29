import { useNavigate } from "react-router-dom";

function TripCard({ name, price }) {
  const navigate = useNavigate();

  const handleBooking = () => {
    navigate("/booking", {
      state: { tripName: name, tripPrice: price }
    });
  };

  return (
    <div
      style={{
        border: "1px solid #ddd",
        borderRadius: "10px",
        padding: "15px",
        width: "200px",
        boxShadow: "0 2px 5px rgba(0,0,0,0.2)",
        textAlign: "center"
      }}
    >
      <h3>{name}</h3>
      <p style={{ color: "green", fontWeight: "bold" }}>₹{price}</p>

      <button
        onClick={handleBooking}
        style={{
          backgroundColor: "#3498db",
          color: "white",
          border: "none",
          padding: "8px 12px",
          borderRadius: "5px",
          cursor: "pointer"
        }}
      >
        Book Now
      </button>
    </div>
  );
}

export default TripCard;