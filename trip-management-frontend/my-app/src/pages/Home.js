import TripCard from "../components/TripCard";

function Home() {
  const trips = [
    { id: 1, name: "Goa Trip", price: 5000 },
    { id: 2, name: "Manali Trip", price: 8000 },
    { id: 3, name: "Kerala Trip", price: 7000 },
    { id: 4, name: "Jaipur Trip", price: 4000 }
  ];

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h1 style={{ textAlign: "center" }}>Trip Management System</h1>

      <div style={{ display: "flex", gap: "20px", flexWrap: "wrap" }}>
        {trips.map((trip) => (
          <TripCard
            key={trip.id}
            name={trip.name}
            price={trip.price}
          />
        ))}
      </div>
    </div>
  );
}

export default Home;