import { useLocation } from "react-router-dom";
import { useState } from "react";

function Booking() {
  const location = useLocation();
  const trip = location.state;

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [people, setPeople] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    setMessage(
      `Booking Confirmed for ${name} (${people} people) for ${trip?.tripName}`
    );
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Booking Page</h2>

      {trip && (
        <div>
          <h3>Selected Trip:</h3>
          <p>{trip.tripName}</p>
          <p>Price: ₹{trip.tripPrice}</p>
        </div>
      )}

      <form onSubmit={handleSubmit}>
        <div>
          <label>Name:</label><br />
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </div>

        <div>
          <label>Email:</label><br />
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>

        <div>
          <label>People:</label><br />
          <input
            type="number"
            value={people}
            onChange={(e) => setPeople(e.target.value)}
          />
        </div>

        <br />
        <button type="submit">Confirm Booking</button>
      </form>

      {message && <h3>{message}</h3>}
    </div>
  );
}

export default Booking;