import { useNavigate } from "react-router-dom";
import React from "react";
import "./Dashboard.css";
import taj from "../Images/taj.jpg";
import beach from "../Images/beach.jpg";
import river from "../Images/river.jpg";
import science from "../Images/science.jpg";

function Dashboard() {
  const navigate = useNavigate();
  const handleOpenSignup = () => navigate("/Signup");
  const categories = [
    "Adventure", "Beach", "Hill", "City", "Cultural", "Romantic"
  ];

  const tripsCards = [
    "🏫 School Trips",
    "🧍 Solo Trips",
    "👴 Senior Citizen Trips",
    "👨‍👩‍👧 Family Trips",
    "👫 Couple Trips",
    "👬 Friends Trips"
  ];

  const travelMedia = [
    { img: "https://img.icons8.com/ios-filled/100/train.png", name: "Train" },
    { img: "https://img.icons8.com/ios-filled/100/bus.png", name: "Bus" },
    { img: "https://img.icons8.com/ios-filled/100/airplane-take-off.png", name: "Aeroplane" },
    
  ];

  return (
    <div className="dashboard">

      {/* NAVBAR */}
      <div className="navbar">
        <h2>TripMania</h2>
        <div className="nav-links">
          {["Home","Trips","Categories","Media","About"].map((item,index)=>(
            <a key={index} href="#">{item}</a>
          ))}
          <button>Login</button>
        </div>
      </div>

      {/* HERO SECTION */}
      <div className="hero-section">
        <div className="hero-overlay">
          <h1>Explore the World with Us 🌍</h1>
          <p>Discover trips for every mood and every moment</p>
          <button className="cta-btn" style={{
    backgroundColor: "#e67e22",
    color: "white",
    padding: "10px 20px",
    border: "none",
    borderRadius: "5px",
    cursor: "pointer"
  }}
  onClick={handleOpenSignup}>Start Exploring</button>
        </div>
      </div>

      {/* TRIP CATEGORIES */}
      <div className="categories-section">
        <h2>Our Trip Categories</h2>
        <div className="categories-cards">
          {categories.map((cat,index)=>(
            <div key={index} className="category-card">{cat}</div>
          ))}
        </div>
      </div>

      {/* TRIPS CARDS */}
      <div className="trips-section">
        <h2>Special Trips</h2>
        <div className="trips-cards">
          {tripsCards.map((trip,index)=>(
            <div key={index} className="trip-card">{trip}</div>
          ))}
        </div>
      </div>

      {/* IMAGE GALLERY */}
      <div className="gallery-section">
        <h2>Explore Beautiful Destinations</h2>
        <div className="gallery-images">
          {[taj, beach, river, science].map((img, index)=>(
            <img key={index} src={img} alt={`destination-${index}`} />
          ))}
        </div>
      </div>

      {/* TRAVEL MEDIA */}
      <div className="media-section">
        <h2>Travel Options</h2>
        <div className="media-cards">
          {travelMedia.map((item,index)=>(
            <div key={index} className="media-card">
              <img src={item.img} alt={item.name}/>
              <p>{item.name}</p>
            </div>
          ))}
        </div>
      </div>

      {/* CTA SECTION */}
      <div className="cta-section">
        <h2>Start Your Journey Today ✈️</h2>
        <button className="cta-btn">Explore Trips</button>
      </div>

      {/* FOOTER */}
      <div className="footer">
        <h3>TripMania</h3>
        <p>Explore. Travel. Enjoy.</p>
        <div className="footer-links">
          {["Home","Trips","Categories","Media","Contact"].map((item,index)=>(
            <a key={index} href="#">{item}</a>
          ))}
        </div>
        <div className="social-icons">
          <a href="#"><img src="https://img.icons8.com/ios-filled/24/facebook-new.png"/></a>
          <a href="#"><img src="https://img.icons8.com/ios-filled/24/instagram-new.png"/></a>
          <a href="#"><img src="https://img.icons8.com/ios-filled/24/twitter.png"/></a>
        </div>
        <p>© 2026 TripMania. All rights reserved.</p>
      </div>

    </div>
  );
}

export default Dashboard;